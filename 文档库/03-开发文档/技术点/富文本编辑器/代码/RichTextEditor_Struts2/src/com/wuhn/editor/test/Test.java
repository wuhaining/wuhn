package com.wuhn.editor.test;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.fileupload.FileItem;

import com.ckfinder.connector.utils.FileUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author wuhn
 * @创建时间 2015-12-11
 * @功能 测试
 * **/
public class Test {
	/**
	 * save if uploaded file item name is full file path not only file name.
	 *
	 * @param item file upload item
	 * @return file name of uploaded item
	 */
	private String getFileItemName(final FileItem item) {
		//Pattern p = Pattern.compile("[^\\\\/]+$");
		//Matcher m = p.matcher(item.getName());

		//return (m.find()) ? m.group(0) : "";
		
		//重命名
		String origin = item.getName();
		return String.valueOf(new Date().getTime()) + "." +FileUtils.getFileExtension(origin);
	}
}
