package com.fj.bos.dao;

import java.util.List;

import com.fj.bos.dao.base.IBaseDao;
import com.fj.bos.domain.Function;

public interface IFunctionDao extends IBaseDao<Function>{
	//��ѯ�����ڵ�
	public List<Function> findTopAll();
}
