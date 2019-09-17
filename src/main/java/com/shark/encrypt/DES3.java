package com.shark.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.util.Properties;

/**
 * 3DES 对称加密工具类
 * 
 */
public class DES3 {
	/**
	 *  密钥
	 */
	private static String secretKey = "tianyikefu1@lx100$#365#$";
	/**
	 *  向量
	 */
	private static String iv = "01234567";
	/**
	 *  加解密统一使用的编码方式
	 */
	private static String encoding = "utf-8";

	/**
	 * 3DES加密 默认加解密
	 * 
	 * @param plainText 普通文本
	 * @return String
	 */
	public static String encrypt(String plainText) throws Exception {
		return encrypt(plainText,secretKey,iv);
	}

	/**
	 * 3DES加密
	 * 
	 * @param plainText 普通文本
	 * @return	String
	 */
	public static String encrypt(String plainText,String secretKey,String iv) throws Exception {
		// 算法 编码形式 格式
		Key deskey = null;
		// 获取指定3DES密钥参数
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		// 根据算法—>工厂
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		// 根据密钥参数获取到KEY
		deskey = keyfactory.generateSecret(spec);
		// 转化密码方式 参数为加密模式
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		// 此类指定一个初始化向量 (IV)参数
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		// 加密模式 密钥 参数 来初始化
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		// 明文加密
		byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
		// 将加密后的数组转换
		return Base64.encode(encryptData);
	}
	
	/**
	 * 3DES解密 默认加解密
	 * 
	 * @param encryptText 加密文本
	 * @return	String
	 */
	public static String decrypt(String encryptText) throws Exception {
		return decrypt(encryptText, secretKey, iv);
	}
	
	
	/**
	 * 3DES解密
	 * 
	 * @param encryptText 加密文本
	 * @return	String
	 */
	public static String decrypt(String encryptText,String secretKey,String iv) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
		byte[] decryptData = cipher.doFinal(Base64.decode(encryptText));
		return new String(decryptData, encoding);
	}

}