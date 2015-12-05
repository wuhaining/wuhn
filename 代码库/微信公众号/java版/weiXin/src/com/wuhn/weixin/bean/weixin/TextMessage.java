package com.wuhn.weixin.bean.weixin;

/**
 * @author wuhn
 * @创建时间 2015-12-04
 * @功能 回复文本消息 MsgType=text
 * **/
public class TextMessage extends BaseMessage{
	private String Content;//文本消息内容

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
	
	
}
