package com.fj.core.dao;

import java.util.List;

import com.fj.core.bean.Brand;

/**
 * 品牌dao
 * @author Administrator
 *
 */
public interface BrandDao {
	//查询所有品牌
	public List<Brand> getBrandListWithPage(Brand brand);
	//查询数量
	public Integer getBrandCount(Brand brand);
	//插入品牌数据
	public void addBrand(Brand brand);
}
