package com.wuhn.weixin.test;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;


/**
 * @author wuhn
 * @创建时间 2015-12-04
 * @功能 sha1加密 java版
 * 		使用 commons-codec-1.10.jar  【apache的一个工具jar】
 * **/
public class SHA1 {

	/**
	 * test 
	 */
	public static void main(String[] args) {
		String str = "abc";
		System.out.println("加密："+DigestUtils.sha1Hex(str));
		String str1 = DigestUtils.sha1Hex(str);
		System.out.println(str1);
		
		System.out.println(String.valueOf(new Date().getTime()));
	}

}
