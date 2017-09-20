package com.fj.dao;

import java.util.List;

import com.fj.domain.PageBean;

public interface BaseDao<T> {
	//���
	public void add(T t);
	//�޸�
	public void update(T t);
	//ɾ��
	public void delete(T t);
	//��ѯ(����id)
	public T findById(int id);
	//��ѯ����
	public List<T> findAll();
	//��ҳ��ѯ����
	public PageBean<T> findPageBeanAll(PageBean<T> pageBean) throws Exception;
	//��ѯ�����������
	public Integer getCount();
	//������ѯ	����һ�����
	public T findOneByCondition(T t) throws Exception;
}
