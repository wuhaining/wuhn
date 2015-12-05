package com.wuhn.weixin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.sun.xml.internal.ws.resources.SenderMessages;
import com.wuhn.weixin.bean.weixin.TextMessage;
import com.wuhn.weixin.utils.CheckUtil;
import com.wuhn.weixin.utils.ReceiveMessageConstant;
import com.wuhn.weixin.utils.MessageUtil;
import com.wuhn.weixin.utils.SendMessageUtil;


/**
 * @author wuhn
 * @创建时间 2015-12-04
 * @功能 微信校验 	
 * **/
public class WeixinServlet extends HttpServlet{
	/**
	 * @功能 开发者提交信息后，微信服务器将发送GET请求到填写的服务器地址URL上
	 * **/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String signature = req.getParameter("signature");//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String timestamp = req.getParameter("timestamp");//时间戳
		String nonce = req.getParameter("nonce");//随机数
		String echostr = req.getParameter("echostr");//随机字符串
		
		PrintWriter out = resp.getWriter();
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			out.print(echostr);
		}
				
	}
	
	
	/**
	 * @功能 当普通微信用户向公众账号发消息时，微信服务器将POST消息的XML数据包到开发者填写的URL上。
	 * **/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		try {
			Map<String, String> map =  MessageUtil.xmlToMap(req);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			String message = null;
			if(ReceiveMessageConstant.MESSAGE_TEXT.equals(msgType)){
				TextMessage text = new TextMessage();
				text.setFromUserName(toUserName);//开发者微信号
				text.setToUserName(fromUserName);//接收方帐号（收到的OpenID）
				text.setMsgType("text");//text
				text.setCreateTime(String.valueOf(new Date().getTime()));//消息创建时间 （整型）
				text.setContent("您发送的消息是："+content);//回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
				message = MessageUtil.textMessageToXml(text);
			}
			else if(ReceiveMessageConstant.MESSAGE_EVENT.equals(msgType)){
				String eventType = map.get("Event");
				if(ReceiveMessageConstant.MESSAGE_EVENT_SUBSCRIBE.equals(eventType)){
					message = SendMessageUtil.initText(toUserName, fromUserName, SendMessageUtil.menuText());
				}
			}
			
			System.out.println(message);
			out.print(message);//返回数据
		} catch (DocumentException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	
}
