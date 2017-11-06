package com.fj.core.service.product;

import cn.itcast.common.page.Pagination;

import com.fj.core.bean.Brand;

public interface BrandService {
	//查询所有品牌
	public Pagination getBrandListWithPage(Brand brand);
	//添加商品
	public void addBrand(Brand brand);

}
