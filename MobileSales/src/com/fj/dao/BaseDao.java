package com.fj.dao;

import java.util.List;

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
	//������ѯ	����һ�����
	public T findOneByCondition(T t) throws Exception;
}
