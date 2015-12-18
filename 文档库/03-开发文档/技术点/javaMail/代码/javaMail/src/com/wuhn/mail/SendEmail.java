package com.wuhn.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

import com.wuhn.model.MailModel;
import com.wuhn.model.SendMailModel;
import com.wuhn.utils.SendMailUtil;

/**
 * @author wuhn
 * @创建时间 2015-12-17
 * @功能 javamail 
 * **/
public class SendEmail {
	
	/**
	 * @功能 发送简单的电子邮件
	 * @param SendMailModel sendMailModel
	 * 		  MailModel mailModel
	 * @return void
	 * **/
	public static void sendEmail(SendMailModel sendMailModel,MailModel mailModel) {
		//设置Properties
		Properties props = SendMailUtil.setSmtpProperties(sendMailModel);
		
		//获取一个session
		Session session = SendMailUtil.getSession(sendMailModel, props);
				
		try {
			//创建一个默认MimeMessage对象，并设置发件人、收件人、主题（From、To、Subject）在消息中。
			Message message = SendMailUtil.setMimeMessage(sendMailModel, mailModel, session);
			
			//发送邮件
			Transport.send(message);
			System.out.println("发送邮件...成功！");
		} catch (Exception e) {
			System.out.println("发送邮件...失败！");
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @功能 发送电子邮件带有附件
	 * @param SendMailModel sendMailModel
	 * 		  MailModel mailModel
	 * @return void
	 * **/	
	public static void SendAttachmentInEmail(SendMailModel sendMailModel,MailModel mailModel) {
		//设置Properties
		Properties props = SendMailUtil.setSmtpProperties(sendMailModel);
		
		//获取一个session
		Session session = SendMailUtil.getSession(sendMailModel, props);
				
		try {
			//创建一个默认MimeMessage对象，并设置发件人、收件人、主题（From、To、Subject）在消息中。
			Message message = SendMailUtil.setMessageBodyPart(sendMailModel, mailModel, session);
			
			//发送邮件
			Transport.send(message);
			System.out.println("发送邮件...成功！");
		} catch (Exception e) {
			System.out.println("发送邮件...失败！");
			e.printStackTrace();
		}
		
	}
	
}
