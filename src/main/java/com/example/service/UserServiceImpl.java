package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public boolean sendMsg(String countryCode, String phoneNum) {
		// 调用腾讯云的短信API
		//生成随机数字
		//发送短信
		//将手机号+验证码存到redis
		return false;
	}

}
