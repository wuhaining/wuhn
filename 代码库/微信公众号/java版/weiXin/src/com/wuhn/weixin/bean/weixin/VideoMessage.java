package com.wuhn.weixin.bean.weixin;

/**
 * @author wuhn
 * @创建时间 2015-12-06
 * @功能 回复视频消息  MsgType=video
 * **/
public class VideoMessage extends BaseMessage{
	private String Video;//视频

	public String getVideo() {
		return Video;
	}

	public void setVideo(String video) {
		Video = video;
	}
	
}
