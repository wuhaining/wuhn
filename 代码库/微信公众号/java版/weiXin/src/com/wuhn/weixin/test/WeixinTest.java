package com.wuhn.weixin.test;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import com.wuhn.weixin.bean.weixin.AccessToken;
import com.wuhn.weixin.utils.MessageUtil;
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
		/*上传
		String path = "E:/images/01.jpg";
		try {
			String mediaId = WeixinUtil.upload(path, token.getAccess_token(), "thumb");
			System.out.println(mediaId);
			
			**
			 * 错误：{"errcode":48001,"errmsg":"api unauthorized hint: [sMC5Fa0579e297]"}
			 * 48001：api功能未授权，请确认公众号已获得该接口，可以在公众平台官网-开发者中心页中查看接口权限
			 * 
			 * 原因：token，我使用了订阅号的token，而这个是测试号的。
			 * 
			 * 成功：
			 * {"type":"image","media_id":"O8qW_CVrlUe7kId696fwlhecXbc58TIFjJGjc_Tb8qXwxXaLCH2ErKsxqHvL9CLr","created_at":1450078115}
			 * {"type":"thumb","thumb_media_id":"knR6WRjxjSmlNr7lGgGX-8dPnLMZr6WMzj-7R515eS-yXpGeu8WS-A6chYpFxANL","created_at":1450080994}
			 * **
		} catch (Throwable e) {
			e.printStackTrace();
		}
		*/
		
		/*创建菜单
		String menu = JSONObject.fromObject(MessageUtil.initMenu()).toString();
		System.out.println(menu);
		int result = WeixinUtil.createMenu(token.getAccess_token(), menu);
		
		if(result==0){
			System.out.println("创建菜单成功");
		}
		else{
			System.out.println("创建菜单失败"+result);
		}
		*/
		
		
		//System.out.println(WeixinUtil.getMenu(token.getAccess_token()));
		
		/*
		int result = WeixinUtil.deleteMenu(token.getAccess_token());
		if(result==0){
			System.out.println("删除菜单成功！");
		}
		else{
			System.out.println("删除菜单失败！");
		}
		*/
	}
}
