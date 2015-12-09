package com.wuhn.smartupload.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wuhn
 * @创建时间 2015-12-09
 * @功能 SmartUpload 批量下载
 * **/
public class BatchSmartDownloadServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	/**
	 * The doPost method of the servlet. 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置下载相应信息
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment;filename=test.zip");
		
		//下载路径
		String path = getServletContext().getRealPath("/")+"images/";
		//获取下载的所有文件名
		String[] filenames = request.getParameterValues("filename");
		String str = "";
		String rt = "\r\n";
		//设置压缩信息
		ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
		//获取需要下载的文件
		for(String filename:filenames){
			str += filename + rt;
			File file = new File(path + filename);
			zipOutputStream.putNextEntry(new ZipEntry(filename));//加入压缩文件
			FileInputStream fileInputStream = new FileInputStream(file);
			byte b[] = new byte[1024];
			int n=0;
			while ((n=fileInputStream.read(b)) != -1) {
				zipOutputStream.write(b, 0, n);
			}
			zipOutputStream.flush();
			fileInputStream.close();
		}
		
		zipOutputStream.setComment("download success:" + rt +str);//zip注释信息
		zipOutputStream.flush();
		zipOutputStream.close();
		
		
	}

}
