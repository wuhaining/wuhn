package com.wuhn.weixin;

import net.sf.json.JSONObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wuhn.weixin.bean.weixin.AccessToken;
import com.wuhn.weixin.utils.MessageUtil;
import com.wuhn.weixin.utils.WeixinUtil;

/**
 * @author wuhn
 * @创建时间 2015-12-16
 * @功能 菜单功能测试 junit4.10
 * **/
public class MenuTest {
	AccessToken token = WeixinUtil.getAccessToken();
	
	@Before
	public void testBefore(){
		System.out.println("*********开始测试**********");
	}
	
	@After
	public void testAfter(){
		System.out.println("*********结束测试**********");
	}
	
	
	@Test
	public void testCreateMenu(){
		//创建菜单
		String menu = JSONObject.fromObject(MessageUtil.initMenu()).toString();
		System.out.println(menu);
		int result = WeixinUtil.createMenu(token.getAccess_token(), menu);
		
		if(result==0){
			System.out.println("创建菜单成功");
		}
		else{
			System.out.println("创建菜单失败"+result);
		}
	}
	
	@Test
	public void testGetMenu(){
		//获取菜单
		System.out.println(WeixinUtil.getMenu(token.getAccess_token()));
	}
	
	@Test
	public void testDeleteMenu(){
		//删除菜单
		int result = WeixinUtil.deleteMenu(token.getAccess_token());
		if(result==0){
			System.out.println("删除菜单成功！");
		}
		else{
			System.out.println("删除菜单失败！");
		}
	}
	
}
