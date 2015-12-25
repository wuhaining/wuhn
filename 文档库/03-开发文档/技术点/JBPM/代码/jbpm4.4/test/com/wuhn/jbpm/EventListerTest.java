package com.wuhn.jbpm;

import org.junit.After;
import org.junit.Before;

/**
 * @author wuhn
 * @创建时间 2015-12-24
 * @功能 事件监听器
 * **/
public class EventListerTest {
	@Before
	public void testBefore(){
		System.out.println("********测试开始**********");
	}
	
	@After
	public void testAfter(){
		System.out.println("********测试结束**********");
	}
	
	
}
