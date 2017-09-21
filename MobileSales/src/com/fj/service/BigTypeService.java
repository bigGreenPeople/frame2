package com.fj.service;

import java.util.List;

import com.fj.domain.BigType;
import com.fj.domain.PageBean;
import com.fj.domain.SmallType;

public interface BigTypeService {
	//��ѯ���еĴ����
	public List<BigType> findAllBigType() throws Exception;
	//��ѯ���е�С���
	public List<SmallType> findAllSmallType() throws Exception;
	//��ҳ��ѯ���еĴ����
	public PageBean<BigType> findAllBigType(PageBean<BigType> pageBean) throws Exception;
	//��ҳ��ѯ���е�С���
	public PageBean<SmallType> findAllSmallType(PageBean<SmallType> pageBean) throws Exception;
	//��Ӵ����
	public void addBigType(BigType bigType) throws Exception;
	//���С���
	public void addSmallType(SmallType smallType) throws Exception;
	//ɾ�������
	public void deleteBigType(BigType bigType) throws Exception;
	//ɾ��С���
	public void deleteSmallType(SmallType smallType) throws Exception;
}
