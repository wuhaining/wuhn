package com.wuhn.weixin.bean.weixin;

/**
 * @author wuhn
 * @创建时间 2015-12-07
 * @功能 access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。
 * 		正常情况下，微信会返回下述JSON数据包给公众号：
 * 		{"access_token":"ACCESS_TOKEN","expires_in":7200}
 * **/
public class AccessToken {
	private String access_token;//获取到的凭证
	private int expires_in;//凭证有效时间，单位：秒
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	
}
