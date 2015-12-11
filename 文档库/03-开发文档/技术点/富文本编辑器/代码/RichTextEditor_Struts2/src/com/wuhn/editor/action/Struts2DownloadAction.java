package com.wuhn.editor.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author wuhn
 * @创建时间 2015-12-09
 * @功能 下载
 * **/
public class Struts2DownloadAction extends ActionSupport{
	private String inputPath;//下载路径 在struts.xml中配置

	private String filename;//下载文件名
	
	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public InputStream getInputStream() throws IOException{
		String path = ServletActionContext.getServletContext().getRealPath("/userfiles/files");
		String filepath = path + "\\" +filename;
		File file = new File(filepath);
		return FileUtils.openInputStream(file);
		
		//return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
	}
	
	public String getDownloadFileName(){
		String downloadFileName = "";
		//中文处理
		try {
			downloadFileName = URLEncoder.encode(filename, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return downloadFileName;
	}
}
