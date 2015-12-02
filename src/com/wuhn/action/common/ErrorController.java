package com.wuhn.action.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * @author wuhn
 * @创建时间 2015-12-02
 * @功能 error	default Servlet container error page.错误跳转页面
 * **/
@Controller
public class ErrorController {
		@RequestMapping(path = "/error", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@ResponseBody
		public Map<String, Object> handle(HttpServletRequest request) {
			System.out.println("**********default Servlet container error**********");
		    Map<String, Object> map = new HashMap<String, Object>();
		    map.put("status", request.getAttribute("javax.servlet.error.status_code"));
		    map.put("reason", request.getAttribute("javax.servlet.error.message"));
		    System.out.println(map);
		    return map;
		}
}
