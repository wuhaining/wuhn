package com.wuhn.jbpm;

import org.junit.After;
import org.junit.Before;

/**
 * @author wuhn
 * @����ʱ�� 2015-12-24
 * @���� �¼�������
 * **/
public class EventListerTest {
	@Before
	public void testBefore(){
		System.out.println("********���Կ�ʼ**********");
	}
	
	@After
	public void testAfter(){
		System.out.println("********���Խ���**********");
	}
	
	
}
