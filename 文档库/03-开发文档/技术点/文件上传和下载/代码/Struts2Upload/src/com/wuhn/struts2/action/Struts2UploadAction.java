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
	private File image; //上传的文件  
	private String imageFileName; //文件名称 要注意前缀要和file的变量一样
	private String imageContentType; //文件类型 要注意前缀要和file的变量一样

    private String result;//返回信息
    
	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
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
    	System.out.println("image:"+image);
    	System.out.println("imageFileName:"+imageFileName);
    	System.out.println("imageContentType:"+imageContentType);
    	System.out.println("文件是否存在："+image.exists());
    	//保存文件
		FileUtils.copyFile(image, new File(localFile, imageFileName));
		result = "上传成功！";
    	
        return SUCCESS;
     }
    
}
