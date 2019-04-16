package com.example.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.example.pojo.User;
import com.github.qcloudsms.SmsSingleSender;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public boolean sendMsg(String countryCode, String phoneNum) {
		boolean flag = true;
		// 调用腾讯云的短信API
		int appid = Integer.parseInt(stringRedisTemplate.opsForValue().get("appid"));// 从redis中读取appid（appid要提前set）
		String appkey = stringRedisTemplate.opsForValue().get("appkey");
		// 生成随机数字
		String code = (int) (Math.random() * 9 + 1) * 1000 + "";
		int limitTime = 300;
		SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		try {
			// 0表示普通短信6
			ssender.send(0, countryCode, phoneNum, code + "是您的验证码，" + limitTime + "秒内有效", "", "");
			stringRedisTemplate.opsForValue().set(phoneNum, code, 300, TimeUnit.SECONDS);// 往redis中存入临时数据
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean verify(String phoneNum, String verifyCode) {
		// 调用redisTemplate，根据手机号的key，查找相应的验证码
		String code = stringRedisTemplate.opsForValue().get(phoneNum);
		boolean flag = false;
		if (code != null && code.equals(verifyCode)) {
			flag = true;
		}
		return flag;
	}

	@Override
	public void register(User user) {
		//调用mongodbd,将用户数据保存起来
		mongoTemplate.insert(user);		
	}

}
