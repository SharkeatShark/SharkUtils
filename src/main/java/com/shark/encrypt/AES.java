package com.shark.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * AES 对称加解密工具
 */
public class AES {

    private static final String UTF8 = "UTF-8";
    private static final String AES = "AES";
    private static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";
    private static final String AES_CBC_NO_PADDING = "AES/CBC/NoPadding";
    private static final String IV_STRING = "deYMRyiEVo0tqHOb";
    private static final String AESKEY = "  1543273496436421";

    /**
     * JDK只支持AES-128加密，也就是密钥长度必须是128bit；参数为密钥key，key的长度小于16字符时用"0"补充，key长度大于16字符时截取前16位
     **/
    private static SecretKeySpec create128BitsKey(String key) throws UnsupportedEncodingException {
        if (key == null) {
            key = "";
        }
        byte[] data = null;
        StringBuffer buffer = new StringBuffer(16);
        buffer.append(key);
        //小于16后面补0
        while (buffer.length() < 16) {
            buffer.append("0");
        }
        //大于16，截取前16个字符
        if (buffer.length() > 16) {
            buffer.setLength(16);
        }
        data = buffer.toString().getBytes(UTF8);

        return new SecretKeySpec(data, AES);
    }

    /**
     * 创建128位的偏移量，iv的长度小于16时后面补0，大于16，截取前16个字符;
     * @param iv
     * @return
     */
    private static IvParameterSpec create128BitsIV(String iv) throws UnsupportedEncodingException {
        if (iv == null) {
            iv = "";
        }
        byte[] data = null;
        StringBuffer buffer = new StringBuffer(16);
        buffer.append(iv);
        while (buffer.length() < 16) {
            buffer.append("0");
        }
        if (buffer.length() > 16) {
            buffer.setLength(16);
        }
        data = buffer.toString().getBytes(UTF8);
        return new IvParameterSpec(data);
    }

    /**
     * 填充 加密
     * 填充方式为Pkcs5Padding时，最后一个块需要填充χ个字节，填充的值就是χ，也就是填充内容由JDK确定
     * @param srcContent
     * @param password
     * @param iv
     * @return
     */
    public static byte[] aesCbcPkcs5PaddingEncrypt(byte[] srcContent, String password, String iv) throws UnsupportedEncodingException {
        SecretKeySpec key = create128BitsKey(password);
        IvParameterSpec ivParameterSpec = create128BitsIV(iv);
        try {
            Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
            byte[] encryptedContent = cipher.doFinal(srcContent);
            return encryptedContent;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 填充 解密
     * @param encryptedContent
     * @param password
     * @param iv
     * @return
     */
    public static byte[] aesCbcPkcs5PaddingDecrypt(byte[] encryptedContent, String password, String iv) throws UnsupportedEncodingException {
        SecretKeySpec key = create128BitsKey(password);
        IvParameterSpec ivParameterSpec = create128BitsIV(iv);
        try {
            Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5_PADDING);
            cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
            byte[] decryptedContent = cipher.doFinal(encryptedContent);
            return decryptedContent;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param content   解密内容
     * @param key    密钥
     * @param iv 偏移向量
     * @return  String
     */
    public static String decrypt(String content , String key, String iv){
        try {
            return Base64.encode(aesCbcPkcs5PaddingDecrypt(Base64.decode(content),key , iv));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密 默认密钥
     * @param content   解密内容
     * @return  String
     */
    public static String decrypt(String content ){
        return decrypt(content,AESKEY, IV_STRING);
    }


    /**
     * 加密
     * @param content   解密内容
     * @param key    密钥
     * @param iv 偏移向量
     * @return  String
     */
    public static String encrypt(String content , String key, String iv){
        try {
            return Base64.encode(aesCbcPkcs5PaddingEncrypt(Base64.decode(content), key, iv));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密 默认密钥
     * @param content   解密内容
     * @return  String
     */
    public static String encrypt(String content){
        return encrypt(content,AESKEY, IV_STRING);
    }

}
