package com.wuhn.weixin.bean.menu;

/**
 * @author wuhn
 * @创建时间 2015-12-15
 * @功能 自定义菜单--公共属性
 * **/
public class Button {
	private String type;
	private String name;
	private Button[] sub_button;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Button[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(Button[] sub_button) {
		this.sub_button = sub_button;
	}
	
	
	
}
