//package com.wuhn.action.register;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.wuhn.bean.User;
//import com.wuhn.bean.register.Register;
//import com.wuhn.service.UserService;
//import com.wuhn.service.impl.UserServiceImpl;
//
///**
// * @author wuhn
// * @创建时间 2016-01-13
// * @功能 注册
// * **/
//@Controller
//public class RegisterController {
//	private UserService userService;
//		
//	public UserService getUserService() {
//		return userService;
//	}
//	
//	@Autowired
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//
//	/**
//	 * @功能 注册
//	 * **/
//	@RequestMapping(value="/registerAdd",method=RequestMethod.POST)
//	@ResponseBody
//	public String registerAdd(User register){
//		int registerInsert = userService.insertSelective(register);
//		System.out.println("保存结果："+registerInsert);
//		if(registerInsert == 1){
//			
//		}
//		return "";
//	}
//}
