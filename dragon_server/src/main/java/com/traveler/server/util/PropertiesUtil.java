package com.traveler.server.util;


import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
    public static void writeProperties(String path,String parameterName,String parameterValue) {
        Properties prop = new Properties();
        try {
            InputStream fis = new FileInputStream(path);
            //从输入流中读取属性列表（键和元素对）

            prop.load(fis);
            //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
            //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            OutputStream fos = new FileOutputStream(path);

            String property = prop.getProperty(parameterName);
//            if (!StringUtils.isNullOrEmpty(property)){
//                prop.remove(property);
//            }
            prop.setProperty(parameterName, parameterValue);
            //以适合使用 load 方法加载到 Properties 表中的格式，
            //将此 Properties 表中的属性列表（键和元素对）写入输出流
            prop.store(fos, "Update '" + parameterName + "' value");
        } catch (IOException e) {
            System.err.println("Visit " + "filePath" + " for updating " + parameterName + " value error");
        }
    }
    public static Map<String,String> readProperties(String filePath) {
        Properties props = new Properties();
        Map<String,String> resultMap = new HashMap();

        try {
            InputStream in = new FileInputStream(filePath);
            props.load(in);
            Enumeration en = props.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String Property = props.getProperty (key);
                resultMap.put(key,Property);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
