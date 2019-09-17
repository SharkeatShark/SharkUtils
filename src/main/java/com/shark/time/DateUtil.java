package com.shark.time;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 时间 工具类
 *
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-11-14:05
 * @projectName SharkUtils
 * @packageName com.shark.util
 */
public class DateUtil {

    /**
     * 年月日时分秒(无下划线) yyyyMMddHHmmss
     */
    public static final String DTLONG = "yyyyMMddHHmmss";
    /**
     * 完整时间 yyyy-MM-dd HH:mm:ss
     */
    public static final String SIMPLE = "yyyy-MM-dd HH:mm:ss";
    /**
     * 年月日时分秒毫秒 yyyy-MM-dd HH:mm:ss:SS
     */
    public static final String DTFULL = "yyyy-MM-dd HH:mm:ss:SS";
    /**
     * 年月日时分秒毫秒 数字串
     */
    public static final String DTLONGS = "yyyyMMddHHmmssSSS";
    /**
     * 年月日(无下划线) yyyyMMdd
     */
    public static final String DTSHORT = "yyyyMMdd";
    /**
     * 周几名称
     */
    final static String dayNames[] = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };

    /**
     * 传入时间格式将当前时间格式化输出 "yyyy-MM-dd HH:mm:ss"
     *
     * @return String
     */
    public static String getCurrentDate() {
        return getCurrentDate(SIMPLE);
    }

    /**
     * 传入时间格式将当前时间格式化输出
     *
     * @param formatterStr 时间格式
     * @return String
     */
    public static String getCurrentDate(String formatterStr) {
        return getStringByDate(new Date(), formatterStr);
    }

    /**
     * 传入毫秒数转换为格式化日期字符串返回
     *
     * @param millis    毫秒数
     * @param formatterStr  格式
     * @return String
     */
    public static String getStringByMillis(long millis, String formatterStr) {
        return getStringByDate(getDateByMillis(millis), formatterStr);
    }

    /**
     * date 数据 格式化 返回字符
     *
     * @param date  时间
     * @param formatterStr  格式
     * @return String
     */
    public static String getStringByDate(Date date, String formatterStr) {
        SimpleDateFormat formatter = null;
        if(StringUtils.isEmpty(formatterStr)){
            formatter = new SimpleDateFormat(DTLONG);
        }else{
            formatter = new SimpleDateFormat(formatterStr);
        }
        return formatter.format(date);
    }

    /**
     * 传入毫秒数转换为日期字符串返回
     *
     * @param millis 毫秒数
     * @return String
     */
    public static String getStringByMillis(long millis) {
        return getStringByMillis(millis,null);
    }

    /**
     * 传入偏移毫秒数转换为日期
     *
     * @param millis    偏移毫秒数
     * @return Date
     */
    public static Date getDateByMillis(long millis) {
        Date date = new Date();
        date.setTime(millis);
        return date;
    }

    /**
     * 将原时间Str转换为目标Str 传入 时间字符串 原时间格式 和 目标格式
     *
     * @param date            时间字符串
     * @param srcFormatterStr 原时间格式
     * @param tagFormatterStr 目标格式
     * @return String
     * @throws ParseException 格式化异常
     */
    public static String getDateFormat(String date, String srcFormatterStr, String tagFormatterStr)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(srcFormatterStr);
        Date parseDate = formatter.parse(date);
        String dateStr = new SimpleDateFormat(tagFormatterStr).format(parseDate);
        return dateStr;
    }


    /**
     * 节假日获取 0为工作日 1为星期天 2为法定假日
     *
     * @param dateStr "yyyyMMdd"格式的日期 为空时默认为当天时间
     * @throws IOException   IO异常
     * @throws HttpException http异常
     * @throws Exception     假期接口调用错误时抛出异常
     */
    public static Integer holidayVer(String dateStr) throws Exception {
        HttpClient httpClient = new HttpClient();
        String url = "net://api.goseek.cn/Tools/holiday?date=";
        if (dateStr == null || dateStr.equals("")) {
            String dateFormat = getCurrentDate("yyyyMMdd");
            url += dateFormat;
        } else {
            url += dateStr;
        }
        GetMethod getMethod = new GetMethod(url);
        getMethod.addRequestHeader("Accept", "text/html, application/xhtml+xml, image/jxr, */*");
        getMethod.addRequestHeader("Accept-Encoding", "gzip, deflate");
        getMethod.addRequestHeader("Accept-Language", "zh-Hans-CN, zh-Hans; q=0.5");
        getMethod.addRequestHeader("Connection", "Keep-Alive");
        getMethod.addRequestHeader("Host", "api.goseek.cn");
        // getMethod.addRequestHeader("If-Modified-Since", "Mon, 25 Dec 2017 07:05:41b
        // GMT");
        getMethod.addRequestHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299");
        Integer executeMethod = null;
        try {
            executeMethod = httpClient.executeMethod(getMethod);
        } catch (IOException e) {
            throw new Exception("IOException:" + e);
        }
        if (executeMethod == 200) {
            String stemp;
            try {
                stemp = getMethod.getResponseBodyAsString();
            } catch (IOException e) {
                throw new Exception("IOException:" + e);
            }
            JSONObject json = (JSONObject) JSONObject.parse(stemp);
            return json.getInteger("data");
        } else {
            throw new Exception("假期接口调用错误：错误返回码-----" + executeMethod);
        }
    }

    /**
     * 获取美国时间
     *
     * @param date 时间
     * @return String
     */
    public static String formatUSDate(Date date) {
        TimeZone timeZoneNY = TimeZone.getTimeZone("America/New_York");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.US);
        outputFormat.setTimeZone(timeZoneNY);
        return outputFormat.format(date);
    }

    /**
     * 时间转换为中国时区时间
     *
     * @param date 时间字符
     * @return String
     */
    public static String toChinaDate(String date) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        try {
            return sdf.format(sdf1.parse(date)).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断 时间 是否是当天
     *
     * @param date 时间
     * @return boolean
     */
    public static boolean isToday(Date date) {
        if (date == null)
            return false;
        Calendar a = Calendar.getInstance();
        Calendar b = Calendar.getInstance();
        b.setTime(date);
        return a.get(Calendar.DAY_OF_MONTH) == b.get(Calendar.DAY_OF_MONTH)
                && a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.YEAR) == b.get(Calendar.YEAR);
    }

    /**
     * 当前时间增加指定分钟数后得到的时间
     *
     * @param minuteAmount 指定分钟
     * @return Date
     */
    public static Date addMinutes(int minuteAmount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, minuteAmount);
        return calendar.getTime();
    }

    /**
     * 当前日期 加上|减去 天数后得到的时间
     * @param dayAmount 指定天数 可以为负数
     * @param yyyyMMdd  字符串日期
     * @return
     */
    public static Date addDays(String yyyyMMdd, int dayAmount) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DTSHORT);
        if(StringUtils.isEmpty(yyyyMMdd)){
            return addDays(dayAmount, null);
        } else {
            Date date = simpleDateFormat.parse(yyyyMMdd);
            return addDays(dayAmount, date);
        }
    }

    /**
     * 当前日期 加上|减去 天数后得到的时间
     * @param dayAmount 指定天数 可以为负数
     * @param date  日期
     * @return
     */
    public static Date addDays(int dayAmount,Date date) {
        Calendar calendar = Calendar.getInstance();
        if(null != date ){
            calendar.setTime(date);
        }else{
            calendar.setTime(new Date());
        }
        calendar.add(Calendar.DATE, dayAmount);
        return calendar.getTime();
    }



    /**
     * 当前日期 加上|减去 天数后得到的时间
     *
     * @param dayAmount 指定天数 可以为负数
     * @return  Date
     */
    public static Date addDays(int dayAmount) throws ParseException {
        return addDays(null , dayAmount);
    }

    /**
     * 获取当前时区 ID  亚洲/上海  Asia/Shanghai
     *
     * @return String
     */
    public static String getTimeZoneID() {
        return Calendar.getInstance().getTimeZone().getID();
    }

    /**
     * 返回时间 的周几
     * @param date date
     * @return String 周日
     */
    public static String toWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0) dayOfWeek = 0;
        return dayNames[dayOfWeek];
    }

    /**
     * 计算两个日期之间相差的天数  int类型
     * @param smdate 较小的时间  date类型
     * @param bdate  较大的时间  date类型
     * @return 相差天数 -1 为空 或者 结束时间比开始时间大 异常返回
     * @throws ParseException 解析错误
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        if(null == smdate || null == bdate || bdate.before(smdate)){
            return -1;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DTSHORT);
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算两个日期之间相差的天数  int 类型
     * @param smdate 较小的时间  String 类型 默认格式：yyyyMMdd
     * @param bdate  较大的时间  String 类型 默认格式：yyyyMMdd
     * @return 相差天数
     * @throws ParseException 解析错误
     */
    public static int daysBetween(String smdate, String bdate,String formatterStr) throws ParseException {
        SimpleDateFormat sdf = null;
        if (StringUtils.isEmpty(formatterStr)) {
            sdf = new SimpleDateFormat(DTSHORT);
        }
        sdf = new SimpleDateFormat(formatterStr);
        return daysBetween(sdf.parse(smdate), sdf.parse(bdate));
    }


    /**
     * 校验当前时间是否在传入时间范围内
     * @param start 开始时间
     * @param end   结束时间
     * @return  boolean
     * @throws Exception
     */
    public static boolean diffDays(Date start,Date end) {
        Date currentDate = new Date();
        if(null == start || null == end || end.before(start)|| start.after(currentDate))
            return false;
        if(end.before(currentDate))
            return false;
        return true;
    }

    /**
     * 计算某个时间点与当前时间相差秒数
     * @param exerciseTimes 某个时间点毫秒数
     * @return  long
     */
    public static long getExpireTimeIn(long exerciseTimes) {
        long currentTimeMillis = System.currentTimeMillis();
        long expireTime = (exerciseTimes - currentTimeMillis)/1000;
        long expireTimeIn = 0;
        if(0<expireTime && expireTime<=Long.MAX_VALUE){
            expireTimeIn = (int)expireTime ;
        }else if(expireTime > Long.MAX_VALUE){
            expireTimeIn = Long.MAX_VALUE;
        }
        return expireTimeIn;
    }

    public static void main(String[] args) throws Exception {
        /*Integer integer = holidayVer(getDateFormat("yyyyMMdd"));
        System.out.println(integer);*/
        String s = getTimeZoneID();
        System.out.println(s);
    }
}
