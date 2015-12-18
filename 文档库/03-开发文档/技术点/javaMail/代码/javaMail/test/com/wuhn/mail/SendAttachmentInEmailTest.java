package com.wuhn.mail;

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
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wuhn
 * @创建时间 2015-12-18
 * @功能 发送电子邮件带有附件测试
 * **/
public class SendAttachmentInEmailTest {
	@Before
	public void testBefore(){
		System.out.println("*******开始测试*******");
	}
	
	@After
	public void testAfter(){
		System.out.println("*******结束测试*******");
	}
	
	
	@Test
	public void testSendAttachmentInEmail(){
		System.out.println("*******发送电子邮件带有附件*******");
	  //收件人邮箱
      String to = "2501935978@qq.com";

      //发送人邮箱
      String from = "765811529@qq.com";
      final String username = "765811529@qq.com";//发送人账号
      final String password = "opzirbzloqhwbgah";//发送人密码 qq授权码

      //smtp服务器（邮件发送服务器）这里使用的是qq服务器
      String host = "smtp.qq.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      //需要加上
      props.put("mail.smtp.port", "465");
      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      props.put("mail.smtp.socketFactory.port", "465");
      
      System.out.println("获取session...");

      //获取session
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
         });

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

         // Create the message part
         BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText("This is message body");

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         String filename = "src\\111111.txt";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart);

         // Send message
         Transport.send(message); 
          
         

         System.out.println("Sent message successfully....");
  
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
	}
}
