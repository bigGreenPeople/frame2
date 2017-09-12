package com.fj.dao;

import java.util.List;

import com.fj.domain.PageBean;

public interface BaseDao<T> {
	//����idȥ��ѯһ��
	public T findById(Integer id) throws Exception;
	//����user������ȥ��ѯ��������
	public List<T> findByCondition(T t) throws Exception;
	//�����ķ�ҳ��ѯ
	public PageBean<T> findPageByCondition(T t,PageBean<T> pageBean) throws Exception;
	//�õ�������м�¼��
	public Integer getCount() throws Exception;
	//���������õ�������м�¼��
	public Integer getCountByCondition(String intoMess,Object[] params) throws Exception;
	public Integer getCountByCondition(String intoMess) throws Exception;
	//��ѯ����
	public List<T> findAll() throws Exception;
	//��ҳ��ѯ����
	public PageBean<T> findPageAll(PageBean<T> pageBean) throws Exception;
	//���һ��
	public int addOne(T t) throws Exception;
	//����ID�޸�һ��
	public int updateById(T t,Integer id) throws Exception;
	//����IDɾ��һ��
	public int deleteById(Integer id) throws Exception;
	
}
