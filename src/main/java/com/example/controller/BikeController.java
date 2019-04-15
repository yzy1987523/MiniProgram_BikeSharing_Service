package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.pojo.Bike;
//标记这个类是一个用于介绍请求和相应用户的一个控制器
//加上@controller注解后，spring容器就会对其实例化
@Controller
public class BikeController {
	@RequestMapping("/addBike")//当客户端发出/hello的请求时就会映射到该方法
	@ResponseBody//该方法返回json数据
	public String add(@RequestBody Bike bike) {//由于wx请求时的参数是json类型，所以要注明参数为json类型
		System.out.println(bike);
		return "hello ";
	}
}
