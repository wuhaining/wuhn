package com.wuhn.smartupload.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class SmartDownloadServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "下载成功";
		//获取下载的文件名
		String filename = request.getParameter("filename");
		//下载
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(getServletConfig(), request, response);
		smartUpload.setContentDisposition(null);//取消默认打开方式
		try {
			smartUpload.downloadFile("/images/"+filename);
		} catch (Exception e) {
			result = "下载失败";
			System.out.println("********异常处理********");
			if(e.getMessage().indexOf("系统找不到指定的路径。") != -1){
				result = "下载失败:文件不存在！";
			}
			e.printStackTrace();
		}
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("/jsp/02.jsp").forward(request, response);
		
		
	}

}
