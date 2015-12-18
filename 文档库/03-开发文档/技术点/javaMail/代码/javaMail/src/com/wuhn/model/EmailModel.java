package com.wuhn.model;

/**
 * @author wuhn
 * @创建时间 2015-12-18
 * @功能 javamail 设置发送的内容
 * **/
public class EmailModel {
	private String subject;//邮件的标题
	private String Text;//邮件的文本内容
	private String file;//附件地址
	private String html;//html内容
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
}
