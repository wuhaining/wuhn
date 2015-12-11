package com.wuhn.editor.action;

import com.opensymphony.xwork2.ActionSupport;


/**
 * @author wuhn
 * @创建时间 2015-12-11
 * @功能 富文本编辑器的预览和保存
 * **/
public class CkeditorAction extends ActionSupport {
	private String editor;

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("富文本信息内容："+editor);
		int beginIndex = editor.indexOf("<a");
		int endIndex = editor.indexOf(">",beginIndex) + 1;
		String beginStr = editor.substring(0, beginIndex);
		String endStr = editor.substring(endIndex);
		
		String str = editor.substring(beginIndex, endIndex);
		String filename = str.substring(str.lastIndexOf("/")+1, str.lastIndexOf("\""));
		String replace = "<a href=download.action?filename="+filename + ">";
		
		editor = beginStr + replace + endStr;
		System.out.println(editor);
		
		
		return SUCCESS;
	}
	
}
