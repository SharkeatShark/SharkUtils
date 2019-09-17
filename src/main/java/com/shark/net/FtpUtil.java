package com.shark.net;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FTP 服务器工具类
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-18-11:20
 * @projectName SharkUtils
 * @packageName com.shark.io
 */
public class FtpUtil {
    /**
     *
     * @param url
     * @param port
     * @param username
     * @param password
     * @param path
     * @param filename
     * @param input
     * @return
     */
    public static boolean uploadFile(String url, int port, String username,
                                     String password, String path, String filename, InputStream input) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(url, port);// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.changeWorkingDirectory(path);
            ftp.storeFile(filename, input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    /**
     *
     * @param url
     * @param port
     * @param username
     * @param password
     * @param path
     * @param filename
     * @param input
     * @return
     */
    public static boolean uploadFile2(String url, int port, String username,
                                      String password, String path, String filename, InputStream input) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(url, port);// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.changeWorkingDirectory(path);
            ftp.storeFile(filename, input);

            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    /**
     *
     * @param url
     * @param port
     * @param username
     * @param password
     * @param remotePath
     * @param fileName
     * @param localPath
     * @return
     */
    public static boolean downFile(String url, int port, String username,
                                   String password, String remotePath, String fileName,
                                   String localPath) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(url, port);
            // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }

            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "/" + ff.getName());
                    OutputStream is = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                }
            }
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    /**
     *
     * @param url
     * @param port
     * @param username
     * @param password
     * @param remotePath
     * @param fileSuffix
     * @return
     */
    public static List<String[]> loadFileList(String url, int port, String username,
                                              String password, String remotePath, String fileSuffix){
        FTPClient ftp = new FTPClient();
        List<String[]> result = new ArrayList<String[]>();
        try {
            int reply;
            ftp.connect(url, port);
            // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return null;
            }
            ftp.setControlEncoding("GBK");
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            String[] item=null;
            for (FTPFile ff : fs) {
                String name = ff.getName();
                if(StringUtils.isBlank(fileSuffix) || (StringUtils.isNotBlank(fileSuffix) && name.lastIndexOf(fileSuffix)==name.replace(fileSuffix,"").length())){
                    item  = new String[2];
                    item[0] = name;
                    item[1] = String.valueOf(ff.getType());
                    result.add(item);
                }
            }
            ftp.logout();
        } catch (IOException e) {
            return null;
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String url = "yexiao.19ye.cn";
        int port = 21;
        String username = "yexiao";
        String password = "yexiao1987";
        String remotePath = "/root";
        //System.out.println("test.php".lastIndexOf(".php")=="test.php".replace(".php","").length());

        System.out.println(JSON.toJSONString(FtpUtil.loadFileList(url, port, username, password, remotePath,"png")));
    }
}
