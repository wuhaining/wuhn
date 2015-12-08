<<<<<<< HEAD
package com.wuhn.scxz.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wuhn
 * @创建时间 2015-12-07
 * @功能 上传文件
 * **/
public class UploadServlet extends HttpServlet {

	/**
	 * get方法
	 * **/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);//默认为post提交
		
	}

	/**
	 * post方法
	 * **/
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("测试：已接收到请求");
		//从request当中获取流信息
		InputStream inputStream = request.getInputStream();
		
		//tempFile指向临时文件
		String tempFileName= "D:\\tempFile";
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
		
		
		//关闭上传文件的名称
		RandomAccessFile randomFile = new RandomAccessFile(tempFile,"r");
		randomFile.readLine();
		String str = randomFile.readLine();
		String strSplit = str.split(";")[str.split(";").length-1]; 
		int beginIndex = strSplit.indexOf("\"")+1;
		int endIndex = strSplit.lastIndexOf("\"");
		System.out.println(strSplit+" beginIndex:"+beginIndex+" endIndex:"+endIndex);
		String filename = strSplit.substring(beginIndex, endIndex);
		System.out.println("filename:"+filename);
		
		//重新定位文件指针到文件头
		randomFile.seek(0);
		long startPosition = 0;
		int i =1;
		//获取文件内容的开始位置
		while ((n = randomFile.readByte())!=-1 && i<4) {
			if(n == '\n'){
				startPosition = randomFile.getFilePointer();
				i++;
			}			
		}
		startPosition = startPosition-1;
		//获取文件内容的结束位置
		randomFile.seek(randomFile.length());
		long endPosition = randomFile.getFilePointer();
		int j = 1;
		while (endPosition >=0 && j<2) {
			endPosition--;
			randomFile.seek(endPosition);
			if(randomFile.readByte()=='\n'){
				j++;
			}
		}
		endPosition = endPosition - 1;
		
		
		//设置保存上传文件的路径
		String realPath = getServletContext().getRealPath("/")+"images/upload";//这是服务器上的地址
		//System.out.println("保存上传文件的路径:"+realPath);
		File fileUploadFile = new File(realPath);
		if (!fileUploadFile.exists()) {
			fileUploadFile.mkdir();
		}
		File saveFile = new File(realPath, filename);
		RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile, "rw");
		//从临时文件当中读取文件内容（根据起止位置获取）
		randomFile.seek(startPosition);
		while (startPosition<endPosition) {
			randomAccessFile.write(randomFile.readByte());
			startPosition = randomFile.getFilePointer();
		}
		//关闭输入输出流、删除临时文件
		randomAccessFile.close();
		randomFile.close();
		
		//返回
		request.setAttribute("result", "上传成功！");
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/01.jsp");
		dispatcher.forward(request, response);
		
	}

}
=======
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
>>>>>>> 27dba74dbd82aa639786a2a93ab720f2515528f8
