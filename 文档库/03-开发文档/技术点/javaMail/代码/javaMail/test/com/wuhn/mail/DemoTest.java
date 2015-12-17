package com.wuhn.mail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DemoTest {
	@Before
	public void testBefore(){
		System.out.println("*******开始测试*******");
	}
	
	@After
	public void testAfter(){
		System.out.println("*******结束测试*******");
	}
	
	
	@Test
	public void testing(){
		System.out.println("*******测试中*******");
	}
}

