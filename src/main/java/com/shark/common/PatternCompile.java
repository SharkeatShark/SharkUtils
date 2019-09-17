package com.shark.common;

import java.util.regex.Pattern;

/**
 * Pattern 预编译工具类
 * @author sharkeatshark@foxmail.com
 * @create 2019-03-29-17:08
 * @projectName SharkUtils
 * @packageName com.shark.util
 */
public interface PatternCompile {
    /**
     * 数字
     */
    Pattern NUMBER_PATTERN = Pattern.compile("[0-9]*");
    /**
     * 任意数字
     */
    Pattern NUMBER_PATTERN_D = Pattern.compile("[\\d]");
    /**
     * [a-zA-Z] 大小写字母
     */
    Pattern azAZ_PATTERN = Pattern.compile("[a-zA-Z]");
    /**
     * 匹配中文 [\u4e00-\u9fa5]
     */
    Pattern CHINESE_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5]");
    /**
     * 汉字 大小字母 数字 下划线 的组合 4到10个
     */
    Pattern LIMIT_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5_a-zA-Z0-9_]{4,10}");
    /**
     * 由数字、26个英文字母或者下划线组成的字符串
     */
    Pattern NUM_AZ_PATTERN = Pattern.compile("^\\w+$");
    /**
     * 邮件地址匹配
     */
    Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
    /**
     * 手机号
     */
    Pattern MOBILENUM_PATTERN = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
    /**
     * 身份证
     */
    Pattern ID_PATTERN = Pattern.compile("/^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$/");
    /**
     * URL
     */
    Pattern URL_PATTERN = Pattern.compile("[a-zA-z]+://[^s]*");
    /**
     * http://www.
     */
//    Pattern URLHTTP_PATTERN = Pattern.compile("net://([w-]+.)+[w-]+(/[w-./?%&=]*)?");
    /**
     * 匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
     */
    Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{4,15}$");
    /**
     * 国内电话号码
     */
    Pattern PHONENUM_PATTERN = Pattern.compile("d{3}-d{8}|d{4}-d{7}");
    /**
     * IPv4
     */
    Pattern IPV4_PATTERN = Pattern.compile("d+.d+.d+.d+");
    /**
     * QQ
     */
    Pattern QQ_PATTERN = Pattern.compile("[1-9][0-9]{4,}");
    /**
     * 中国邮政编码
     */
    Pattern POSTAL_PATTERN = Pattern.compile("[1-9]d{5}(?!d)");
}
