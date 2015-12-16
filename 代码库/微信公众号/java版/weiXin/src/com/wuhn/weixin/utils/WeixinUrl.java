package com.wuhn.weixin.utils;


/**
 * @author wuhn
 * @创建时间 20115-12-06
 * @功能 微信接口调用url
 * **/
public class WeixinUrl {
	//获取接口调用凭据——获取access token——post
	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";//获取access_token
	
	/*********素材管理*************/
	//新增临时素材——POST/FORM
	public static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";//上传多媒体文件
	
	/*********自定义菜单管理*************/
	//自定义菜单创建接口——POST
	public static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";//创建菜单	
	//自定义菜单查询接口——GET
	public static final String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";//查询菜单
	//自定义菜单删除接口——GET
	public static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";//删除菜单
}

