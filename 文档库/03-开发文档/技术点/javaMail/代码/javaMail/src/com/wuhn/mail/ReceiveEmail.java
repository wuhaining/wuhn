package com.wuhn.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;

import com.wuhn.model.EmailModel;
import com.wuhn.model.SendEmailModel;
import com.wuhn.utils.CheckingMails;

/**
 * @author wuhn
 * @创建时间 2015-12-18
 * @功能 javamail 邮件检查和提取
 * **/
public class ReceiveEmail {
	/**
	 * @功能 邮件检查和提取
	 * @param SendEmailModel sendMailModel
	 * @return void
	 * @throws MessagingException 
	 * @throws IOException 
	 * **/
	public static void receiveEmail(SendEmailModel sendMailModel) throws MessagingException, IOException {
		Properties properties = CheckingMails.setPop3Properties(sendMailModel);
		
		Store store = CheckingMails.getStore(sendMailModel, properties);
		
		//创建一个文件夹并打开它
		Folder emailFolder = store.getFolder("INBOX");
	    emailFolder.open(Folder.READ_ONLY);
	    //从folder中获取这些邮件信息并打印出来
        Message[] messages = emailFolder.getMessages();
        
        System.out.println("邮件总数：" + messages.length);

        for (int i = 0, n = messages.length; i < n; i++) {
        	Message message = messages[i];
        	System.out.println("---------------------------------");
        	System.out.println("Email Number " + (i + 1));
        	System.out.println("Subject: " + message.getSubject());
        	System.out.println("From: " + message.getFrom()[0]);
        	System.out.println("Text: " + message.getContent().toString());

        }

        //关闭store和Folder
        emailFolder.close(false);
        store.close();
		
	}
}
