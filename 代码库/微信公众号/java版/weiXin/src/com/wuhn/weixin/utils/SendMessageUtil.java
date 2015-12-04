package com.wuhn.weixin.utils;

import java.util.Date;

import com.wuhn.weixin.bean.weixin.TextMessage;


/**
 * @author wuhn
 * @创建时间 2015-12-04
 * @功能 设置预定的发送消息
 * **/
public class SendMessageUtil {
	
	/**
	 * 统一返回text格式
	 * **/
	public static String initText(String toUserName,String fromUserName,String content){	
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);//开发者微信号
		text.setToUserName(fromUserName);//接收方帐号（收到的OpenID）
		text.setMsgType(MessageConstant.MESSAGE_TEXT);//text
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
		stringBuffer.append("1、美女\n");
		stringBuffer.append("2、喵星人\n");
		return stringBuffer.toString();	
	}
}
