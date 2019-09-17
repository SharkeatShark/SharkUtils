package com.shark.io;

import com.shark.util.StrUtil;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/***
 * 导出EXCEL列表
 */
public class CommonExcel {

    /**
     * 导出excel
     *
     * @param list         传入要导出的excel列表信息（list里必须是map类型）
     * @param response
     * @param columnTitles 以数组方式传入列名（相当于表头）
     * @param columnValues 以数组方式传入列内容（map键）
     * @param title        导出excel的标题
     * @param sheetName    工作薄名称
     */
    public static void exportExcel(List list, HttpServletResponse response,
                                   String[] columnTitles, String[] columnValues, String title,
                                   String sheetName) {
        try {

            InputStream in = getInputStream(list, columnTitles, columnValues,
                    title, sheetName);
            BufferedInputStream br = new BufferedInputStream(in);
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = new String(title.getBytes("UTF-8"), "UTF-8");
            java.util.Date date1 = new java.util.Date();
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String timeStr = df.format(date1);
            response.setHeader("Content-Disposition", "attachment; filename="
                    + java.net.URLEncoder.encode(fileName, "UTF-8") + timeStr
                    + ".xls");
            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) > 0)
                out.write(buf, 0, len);
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出excel时设置列表信息
     *
     * @param prizelist
     * @param columnTitles
     * @param columnValues
     * @param title
     * @param sheetName
     * @return
     */
    public static InputStream getInputStream(List prizelist,
                                             String[] columnTitles, String[] columnValues, String title, String sheetName) {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFCellStyle herdStyle = wb.createCellStyle();
        herdStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont herdFont = wb.createFont();
        herdFont.setFontHeightInPoints((short) 18);
        herdStyle.setFont(herdFont);
        HSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 12);
        titleStyle.setFont(titleFont);

        titleStyle.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
        titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        HSSFCellStyle cellstyle = wb.createCellStyle();
        cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        HSSFSheet sheet = wb.createSheet(sheetName);

        sheet.setColumnWidth(0, 256 * 25);
        sheet.setColumnWidth(1, 256 * 25);
        HSSFRow row0 = sheet.createRow(0);
        HSSFCell herdCell = row0.createCell(0);
        herdCell.setCellValue(title);
        herdCell.setCellStyle(herdStyle);
        // sheet.AddMergedRegion(new Region(0, 0, 0, 5));

        sheet.addMergedRegion(new Region(0, (short) 0, 0,
                (short) (columnTitles.length - 1))); // 合并单元格

        HSSFRow row1 = sheet.createRow(1);
        //
        for (int i = 0; i < columnTitles.length; i++) {
            HSSFCell titleCell = row1.createCell(i);
            titleCell.setCellValue(columnTitles[i]);
            titleCell.setCellStyle(titleStyle);
        }

        if (prizelist != null && prizelist.size() > 0) {
            for (int i = 0; i < prizelist.size(); i++) {

                Map prize = (Map) prizelist.get(i);
                //System.out.println(i);
                HSSFRow row = sheet.createRow(i + 2);


                for (int j = 0; j < columnValues.length; j++) {
                    HSSFCell cell = row.createCell(j);
                    if (prize.get(columnValues[j]) == null) {
                        cell.setCellValue("");
                    } else {
                        cell.setCellValue(prize.get(columnValues[j]).toString());
                    }

                    cell.setCellStyle(cellstyle);
                }
            }
        }
        final File file = new File(StrUtil.generate6SerialId() + (".xls").toString());

