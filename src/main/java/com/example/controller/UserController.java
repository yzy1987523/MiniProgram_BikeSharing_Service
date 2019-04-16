package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pojo.User;
import com.example.service.UserService;

@Controller
public class UserController {//控制层主要接受用户请求并响应，业务层主要处理具体业务，反馈用户操作的结果
	@Autowired//按类型注入，一般是要用到其他类时的一种引用格式
	private UserService userService;
	
	@RequestMapping("/user/genCode")
	@ResponseBody
	public boolean genVerifyCode(String countryCode,String phoneNum) {
		boolean flag=userService.sendMsg(countryCode,phoneNum);
		return flag;
	}
	
	@RequestMapping("/user/verify")
	@ResponseBody
	public boolean verify(String phoneNum,String verifyCode) {
		//调用Service层，进行校验
		return userService.verify(phoneNum,verifyCode); 
	}
	
	@RequestMapping("/user/register")
	@ResponseBody
	public boolean reg(@RequestBody User user) {
		boolean flag=true;
		try {
			//将用户数据存储起来
			userService.register(user);
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		return flag; 
	}
}
