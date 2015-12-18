package com.wuhn.mail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wuhn.model.MailModel;
import com.wuhn.model.SendMailModel;

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
		SendMailModel sendMailModel = new SendMailModel();
		sendMailModel.setTo("2501935978@qq.com");
		sendMailModel.setFrom("765811529@qq.com");
		sendMailModel.setUsername("765811529@qq.com");
		sendMailModel.setPassword("opzirbzloqhwbgah");
		sendMailModel.setPort("465");
		sendMailModel.setHost("smtp.qq.com");
		
		MailModel mailModel = new MailModel();
		mailModel.setSubject("测试发送邮件");
		mailModel.setText("这是一个测试内容！");
		
		SendEmail.sendEmail(sendMailModel, mailModel);
		
	}
	
	@Test
	public void testSendAttachmentInEmail(){
		System.out.println("*******带附件邮件发送*******");
		//设置初始化属性
		SendMailModel sendMailModel = new SendMailModel();
		sendMailModel.setTo("2501935978@qq.com");
		sendMailModel.setFrom("765811529@qq.com");
		sendMailModel.setUsername("765811529@qq.com");
		sendMailModel.setPassword("opzirbzloqhwbgah");
		sendMailModel.setPort("465");
		sendMailModel.setHost("smtp.qq.com");
		
		MailModel mailModel = new MailModel();
		mailModel.setSubject("测试发送邮件");
		mailModel.setText("这是一个测试内容！");
		mailModel.setFile("src\\111111.txt");
		
		SendEmail.SendAttachmentInEmail(sendMailModel, mailModel);
		
	}
	
	@Test
	public void testSendHTMLEmail(){
		System.out.println("*******带html邮件发送*******");
		//设置初始化属性
		SendMailModel sendMailModel = new SendMailModel();
		sendMailModel.setTo("2501935978@qq.com");
		sendMailModel.setFrom("765811529@qq.com");
		sendMailModel.setUsername("765811529@qq.com");
		sendMailModel.setPassword("opzirbzloqhwbgah");
		sendMailModel.setPort("465");
		sendMailModel.setHost("smtp.qq.com");
		
		MailModel mailModel = new MailModel();
		mailModel.setSubject("测试发送邮件");
		mailModel.setText("这是一个测试内容！");
		mailModel.setHtml("<h1>This is actual message embedded in HTML tags</h1>");
		
		SendEmail.sendEmail(sendMailModel, mailModel);
		
	}
}
