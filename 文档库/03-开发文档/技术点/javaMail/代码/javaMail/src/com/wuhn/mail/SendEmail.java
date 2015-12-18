package com.wuhn.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

import com.wuhn.model.EmailModel;
import com.wuhn.model.SendEmailModel;
import com.wuhn.utils.SendEmailUtil;

/**
 * @author wuhn
 * @创建时间 2015-12-17
 * @功能 javamail 
 * **/
public class SendEmail {
	
	/**
	 * @功能 发送简单的电子邮件
	 * @param SendEmailModel sendMailModel
	 * 		  MailModel mailModel
	 * @return void
	 * **/
	public static void sendEmail(SendEmailModel sendMailModel,EmailModel mailModel) {
		//设置Properties
		Properties props = SendEmailUtil.setSmtpProperties(sendMailModel);
		
		//获取一个session
		Session session = SendEmailUtil.getSession(sendMailModel, props);
				
		try {
			//创建一个默认MimeMessage对象，并设置发件人、收件人、主题（From、To、Subject）在消息中。
			Message message = SendEmailUtil.setMimeMessage(sendMailModel, mailModel, session);
			
			//发送邮件
			Transport.send(message);
			System.out.println("发送邮件...成功！");
		} catch (Exception e) {
			System.out.println("发送邮件...失败！");
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @功能 发送带有附件的电子邮件
	 * @param SendEmailModel sendMailModel
	 * 		  MailModel mailModel
	 * @return void
	 * **/	
	public static void sendAttachmentInEmail(SendEmailModel sendMailModel,EmailModel mailModel) {
		//设置Properties
		Properties props = SendEmailUtil.setSmtpProperties(sendMailModel);
		
		//获取一个session
		Session session = SendEmailUtil.getSession(sendMailModel, props);
				
		try {
			//创建一个默认MimeMessage对象，并设置发件人、收件人、主题（From、To、Subject）在消息中。
			Message message = SendEmailUtil.setMessageBodyPart(sendMailModel, mailModel, session);
			
			//发送邮件
			Transport.send(message);
			System.out.println("发送邮件...成功！");
		} catch (Exception e) {
			System.out.println("发送邮件...失败！");
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @功能 发送带有图片的电子邮件
	 * @param SendEmailModel sendMailModel
	 * 		  MailModel mailModel
	 * @return void
	 * **/	
	public static void sendInlineImagesInEmail(SendEmailModel sendMailModel,EmailModel mailModel) {
		//设置Properties
		Properties props = SendEmailUtil.setSmtpProperties(sendMailModel);
		
		//获取一个session
		Session session = SendEmailUtil.getSession(sendMailModel, props);
				
		try {
			//创建一个默认MimeMessage对象，并设置发件人、收件人、主题（From、To、Subject）在消息中。
			Message message = SendEmailUtil.setInlineImages(sendMailModel, mailModel, session);
			
			//发送邮件
			Transport.send(message);
			System.out.println("发送邮件...成功！");
		} catch (Exception e) {
			System.out.println("发送邮件...失败！");
			e.printStackTrace();
		}
		
	}
	
}
