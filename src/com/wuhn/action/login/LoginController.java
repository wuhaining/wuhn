package com.wuhn.action.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wuhn.bean.login.LoginUser;

/**
 * @author wuhn
 * @创建时间 2015-12-02
 * @功能 登陆
 * **/
@Controller
public class LoginController {
	/**
	 * @功能 登陆
	 * **/
	@RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(LoginUser loginUser) {
		System.out.println("账号："+loginUser.getName());
		System.out.println("密码："+loginUser.getPassword());
		
        return "index";
    }
}
