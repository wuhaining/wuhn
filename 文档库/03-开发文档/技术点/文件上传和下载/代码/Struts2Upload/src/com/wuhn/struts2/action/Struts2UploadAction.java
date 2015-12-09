package com.wuhn.struts2.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author wuhn
 * @创建时间 2015-12-09
 * @功能 上传
 * **/
public class Struts2UploadAction extends ActionSupport {
	private File upload;// File - the actual File
    private String uploadContentType;//ContentType : String - the content type of the file
    private String uploadFileName;//FileName : String - the actual name of the file uploaded (not the HTML name)
    private String result;//返回信息
    
	
    
    public File getUpload() {
		return upload;
	}



	public void setUpload(File upload) {
		this.upload = upload;
	}



	public String getUploadContentType() {
		return uploadContentType;
	}



	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}



	public String getUploadFileName() {
		return uploadFileName;
	}



	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	@Override
    public String execute() throws Exception{
    	//设置存储路径
    	String path = ServletActionContext.getServletContext().getRealPath("/images");
    	File file = new File(path);
    	if(!file.exists()){
    		file.mkdir();
    	}
    	System.out.println("uploadFileName:"+uploadFileName);
    	System.out.println("文件是否存在："+file.exists());
    	//保存文件
		FileUtils.copyFile(upload, new File(file, uploadFileName));
		result = "上传成功！";
    	
        return SUCCESS;
     }
    
}
