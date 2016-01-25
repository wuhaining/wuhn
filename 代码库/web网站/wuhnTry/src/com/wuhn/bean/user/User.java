package com.wuhn.bean.user;

import com.wuhn.bean.register.Register;

/**
 * @author wuhn
 * @创建时间 2016-01-13
 * @功能 用户详细信息
 * **/
public class User extends Register{
	private String name;//真名
	private String password;//密码
	private int gender;//性别 0为女，1为男
	private String birthday;//生日
	private String picture;//图像
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
