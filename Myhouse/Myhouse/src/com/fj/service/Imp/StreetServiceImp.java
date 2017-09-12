package com.fj.service.Imp;

import java.util.List;

import com.fj.dao.StreetDao;
import com.fj.dao.Imp.StreetDaoImp;
import com.fj.domain.Street;
import com.fj.service.StreetService;

public class StreetServiceImp implements StreetService{
	private StreetDao streetDao = new StreetDaoImp();
	@Override
	public List<Street> findAllStreet() throws Exception {
		// TODO Auto-generated method stub
		return streetDao.findAll();
	}

}
