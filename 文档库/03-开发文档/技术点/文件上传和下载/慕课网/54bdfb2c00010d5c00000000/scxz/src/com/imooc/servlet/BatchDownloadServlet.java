package com.imooc.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BatchDownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/x-msdownload");
		resp.setHeader("Content-Disposition", "attachment;filename=test.zip");
		String path = getServletContext().getRealPath("/") + "images/";
		String[] filenames  = req.getParameterValues("filename");
		String str = "";
		String rt = "\r\n";
		ZipOutputStream zos = new ZipOutputStream(resp.getOutputStream());
		for(String filename : filenames){
			str += filename + rt;
			File file = new File(path + filename);
			zos.putNextEntry(new ZipEntry(filename));
			FileInputStream fis = new FileInputStream(file);
			byte b[] = new byte[1024];
			int n = 0;
			while((n = fis.read(b)) != -1){
				zos.write(b, 0, n);
			}
			zos.flush();
			fis.close();
		}
		zos.setComment("download success:" + rt + str);
		zos.flush();
		zos.close();
		
	}

}
