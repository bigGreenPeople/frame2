package com.fj.service;

import java.util.List;

import com.fj.domain.District;

public interface DistrictService {
	//查询所有的区域
	public List<District> findAllDistrict() throws Exception;
}
