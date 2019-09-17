package com.shark.latitude;

import java.math.BigDecimal;

/**
 * 经纬度工具类
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-12-16:50
 * @projectName SharkUtils
 * @packageName com.shark.latitude
 */
public class LatitudeUtil {

    /**
     * 地球半径
     */
    public final static Double R = 6378137D;

    /**
     * 计算地球上任意两点(经纬度)距离
     *
     * @param long1 第一点经度
     * @param lat1  第一点纬度
     * @param long2 第二点经度
     * @param lat2  第二点纬度
     * @return 返回距离 单位：米
     */
    public static double distance(double long1, double lat1, double long2, double lat2) {
        double a, b;
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        a = lat1 - lat2;
        b = (long1 - long2) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2
                * R
                * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
                * Math.cos(lat2) * sb2 * sb2));
        return d;
    }

    /**
     * DMS(度分秒)转换为Double
     * @param DMS
     * @return
     */
    public static double DMStoDD(String DMS){
        double degree = Double.valueOf(DMS.split("°")[0]);
        double branch = Double.valueOf(DMS.split("°")[1].split("′")[0]);
        double second = Double.valueOf(DMS.split("°")[1].split("′")[1].split("″")[0]);
        return add(degree, add(div(branch, 60), div(second, 3600)));
    }

    /**
     * 除
     * @param v1
     * @param v2
     * @return
     */
    private static double div(double v1,double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, 10, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 加
     * @param v1
     * @param v2
     * @return
     */
    private static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).setScale(10,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
//		LatitudeUtil.distance(long1, lat1, long2, lat2);
        System.out.println(LatitudeUtil.DMStoDD("31°13′31″"));
        System.out.println(LatitudeUtil.DMStoDD("121°26′48″"));

        System.out.println(LatitudeUtil.distance(31.2252777778,121.4466666666,32,121.4466666666));

    }
}
