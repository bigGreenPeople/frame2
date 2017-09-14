package com.fj.service;

import java.util.List;

import com.fj.domain.House;
import com.fj.domain.HouseVo;
import com.fj.domain.PageBean;

public interface HouseService {
	//添加房屋信息
	public int addHouse(House house) throws Exception;
	//删除房屋
	public int removeHouse(Integer id) throws Exception;
	//修改房屋信息
	public int updateHouse(House house) throws Exception;
	//条件查询房屋信息
	public List<HouseVo> findHouseByCondition(House house) throws Exception;
	//分页条件查询房屋信息
	public PageBean<HouseVo> findHousePageByCondition(House house,Integer currentPage) throws Exception;
	//分页条件查询房屋信息(搜索过滤)
	public PageBean<HouseVo> findHousePageByCondition2(House house,Integer currentPage) throws Exception;
	//查询所有房屋信息
	public List<HouseVo> findAllHouse() throws Exception;
	//分页查询所有房屋信息
	public PageBean<HouseVo> findPageAllHouse(Integer currentPage) throws Exception;
	//依靠查询房屋
	public HouseVo findHouseById(Integer id) throws Exception;
}
