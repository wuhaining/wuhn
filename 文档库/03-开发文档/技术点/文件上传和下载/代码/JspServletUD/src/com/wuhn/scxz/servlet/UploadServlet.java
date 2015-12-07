package com.wuhn.scxz.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet extends HttpServlet {

	/**
	 * 
	 * **/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);//默认为post提交
		
	}

	/**
	 * 
	 * **/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("测试：已接收到请求");
		//从request当中获取流信息
		InputStream inputStream = request.getInputStream();
		
		//tempFile指向临时文件
		String tempFileName= "E:/tempFile";
		File tempFile = new File(tempFileName);
		
		//fileOutputStream文件输出流指向这个临时文件
		FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
		byte b[] = new byte[1024];
		int n;
		while ((n = inputStream.read(b)) != -1) {
			fileOutputStream.write(b, 0, n);
		}
		//关闭输出流、输入流
		fileOutputStream.close();
		inputStream.close();
	}

}
