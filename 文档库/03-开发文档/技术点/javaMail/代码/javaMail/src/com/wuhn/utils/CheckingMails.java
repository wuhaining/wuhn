package com.wuhn.utils;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import com.wuhn.model.SendEmailModel;

/**
 * @author wuhn
 * @创建时间 2015-12-18
 * @功能 javamail 邮件检查和提取
 * **/
public class CheckingMails {
	/**
	 * @功能 设置连接pop3邮件的属性 	邮件接收服务器
	 * @param SendEmailModel sendMailModel
	 * @return Properties properties
	 * **/
	public static Properties setPop3Properties(SendEmailModel sendMailModel){
		Properties properties = new Properties();
		properties.put("mail.pop3.host", sendMailModel.getHost());
		properties.put("mail.pop3.port", sendMailModel.getPort());
		properties.put("mail.pop3.starttls.enable", "true");
		
		return properties;
	}
	
	
	/**
	 * @功能 设置创建pop3 store并连接pop服务器 
	 * @param SendEmailModel sendMailModel
	 * 		  Properties properties	
	 * @return Store store
	 * @throws MessagingException 
	 * **/
	public static Store getStore(SendEmailModel sendMailModel,Properties properties) throws MessagingException{
		//获取session
		Session emailSession = Session.getDefaultInstance(properties);
		emailSession.setDebug(true);
		//创建pop3 store
		Store store = emailSession.getStore("pop3s");
		//连接pop服务器 
		store.connect(sendMailModel.getHost(),sendMailModel.getUsername(),sendMailModel.getPassword());
		
		return store;
	}
	
	
}
