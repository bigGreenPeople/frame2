package com.fj.service;

import com.fj.domain.Manager;
import com.fj.domain.PageBean;

public interface ManagerService {
	//����Ա��¼
	public Manager login(Manager manager) throws Exception;
	//�޸�����
	public void updatePass(Manager manager) throws Exception;
	//��ҳ��ѯ����
	public PageBean<Manager> findAllManager(PageBean<Manager> pageBean) throws Exception;
	//��ӹ���Ա
	public void addManager(Manager manager) throws Exception;
	//ɾ������Ա
	public void deleteManager(Manager manager) throws Exception;
}
