package com.fj.dao;

import java.util.List;

public interface BaseDao<T> {
	//����idȥ��ѯһ��
	public T findById(Integer id) throws Exception;
	//����user������ȥ��ѯ��������
	public List<T> findByCondition(T t) throws Exception;
	//��ѯ����
	public List<T> findAll() throws Exception;
	//���һ��
	public int addOne(T t) throws Exception;
	//����ID�޸�һ��
	public int updateById(T t,Integer id) throws Exception;
	//����IDɾ��һ��
	public int deleteById(Integer id) throws Exception;
	
}
