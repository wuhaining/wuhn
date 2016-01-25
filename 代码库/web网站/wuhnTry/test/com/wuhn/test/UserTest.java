package com.wuhn.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wuhn.bean.User;
import com.wuhn.dao.UserMapper;
import com.wuhn.service.UserService;
import com.wuhn.service.impl.UserServiceImpl;

/**
 * @author wuhn
 * @创建时间 2016-01-13
 * @功能 用户
 * **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class UserTest {
	@Before
	public void testBefore(){
		System.out.println("*******开始测试*******");
	}
	
	@After
	public void testAfter(){
		System.out.println("*******结束测试*******");
	}
	
	private UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Test
	public void testSave(){
		System.out.println("*******测试中*******");
		User user = new User();
		user.setUserid("123");
		user.setNickname("111");
		user.setEmail("2255@qq.com");
		user.setPassword("123");
		System.out.println(userService.insertSelective(user));
	}

}
