package com.wuhn.weixin.utils;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


/**
 * @author wuhn
 * @创建时间 2015-12-04
 * @功能 加密/校验流程[验证服务器地址的有效性]
 * **/
public class CheckUtil {
	private static final String TOKEN = "wuhn";//需要微信上的token一样
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		String[] arrStrings = new String[]{TOKEN,timestamp,nonce};
		//1. 将token、timestamp、nonce三个参数进行字典序排序
		Arrays.sort(arrStrings);
		
		//2. 将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuffer content = new StringBuffer();
		for (int i = 0; i < arrStrings.length; i++) {
			content.append(arrStrings[i]);		
		}
		//sha1加密
		String temp = DigestUtils.sha1Hex(content.toString());
		
		//3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		System.out.println("signature:"+signature);
		System.out.println("temp:"+temp);
		return temp.equals(signature);
	}
}
