package com.wuhn.weixin.bean.weixin;

/**
 * @author wuhn
 * @创建时间 2015-12-05
 * @功能 回复图片消息 MsgType=image
 * **/
public class ImageMessage extends BaseMessage{
	private String Image;//回复图片消息

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}
	
}
