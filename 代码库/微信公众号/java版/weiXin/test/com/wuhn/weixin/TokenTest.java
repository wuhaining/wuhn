package com.wuhn.weixin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wuhn.weixin.bean.weixin.AccessToken;
import com.wuhn.weixin.utils.WeixinUtil;

/**
 * @author wuhn
 * @创建时间 2015-12-16
 * @功能 access_token测试
 * **/
public class TokenTest {
	@Before
	public void testBefore(){
		System.out.println("*********开始测试**********");
	}
	
	@After
	public void testAfter(){
		System.out.println("*********结束测试**********");
	}
	
	
	@Test
	public void testGetMenu(){
		//获取access_token
		AccessToken token = WeixinUtil.getAccessToken();
		System.out.println("票据："+token.getAccess_token());
		System.out.println("有效时间："+token.getExpires_in());		
	}
}
