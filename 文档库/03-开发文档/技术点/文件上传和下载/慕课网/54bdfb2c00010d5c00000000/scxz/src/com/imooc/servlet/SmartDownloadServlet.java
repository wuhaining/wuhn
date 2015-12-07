package com.imooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class SmartDownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String filename = request.getParameter("filename");
		
		SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), request, response);
		su.setContentDisposition(null);
		try {
			su.downloadFile("/images/"+ filename);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}

}
