package com.shark.bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * 实体类转换工具类
 * @author sharkeatshark@foxmail.com
 * @create 2019-04-11-17:07
 * @projectName SharkUtils
 * @packageName com.shark.util
 */
public class BeanUtil {

    /**
     * map转换为Object
     * @param map
     * @param beanClass
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IntrospectionException
     * @throws InvocationTargetException
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws IllegalAccessException, InstantiationException, IntrospectionException, InvocationTargetException {
        if (map == null)
            return null;
        Object obj = beanClass.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            Method setter = property.getWriteMethod();
            if (setter != null) {
                setter.invoke(obj, map.get(property.getName()));
            }
        }
        return obj;
    }

    /**
     * Object转换为map
     * @param obj
     * @return
     * @throws IntrospectionException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        if(obj == null)
            return null;
        Map<String, Object> map = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter!=null ? getter.invoke(obj) : null;
            map.put(key, value);
        }
        return map;
    }

    /**
     * 内部静态类 可以通过   BeanUtil.ByReflect.objectToMap(Object obj)  来访问静态方法
     * 若    ByReflect 不为 public static 则不可使用    BeanUtil.ByReflect.objectToMap(Object obj)  来访问静态方法
     */
    public static class ByReflect {
        /**
         * map转换为Object
         * @param map
         * @param beanClass
         * @return
         * @throws IllegalAccessException
         * @throws InstantiationException
         */
        public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws IllegalAccessException, InstantiationException {
            if (map == null)
                return null;
            Object obj = beanClass.newInstance();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
            return obj;
        }

        /**
         * Object转换为map
         * @param obj
         * @return
         * @throws IllegalAccessException
         */
        public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
            if(obj == null)
                return null;
            Map<String, Object> map = new HashMap<String, Object>();
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
            return map;
        }
    }



}



