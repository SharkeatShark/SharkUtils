package com.shark.util;

import com.alibaba.fastjson.JSON;
import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.huaban.analysis.jieba.WordDictionary;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 结巴分词
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-18-17:41
 * @projectName SharkUtils
 * @packageName com.shark.util
 */
public class JieBaAnalysis {

    private static JiebaSegmenter segmenter = null;

    /**
     * 获取分词(会继承上次分词器)
     * @param str 字符串
     * @return String[]
     */
    public static String[] participle(String str) {
        return participle(str, null);
    }

    /**
     * 获取分词(若需初始化,file=null即可)
     * @param str  待分词的语句
     * @param file 文件
     * @return String[]
     */
    public static String[] participle(String str, File file) {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        if (file != null)
            WordDictionary.getInstance().loadUserDict(file.toPath());
        List<SegToken> segTokens = segmenter.process(str, JiebaSegmenter.SegMode.SEARCH);
        JieBaAnalysis.segmenter = segmenter;
        List<String> arr = new ArrayList<>();
        for (SegToken st : segTokens) {
            arr.add(st.word);
        }
        return arr.toArray(new String[0]);
    }

    /**
     * 分词
     * @param str
     * @param file
     * @param flag
     * @return
     */
    public static String[] participle(String str, File file, boolean flag) {
        if (flag) {
            return participle(str, file);
        } else {
            List<SegToken> segTokens = JieBaAnalysis.segmenter.process(str, JiebaSegmenter.SegMode.SEARCH);
            List<String> arr = new ArrayList<>();
            for (SegToken st : segTokens) {
                arr.add(st.word);
            }
            return arr.toArray(new String[0]);
        }
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(participle("你好呀,哈哈哈哈", new File("C:\\Users\\dell\\Desktop\\temp2068201009118824319.txt"))));
    }
}
