package com.wuhn.weixin.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wuhn.weixin.bean.weixin.Image;
import com.wuhn.weixin.bean.weixin.ImageMessage;
import com.wuhn.weixin.bean.weixin.Music;
import com.wuhn.weixin.bean.weixin.MusicMessage;
import com.wuhn.weixin.bean.weixin.News;
import com.wuhn.weixin.bean.weixin.NewsMessage;
import com.wuhn.weixin.bean.weixin.TextMessage;


/**
 * @author wuhn
 * @创建时间 2015-12-04
 * @功能 设置预定的发送消息
 * **/
public class SendMessageUtil {
	
	/**
	 * 统一返回text格式	文本
	 * **/
	public static String initTextMessage(String toUserName,String fromUserName,String content){	
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);//开发者微信号
		text.setToUserName(fromUserName);//接收方帐号（收到的OpenID）
		text.setMsgType(SendMessageConstant.MESSAGE_TEXT);//text
		text.setCreateTime(String.valueOf(new Date().getTime()));//消息创建时间 （整型）
		text.setContent("您发送的消息是："+content);//回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
		return MessageUtil.textMessageToXml(text);
	}
	
	/**
	 * 主菜单
	 * **/
	public static String menuText(){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("欢迎您的关注，请按菜单提示进行操作：\n\n");
		stringBuffer.append("?、帮助\n");
		stringBuffer.append("1、文本\n");
		stringBuffer.append("2、图文\n");
		stringBuffer.append("3、图片\n");
		stringBuffer.append("4、音乐\n");
		return stringBuffer.toString();	
	}
	
	/**
	 * 统一返回news格式	图文
	 * **/
	public static String initNewsMessage(String toUserName,String fromUserName){
		String message = null;
		List<News> newsList = new ArrayList<News>();
		NewsMessage newsMessage = new NewsMessage();
		
		News news_one = new News();
		news_one.setTitle("图文标题");//图文消息标题
		news_one.setDescription("图文描述，此处省略500字。。。");//图文消息描述
		news_one.setPicUrl("http://wuhn.ngrok.cc/weiXin/images/cat.jpg");//图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
		news_one.setUrl("www.baidu.com");//点击图文消息跳转链接
		newsList.add(news_one);
		
		newsMessage.setToUserName(fromUserName);
		newsMessage.setFromUserName(toUserName);
		newsMessage.setCreateTime(String.valueOf(new Date().getTime()));
		newsMessage.setMsgType(SendMessageConstant.MESSAGE_NEWS);
		newsMessage.setArticleCount(String.valueOf(newsList.size()));
		newsMessage.setArticles(newsList);
		
		message = MessageUtil.newsMessageToXml(newsMessage);
		return message;
	}	

	
	/**
	 * 统一返回图片消息	文本
	 * **/
	public static String initImageMessage(String toUserName,String fromUserName){	
		String message = null;
		Image image = new Image();
		image.setMediaId("-JKWzc130bJhaFu5F-tNLByPzUag_uJewAzSbTXVp2lF2aPhKsJBSWrVP5JlZwD5");
		ImageMessage imageMessage = new ImageMessage();
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(SendMessageConstant.MESSAGE_IMAGE);
		imageMessage.setCreateTime(String.valueOf(new Date().getTime()));
		imageMessage.setImage(image);
		message = MessageUtil.imageMessageToXml(imageMessage);
		return message;
	}
	
	
	/**
	 * 统一返回音乐消息	文本
	 * **/
	public static String initMusicMessage(String toUserName,String fromUserName){	
		String message = null;
		Music music = new Music();
		music.setThumbMediaId("KSoL2vq34gOmlKEGD9wj5U9skkVyIRSqpyXBkWqLOMrrWHHjb0OQ66PtcAkbT_Ax");
		music.setTitle("music 测试");
		music.setDescription("空白格--杨宗纬");
		music.setMusicUrl("http://wuhn.ngrok.cc/weiXin/resource/music/01.mp3");
		music.setHQMusicUrl("http://wuhn.ngrok.cc/weiXin/resource/music/01.mp3");
		
		MusicMessage musicMessage = new MusicMessage();
		musicMessage.setFromUserName(toUserName);
		musicMessage.setToUserName(fromUserName);
		musicMessage.setMsgType(SendMessageConstant.MESSAGE_MUSIC);
		musicMessage.setCreateTime(String.valueOf(new Date().getTime()));
		musicMessage.setMusic(music);
		
		message = MessageUtil.MusicMessageToXml(musicMessage);
		return message;
	}
}
