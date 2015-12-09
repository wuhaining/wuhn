package com.wuhn.struts2.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author wuhn
 * @创建时间 2015-12-10
 * @功能 批量上传
 * **/
public class BatchStruts2DownloadAction extends ActionSupport {
	private List<File> image; //上传的文件  
	private List<String> imageFileName; //文件名称 要注意前缀要和file的变量一样
	private List<String> imageContentType; //文件类型 要注意前缀要和file的变量一样

    private String result;//返回信息

	public List<File> getImage() {
		return image;
	}

	public void setImage(List<File> image) {
		this.image = image;
	}

	public List<String> getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(List<String> imageFileName) {
		this.imageFileName = imageFileName;
	}

	public List<String> getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(List<String> imageContentType) {
		this.imageContentType = imageContentType;
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
    	File localFile = new File(path);
    	if(!localFile.exists()){
    		localFile.mkdir();
    	}
    	//循环保存文件
    	for (int i=0;i<image.size();i++) {
    		FileUtils.copyFile(image.get(i), new File(localFile, imageFileName.get(i)));
		}
		
		result = "上传成功！";
    	
        return SUCCESS;
     }
}
