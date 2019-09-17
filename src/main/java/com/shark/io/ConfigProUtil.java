package com.shark.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 根据类文件加载资源文件。项目class根目录下
 * @aurthor sunh
 * @create 2018-06-28-16:45
 */
public class ConfigProUtil {

    public static Properties getProperties( String name,Class<?> className){
        Properties properties = new Properties();
        InputStream resourceAsStream = className.getResourceAsStream("/" + name);
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                Exception exception = new Exception("资源文件加载流，关闭失败！", e);
                exception.printStackTrace();
            }
        }
        return properties;
    }

    @Test
    public void test(){
        Properties properties = getProperties("configuration.properties", ConfigProUtil.class);
        Object privatekey = properties.get("DES3.secretKey");
        System.out.println(privatekey);
    }
}
