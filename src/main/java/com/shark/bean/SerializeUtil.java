package com.shark.bean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 类序列化工具
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-25-18:12
 * @projectName SharkUtils
 * @packageName com.shark.bean
 */
public class SerializeUtil {

    /**
     * 序列化
     * @param object    源对象
     * @return  byte[]  序列化数组
     */
    public static byte[] serialize(Object object) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化
     * @param bytes 序列化对象
     * @param tClass    返回类型
     * @param <T>   泛型
     * @return  <T> T
     */
    @SuppressWarnings("unchecked")
    public static <T> T unserialize(byte[] bytes, Class<T> tClass) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
