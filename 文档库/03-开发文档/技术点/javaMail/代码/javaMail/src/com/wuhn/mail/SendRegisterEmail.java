package com.wuhn.mail;

import com.wuhn.model.EmailModel;
import com.wuhn.model.SendEmailModel;
import com.wuhn.model.User;

/**
 * @author wuhn
 * @创建时间 2015-12-18
 * @功能 javamail 发送注册邮件
 * 		发送邮件是一件非常耗时的事情，因此这里设计一个线程类来发送邮件
 * **/
public class SendRegisterEmail extends Thread{
	 private User user;
	 
	 public SendRegisterEmail(User user){
         this.user = user;
     }
	 
	 @Override
	public void run() {
		//设置初始化属性
		SendEmailModel sendMailModel = new SendEmailModel();
		sendMailModel.setTo(user.getEmail());
		sendMailModel.setFrom("765811529@qq.com");
		sendMailModel.setUsername("765811529@qq.com");
		sendMailModel.setPassword("");
		sendMailModel.setPort("465");
		sendMailModel.setHost("smtp.qq.com");
		
		
		EmailModel mailModel = new EmailModel();
		mailModel.setSubject("模拟用户注册发送邮件");
		mailModel.setText("恭喜您注册成功，您的用户名：" + user.getUsername() + ",您的密码：" + user.getPassword() + "，请妥善保管，如有问题请联系网站客服!!");
		
		SendEmail.sendEmail(sendMailModel, mailModel);
	}
}
