package com.shark.io.Freemark;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用freemark生成word
 * @author stormwy
 *
 */
public class Freemark {
	/**
	 * freemark模板配置
	 */
	private Configuration configuration;
	/**
	 * freemark模板的名字
	 */
	private String templateName;
	/**
	 * 生成文件名
	 */
	private String fileName;
	/**
	 * 生成文件路径
	 */
	private String filePath;
	
	public static void main(String[] args){
		Map<String, Object> valueMap = new HashMap<String, Object>();
		Freemark freemark = new Freemark("model/");
		freemark.setTemplateName("model.ftl");
		freemark.setFileName("doc_"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date())+".doc");
		freemark.setFilePath("bin/");
		freemark.createWord(valueMap);
	}
	
	public void createWord(Map<String, Object> map){
		
		Template t = null;
		try {
			t = configuration.getTemplate(templateName,"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File outFile = new File(filePath+fileName);
		Writer out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			t.process(map, out);
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * freemark初始化
	 * @param templatePath 模板文件位置
	 */
	public Freemark(String templatePath) {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
		configuration.setClassForTemplateLoading(this.getClass(),templatePath);		
	}	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
}
