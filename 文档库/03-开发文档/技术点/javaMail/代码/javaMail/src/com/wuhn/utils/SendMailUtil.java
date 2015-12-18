package com.wuhn.utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.wuhn.model.MailModel;
import com.wuhn.model.SendMailModel;

/**
 * @author wuhn
 * @创建时间 2015-12-17
 * @功能 javamail 公用方法
 * **/
public class SendMailUtil {
	
	/**
	 * @功能 设置连接smtp邮件的属性
	 * @param SendMailModel sendMailModel
	 * @return Properties props
	 * **/
	public static Properties setSmtpProperties(SendMailModel sendMailModel){
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", sendMailModel.getHost());		
		props.put("mail.smtp.port", sendMailModel.getPort());
		//需要加上
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.port", sendMailModel.getPort());
		
		return props;
	}
	
	/**
	 * @功能 获取session
	 * @param SendMailModel sendMailModel
	 * 		  Properties props	
	 * @return Session session
	 * **/
	public static Session getSession(final SendMailModel sendMailModel,Properties props){
		Session session = Session.getInstance(props,
		         new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		               return new PasswordAuthentication(sendMailModel.getUsername(), sendMailModel.getPassword());
			   }
		         });
		session.setDebug(true);//开启session调试
		
		return session;
	}
	
	
	/**
	 * @功能 创建一个MimeMessage对象（Message类是创建和解析邮件内容的API，它的实例对象代表一封电子邮件。） 
	 * @param SendMailModel sendMailModel
	 * 		  MailModel mailModel
	 * 		  Session session
	 * @return Message message
	 * @throws MessagingException 
	 * @throws AddressException 
	 * **/
	public static Message setMimeMessage(SendMailModel sendMailModel,MailModel mailModel,Session session) throws AddressException, MessagingException{
		//创建一个MimeMessage对象（Message类是创建和解析邮件内容的API，它的实例对象代表一封电子邮件。） 
		Message message = new MimeMessage(session);
	
		//指明邮件的发件人
		message.setFrom(new InternetAddress(sendMailModel.getFrom()));
	
		//指明邮件的收件人
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(sendMailModel.getTo()));
	
		//邮件的标题
		message.setSubject(mailModel.getSubject());
	
		//邮件的文本内容
		message.setText(mailModel.getText());
		
		//邮件的html内容
		if(!mailModel.getHtml().isEmpty()){
			message.setContent(mailModel.getHtml(), "text/html");
		}
	    
		return message;
	}
	
	
	/**
	 * @功能 创建message对象
	 * @param SendMailModel sendMailModel
	 * 		  MailModel mailModel
	 * 		  Session session
	 * @return Message message
	 * @throws MessagingException 
	 * @throws AddressException 
	 * **/
	public static Message setMessageBodyPart(SendMailModel sendMailModel,MailModel mailModel,Session session) throws AddressException, MessagingException{
		//创建一个MimeMessage对象（Message类是创建和解析邮件内容的API，它的实例对象代表一封电子邮件。） 
		Message message = new MimeMessage(session);
	
		//指明邮件的发件人
		message.setFrom(new InternetAddress(sendMailModel.getFrom()));
	
		//指明邮件的收件人
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(sendMailModel.getTo()));
	
		//邮件的标题
		message.setSubject(mailModel.getSubject());
	
		
		//message.setText(mailModel.getText());
		
		//创建一个Multipart message【可以包含多个MimeBodyPart】
		Multipart multipart = new MimeMultipart();
		
		//创建第一个MimeBodyPart，设置邮件内容【MimeBodyPart也可以再包含一个Multipart】
		BodyPart messageBodyPart = new MimeBodyPart();
		//邮件的文本内容
		messageBodyPart.setText("This is message body");
		multipart.addBodyPart(messageBodyPart);
		
		//创建第二个MimeBodyPart，设置邮件附件
		messageBodyPart = new MimeBodyPart();
        String filename = mailModel.getFile();
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);
        
        //完成message的组装
        message.setContent(multipart);
        
		return message;
	}
	
}
