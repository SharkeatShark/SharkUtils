package com.shark.encrypt;

import com.shark.io.ConfigProUtil;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * RSA 非对称加密 安全编码组件
 */
public class RSA extends Coder {
	public static final String KEY_ALGORITHM = "RSA";
	/**
	 * 签名法则
	 */
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
	/**
	 * 公钥
	 */
	private static final String PUBLIC_KEY = "RSAPublicKey";
	/**
	 * 私钥
	 */
	private static final String PRIVATE_KEY = "RSAPrivateKey";

	private static String public_key = null;
	private static String private_key = null;

	/**
	 * 获取资源文件
	 */
	static {
		Properties properties = ConfigProUtil.getProperties("configuration.properties", RSA.class);
		if(null != properties){
			System.out.println(properties.getProperty("privatekey"));
		}
	}


	/**
	 * 私钥 对 信息 生成 数字签名
	 *
	 * @param data 加密数据
	 * @param privateKey 私钥
	 * @return
	 * @throws Exception
	 */
	public static String sign(byte[] data, String privateKey) throws Exception {
		// 解密由base64编码的私钥
		byte[] keyBytes = decryptBASE64(privateKey);
		// 构造PKCS8EncodedKeySpec对象
		// 私钥规范
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		// KEY_ALGORITHM 指定的加密算法
		// 指定算法
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		// 取私钥匙对象
		// 获得私钥
		PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
		// 用私钥对信息生成数字签名
		// 签名法则
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		// 初始化
		signature.initSign(priKey);
		// 使用指定的 byte 数组更新要签名或验证的数据
		signature.update(data);
		// 返回所有已更新数据的签名字节
		return encryptBASE64(signature.sign());
	}

	/**
	 * 校验 数字 签名
	 * 
	 * @param data 加密数据
	 * @param publicKey 公钥
	 * @param sign 数字签名
	 * @return 校验成功返回true 失败返回false
	 * @throws Exception
	 */
	public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
		// 解密由base64编码的公钥
		byte[] keyBytes = decryptBASE64(publicKey);
		// 构造X509EncodedKeySpec对象
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		// KEY_ALGORITHM 指定的加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		// 取公钥匙对象
		PublicKey pubKey = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
		signature.initVerify(pubKey);
		signature.update(data);
		// 验证传入的签名
		return signature.verify(decryptBASE64(sign));
	}

	/**
	 * 解密<br> 用私钥解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPrivateKey(byte[] data, String key) throws Exception {
		// 对密钥解密
		// 先将 密钥 按 BASE64 解密
		byte[] keyBytes = decryptBASE64(key);
		// 私密钥规范
		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		// 指定算法对象工厂
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		// 根据提供的密钥规范（密钥材料）生成私钥对象。
		Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		// 对数据解密
		// Cipher类为 加密和解密的类
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		// 解密模式 ，密钥 初始化
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		// 解密
		return cipher.doFinal(data);
	}

	/**
	 * 解密<br> 用公钥解密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByPublicKey(byte[] data, String key) throws Exception {
		// 对密钥解密
		byte[] keyBytes = decryptBASE64(key);
		// 取得公钥
		// 公密钥规范
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicKey = keyFactory.generatePublic(x509KeySpec);
		// 对数据解密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		return cipher.doFinal(data);
	}

	/**
	 * 加密<br> 用公钥加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(byte[] data, String key) throws Exception {
		// 对公钥解密
		byte[] keyBytes = decryptBASE64(key);
		// 取得公钥
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key publicKey = keyFactory.generatePublic(x509KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		// 加密
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		return cipher.doFinal(data);
	}

	/**
	 * 加密<br> 用私钥加密
	 * 
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPrivateKey(byte[] data, String key) throws Exception {
		// 对密钥解密
		byte[] keyBytes = decryptBASE64(key);
		// 取得私钥
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
		// 对数据加密
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		// 私钥加密
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		return cipher.doFinal(data);
	}

	/**
	 * 取得私钥
	 * 
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);
		return encryptBASE64(key.getEncoded());
	}

	/**
	 * 取得公钥
	 * 
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
		// 获取公钥
		Key key = (Key) keyMap.get(PUBLIC_KEY);
		// 返回基本编码格式 BASE64加密为字符串格式
		return encryptBASE64(key.getEncoded());
	}

	/**
	 * 初始化密钥
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> initKey() throws Exception {
		// 管理提供者。
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		// 指定算法 密钥对生产者
		KeyPairGenerator keyPairGen = KeyPairGenerator .getInstance(KEY_ALGORITHM);
		// 此类提供强加密随机数生成器 (RNG)。
		SecureRandom random = new SecureRandom();
		// 以random为数据源产生1024位密钥生成器
		keyPairGen.initialize(1024,random);
		// 获得public/private密钥对象
		KeyPair keyPair = keyPairGen.generateKeyPair();
		// 获得公钥对象
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		// 获得私钥对象
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		// 将密钥对象放入Map中返回
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put(PUBLIC_KEY, publicKey);
		keyMap.put(PRIVATE_KEY, privateKey);
		return keyMap;
	}

}
