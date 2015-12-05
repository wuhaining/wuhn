package com.wuhn.weixin.utils;

/**
 * @author wuhn
 * @创建时间 20115-12-04
 * @功能 *接收消息类型
 * **/
public class ReceiveMessageConstant {
	/***********接收消息类型**************/
	//普通消息
	public static final String MESSAGE_TEXT = "text";//文本消息
	public static final String MESSAGE_IMAGE = "image";//图片消息
	public static final String MESSAGE_VOICE = "voice";//语音消息
	public static final String MESSAGE_VIDEO = "video";//视频消息
	public static final String MESSAGE_SHORTVIDEO = "shortvideo";//小视频消息
	public static final String MESSAGE_LOCATION = "location";//地理位置消息
	public static final String MESSAGE_LINK = "link";//链接消息
	//事件推送
	public static final String MESSAGE_EVENT = "event";//事件推送
	public static final String MESSAGE_EVENT_SUBSCRIBE = "subscribe";//事件推送关注
	public static final String MESSAGE_EVENT_UNSUBSCRIBE = "unsubscribe";//取消关注事件
	public static final String MESSAGE_EVENT_SUBSCRIBE_QRSCENE = "qrscene_";//扫描带参数二维码事件subscribe
	public static final String MESSAGE_EVENT_LOCATION = "LOCATION";//上报地理位置事件
	public static final String MESSAGE_EVENT_CLICK = "CLICK";//自定义菜单事件
	public static final String MESSAGE_EVENT_VIEW = "VIEW";//点击菜单跳转链接时的事件推送
}
