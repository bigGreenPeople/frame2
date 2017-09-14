package com.fj.dao;

import com.fj.domain.House;
import com.fj.domain.PageBean;

public interface HouseDao extends BaseDao<House>{
	//ÒÀ¿¿Ìõ¼şËÑË÷·¿Îİ
	public PageBean<House> findHouseByCondition(House house,PageBean<House> pageBean) throws Exception;
}
