package com.fj.domain;

import java.util.Date;

public class HouseVo extends House {
	//区域
	private District district;
	//街道
	private Street street;
	//类型
	private Type type;
	
	public HouseVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public HouseVo(House house) {
		super(house.getId(), house.getUser_id(), house.getType_id(), house.getTitle(), 
				house.getDescription(),house.getPrice(), house.getPubDate(), house.getFloorAge(),
				house.getContact(), house.getStreet_id());
		// TODO Auto-generated constructor stub
	}



	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	
}
