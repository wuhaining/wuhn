package com.wuhn.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wuhn
 * @创建时间 2105-11-26
 * @功能 测试springmvc框架是否搭建成功过
 * **/
@Controller
public class TestController {
	
	@RequestMapping("/helloWorld")
    public String helloWorld(Model model) {
        model.addAttribute("mesages", "Hello World!");
        return "helloWorld";
    }
}
