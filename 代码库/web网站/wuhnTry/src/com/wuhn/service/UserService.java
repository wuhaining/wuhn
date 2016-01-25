package com.wuhn.service;

import com.wuhn.bean.User;

/**
 * @author wuhn
 * @创建时间 2016-01-13
 * @功能 用户接口
 * **/
public interface UserService {
	
	int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
