package com.wuhn.weixin.bean.weixin;

/**
 * @author wuhn
 * @创建时间 2015-12-06
 * @功能 回复语音消息  MsgType=voice
 * **/
public class VoiceMessage extends BaseMessage{
	private Voice Voice;//语音

	public Voice getVoice() {
		return Voice;
	}

	public void setVoice(Voice voice) {
		Voice = voice;
	}

	
	
	
}
