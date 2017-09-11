package com.fj.service.Imp;

import java.util.ArrayList;
import java.util.List;

import com.fj.dao.*;
import com.fj.dao.Imp.*;
import com.fj.domain.*;
import com.fj.service.HouseService;

public class HouseServiceImp implements HouseService {

	private HouseDao houseDao = new HouseDaoImp();
	private DistrictDao districtDao = new DistrictDaoImp();
	private StreetDao streetDao = new StreetDaoImp();
	private TypeDao typeDao = new TypeDaoImp();
	@Override
	public int addHouse(House house) throws Exception {
		// TODO Auto-generated method stub
		return houseDao.addOne(house);
	}

	@Override
	public int removeHouse(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return houseDao.deleteById(id);
	}

	@Override
	public int updateHouse(House house) throws Exception {
		// TODO Auto-generated method stub
		return houseDao.updateById(house, house.getId());
	}

	@Override
	public List<HouseVo> findHouseByCondition(House house) throws Exception {
		// TODO Auto-generated method stub
		//创建一个对应的HouseVo类
		List<House> houseList = houseDao.findByCondition(house);
		List<HouseVo> houseVoList = new ArrayList<HouseVo>();
		if(houseList!=null){
			for (House h : houseList) {
				//创建对象
				HouseVo houseVo = new HouseVo(h);
				
				Street street = streetDao.findById(h.getStreet_id());
				houseVo.setStreet(street);
				houseVo.setDistrict(districtDao.findById(street.getDistrict_id()));
				houseVo.setType(typeDao.findById(h.getType_id()));
				
				houseVoList.add(houseVo);
			}
		}
		return houseVoList;
	}

	@Override
	public List<HouseVo> findAllHouse() throws Exception {
		// TODO Auto-generated method stub
		//创建一个对应的HouseVo类
		List<House> houseList = houseDao.findAll();
		List<HouseVo> houseVoList = new ArrayList<HouseVo>();
		if(houseList!=null){
			for (House h : houseList) {
				//创建对象
				HouseVo houseVo = new HouseVo(h);
				
				Street street = streetDao.findById(h.getStreet_id());
				houseVo.setStreet(street);
				houseVo.setDistrict(districtDao.findById(street.getDistrict_id()));
				houseVo.setType(typeDao.findById(h.getType_id()));
				
				houseVoList.add(houseVo);
			}
		}
		return houseVoList;
	}



}
