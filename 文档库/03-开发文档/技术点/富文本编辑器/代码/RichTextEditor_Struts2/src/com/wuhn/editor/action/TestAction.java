package com.wuhn.editor.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		System.out.println("*********测试**********");
		return SUCCESS;
	}
}
