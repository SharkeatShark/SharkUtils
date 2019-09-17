package com.shark.encrypt;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 配置文件加解密
 * @author sharkeatshark@foxmail.com
 * @create 2019-07-29-13:38
 * @projectName SharkUtils
 * @packageName com.shark.encrypt
 */
public class EncryptPropertyPlaceholder extends PropertyPlaceholderConfigurer {

    //配置文件中要解密的键值对的key
    private String[] encryptPropNames = {"jdbc.service.cipherText", "jdbc.log.cipherText"
            , "redis.sentinels.cipherText"};

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            String decryptValue = AES.decrypt(propertyValue,null,null);
            System.out.println(decryptValue);
            return decryptValue;
        } else {
            return propertyValue;
        }
    }

    /**
     * 判断是否是加密的属性
     * @param propertyName
     * @return
     */
    private boolean isEncryptProp(String propertyName) {
        for (String encryptPropertyName : encryptPropNames) {
            if (encryptPropertyName.equals(propertyName))
                return true;
        }
        return false;
    }


}
