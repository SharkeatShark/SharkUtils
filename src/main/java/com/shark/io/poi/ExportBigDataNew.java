package com.shark.io.poi;

import com.shark.net.JDBCUtilSingle;
import com.shark.util.StrUtil;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 大批量数据导出公用方法
 * @author OuYang
 * 2014-02-19
 */
public class ExportBigDataNew 
{

	/**
	 * 数据清单导出
	 * @param response 输出流对象
	 * @param title 导出的Excel标题
	 * @param columnTitles 列头数组
	 * @param columnValues 数据集合键值数组
	 * @param sqlValue sql语句
	 */
	public static void exportData
	(HttpServletResponse response, String title, String[] columnTitles, String[] columnValues, String sqlValue)
	{
		try
		{
			//获取数据流
			InputStream in = getInputStreamInfo(columnTitles, columnValues, sqlValue);
			BufferedInputStream br = new BufferedInputStream(in);
			byte[] buf = new byte[1024];
			int len = 0;
			//设置输出信息格式
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			String fileName = new String(title.getBytes("UTF-8"), "UTF-8");
			//获取当前时间,设置默认文件名
			Date dateValue = new Date();
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String timeStr = df.format(dateValue);
			response.setHeader("Content-Disposition", "attachment; filename="
					+ java.net.URLEncoder.encode(fileName, "UTF-8") + timeStr
					+ ".csv");
			//获取输出流
			OutputStream out = response.getOutputStream();
			//循环输出
			while ((len = br.read(buf)) > 0)
				out.write(buf, 0, len);
			//关闭流
			out.close();
			br.close();
			in.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据流
	 * @param columnTitles 列头数组
	 * @param columnValues 数据集合键值数组
	 * @param sqlValue sql语句
	 * @return
	 */
	public static InputStream getInputStreamInfo
	(String[] columnTitles,String[] columnValues,String sqlValue)
	{
		//各类变量定义
		ResultSet dataInfo = null;//结果集
		Statement dataSta = null;//执行SQL对象
		Connection dataCon = null;//数据库连接对象
		BufferedWriter bw = null;//输出流
		StringBuffer sb = null;//字符串容器
		InputStream is = null;//输入流
		try
		{
			//定义文件
			final File file = new File(StrUtil.generate6SerialId()+ (".csv").toString());
			//各类变量赋值
			dataCon = JDBCUtilSingle.getInitJDBCUtil().getConnectionNew();
			dataSta = dataCon.createStatement();
			//bw = new BufferedWriter(new FileWriter(file));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"gb2312"));
			sb = new StringBuffer("");
			//判断列头是否为空
			if(columnTitles != null)
			{
				//设置列头
				for (int i = 0; i < columnTitles.length; i++)
				{
					sb.append("\"" + columnTitles[i] + "\",");
				}
				bw.write(sb.toString().substring(0,sb.toString().length()-1) + "\n");
			}
			//执行SQL获取结果集
			dataInfo = dataSta.executeQuery(sqlValue);
			while(dataInfo.next())
			{
				sb = new StringBuffer("");
				for (int i = 0; i < columnValues.length; i++)
				{
					if(dataInfo.getString(columnValues[i]) != null)
						sb.append("\"" + dataInfo.getString(columnValues[i]) + "\",");
					else
						sb.append("\"\",");
				}
				
				bw.write(sb.toString().substring(0,sb.toString().length()-1) + "\n");
			}
			//关闭流
			bw.close();
			//关闭数据库连接
			dataInfo.close();
			dataSta.close();
			dataCon.close();
			//读取数据流返回
			is = new FileInputStream(file);
			//设置删除文件的延时器
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(8000);//8秒钟
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					file.delete();
				}
			}).start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return is;
	}
	
}
