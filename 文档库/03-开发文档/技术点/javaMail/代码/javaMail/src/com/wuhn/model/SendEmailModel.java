package com.wuhn.model;

/**
 * @author wuhn
 * @创建时间 2015-12-18
 * @功能 javamail 发送简单的电子邮件
 * **/
public class SendEmailModel {
	private String to;//收件人邮箱
	private String from;//发送人邮箱
	private String username;//发送人账号
	private String password;//发送人密码 qq授权码
	private String host;//smtp服务器（邮件发送服务器）这里使用的是qq服务器
	private String port;//端口
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
		
	
}
