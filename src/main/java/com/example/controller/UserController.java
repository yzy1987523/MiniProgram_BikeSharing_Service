package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {//控制层主要接受用户请求并响应，业务层主要处理具体业务，反馈用户操作的结果
	private UserService 
	
	
	@RequestMapping("/user/genCode")
	@ResponseBody
	public boolean genVerifyCode(String countryCode,String phoneNum) {
		return false;
	}
}
