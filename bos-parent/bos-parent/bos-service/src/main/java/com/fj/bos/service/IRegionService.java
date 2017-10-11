package com.fj.bos.service;

import java.util.List;

import com.fj.bos.domain.Region;
import com.fj.bos.utils.PageBean;

public interface IRegionService {
//�������� 
	public void saveBatch(List<Region> regionList);
	//��ҳ��ѯ
	public void pageQuery(PageBean pageBean);
	//��ѯ��������
	public List<Region> findAll();
	//����ҳ���������ģ����ѯ
	public List<Region> findListByQ(String q);
}
