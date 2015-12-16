package com.wuhn.weixin.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

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

import com.wuhn.weixin.bean.menu.ClickButton;
import com.wuhn.weixin.bean.menu.Menu;
import com.wuhn.weixin.bean.weixin.AccessToken;

import net.sf.json.JSONObject;

/**
 * @author wuhn
 * @创建时间 2015-12-06
 * @功能 获取access token【access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。】
 * **/
public class WeixinUtil {
	//这两个参数可在【开发者中心】中找到
	//正式环境
	//private static final String APPID="wxd36bcdcb32caeea5";//appid 第三方用户唯一凭证
	//private static final String APPSECRET="d15d900eccb38cac3db883e9d3f71e2a";//secret 第三方用户唯一凭证密钥，即appsecret
	//测试号
	private static final String APPID="wx3df1d255a7db4b87";//appid 第三方用户唯一凭证
	private static final String APPSECRET="c3f43d028074f7655b355605901736f6";//secret 第三方用户唯一凭证密钥，即appsecret
	
	//固定
	private static final String GRANT_TYPE="client_credential";//grant_type 获取access_token填写client_credential
	
	
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
		httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
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
	
	
	/**
	 * @功能 获取access_token
	 * **/
	public static AccessToken getAccessToken(){
		AccessToken accessToken = new AccessToken();
		String url = WeixinUrl.ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		JSONObject jsonObject = doGetStr(url);
		if(jsonObject != null){
			accessToken.setAccess_token(jsonObject.getString("access_token"));
			accessToken.setExpires_in(jsonObject.getInt("expires_in"));
		}
		return accessToken;
	}
	
	
	/**
	 * @throws IOException 
	 * @功能 新增临时素材 上传
	 * **/
	public static String upload(String filePath,String accessToken,String type) throws Throwable{
		File file = new File(filePath);
		if(!file.exists()||!file.isFile()){
			throw new IOException("文件不存在");
		}
		String url = WeixinUrl.UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);
		
		URL urlObj = new URL(url);
		
		//连接
		HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setUseCaches(true);
		
		//设置请求头信息
		connection.setRequestProperty("Connection", "Keep-Alive");
		connection.setRequestProperty("Charset", "UTF-8");
		
		//设置边界
		String BOUNDARY = "------------" + System.currentTimeMillis();
		connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);
		
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("--");
		sbBuilder.append(BOUNDARY);
		sbBuilder.append("\r\n");
		sbBuilder.append("Content-Disposition:form-data;name=\"file\";filename=\""+file.getName()+"\"\r\n");
		sbBuilder.append("Content-Type:application/octet-stream\r\n\r\n");
		
		byte[] head = sbBuilder.toString().getBytes("utf-8");
		
		//获得输出流
		OutputStream outputStream = new DataOutputStream(connection.getOutputStream());
		//输出表头
		outputStream.write(head);
		
		//文件正文部分
		//把文件已流文件的方式，推入到url中
		DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = dataInputStream.read(bufferOut)) != -1) {
			outputStream.write(bufferOut, 0, bytes);
			
		}
		
		dataInputStream.close();
		
		//结尾部分
		byte[] foot = ("\r\n--"+BOUNDARY+"--\r\n").getBytes("utf-8");//定义最后数据分割线
		
		outputStream.write(foot);
		
		outputStream.flush();
		outputStream.close();
		
		
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			//定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;		
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			
			if(result==null){
				result = buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(reader!=null){
				reader.close();
			}
		}
		
		JSONObject jsonObject = JSONObject.fromObject(result);
		System.out.println(jsonObject);
		String typeName = "media_id";
		if(!"image".equals(type)){
			typeName = type + "_media_id";
		}
		String mediaId = jsonObject.getString(typeName);
		return mediaId;
		
	}
	
	
	/**
	 * @功能 创建菜单
	 * **/
	public static int createMenu(String accessToken,String menu){
		int result = 0;
		String url = WeixinUrl.CREATE_MENU_URL.replace("ACCESS_TOKEN", accessToken);
		
		JSONObject jsonObject = doPostStr(url, menu);
		if(jsonObject != null){
			result = jsonObject.getInt("errcode");
		}
		
		return result;		
	}
	
	/**
	 * @功能 创建菜单
	 * **/
	public static JSONObject getMenu(String accessToken){
		JSONObject jsonObject = new JSONObject();
		String url = WeixinUrl.GET_MENU_URL.replace("ACCESS_TOKEN", accessToken);
		
		jsonObject = doGetStr(url);
		
		return jsonObject;
	}
	
	
	/**
	 * @功能 菜单
	 * **/
	public static int deleteMenu(String accessToken){
		int result = 0;
		String url = WeixinUrl.DELETE_MENU_URL.replace("ACCESS_TOKEN", accessToken);
		
		JSONObject jsonObject = doGetStr(url);
		if(jsonObject != null){
			result = jsonObject.getInt("errcode");
		}
		
		return result;			
	}
	
	
	
}