        try {
            OutputStream os = new FileOutputStream(file);
            wb.write(os);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(7000);// 7秒钟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                file.delete();
            }
        }).start();

        return is;
    }

    /**
     * 导出excel
     *
     * @param list         传入要导出的excel列表信息（list里必须是map类型）
     * @param response
     * @param columnTitles 以数组方式传入列名（相当于表头）
     * @param columnValues 以数组方式传入列内容（map键）
     * @param title        导出excel的标题
     */
    public static void exportExcel(List list, HttpServletResponse response,
                                   String[] columnTitles, String[] columnValues, String title) {
        try {

            InputStream in = getInputStream(list, columnTitles, columnValues,
                    title);
            BufferedInputStream br = new BufferedInputStream(in);
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = new String(title.getBytes("UTF-8"), "UTF-8");
            java.util.Date date1 = new java.util.Date();
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String timeStr = df.format(date1);
            response.setHeader("Content-Disposition", "attachment; filename="
                    + java.net.URLEncoder.encode(fileName, "UTF-8") + timeStr
                    + ".xls");
            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) > 0)
                out.write(buf, 0, len);
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出excle时设置列表信息
     *
     * @param prizelist
     * @param columnTitles
     * @param columnValues
     * @param title
     * @return
     */
    public static InputStream getInputStream(List prizelist,
                                             String[] columnTitles, String[] columnValues, String title) {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFCellStyle herdStyle = wb.createCellStyle();
        herdStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont herdFont = wb.createFont();
        herdFont.setFontHeightInPoints((short) 18);
        herdStyle.setFont(herdFont);
        HSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 12);
        titleStyle.setFont(titleFont);

        titleStyle.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
        titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        HSSFCellStyle cellstyle = wb.createCellStyle();
        cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        HSSFSheet sheet = wb.createSheet();

        sheet.setColumnWidth(0, 256 * 25);
        sheet.setColumnWidth(1, 256 * 25);
        HSSFRow row0 = sheet.createRow(0);
        HSSFCell herdCell = row0.createCell(0);
        herdCell.setCellValue(title);
        herdCell.setCellStyle(herdStyle);
        // sheet.AddMergedRegion(new Region(0, 0, 0, 5));

        sheet.addMergedRegion(new Region(0, (short) 0, 0,
                (short) (columnTitles.length - 1))); // 合并单元格

        HSSFRow row1 = sheet.createRow(1);
        //
        for (int i = 0; i < columnTitles.length; i++) {
            HSSFCell titleCell = row1.createCell(i);
            titleCell.setCellValue(columnTitles[i]);
            titleCell.setCellStyle(titleStyle);
        }

        if (prizelist != null && prizelist.size() > 0) {
            for (int i = 0; i < prizelist.size(); i++) {

                Map prize = (Map) prizelist.get(i);
                HSSFRow row = sheet.createRow(i + 2);

                for (int j = 0; j < columnValues.length; j++) {
                    HSSFCell cell = row.createCell(j);
                    if (prize.get(columnValues[j]) == null) {
                        cell.setCellValue("");
                    } else {
                        cell
                                .setCellValue(prize.get(columnValues[j])
                                        .toString());
                    }

                    cell.setCellStyle(cellstyle);
                }
            }
        }

        final File file = new File(StrUtil.generate6SerialId()
                + (".xls").toString());

        try {
            OutputStream os = new FileOutputStream(file);
            wb.write(os);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(7000);// 7秒钟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                file.delete();
            }
        }).start();

        return is;
    }

    /**
     * 导出excel
     * @param response
     * @param workbook  EXCEL文件
     * @param title 导出excel的标题
     */
    public static void exportExcel(HttpServletResponse response,
                                   HSSFWorkbook workbook, String title) {
        try {
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/x-msdownload;charset=UTF-8");
            String fileName = new String(title.getBytes("UTF-8"), "UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + java.net.URLEncoder.encode(fileName, "UTF-8") + ".xls");
            OutputStream outStream = response.getOutputStream();
            workbook.write(outStream);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 把一张图片导出excel
     *
     * @param response
     * @param filenamePath 文件名的存放路径
     * @param title
     */
    public static void exportExcel(HttpServletResponse response, String filenamePath, String title) {
        try {

            InputStream in = getInputStream(filenamePath);
            BufferedInputStream br = new BufferedInputStream(in);
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = new String(title.getBytes("UTF-8"), "UTF-8");
            java.util.Date date1 = new java.util.Date();
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String timeStr = df.format(date1);
            response.setHeader("Content-Disposition", "attachment; filename="
                    + java.net.URLEncoder.encode(fileName, "UTF-8") + timeStr
                    + ".xls");
            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) > 0)
                out.write(buf, 0, len);
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 把后缀为.png图片导入Excel
     *
     * @param filenamePath 文件名的存放路径
     * @return
     */
    public static InputStream getInputStream(String filenamePath) {

        BufferedImage bufferImg = null;
        // 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();

        try {
            bufferImg = ImageIO.read(new File(filenamePath));
            ImageIO.write(bufferImg, "png", byteArrayOut);
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        // 创建一个工作薄
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet1 = wb.createSheet("new sheet");
        HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 512, 255,
                (short) 1, 1, (short) 10, 20);

        anchor.setAnchorType(2);
        // 插入图片
        patriarch.createPicture(
                anchor,
                wb.addPicture(byteArrayOut.toByteArray(),
                        HSSFWorkbook.PICTURE_TYPE_PNG)).resize();

        final File file = new File(StrUtil.generate6SerialId()
                + (".xls").toString());
        try {
            OutputStream os = new FileOutputStream(file);
            wb.write(os);
            os.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(7000);// 7秒钟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                file.delete();
            }
        }).start();
        return is;
    }

    /**
     * 导出excel
     *
     * @param list         传入要导出的excel列表信息（list里必须是map类型）
     * @param response
     * @param columnTitles 以数组方式传入列名（相当于表头）
     * @param columnValues 以数组方式传入列内容（map键）
     * @param title        导出excel的标题
     * @param sheetName    工作薄名称
     */
    public static void exportExcel2(List list, HttpServletResponse response,
                                    String[] columnTitles, String[] columnValues, String title,
                                    String sheetName) {
        try {

            InputStream in = getInputStreamInfo(list, columnTitles, columnValues);
            BufferedInputStream br = new BufferedInputStream(in);
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = new String(title.getBytes("UTF-8"), "UTF-8");
            java.util.Date date1 = new java.util.Date();
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String timeStr = df.format(date1);
            response.setHeader("Content-Disposition", "attachment; filename="
                    + java.net.URLEncoder.encode(fileName, "UTF-8") + timeStr
                    + ".csv");
            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) > 0)
                out.write(buf, 0, len);
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取list数据流
     *
     * @param columnTitles 列头数组
     * @param columnValues 数据集合键值数组
     * @param sqlValue     sql语句
     * @return
     */
    /**
     *
     * @param prizelist
     * @param columnTitles
     * @param columnValues
     * @return
     */
    public static InputStream getInputStreamInfo(List prizelist, String[] columnTitles, String[] columnValues) {
        //各类变量定义
        BufferedWriter bw = null;//输出流
        StringBuffer sb = null;//字符串容器
        InputStream is = null;//输入流
        try {
            //定义文件
            final File file = new File(StrUtil.generate6SerialId() + (".csv").toString());
            //各类变量赋值
            //bw = new BufferedWriter(new FileWriter(file));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "gb2312"));
            sb = new StringBuffer("");
            //判断列头是否为空
            if (columnTitles != null) {
                //设置列头
                for (int i = 0; i < columnTitles.length; i++) {
                    sb.append("\"" + columnTitles[i] + "\",");
                }
                bw.write(sb.toString().substring(0, sb.toString().length() - 1) + "\n");
            }

            //执行list获取结果集
            if (prizelist != null && prizelist.size() > 0) {
                for (int i = 0; i < prizelist.size(); i++) {
                    sb = new StringBuffer("");
                    Map prize = (Map) prizelist.get(i);
                    for (int j = 0; j < columnValues.length; j++) {
                        if (prize.get(columnValues[j]) != null)
                            sb.append("\"" + prize.get(columnValues[j]).toString() + "\",");
                        else
                            sb.append("\"\",");
                    }
                    bw.write(sb.toString().substring(0, sb.toString().length() - 1) + "\n");
                }
            }

            //关闭流
            bw.close();
            //读取数据流返回
            is = new FileInputStream(file);
            //设置删除文件的延时器
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(8000);//8秒钟
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    file.delete();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is;
    }

}
