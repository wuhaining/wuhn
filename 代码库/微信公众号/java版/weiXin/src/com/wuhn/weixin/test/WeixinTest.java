package com.wuhn.weixin.test;

import com.wuhn.weixin.bean.weixin.AccessToken;
import com.wuhn.weixin.utils.WeixinUtil;

/**
 * @author wuhn
 * @创建时间 2015-12-07
 * @功能 access_token测试
 * **/
public class WeixinTest {
	public static void main(String[] args) {
		System.out.println("*********测试开始***********");
		AccessToken token = WeixinUtil.getAccessToken();
		System.out.println("票据："+token.getAccess_token());
		System.out.println("有效时间："+token.getExpires_in());
		System.out.println("*********测试结束***********");
	}
}
