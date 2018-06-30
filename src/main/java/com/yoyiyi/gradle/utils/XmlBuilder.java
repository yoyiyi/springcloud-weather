package com.yoyiyi.gradle.utils;

import java.io.Reader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * 类名：XmlBuilder
 * 描述：TODO
 * 时间：2018/6/30 10:02
 *
 * @author <a href="2455676683@qq.com">zzq</a>
 * @version 1.0
 */
public class XmlBuilder {
    /**
     * xml 转换成对象
     *
     * @return
     */
    public static Object xmlStr2Object(Class<?> clazz, String xmlStr) throws Exception {
        Object object;
        Reader reader;
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        // XML 转为对象的接口
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        reader = new StringReader(xmlStr);
        object = unmarshaller.unmarshal(reader);
        reader.close();
        return object;
    }
}
