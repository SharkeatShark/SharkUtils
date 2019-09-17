package com.shark;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author sharkeatshark@foxmail.com
 * @create 2019-08-15-14:39
 * @projectName SharkUtils
 * @packageName com.shark
 */
public class testNio {

    @Test
    public void readHTMLContent() {
        Charset charset = Charset.forName("utf8");// 创建GBK字符集
        SocketChannel channel = null;
        try {
            InetSocketAddress socketAddress = new InetSocketAddress(
                    "www.baidu.com", 80);
            //step1:打开连接
            channel = SocketChannel.open(socketAddress);
            //step2:发送请求，使用utf8编码
            channel.write(charset.encode("GET " + "/ HTTP/1.1" + "\r\n\r\n"));
            //step3:读取数据
            ByteBuffer buffer = ByteBuffer.allocate(1024);// 创建1024字节的缓冲
            while (channel.read(buffer) != -1) {
                buffer.flip();// flip方法在读缓冲区字节操作之前调用。
                System.out.println(charset.decode(buffer));
                // 使用Charset.decode方法将字节转换为字符串
                buffer.clear();// 清空缓冲
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String infile = "C:\\Users\\SHARK\\Desktop\\孙寒最近工作内容及耗时.txt";
        String outfile = "C:\\Users\\SHARK\\Desktop\\新建文本文档11.txt";
        // 获取源文件和目标文件的输入输出流
        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);        // 获取输入输出通道
        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);// new 一个全新的缓冲区
        while (true) {            // clear方法重设缓冲区，使它可以接受读入的数据
            buffer.clear();            // 从输入通道中将数据读到缓冲区
            int r = fcin.read(buffer);            // read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
            if (r == -1) {
                break;
            }
            buffer.flip();// flip方法让缓冲区可以将新读入的数据写入另一个通道
            fcout.write(buffer);// 从输出通道中将数据写入缓冲区
        }
    }
}
