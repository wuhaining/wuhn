package com.wuhn.bean.register;

/**
 * @author wuhn
 * @创建时间 2016-01-13
 * @功能 注册
 * **/
public class Register {
	private String nickname;//昵称
	private String email;//邮箱
	private String password;//密码
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
