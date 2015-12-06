package com.wuhn.weixin.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

/**
 * @author wuhn
 * @创建时间 2015-12-06
 * @功能 获取access token【access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。】
 * **/
public class WeixinUtil {
	//这两个参数可在【开发者中心】中找到
	private static final String APPID="wxd36bcdcb32caeea5";//appid 第三方用户唯一凭证
	private static final String APPSECRET="d15d900eccb38cac3db883e9d3f71e2a ";//secret 第三方用户唯一凭证密钥，即appsecret
	
	
	/**
	 * @功能 Get方法获取access_token
	 * @param String url 接口地址参数
	 * **/
	public static JSONObject doGetStr(String url){
		CloseableHttpClient  httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		try {
			CloseableHttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if(entity!=null){
				String result = EntityUtils.toString(entity,"UTF-8");
				jsonObject = JSONObject.fromObject(result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonObject;
	}
	
	/**
	 * @功能 Post方法获取access_token
	 * **/
	public static JSONObject doPostStr(String url,String outStr){
		CloseableHttpClient  httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		JSONObject jsonObject = null;
		httpPost.setEntity(new StringEntity(outStr, ContentType.create("text/plain", "UTF-8")));
		try {
			CloseableHttpResponse response = httpClient.execute(httpPost);
			String result = EntityUtils.toString(response.getEntity(), "UTF-8");
			jsonObject = JSONObject.fromObject(result);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonObject;
	}
}
