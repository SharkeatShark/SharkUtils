package com.shark.util;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 数组工具类
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-04-9:36
 * @projectName SharkUtils
 * @packageName com.shark.util
 */
public class ArrayUtil {

    /**
     * 求两个数组的并集，利用set的元素唯一性
     * @param arr1
     * @param arr2
     * @param <T>
     * @return 返回 T[]
     */
    public static <T>  T[] unionToArray(T[] arr1, T[] arr2) {
        Set<T> set = unionToSet(arr1,arr2);
        return set.toArray(createGenericArray(arr1, 0));
    }

    /**
     * 求两个数组的并集，利用set的元素唯一性
     * @param arr1
     * @param arr2
     * @param <T>
     * @return 返回 Set<T>
     */
    public static <T>  Set<T> unionToSet(T[] arr1, T[] arr2) {
        Set<T> set = new HashSet((arr1.length > arr2.length) ? arr1.length : arr2.length);
        for (T str : arr1) {
            set.add(str);
        }
        for (T str : arr2) {
            set.add(str);
        }
        return set;
    }

    /**
     * 求两个数组的交集 数组
     * @param arr1
     * @param arr2
     * @param <T>
     * @return 返回 T[]
     */
    public static <T> T[] intersectToArray(T[] arr1, T[] arr2){
        List<T> list = intersectToList(arr1,arr2);
        return list.toArray(createGenericArray(arr1, 0));
    }

    /**
     * 求两个数组的交集 列表
     * @param arr1
     * @param arr2
     * @param <T>
     * @return 返回 List<T>
     */
    public static <T> List<T> intersectToList(T[] arr1, T[] arr2){
        Map<T, Boolean> map = new HashMap((arr1.length > arr2.length) ? arr1.length/2 : arr2.length/2);
        List<T> list = new ArrayList<T>();
        for (T str : arr1){
            if (!map.containsKey(str))
                map.put(str, Boolean.FALSE);
        }
        for (T str : arr2){
            if (map.containsKey(str))
                map.put(str, Boolean.TRUE);
        }
        for (Iterator<Map.Entry<T, Boolean>> it = map.entrySet().iterator(); it.hasNext();){
            Map.Entry<T,Boolean> e = it.next();
            if (e.getValue().equals(Boolean.TRUE))
                list.add(e.getKey());
        }
        return list;
    }

    /**
     * 数组转为 list
     * @param arr
     * @param <T>
     * @return 返回 List<T>
     */
    public static <T> List<T> arrToList(T[] arr){
        return Arrays.asList(arr);
    }

    @Test
    public void test() {
        String[] arr1 = {"1","2","3","3","4","5","6","7"};
        String[] arr2 = {"10","9","8","7","6","5","4","2"};
        String[] strings = unionToArray(arr1, arr2);
        /*// 求两个数组的并集
        Arrays.stream(strings).forEach(s -> System.out.println(s) );
        System.out.println("=======================");
        Set<String> strings1 = unionToSet(arr1, arr2);
        strings1.forEach(s -> System.out.println(s) );
        System.out.println("=======================");*/
        /*// 求两个数组的交集
        String[] strings2 = intersectToArray(arr1, arr2);
        Arrays.stream(strings2).forEach(s -> System.out.println(s) );
        System.out.println("=======================");
        List<String> strings3 = intersectToList(arr1, arr2);
        strings3.forEach(s -> System.out.println(s) );
        System.out.println("=======================");*/
        /*// 从 arr中 移除 obj中的元素
        List<String> strings1 = removeObjToList(arr1, arr2);
        strings1.forEach(s -> System.out.println(s) );
        System.out.println("=======================");
        String[] strings2 = removeObjToArray(arr1, arr2);
        Arrays.stream(strings2).forEach(s -> System.out.println(s) );
        System.out.println("=======================");*/
        String haha = mergeStrArr(arr1, "haha");
        System.out.println(haha);
    }

    /**
     *  从 arr中 移除 obj中的元素  obj需要覆写 toString()  方法
     * @param arr   源
     * @param obj   需要移除的元素
     * @param <T>  元素泛型
     * @return  返回 List<T> 类型
     */
    public static <T> List<T> removeObjToList(T[] arr,T[] obj){
        List<T> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < obj.length; j++) {
                if(arr[i].toString().equals(obj[j].toString())) {
                    flag = false;
                    break;
                }
            }
            if(flag) list.add(arr[i]);
        }
        return list;
    }

    /**
     * 从 arr中 移除 obj中的元素    需要覆写 toString()  方法
     * @param arr
     * @param obj
     * @param <T>
     * @return  返回 T[] 类型
     */
    public static <T> T[] removeObjToArray(T[] arr,T[] obj){
        List<T> list = removeObjToList(arr, obj);
        return list.toArray(createGenericArray(arr,0));
    }

    /**
     * 合并字符串数组,并指定间隔符
     * @param arr 数组合并
     * @param str
     * @return
     */
    public static String mergeStrArr(String[] arr,String str){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if(i != arr.length -1){
                sb.append(arr[i]+str);
            }else{
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 泛型数组 初始化
     * @param arr
     * @param size 初始化大小 默认输入 0
     * @param <T>
     * @return 返回 T[]
     */
    public static <T> T[] createGenericArray (T[] arr, int size){
        return (T[]) Array.newInstance(arr.getClass().getComponentType(), size);
    }
}
