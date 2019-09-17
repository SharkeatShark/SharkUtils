package com.shark.util;

import com.shark.common.PatternCompile;
import com.shark.encrypt.MD5;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.security.SecureRandom;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.bouncycastle.asn1.x509.X509Name.DC;

/**
 * 字符串 工具类
 *
 * @author sharkeatshark@foxmail.com
 * @create 2019-03-29-16:15
 * @projectName SharkUtils
 * @packageName com.shark.util
 */
public class StrUtil {

    /**
     * 根据系统返回换行符
     */
    private static String lineSeparator = System.getProperty("line.separator", "/n");

    static Random random = new SecureRandom();

    /**
     * 字符串为空 返回 true
     *
     * @param str
     * @return 空 true 非 false
     */
    public static boolean isEmpty(String str) {
        if (null == str || str.trim().length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 字符串不为空 返回 true
     *
     * @param str
     * @return 空 false 非 true
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 至少有一个为空返回 true
     *
     * @param args
     * @return 空 true 非 false
     */
    public static boolean isLessEmpty(Object... args) {
        for (Object object : args) {
            if (object instanceof String) {
                String str = (String) object;
                if (null == str || str.trim().length() == 0) return true;
            } else {
                if (null == object) return true;
            }
        }
        return false;
    }

    /**
     * 至少有一个不为空返回 true
     *
     * @param args
     * @return 至少有一个不为空返回 true 非 false
     */
    public static boolean isLessNotEmpty(Object... args) {
        for (Object object : args) {
            if (object instanceof String) {
                String str = (String) object;
                if (null != str && !(str.trim().length() == 0)) return true;
            } else {
                if (null != object) return true;
            }
        }
        return false;
    }

    /**
     * 都不为空返回 true
     *
     * @param args
     * @return 都不为空返回 true
     */
    public static boolean isAllNotEmpty(Object... args) {
        for (Object object : args) {
            if (object instanceof String) {
                String str = (String) object;
                if (null == str || str.trim().length() == 0) return false;
            } else {
                if (null == object) return false;
            }
        }
        return true;
    }

    /**
     * 传入原字符 和 截取标准 将字符串截取为list
     *
     * @param str   原字符串
     * @param regex 截取字符串
     * @return 返回列表
     */
    public static List strSplitToList(String str, String regex) {
        List<String> list = Arrays.asList(str.split(regex));
        return list;
    }

    /**
     * 正则表达式匹配两个指定字符串中间的内容
     *
     * @param soap
     * @param rgex
     * @return
     */
    public static List<String> getBetweenSub(String soap, String rgex) {
        List<String> list = new ArrayList<String>();
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        return list;
    }

    /**
     * 根据正则标准截取字符串，返回符合标准的所有的字符串的集合。
     *
     * @param str   原字符串
     * @param regex 截取标准
     * @return matchRegexList 返回符合标准的所有的字符串集合
     */
    public static List<String> subStrList(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(str);
        List<String> matchRegexList = new ArrayList<>();
        while (m.find()) {
            matchRegexList.add(m.group());
        }
        return matchRegexList;
    }

    /**
     * 根据正则标准截取字符串，返回符合标准的所有的字符串组成新的字符串。
     * 例："获取特定字符在字符串中的位置" 字 "字字"
     *
     * @param str   原字符串
     * @param regex 截取标准
     * @return matchRegexList 返回符合标准的所有的字符串集合
     */
    public static String getSubConTogether(String str, String regex) {
        if (null == str || str.length() == 0) {
            return null;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(str);
        StringBuffer buf = new StringBuffer();
        while (m.find()) {
            buf.append(m.group());
        }
        return buf.toString();
    }

    /**
     * 返回单个字符串，若匹配到多个的话就返回第一个字符串
     *
     * @param soap
     * @param rgex
     * @return 未匹配到返回 ""
     */
    public static String getFirstSub(String soap, String rgex) {
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher m = pattern.matcher(soap);
        while (m.find()) {
            return m.group(0);
        }
        return "";
    }

    /**
     * 获取特定字符在字符串中的位置
     * 例："获取特定字符在字符串中的位置" 字 在字符串中出现第二次的位置 为 7
     *
     * @param string    这里是获取"/"符号的位置
     * @param matString 在该字符串中寻找
     * @param n         当"/"符号第几次次出现的位置
     * @return 不符合返回 0
     */
    public static int getCharacterPosition(String string, String matString, int n) {
        // string这里是获取"/"符号的位置
        // matString  在该字符串中寻找
        Matcher slashMatcher = Pattern.compile(string).matcher(matString);
        int mIdx = 0;
        while (slashMatcher.find()) {
            mIdx++;
            // 当"/"符号第几次次出现的位置
            if (mIdx == n) break;
        }
        return slashMatcher.start();
    }

    /**
     * 剔除数字
     * 例："获取特定100字符在字符串中的位置"
     *
     * @param value
     * @return 参数为空时 返回 ""
     */
    public static String removeDigital(String value) {
        if (value == null || value.length() == 0)
            return "";
        Matcher matcher = PatternCompile.NUMBER_PATTERN_D.matcher(value);
        String result = matcher.replaceAll("");
        return result;
    }

    /**
     * 获取字符串的 编码方式 GB2312   ISO-8859-1  UTF-8   GBK
     *
     * @param str 源
     * @return 返回字符的编码方式   未解析返回 ""
     */
    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }

    /**
     * 生成指定 length 的随机数字和字母
     *
     * @param length
     * @return
     */
    public static String getStringRandom(int length) {
        String val = "";
        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 字符首字符小写
     *
     * @param str
     * @return
     */
    public static String lowerFirstChar(String str) {
        char[] chars = str.toCharArray();
        // 首字符小写 大写是将字符 -32
        chars[0] += 32;
        return String.valueOf(chars);
    }

    /**
     * 字符首字符大写
     *
     * @param str
     * @return
     */
    public static String upperFirstChar(String str) {
        char[] chars = str.toCharArray();
        // 首字符小写 大写是将字符 -32
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    /**
     * 生成6位随机数 字符串
     *
     * @return
     */
    public static String generate6SerialId() {
        int Value = ((int) (100000 + (999999 - 100000) * Math.random()));
        return "" + Value;
    }

    /**
     * 转换文件大小 文件大小转换单位
     *
     * @param fileS
     * @return
     */
    public static String FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    /**
     * 生成随机验证码(数字)
     *
     * @param length 长度
     * @return
     */
    public static String getCaptcha(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("长度不能小于0!");
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(String.valueOf(random.nextInt(10)));
        }
        return sb.toString();
    }

    /**
     * 生成随机验证码(默认6位数字)
     *
     * @return
     */
    public static String getCaptcha() {
        return getCaptcha(6);
    }

    /**
     * 随机生成密码
     *
     * @param upperCaseLength(大写字母长度)
     * @param lowerCaseLength(小写字母长度)
     * @param numberLenght(数字长度)
     * @return
     */
    public static String getPasswordRandom(int upperCaseLength, int lowerCaseLength, int numberLenght) {
        StringBuffer sb = new StringBuffer();
        Set<String> hashSet = new HashSet<String>();
        //随机生成大写字母
        if (upperCaseLength > 0) {
            int result[] = randomCommon(65, 91, upperCaseLength);
            for (int i = 0; i < result.length; i++) {
                hashSet.add(String.valueOf((char) (result[i])));
            }
        }

        //随机生成小写字母
        if (lowerCaseLength > 0) {
            int result[] = randomCommon(97, 123, lowerCaseLength);
            for (int i = 0; i < result.length; i++) {
                hashSet.add(String.valueOf((char) (result[i])));
            }
        }

        //随机生成数字
        if (numberLenght > 0) {
            int result[] = randomCommon(0, 9, numberLenght);
            for (int i = 0; i < result.length; i++) {
                hashSet.add(String.valueOf(result[i]));
            }
        }

        for (String str : hashSet) {
            sb.append(str);
        }
        if (CheckPwdUtil.checkPwd(sb.toString().toLowerCase())) {
            System.out.println("aaaa::" + sb.toString().toLowerCase());
            return getPasswordRandom(2, 3, 3);
        }
        return sb.toString();
    }

    /**
     * 随机生成密码(八位长度)
     * 一位大写字母 + 二位小写字母 + 五位数字
     *
     * @return
     */
    public static String getPasswordRandom() {
        return getPasswordRandom(2, 3, 3);
    }

    /**
     * 随机指定范围内N个不重复的数
     * 最简单最基本的方法
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n   随机数个数
     */
    public static int[] randomCommon(int min, int max, int n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        return result;
    }

    /**
     * 将Clob转换为String
     *
     * @param ClobObj
     * @return
     */
    public static String getClobToString(Object ClobObj) {
        String retString = "";
        Clob ruleClob = (Clob) ClobObj;
        if (ruleClob != null) {
            try {
                retString = ruleClob.getSubString((long) 1, (int) ruleClob.length());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return retString;
    }

    /**
     * 将map对象转换成键值对拼接在url后
     *
     * @param map
     * @return String
     */
    public static String getRightUrl(String rightUrl, Map map) {
        final String mark = "?";
        StringBuffer rightUrlNew = new StringBuffer(rightUrl);
        if (!rightUrl.contains(mark)) {
            rightUrlNew.append(mark);
        }
        if (map != null) {
            try {
                Iterator iter = map.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    Object key = entry.getKey();
                    Object val = entry.getValue();
                    //  这样写会加快点速率
                    rightUrlNew.append("&");
                    rightUrlNew.append(key);
                    rightUrlNew.append("=");
                    rightUrlNew.append(val);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rightUrlNew.toString();
    }


    /**
     * UTF-8编码格式判断
     * @param fileName  需要分析的数据
     * @return 是否为UTF-8编码格式
     */
    public static boolean isUTF8(String fileName) {
        File f = new File( fileName);
        byte[] rawtext;
        try {
            InputStream ios = new FileInputStream(f);
            rawtext = new byte[3];
            ios.read(rawtext);
            ios.close();
            int score = 0;
            int i, rawtextlen = 0;
            int goodbytes = 0, asciibytes = 0;
            // Maybe also use UTF8 Byte Order Mark: EF BB BF
            // Check to see if characters fit into acceptable ranges
            rawtextlen = rawtext.length;
            for (i = 0; i < rawtextlen; i++) {
                if ((rawtext[i] & (byte) 0x7F) == rawtext[i]) {
                    // 最高位是0的ASCII字符
                    asciibytes++;
                    // Ignore ASCII, can throw off count
                } else if (-64 <= rawtext[i] && rawtext[i] <= -33
                        //-0x40~-0x21
                        && // Two bytes
                        i + 1 < rawtextlen && -128 <= rawtext[i + 1] && rawtext[i + 1] <= -65) {
                    goodbytes += 2;
                    i++;
                } else if (-32 <= rawtext[i]
                        && rawtext[i] <= -17
                        && // Three bytes
                        i + 2 < rawtextlen && -128 <= rawtext[i + 1]
                        && rawtext[i + 1] <= -65 && -128 <= rawtext[i + 2]
                        && rawtext[i + 2] <= -65) {
                    goodbytes += 3;
                    i += 2;
                }
            }
            if (asciibytes == rawtextlen) {
                return false;
            }
            score = 100 * goodbytes / (rawtextlen - asciibytes);
            // If not above 98, reduce to zero to prevent coincidental matches
            // Allows for some (few) bad formed sequences
            if (score > 98) {
                return true;
            } else if (score > 95 && goodbytes > 30) {
                return true;
            } else {
                return false;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Test
    public void testGetCharacterPosition() {
        /*String str = "获取特定字符在字符串中的位置";
        String strSplit = "字";
        int characterPosition = getCharacterPosition(strSplit, str, 2);
        System.out.println(characterPosition);
        int i = str.indexOf(strSplit);
        System.out.println(i);
        char[] chars = str.toCharArray();
        System.out.println(chars.length + String.valueOf(chars[characterPosition]) + String.valueOf(chars[i]));*/
        String str = "获取特定100字符在字符串中的位置";
        String strSplit = "字";
//        String s = removeDigital(str, "[\\d]");
//        String subConTogetherUtil = getSubConTogetherUtil(str, strSplit);
        String subConTogetherUtil = getFirstSub(str, strSplit);
        System.out.println(subConTogetherUtil);

    }
}
