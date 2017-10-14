package com.fj.bos.service;

import java.util.List;

import com.fj.bos.domain.Function;
import com.fj.bos.utils.PageBean;

public interface IFunctionService {
	//�õ����е�Ȩ��
	public List<Function> findAll();

	public void save(Function model);

	public void pageQuery(PageBean pageBean);
	//�õ��û���Ӧ�Ĳ˵�
	public List<Function> findMenu();
	
}