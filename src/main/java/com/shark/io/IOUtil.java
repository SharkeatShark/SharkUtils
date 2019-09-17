package com.shark.io;

import java.io.*;
import java.util.ArrayList;

/**
 * 常用IO 流操作
 */
public class IOUtil implements Serializable {

    public static String readString(Reader reader) throws IOException {
        if (reader == null) {
            return null;
        }

        StringBuffer result = new StringBuffer();
        char[] cbuf = new char[8 * 1024];
        int len = 0;
        while (len != -1) {
            len = reader.read(cbuf, 0, cbuf.length);
            if (len > 0) {
                result.append(cbuf, 0, len);
            }
        }
        reader.close();

        return result.toString();
    }

    public static byte[] readLargeBinary(InputStream is) throws IOException {
        if (is == null)
            return null;

        ArrayList al = new ArrayList();
        byte[] b = new byte[10240];
        int alllen = 0;
        int len = 0;
        while ((len = is.read(b)) != -1) {
            alllen += len;
            byte[] b1 = new byte[len];
            System.arraycopy(b, 0, b1, 0, len);
            al.add(b1);
        }
        is.close();

        b = new byte[alllen];
        int pos = 0;
        for (int i = 0; i < al.size(); i++) {
            byte[] b1 = (byte[]) al.get(i);
            System.arraycopy(b1, 0, b, pos, b1.length);
            pos += b1.length;
        }
        return b;
    }

    public static void writeObject(Object obj, OutputStream os) throws
            IOException {
        ObjectOutputStream p = new ObjectOutputStream(os);
        p.writeObject(obj);
        p.flush();
        p.close();
        p = null;

        os.close();
    }

    public static Object readObject(InputStream is) throws IOException,
            ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(is);
        Object obj = ois.readObject();
        ois.close();
        is.close();

        return obj;
    }

    public static byte[] Object2Bytes(Object obj) throws IOException {
        if (obj == null) {
            return null;
        }

        byte[] b;

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        writeObject(obj, os);
        b = os.toByteArray();
        os.close();
        os = null;

        return b;
    }

    public static Object Bytes2Object(byte[] b) throws IOException,
            ClassNotFoundException {
        return readObject(new ByteArrayInputStream(b));
    }

    public static Object clone(Object obj) throws IOException,
            ClassNotFoundException {
        return Bytes2Object(Object2Bytes(obj));
    }

    public static void forceClose(InputStream is) {
        try {
            is.close();
        }
        catch (IOException e) {
        }
    }

    public static void forceClose(OutputStream is) {
        try {
            is.close();
        }
        catch (IOException e) {
        }
    }
}