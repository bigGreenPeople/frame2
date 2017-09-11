package com.fj.service;

import java.util.List;

import com.fj.domain.House;
import com.fj.domain.HouseVo;

public interface HouseService {
	//添加房屋信息
	public int addHouse(House house) throws Exception;
	//删除房屋
	public int removeHouse(Integer id) throws Exception;
	//修改房屋信息
	public int updateHouse(House house) throws Exception;
	//条件查询房屋信息
	public List<HouseVo> findHouseByCondition(House house) throws Exception;
	//查询所有房屋信息
	public List<HouseVo> findAllHouse() throws Exception;
}
