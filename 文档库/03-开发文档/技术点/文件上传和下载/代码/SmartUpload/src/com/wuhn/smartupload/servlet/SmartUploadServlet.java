package com.wuhn.smartupload.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * @author wuhn
 * @创建时间 2015-12-08
 * @功能 SmartUpload 上传 
 * **/
public class SmartUploadServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);//默认post
		
	}

	/**
	 * The doPost method of the servlet. 
	 *
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置上传文件保存路径
		String filePath = getServletContext().getRealPath("/")+"images";
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
		
		SmartUpload smartUpload = new SmartUpload();
		//初始化对象
		smartUpload.initialize(getServletConfig(), request, response);
		//设置上传文件
		smartUpload.setMaxFileSize(1024*1024*10);
		//设置所有文件的大小
		smartUpload.setTotalMaxFileSize(1024*1024*100);
		//设置文件的类型
		smartUpload.setAllowedFilesList("txt,jpg,gif");
		String result = "上传成功！";
		//设置禁止上传的文件类型
		try {
			smartUpload.setDeniedFilesList("rar,jsp,js");
			//上传文件
			smartUpload.upload();
			//保存文件
			int count = smartUpload.save(filePath);		
		} catch (Exception e) {
			//捕捉Exception异常 ，不然捕捉到异常
			result = "上传失败！";
			if(e.getMessage().indexOf("1015") != -1){
				result = "上传失败：上传文件类型不正确！";
			}else if (e.getMessage().indexOf("1010") != -1) {
				result = "上传失败：上传文件类型不正确！";
			}else if (e.getMessage().indexOf("1105") != -1) {
				result = "上传失败：上传文件大小大于允许上传的最大值！";
			}else if (e.getMessage().indexOf("1110") != -1) {
				result = "上传失败：上传文件总大小大于允许上传总大小的最大值！";
			}
			e.printStackTrace();
		}
		
		//获取上传文件的属性
		for(int i=0;i<smartUpload.getFiles().getCount();i++){
			com.jspsmart.upload.File tempFile = smartUpload.getFiles().getFile(i);
			System.out.println("***************");
			System.out.println("表单中name的值："+tempFile.getFileName());
			System.out.println("上传文件名："+tempFile.getFileName());
			System.out.println("上传文件大小："+tempFile.getSize());
			System.out.println("上传文件的拓展名："+tempFile.getFileExt());
			System.out.println("上传文件全名："+tempFile.getFilePathName());
			System.out.println("***************");
		}
		
		System.out.println("上传结果："+result);
		request.setAttribute("result", result);
		request.getRequestDispatcher("/jsp/01.jsp").forward(request, response);
		
		
	}

}
