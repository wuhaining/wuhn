package com.wuhn.weixin.bean.weixin;

/**
 * @author wuhn
 * @创建时间 2015-12-06
 * @功能 回复视频消息  MsgType=video
 * **/
public class VideoMessage extends BaseMessage{
	private Video Video;//视频

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}

	
	
}
