package com.shark;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-08-13:53
 * @projectName SharkUtils
 * @packageName com.shark
 */
public class CeShiLei {

    static int count = 11;

    public static void main(String[] args) throws Exception {
//        List<String> betweenSub = StrUtil.getBetweenSub("a无钢圈的设计，舒适贴身。a有助于展现优美的胸型，不易影响上衣外观的无钢圈文胸。a", ",");
//        System.out.println(testInt());
//        testZHIchuandi(count);
        Map<String , Student> map = new HashMap<>(6);
        int i = 5;
        List<Strent> list = new ArrayList<>(5);
        while (i-- > 0){
            Strent strent = new Strent();
            strent.setName("zhangshan" + i);
            strent.setNo(i + "");
            list.add(strent);
        }
        // 属性分别作为键与值
        Map<String, String> collect = list.stream().collect(Collectors.toMap(Strent::getNo, Strent::getName));
        System.out.println(collect);
        // 属于作为键 对象作为值
        Map<String, Strent> collect1 = list.stream().collect(Collectors.toMap(Strent::getNo,strent -> strent));
        System.out.println(collect1);
        //
        list.stream().forEach(s -> {

        });

        System.out.println(count);

    }

    private static int testInt(){
        int i = 0;
        try{
            i = 1;
            return i;
        }finally {
            i = 2;
            return i;
        }
    }

    @Test
    public void test(){
        testZHIchuandi(count);
        System.out.println(count);
    }

    private static void testZHIchuandi(int count ){
        count = 1111;
        System.out.println(count);
    }

    @Test
    public void testStr(){

    }


}
