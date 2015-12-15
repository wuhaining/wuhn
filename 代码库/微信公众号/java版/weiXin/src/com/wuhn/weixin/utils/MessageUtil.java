package com.wuhn.weixin.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wuhn.weixin.bean.menu.Button;
import com.wuhn.weixin.bean.menu.ClickButton;
import com.wuhn.weixin.bean.menu.Menu;
import com.wuhn.weixin.bean.menu.ViewButton;
import com.wuhn.weixin.bean.weixin.ImageMessage;
import com.wuhn.weixin.bean.weixin.MusicMessage;
import com.wuhn.weixin.bean.weixin.News;
import com.wuhn.weixin.bean.weixin.NewsMessage;
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
	 * @功能 将文本消息对象转为xml  java转xml 实用xstream-1.4.7.jar
	 * @param TextMessage textMessage
	 * @return String
	 * **/
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
		
	}
	
	/**
	 * @功能 将图文消息对象转为xml  java转xml 实用xstream-1.4.7.jar
	 * @param NewsMessage newsMessage
	 * @return String
	 * **/
	public static String newsMessageToXml(NewsMessage newsMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new News().getClass());
		return xstream.toXML(newsMessage);	
	}
	
	/**
	 * @功能 将图片消息对象转为xml  java转xml 实用xstream-1.4.7.jar
	 * @param ImageMessage imageMessage
	 * @return String
	 * **/
	public static String imageMessageToXml(ImageMessage imageMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
		
	}
	
	
	/**
	 * @功能 将音乐消息对象转为xml  java转xml 实用xstream-1.4.7.jar
	 * @param MusicMessage musicMessage
	 * @return String
	 * **/
	public static String MusicMessageToXml(MusicMessage musicMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
		
	}
	
	
	/**
	 * @功能 组装菜单
	 * **/
	public static Menu initMenu(){
		Menu menu = new Menu();
		ClickButton clickButton11 = new ClickButton();
		clickButton11.setName("菜单1号");
		clickButton11.setType("click");
		clickButton11.setKey("cd_11");
		
		ViewButton viewButton21 = new ViewButton();
		viewButton21.setName("view菜单");
		viewButton21.setType("view");
		viewButton21.setUrl("https://www.baidu.com/");
		
		ClickButton clickButton31 = new ClickButton();
		clickButton31.setName("扫码推事件");
		clickButton31.setType("scancode_push");
		clickButton31.setKey("cd_31");
		
		ClickButton clickButton32 = new ClickButton();
		clickButton32.setName("地理位置选择器");
		clickButton32.setType("location_select");
		clickButton32.setKey("cd_32");
		
		Button button = new Button();
		button.setName("菜单");
		button.setSub_button(new Button[]{clickButton31,clickButton32});
		
		menu.setButtons(new Button[]{clickButton11,viewButton21,button});
		
		return menu;
	}
}
