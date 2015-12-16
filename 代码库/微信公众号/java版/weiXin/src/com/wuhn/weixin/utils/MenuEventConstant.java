package com.wuhn.weixin.utils;

/**
 * @author wuhn
 * @创建时间 20115-12-16
 * @功能 自定义菜单事件推送
 * **/
public class MenuEventConstant {
	public static final String MENU_EVENT_CLICK = "CLICK";//点击菜单拉取消息时的事件推送
	public static final String MENU_EVENT_VIEW = "VIEW";//点击菜单跳转链接时的事件推送
	public static final String SCANCODE_PUSH = "scancode_push";//扫码推事件的事件推送
	public static final String SCANCODE_WAITMSG = "scancode_waitmsg";//扫码推事件且弹出“消息接收中”提示框的事件推送
	public static final String PIC_SYSPHOTO = "pic_sysphoto";//弹出系统拍照发图的事件推送
	public static final String PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";//弹出拍照或者相册发图的事件推送
	public static final String PIC_WEIXIN = "pic_weixin";//弹出微信相册发图器的事件推送
	public static final String LOCATION_SELECT = "location_select";//弹出地理位置选择器的事件推送
}
