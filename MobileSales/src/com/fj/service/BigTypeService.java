package com.fj.service;

import com.fj.domain.BigType;
import com.fj.domain.PageBean;

public interface BigTypeService {
	//��ҳ��ѯ���еĴ����
	public PageBean<BigType> findAllBigType(PageBean<BigType> pageBean) throws Exception;
}
