package com.shark.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

public class ConfigUtil {

	private static ConfigUtil configUtil = new ConfigUtil();

    private ConfigUtil() {}
	
	public static ConfigUtil getInstance() {
		return configUtil;
	}

	/**
	 * 获取文件中的键对应的值
	 * @param path	文件地址
	 * @param key	键
	 * @return 获取文件中的值
	 */
	public String getValue(String path,String key){
		FileInputStream fos = null;
		InputStreamReader isr = null;
		Properties prop = null;
		String realPath = this.getClass().getResource("/").getPath();
		realPath = path.replace("classpath:", realPath);
		try {
			realPath = URLDecoder.decode(realPath, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try {
			fos = new FileInputStream(new File(realPath));
			isr = new InputStreamReader(fos,"utf-8");
			prop = new Properties();
			prop.load(isr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(fos != null)	fos.close();
				if(isr != null) isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop.getProperty(key);
	}
	
	public static void main(String[] args) {
//		System.out.println(ConfigUtil.getInstance().getClass().getResource("/").getPath());
//		System.out.println(ConfigUtil.class.getResource("/").getPath());
		System.out.println(ConfigUtil.getInstance().getValue("C:\\Users\\SHARK\\Desktop\\a.txt", "a"));
	}
}