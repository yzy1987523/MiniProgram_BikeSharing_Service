package com.example.service;

import java.util.List;

import com.example.pojo.Bike;

public interface BikeService {

	void save(Bike bike);

	List<Bike> findNear(double longitude, double latitude);
	
}
