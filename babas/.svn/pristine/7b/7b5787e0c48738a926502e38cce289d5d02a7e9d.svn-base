package com.fj.core.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;

import com.fj.core.bean.Brand;
import com.fj.core.dao.BrandDao;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;
	
	@Transactional(readOnly = true)
	public Pagination getBrandListWithPage(Brand brand) {
		Pagination pagination = new Pagination(brand.getPageNo(), 5, brandDao.getBrandCount(brand));
		pagination.setList(brandDao.getBrandListWithPage(brand));
		return pagination;
	}

	public void addBrand(Brand brand) {
		// TODO Auto-generated method stub
		brandDao.addBrand(brand);
	}

}
