package com.shark.audio;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.ByteArrayInputStream;
import java.io.File;

/**
 * WAV音频文件工具类
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-11-15:49
 * @projectName SharkUtils
 * @packageName com.shark.util
 */
public class WavUtil {

    /**
     * 多个WAV 文件合并为一个文件
     * @param out
     * @param wav
     * @throws Exception
     */
    public static void merge(File out, File... wav)throws Exception{
        File file ;
        AudioFileFormat aff = AudioSystem.getAudioFileFormat(wav[0]);
        AudioInputStream ais ;
        byte[] b = new byte[0];
        for (int i = 0; i < wav.length; i++) {
            file = wav[i];
            ais = AudioSystem.getAudioInputStream(file);
            byte[] buff = new byte[(int)ais.getFrameLength()];
            ais.read(buff);
            b = byteArrayMearge(b,buff);
            ais.close();
        }
        AudioInputStream aiss = new AudioInputStream(new ByteArrayInputStream(b), aff.getFormat(), b.length/aff.getFormat().getFrameSize());
        AudioSystem.write(aiss, AudioFileFormat.Type.WAVE, out);
    }

    /**
     * 将两个 byte数组拼接为一个数组
     * @param b1
     * @param b2
     * @return
     */
    private static byte[] byteArrayMearge(byte[] b1,byte[] b2){
        byte[] res = new byte[b1.length+b2.length];
        System.arraycopy(b1, 0, res, 0, b1.length);
        System.arraycopy(b2, 0, res, b1.length, b2.length);
        return res;
    }

    /**
     *  多个 byte数组拼接为一个数组
     * @param b
     * @return
     */
    private static byte[] byteArrayMearge(byte[]... b){
        byte[] res = new byte[0];
        for (int i = 0; i < res.length; i++) {
            res = byteArrayMearge(res,b[i]);
        }
        return res;
    }

    public static void main(String[] args) throws Exception{
        String path = "C:\\Users\\dell\\Desktop\\222\\111.wav";
        String path1 = "C:\\Users\\dell\\Desktop\\222\\1371_18510985707_20170308090507.wav";
        String path2 = "C:\\Users\\dell\\Desktop\\222\\1372_15011585183_20170308140954.wav";
        String path3 = "C:\\Users\\dell\\Desktop\\222\\1370_13552050662_20170308142402.wav";
        merge(new File(path),new File(path1),new File(path2),new File(path3));
    }
}
