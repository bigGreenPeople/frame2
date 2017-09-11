package com.fj.service.Imp;

import java.util.List;

import com.fj.dao.TypeDao;
import com.fj.dao.Imp.TypeDaoImp;
import com.fj.domain.Type;
import com.fj.service.TypeService;

public class TypeServiceImp implements TypeService {
	private TypeDao typeDao = new TypeDaoImp();
	@Override
	public List<Type> findAllType() throws Exception {
		// TODO Auto-generated method stub
		return typeDao.findAll();
	}

}
