package com.shark.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.UnsupportedEncodingException;

/**
 * 汉语转拼音
 */
public class HanyuUtil {
    private static HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
    static {
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    }

    /**
     * 转换单个字符为拼音 只取一个发音，如果是多音字，仅取第一个发音
     * @param c
     * @return
     */
    public static String getCharacterPinYin(char c) throws BadHanyuPinyinOutputFormatCombination {
        String[] pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);
        // 如果c不是汉字，toHanyuPinyinStringArray会返回null
        if (pinyin == null) {
            return null;
        }
        // 只取一个发音，如果是多音字，仅取第一个发音
        return pinyin[0];
    }

    /**
     * 字符串转换一个拼音的字符串
     * @param str
     * @return
     */
    public static String getStringPinYin(String str) throws BadHanyuPinyinOutputFormatCombination {
        StringBuilder sb = new StringBuilder();
        String tempPinyin = null;
        for (int i = 0; i < str.length(); ++i) {
            tempPinyin = getCharacterPinYin(str.charAt(i));
            if (tempPinyin == null) {
                // 如果str.charAt(i)非汉字，则保持原样
                sb.append(str.charAt(i));
            } else {
                sb.append(tempPinyin);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws UnsupportedEncodingException, BadHanyuPinyinOutputFormatCombination {
        String str = HanyuUtil.getStringPinYin("女人!");
        System.out.println(str);
    }
}

