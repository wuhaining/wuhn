package com.wuhn.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SendMailTest {
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
		System.out.println("*******简单邮件发送开始*******");
		
		 //收件人邮箱
	      String to = "2501935978@qq.com";

	      //发送人邮箱
	      String from = "765811529@qq.com";
	      final String username = "765811529@qq.com";//发送人账号
	      final String password = "qw82232160";//发送人密码

	      //smtp服务器（邮件发送服务器）这里使用的是qq服务器
	      String host = "smtp.qq.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "465");
	      
	      System.out.println("获取session...");
	      //获取session
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(username, password);
		   }
	         });
	      System.out.println("创建一个MimeMessage对象...");
	      try {
			   //创建一个MimeMessage对象（Message类是创建和解析邮件内容的API，它的实例对象代表一封电子邮件。） 
			   Message message = new MimeMessage(session);
			
			   //指明邮件的发件人
			   message.setFrom(new InternetAddress(from));
			
			   //指明邮件的收件人
			   message.setRecipients(Message.RecipientType.TO,
		               InternetAddress.parse(to));
			
			   //邮件的标题
			   message.setSubject("Testing Subject");
			
			   //邮件的文本内容
			   message.setText("Hello, this is sample for to check send " +
				"email using JavaMailAPI ");
			   System.out.println("发送邮件...");
			   //发送邮件
			   Transport.send(message);
			   
			   System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	    	  e.printStackTrace();
	         throw new RuntimeException(e);
	      }
	      System.out.println("*******简单邮件发送完毕*******");
		
	}
	
	@Test
	public void testSendMailOther() throws Exception{
		Properties prop = new Properties();
		         prop.setProperty("mail.host", "smtp.qq.com");
		         prop.setProperty("mail.transport.protocol", "smtp");
		         prop.setProperty("mail.smtp.auth", "true");
		         prop.setProperty("mail.smtp.port", "465");
		         //使用JavaMail发送邮件的5个步骤
		         //1、创建session
		         Session session = Session.getInstance(prop);
		         //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		         session.setDebug(true);
		         //2、通过session得到transport对象
		         Transport ts = session.getTransport();
		         //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
		         ts.connect("smtp.qq.com", "765811529@qq.com", "qw82232160");
		         //4、创建邮件
		         Message message = createSimpleMail(session);
		         //5、发送邮件
		         ts.sendMessage(message, message.getAllRecipients());
		         ts.close();
	}
	
	
	
	public static MimeMessage createSimpleMail(Session session)
	             throws Exception {
	         //创建邮件对象
	         MimeMessage message = new MimeMessage(session);
	         //指明邮件的发件人
	         message.setFrom(new InternetAddress("765811529@qq.com"));
	         //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
	         message.setRecipient(Message.RecipientType.TO, new InternetAddress("765811529@qq.com"));
	         //邮件的标题
	         message.setSubject("只包含文本的简单邮件");
	         //邮件的文本内容
	         message.setContent("你好啊！", "text/html;charset=UTF-8");
	         //返回创建好的邮件对象
	         return message;
	     }
}
