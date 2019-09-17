package com.shark.util;

/**
 * boolean 多个判断 判断
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-03-11:05
 * @projectName SharkUtils
 * @packageName com.shark.util
 */
public class BooleanUtil {

    /**
     * 多个标志 判断是否都为false 全为fasle返回true
     * @param flag
     * @return true 全为true返回true; false 有一个为false则返回false
     */
    public static boolean isALLFalse(boolean... flag) {
        for (boolean b : flag) {
            if (b)  return false;
        }
        return true;
    }

    /**
     * 多个标志 判断是否都为true 全为true返回true
     * @param flag
     * @return true 全为true返回true; false 有一个为false则返回false
     */
    public static boolean isALLTrue(boolean... flag) {
        for (boolean b : flag) {
            if (!b) return false;
        }
        return true;
    }
}
