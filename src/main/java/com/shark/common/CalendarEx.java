package com.shark.common;

import java.util.Calendar;

/**
 * 日历扩展实体类    日期格式为：xxxx-yy-zz
 *
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-12-13:58
 * @projectName SharkUtils
 * @packageName com.shark.common
 */
public class CalendarEx {
    /**
     * 日期属性：年
     */
    private int x;
    /**
     * 日期属性：月
     */
    private int y;
    /**
     * 日期属性：日
     */
    private int z;
    /**
     * 当前日期
     */
    private Calendar localTime;

    public CalendarEx() {
        localTime = Calendar.getInstance();
        x = localTime.get(Calendar.YEAR);
        y = localTime.get(Calendar.MONTH) + 1;
        z = localTime.get(Calendar.DATE);
    }

    public static CalendarEx getInstance() {
        return new CalendarEx();
    }

    /**
     * 得到当前日期 格式为：xxxx-yy-zz 2019-04-12
     *
     * @return String
     */
    public String today() {
        return x + "-" + thisMonth() + "-" + thisDay();
    }

    /**
     * 得到当前日期 格式为：zz 12
     *
     * @return
     */
    public String thisDay() {
        return z >= 10 ? String.valueOf(z) : ("0" + z);
    }

    /**
     * 得到当前月份月初 格式为：xxxx-yy-zz 2019-04-01
     *
     * @return String
     */
    public String thisMonthBegin() {
        return thisMonth() + "-01";
    }

    /**
     * 得到当前月份 格式为：xxxx-yy 2019-04
     *
     * @return
     */
    public String thisMonth() {
        String strY = y >= 10 ? String.valueOf(y) : ("0" + y);
        return x + "-" + strY;
    }

    /**
     * 得到当前月份月底 格式为：xxxx-yy-zz 2019-04-30
     *
     * @return String
     */
    public String thisMonthEnd() {
        String strZ = null;
        if (y == 1 || y == 3 || y == 5 || y == 7 || y == 8 || y == 10 || y == 12) {
            strZ = "31";
        }
        if (y == 4 || y == 6 || y == 9 || y == 11) {
            strZ = "30";
        }
        if (y == 2) {
            boolean leap = leapYear(x);
            if (leap) {
                strZ = "29";
            } else {
                strZ = "28";
            }
        }
        return thisMonth() + "-" + strZ;
    }

    /**
     * 得到当前季度季初 格式为：xxxx-yy-zz 2019-04-01
     *
     * @return String
     */
    public String thisSeason() {
        String dateString = "";
        if (y >= 1 && y <= 3) {
            dateString = x + "-" + "01" + "-" + "01";
        } else if (y >= 4 && y <= 6) {
            dateString = x + "-" + "04" + "-" + "01";
        } else if (y >= 7 && y <= 9) {
            dateString = x + "-" + "07" + "-" + "01";
        } else if (y >= 10 && y <= 12) {
            dateString = x + "-" + "10" + "-" + "01";
        }
        return dateString;
    }

    /**
     * 得到当前季度季末 格式为：xxxx-yy-zz 2019-06-30
     *
     * @return String
     */
    public String thisSeasonEnd() {
        String dateString = "";
        if (y >= 1 && y <= 3) {
            dateString = x + "-" + "03" + "-" + "31";
        } else if (y >= 4 && y <= 6) {
            dateString = x + "-" + "06" + "-" + "30";
        } else if (y >= 7 && y <= 9) {
            dateString = x + "-" + "09" + "-" + "30";
        } else if (y >= 10 && y <= 12) {
            dateString = x + "-" + "12" + "-" + "31";
        }
        return dateString;
    }

    /**
     * 得到当前年份年初 格式为：xxxx-yy-zz 2019-01-01
     *
     * @return String
     */
    public String thisYearBegin() {
        return x + "-01" + "-01";
    }

    /**
     * 得到当前年份年底 格式为：xxxx-yy-zz 2019-12-31
     *
     * @return String
     */
    public String thisYearEnd() {
        return x + "-12" + "-31";
    }

    /**
     * 判断输入年份是否为闰年
     *
     * @param year
     * @return boolean
     */
    public boolean leapYear(int year) {
        boolean leap;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) leap = true;
                else leap = false;
            } else leap = true;
        } else leap = false;
        return leap;
    }

    public static void main(String[] args) {
        String today = CalendarEx.getInstance().thisYearEnd();
        System.out.println(today);
    }
}
