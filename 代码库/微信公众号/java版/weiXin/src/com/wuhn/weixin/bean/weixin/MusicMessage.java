package com.wuhn.weixin.bean.weixin;

/**
 * @author wuhn
 * @创建时间 2015-12-04
 * @功能 回复音乐消息 MsgType=music
 * **/
public class MusicMessage extends BaseMessage{
	private Music Music;//音乐

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}

	
	
}
