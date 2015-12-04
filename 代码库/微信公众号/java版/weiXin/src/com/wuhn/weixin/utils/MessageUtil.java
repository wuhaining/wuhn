package com.wuhn.weixin.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wuhn.weixin.bean.weixin.TextMessage;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

/**
 * @author wuhn
 * @创建时间 2015-12-04
 * @功能 消息格式转换
 * **/
public class MessageUtil {
	
	/**
	 * @功能 xml转化为map  xml转java   使用dom4j
	 * @param HttpServletRequest request
	 * @return Map<String,String>
	 * @throws IOException
	 * 		   DocumentException
	 * **/
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		
		InputStream inputStream = request.getInputStream();
		Document document = reader.read(inputStream);
		
		Element root = document.getRootElement();
		
		List<Element> list = root.elements();
		
		for (Element element : list) {
			map.put(element.getName(), element.getText());
		}
		inputStream.close();
		
		return map;
	}
	
	/**
	 * @功能 将文本消息对象转为xml  java转xml
	 * @param TextMessage textMessage
	 * @return String
	 * **/
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
		
	}
}
