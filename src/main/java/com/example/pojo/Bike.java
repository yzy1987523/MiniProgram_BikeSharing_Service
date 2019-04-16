package com.example.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

//Bike这个类，以后跟MongoDB中bikes collection关联上了
@Document(collection="bikes")
public class Bike {
	//主键（唯一，建立索引），id对应mongo中的_id
	@Id
	private String id;
	private double longitude;
	private double latitude;
	
	//建立索引
	@Indexed
	private Long bikeNo; 
	public Long getBikeNo() {
		return bikeNo;
	}
	public void setBikeNo(Long bikeNo) {
		this.bikeNo = bikeNo;
	}
	private int status;
	public String getId() {
		return id;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
