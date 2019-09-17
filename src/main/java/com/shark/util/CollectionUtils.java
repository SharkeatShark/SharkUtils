package com.shark.util;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 集合工具类
 *
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-08-14:40
 * @projectName SharkUtils
 * @packageName com.shark.util
 */
public class CollectionUtils {

    /**
     * list中元素的方法作为Map的K键，元素作为Map的V值。 CollectionUtil.list2Map(strings, "toString", String.class);
     *
     * @param list          列表
     * @param keyMethodName 方法名
     * @param c             类型
     * @param <K>           键
     * @param <V>           值
     * @return 返回 Map<K, V> 类型
     */
    public static <K, V> Map<K, V> list2Map(List<V> list, String keyMethodName, Class<V> c) { // 列表中的类型和class类型相同注意
        Map<K, V> map = new HashMap<K, V>();
        if (list != null) {
            try {
                Method methodGetKey = c.getMethod(keyMethodName);
                for (int i = 0; i < list.size(); i++) {
                    V value = list.get(i);
                    @SuppressWarnings("unchecked")
                    K key = (K) methodGetKey.invoke(list.get(i));
                    map.put(key, value);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("field can't match the key!");
            }
        }
        return map;
    }

    /**
     * 拆分集合 分批带零头
     *
     * @param <T>
     * @param resList 要拆分的集合
     * @param count   每个集合的元素个数
     * @return List<List<T>>    返回拆分后的各个集合 最后不足的作为一个返回
     */
    public static <T> List<List<T>> split(List<T> resList, int count) {
        if (resList == null || count < 1)
            return null;
        List<List<T>> ret = new ArrayList<List<T>>();
        int size = resList.size();
        // 数据量不足count指定的大小
        if (size <= count) {
            ret.add(resList);
        } else {
            int pre = size / count;
            int last = size % count;
            //前面pre个集合，每个大小都是count个元素
            for (int i = 0; i < pre; i++) {
                List<T> itemList = new ArrayList<T>();
                for (int j = 0; j < count; j++) {
                    itemList.add(resList.get(i * count + j));
                }
                ret.add(itemList);
            }
            //last的进行处理
            if (last > 0) {
                List<T> itemList = new ArrayList<T>();
                for (int i = 0; i < last; i++) {
                    itemList.add(resList.get(pre * count + i));
                }
                ret.add(itemList);
            }
        }
        return ret;
    }

    /**
     * 拆分集合 分批带零头
     *
     * @param listSrc     要拆分的集合
     * @param multipleNum 每个集合的元素个数
     * @param <T>
     * @return List<List<T>> 返回拆分后的各个集合 最后不足的作为一个返回
     */
    public static <T> List<List<T>> splitList(List<T> listSrc, Integer multipleNum) {
        List<List<T>> listOutter = new ArrayList<>();
        List<T> listInner = new ArrayList<>();
        int length = listSrc.size();// 列表长度
        int num = length / multipleNum;// 倍数
        int remainder = length % multipleNum;// 模
        int count = 1;// 计数
        boolean flag = false;
        if (num == 0 ? true : false) {
            flag = true;
        }
        for (int i = 0; i < length; i++) {
            listInner.add(listSrc.get(i));
            if (count % multipleNum == 0 ? true : false) {
                listOutter.add(listInner);
                listInner = new ArrayList<>();
            }
            if (num * multipleNum == count && remainder != 0) {
                flag = true;
            }
            if (flag && count % multipleNum == remainder ? true : false) {
                listOutter.add(listInner);
            }
            count++;
        }
        return listOutter;
    }

    /**
     * 总数量均匀分配，多余的放最后一部分
     *
     * @param listSrc
     * @param multipleNum
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> splitListEq(List<T> listSrc, Integer multipleNum) {
        List<List<T>> listOutter = new ArrayList();
        int length = listSrc.size();// 列表长度
        int num = length / multipleNum;//
        int remainder = length % multipleNum;// 模
        if (remainder == 0) { // 能否整除
            for (int i = 0; i < multipleNum; i++) {
                List<T> listInner = new ArrayList();
                for (int j = num * i; j < (i + 1) * num; j++) {
                    listInner.add(listSrc.get(j));
                }
                listOutter.add(i, listInner);
            }
        } else {
            for (int i = 0; i < multipleNum - 1; i++) {
                List<T> listInner = new ArrayList();
                for (int j = num * i; j < (i + 1) * num; j++) {
                    listInner.add(listSrc.get(j));
                }
                listOutter.add(i, listInner);
            }
            List<T> listInner = new ArrayList();
            for (int i = (num * (multipleNum - 1)); i < length; i++) {
                listInner.add(listSrc.get(i));
            }
            listOutter.add(multipleNum - 1, listInner);
        }
        return listOutter;
    }

    /**
     * 获取 其中一段的list元素
     * @param list  源
     * @param pageNum   页数（计算开始地址）
     * @param pageSize  size 返回list大小
     * @param <T>   泛型
     * @return  List<T>
     */
    public static <T> List<T> getPageFromList(List<T> list, int pageNum, int pageSize){
        int start = (pageNum - 1) * pageSize;
        List<T> result = new ArrayList<T>();
        if(start < list.size()){
            for (int i = 0; i < pageSize; i++) {
                if(start + i < list.size()){
                    result.add(list.get(start+i));
                }else{
                    break;
                }
            }
        }
        return result;
    }

    @Test
    public void testEqList() {
        // 初始化
        List list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i, i);
        }
        // 循环天数
        for (int day = 10; day >= 1; day--) {
            System.out.println("剩余领取数量" + list.size());
            List list1 = splitListEq(list, day);
            System.out.println("天数：" + day + "，均分份数：" + list1.size() + "，头一个：" + list1.get(0).toString() + "，尾一个：" + list1.get(list1.size() - 1).toString());
            List useed = (List) list1.get(0);
            for (int i = 0; i < useed.size(); i++) {
                list.remove(useed.get(i));
            }
            System.out.println("第" + day + "天，领用了" + useed.size() + "个,还剩" + list.size() + "个");
            if (day == 7) {
                int start = (int) list.get(list.size() - 1);
                int num = 53;
                int end = start + num;
                int index = list.size();
                for (int i = start + 1; i <= end; i++, index++) {
                    list.add(index, i);
                }
                System.out.println("第" + day + "天，增加数量" + num + "个,还剩" + list.size() + "个");
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> resList = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98");
//        List<List<String>> ret = split(resList, 10);
        List<List<String>> ret = splitList(resList, 10);
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
        }
    }

}
