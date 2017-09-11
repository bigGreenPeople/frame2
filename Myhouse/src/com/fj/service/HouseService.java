package com.fj.service;

import java.util.List;

import com.fj.domain.House;
import com.fj.domain.HouseVo;

public interface HouseService {
	//��ӷ�����Ϣ
	public int addHouse(House house) throws Exception;
	//ɾ������
	public int removeHouse(Integer id) throws Exception;
	//�޸ķ�����Ϣ
	public int updateHouse(House house) throws Exception;
	//������ѯ������Ϣ
	public List<HouseVo> findHouseByCondition(House house) throws Exception;
	//��ѯ���з�����Ϣ
	public List<HouseVo> findAllHouse() throws Exception;
}
