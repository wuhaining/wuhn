package com.wuhn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuhn.bean.User;
import com.wuhn.dao.UserMapper;
import com.wuhn.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	

	@Override
	public int deleteByPrimaryKey(String userid) {
		return userMapper.deleteByPrimaryKey(userid);
	}

	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(String userid) {
		return userMapper.selectByPrimaryKey(userid);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}

}
