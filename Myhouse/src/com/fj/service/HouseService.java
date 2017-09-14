package com.fj.service;

import java.util.List;

import com.fj.domain.House;
import com.fj.domain.HouseVo;
import com.fj.domain.PageBean;

public interface HouseService {
	//��ӷ�����Ϣ
	public int addHouse(House house) throws Exception;
	//ɾ������
	public int removeHouse(Integer id) throws Exception;
	//�޸ķ�����Ϣ
	public int updateHouse(House house) throws Exception;
	//������ѯ������Ϣ
	public List<HouseVo> findHouseByCondition(House house) throws Exception;
	//��ҳ������ѯ������Ϣ
	public PageBean<HouseVo> findHousePageByCondition(House house,Integer currentPage) throws Exception;
	//��ҳ������ѯ������Ϣ(��������)
	public PageBean<HouseVo> findHousePageByCondition2(House house,Integer currentPage) throws Exception;
	//��ѯ���з�����Ϣ
	public List<HouseVo> findAllHouse() throws Exception;
	//��ҳ��ѯ���з�����Ϣ
	public PageBean<HouseVo> findPageAllHouse(Integer currentPage) throws Exception;
	//������ѯ����
	public HouseVo findHouseById(Integer id) throws Exception;
}
