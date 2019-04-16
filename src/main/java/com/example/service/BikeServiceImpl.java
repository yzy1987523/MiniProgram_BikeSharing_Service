package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.example.pojo.Bike;

@Service
public class BikeServiceImpl implements BikeService {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void save(Bike bike) {
		
//		mongoTemplate.insert(bike,"bike");
		mongoTemplate.insert(bike);//因为在bike类中添加了注解，所以不用写  "bike"
	}

}
