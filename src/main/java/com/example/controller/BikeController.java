package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.pojo.Bike;
import com.example.service.BikeService;
//标记这个类是一个用于介绍请求和相应用户的一个控制器
//加上@controller注解后，spring容器就会对其实例化
@Controller
public class BikeController {
	//到spring容器中，查找bikeservice类型的实例，然后注入到bikecontrloller实例中
	@Autowired
	private BikeService bikeService;
	
	@RequestMapping("/bike/add")//当客户端发出/bike/add的请求时就会映射到该方法
	@ResponseBody//该方法返回json数据
	public String add(@RequestBody Bike bike) {//由于wx请求时的参数是json类型，所以要注明参数为json类型
//		System.out.println(bike);
//		return "hello ";
		//调用service
		bikeService.save(bike);
		return "success";
	}
	@RequestMapping("/bike/findNear")
	@ResponseBody//该方法返回json数据
	public List<Bike> findNear(double longitude,double latitude) {
		List<Bike> bikes =bikeService.findNear(longitude,latitude);
		return bikes;
	}
}
