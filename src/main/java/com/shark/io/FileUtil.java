package com.shark.io;

import org.apache.poi.util.IOUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;

/**
 * word 文件工具类
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-12-16:26
 * @projectName SharkUtils
 * @packageName com.shark.util
 */
public class FileUtil {

    /**
     * 根据文件路径 获取到一个输入流
     * @param path  文件路径
     * @return  InputStream
     */
    public static InputStream getInputStream(String path){
        try {
            File file = new File(path);
            if(file.exists()){
                return new FileInputStream(file);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 往文件中写字符串 默认 编码 UTF-8
     * @param content   内容
     * @param file  文件
     * @return  boolean
     */
    public static boolean toFile(String content,File file){
        return toFile(content,file,"UTF-8");
    }

    /**
     * 往文件中写字符串
     * @param content   内容
     * @param file  文件
     * @param charSet   编码
     * @return  boolean
     */
    public static boolean toFile(String content,File file,String charSet){
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(file),charSet);
            writer.write(content);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if(writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * 往文件中写字符串
     * @param content   内容
     * @param filepath  文件地址
     * @return  boolean
     */
    public static boolean toFile(String content,String filepath){
        return toFile(content,filepath,"UTF-8");
    }

    /**
     * 往文件中写字符串
     * @param content   内容
     * @param filepath  文件地址
     * @param charSet   编码
     * @return  boolean
     */
    public static boolean toFile(String content,String filepath,String charSet){
        File file = new File(filepath);
        return toFile(content,file,charSet);
    }

    /**
     * 读取文件
     * @param filepath  文件地址
     * @return  String
     */
    public static String readFile(String filepath) {
        return readFile(new File(filepath),null,"utf-8");
    }

    /**
     * 读取文件
     * @param file  文件
     * @return  String
     */
    public static String readFile(File file) {
        return readFile(file,null,"utf-8");
    }

    /**
     * 读取文件
     * @param file  文件
     * @param lineFilter    行过滤
     * @param charSet   字符编码
     * @return  String
     */
    public static String readFile(File file, LineFilter lineFilter, String charSet) {
        BufferedReader br = null;
        StringBuffer sb = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file),charSet));
            sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
                if(lineFilter != null){
                    lineFilter.lineArrival(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     *
     */
    public interface LineFilter{
        void lineArrival(String line);
    }

    /**
     * 通过文件通道复制文件
     * @param s 源文件
     * @param t 新文件
     */
    public static void fileCopyByChannel(File s, File t) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(s);
            fo = new FileOutputStream(t);
            in = fi.getChannel();//得到对应的文件通道
            out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 网络下载文件
     * @param httpUrl   网络地址
     * @param filePath  文件地址
     * @return  boolean
     */
    public static boolean httpDownload(String httpUrl,String filePath){
        File file = new File(filePath);
        return httpDownload(httpUrl,file);
    }

    /**
     * 网络下载文件
     * @param httpUrl   网络地址
     * @param file  文件
     * @return  boolean
     */
    public static boolean httpDownload(String httpUrl,File file){
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;
        URL url = null;
        URLConnection conn = null;
        InputStream inStream = null;
        FileOutputStream fs = null;
        try {
            url = new URL(httpUrl);
            conn = url.openConnection();
            inStream = conn.getInputStream();
            fs = new FileOutputStream(file);

            byte[] buffer = new byte[1204];
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if(fs != null)
                    fs.close();
                if(inStream != null)
                    inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
