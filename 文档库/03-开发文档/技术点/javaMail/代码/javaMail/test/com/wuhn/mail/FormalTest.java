package com.wuhn.mail;

import java.io.IOException;

import javax.mail.MessagingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wuhn.model.EmailModel;
import com.wuhn.model.SendEmailModel;

/**
 * @author wuhn
 * @创建时间 2015-12-17
 * @功能 javamail 正式测试
 * **/
public class FormalTest {
	@Before
	public void testBefore(){
		System.out.println("*******开始测试*******");
	}
	
	@After
	public void testAfter(){
		System.out.println("*******结束测试*******");
	}
	
	
	@Test
	public void testSendMail(){
		System.out.println("*******简单邮件发送*******");
		//设置初始化属性
		SendEmailModel sendMailModel = new SendEmailModel();
		sendMailModel.setTo("2501935978@qq.com");
		sendMailModel.setFrom("765811529@qq.com");
		sendMailModel.setUsername("765811529@qq.com");
		sendMailModel.setPassword("");
		sendMailModel.setPort("465");
		sendMailModel.setHost("smtp.qq.com");
		
		EmailModel mailModel = new EmailModel();
		mailModel.setSubject("测试发送邮件");
		mailModel.setText("这是一个测试内容！");
		
		SendEmail.sendEmail(sendMailModel, mailModel);
		
	}
	
	@Test
	public void testSendAttachmentInEmail(){
		System.out.println("*******带附件邮件发送*******");
		//设置初始化属性
		SendEmailModel sendMailModel = new SendEmailModel();
		sendMailModel.setTo("2501935978@qq.com");
		sendMailModel.setFrom("765811529@qq.com");
		sendMailModel.setUsername("765811529@qq.com");
		sendMailModel.setPassword("");
		sendMailModel.setPort("465");
		sendMailModel.setHost("smtp.qq.com");
		
		EmailModel mailModel = new EmailModel();
		mailModel.setSubject("测试发送邮件");
		mailModel.setText("这是一个测试内容！");
		mailModel.setFile("src\\111111.txt");
		
		SendEmail.sendAttachmentInEmail(sendMailModel, mailModel);
		
	}
	
	@Test
	public void testSendHTMLEmail(){
		System.out.println("*******带html邮件发送*******");
		//设置初始化属性
		SendEmailModel sendMailModel = new SendEmailModel();
		sendMailModel.setTo("2501935978@qq.com");
		sendMailModel.setFrom("765811529@qq.com");
		sendMailModel.setUsername("765811529@qq.com");
		sendMailModel.setPassword("");
		sendMailModel.setPort("465");
		sendMailModel.setHost("smtp.qq.com");
		
		EmailModel mailModel = new EmailModel();
		mailModel.setSubject("测试发送邮件");
		mailModel.setText("这是一个测试内容！");
		mailModel.setHtml("<h1>This is actual message embedded in HTML tags</h1>");
		
		SendEmail.sendEmail(sendMailModel, mailModel);
		
	}
	
	@Test
	public void testSendInlineImagesInEmail(){
		System.out.println("*******带图片邮件发送*******");
		//设置初始化属性
		SendEmailModel sendMailModel = new SendEmailModel();
		sendMailModel.setTo("2501935978@qq.com");
		sendMailModel.setFrom("765811529@qq.com");
		sendMailModel.setUsername("765811529@qq.com");
		sendMailModel.setPassword("");
		sendMailModel.setPort("465");
		sendMailModel.setHost("smtp.qq.com");
		
		EmailModel mailModel = new EmailModel();
		mailModel.setSubject("测试发送邮件");
		mailModel.setFile("src\\01.jpg");
		mailModel.setHtml("<H1>Hello</H1><img src='cid:image'>");
		
		SendEmail.sendInlineImagesInEmail(sendMailModel, mailModel);
		
	}
	
	@Test
	public void testReceiveEmail(){
		System.out.println("*******带图片邮件发送*******");
		//设置初始化属性
		SendEmailModel sendMailModel = new SendEmailModel();
		sendMailModel.setTo("2501935978@qq.com");
		sendMailModel.setFrom("765811529@qq.com");
		sendMailModel.setUsername("765811529@qq.com");
		sendMailModel.setPassword("");
		sendMailModel.setPort("995");
		sendMailModel.setHost("pop.qq.com");
	
		
		try {
			ReceiveEmail.receiveEmail(sendMailModel);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
