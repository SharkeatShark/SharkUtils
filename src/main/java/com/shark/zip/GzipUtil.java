package com.shark.zip;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 解压|压缩工具类
 *
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-25-17:27
 * @projectName SharkUtils
 * @packageName com.shark.zip
 */
public class GzipUtil {

    /**
     * gzip 压缩字符
     *
     * @param primStr 源字符
     * @return String
     */
    public static String gzip(String primStr) {
        if (StringUtils.isEmpty(primStr))
            return primStr;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             GZIPOutputStream gzip = new GZIPOutputStream(out)) {
            gzip.write(primStr.getBytes());
            return new BASE64Encoder().encode(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return primStr;
    }

    /**
     * gzip 解压字符
     *
     * @param primStr 源字符
     * @return String
     */
    public static String gunzip(String primStr) {
        if (StringUtils.isEmpty(primStr))
            return primStr;
        ByteArrayInputStream in = null;
        GZIPInputStream ginzip = null;
        byte[] compressed = null;
        String decompressed = null;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            compressed = new BASE64Decoder().decodeBuffer(primStr);
            in = new ByteArrayInputStream(compressed);
            ginzip = new GZIPInputStream(in);
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = ginzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return primStr;
        } finally {
            if (ginzip != null) {
                try {
                    ginzip.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
        return decompressed;
    }


    /**
     * 文件打包下载
     * @param files
     * @param request
     * @param response
     * @param rarFilename
     * @return
     * @throws Exception
     */
    public static HttpServletResponse downLoadFiles(
            List<File> files,HttpServletRequest request, HttpServletResponse response, String rarFilename)throws Exception {
        try {
            /**
             * 这个集合就是你想要打包的所有文件， 这里假设已经准备好了所要打包的文件
             */
            //List<File> files = new ArrayList<File>();

            /**
             * 创建一个临时压缩文件， 我们会把文件流全部注入到这个文件中 这里的文件你可以自定义是.rar还是.zip
             */
            File file = new File(rarFilename);
            if (!file.exists()) {
                file.createNewFile();
            }
            response.reset();
            // response.getWriter()
            // 创建文件输出流
            FileOutputStream fous = new FileOutputStream(file);
            /**
             * 打包的方法我们会用到ZipOutputStream这样一个输出流, 所以这里我们把输出流转换一下
             */
            ZipOutputStream zipOut = new ZipOutputStream(fous);
            /**
             * 这个方法接受的就是一个所要打包文件的集合， 还有一个ZipOutputStream
             */
            zipFile(files, zipOut);
            zipOut.close();
            fous.close();
            return downloadZip(file, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 直到文件的打包已经成功了， 文件的打包过程被我封装在FileUtil.zipFile这个静态方法中，
         * 稍后会呈现出来，接下来的就是往客户端写数据了
         */

        return response;
    }

    /**
     * 把接受的全部文件打成压缩包
     * @param files
     * @param outputStream
     */
    public static void zipFile(List files, ZipOutputStream outputStream) {
        int size = files.size();
        for (int i = 0; i < size; i++) {
            File file = (File) files.get(i);
            zipFile(file, outputStream);
        }
    }

    /**
     *
     * @param file
     * @param response
     * @return
     */
    public static HttpServletResponse downloadZip(File file,
                                                  HttpServletResponse response) {
        try {
            // 以流的形式下载文件。
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(
                    file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();

            BufferedOutputStream toClient = new BufferedOutputStream(
                    response.getOutputStream());
            response.setContentType("application/octet-stream");

            // 如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
            response.setHeader("Content-Disposition", "attachment;filename="
                    + URLEncoder.encode(file.getName(), "UTF-8"));
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                File f = new File(file.getPath());
                f.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    /**
     * 根据输入的文件与输出流对文件进行打包
     *
     * @param inputFile
     * @param ouputStream
     */
    public static void zipFile(File inputFile, ZipOutputStream ouputStream) {
        try {
            if (inputFile.exists()) {
                /**
                 * 如果是目录的话这里是不采取操作的， 至于目录的打包正在研究中
                 */
                if (inputFile.isFile()) {
                    FileInputStream IN = new FileInputStream(inputFile);
                    BufferedInputStream bins = new BufferedInputStream(IN, 512);
                    // org.apache.tools.zip.ZipEntry
                    ZipEntry entry = new ZipEntry(inputFile.getName());
                    ouputStream.putNextEntry(entry);
                    // 向压缩文件中输出数据
                    int nNumber;
                    byte[] buffer = new byte[512];
                    while ((nNumber = bins.read(buffer)) != -1) {
                        ouputStream.write(buffer, 0, nNumber);
                    }
                    // 关闭创建的流对象
                    bins.close();
                    IN.close();
                } else {
                    try {
                        File[] files = inputFile.listFiles();
                        for (int i = 0; i < files.length; i++) {
                            zipFile(files[i], ouputStream);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
