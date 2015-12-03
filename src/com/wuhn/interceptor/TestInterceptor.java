package com.wuhn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor implements HandlerInterceptor{
	/**
	 * 3、请求结束之后
	 * **/
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("运行到这了afterCompletion");
		
	}
	
	/**
	 *2、请求被处理之后
	 * **/
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		//可以通过ModelAndView参数来改变显示的视图，或修改发往视图的方法。
		System.out.println("运行到这了postHandle");
		arg3.addObject("msg", "在postHandle中修改信息");
		arg3.setViewName("index");
		
	}
	
	/**
	 * 1、请求被处理之前
	 * 返回值表示是否将当前的请求拦截下来
	 * true:请求继续执行下去
	 * false：请求被终止
	 * Object arg2 表示被拦截的请求的目标对象
	 * **/
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("运行到这了preHandle");
		//如果不配置web.xml的字符集 过滤器,会出现乱码现象。也可以在这里实现
		//arg0.setCharacterEncoding("utf-8");
		
		//对用户是否登录进行判断
		if(arg0.getSession().getAttribute("user")==null){
			//如果用户没有登录，就终止请求，并发送到登录页面
			System.out.println(arg0.getRequestURI());
			arg0.getRequestDispatcher("/externalPages/login/login.jsp").forward(arg0, arg1);
			return false;
		}
		
		return true;
	}

}
