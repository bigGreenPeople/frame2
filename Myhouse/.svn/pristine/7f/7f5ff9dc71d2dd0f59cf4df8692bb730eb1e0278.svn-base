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
	public HouseVo findHouseById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		House house = houseDao.findById(id);
		List<House> list = new ArrayList<House>();
		list.add(house);
		List<HouseVo> houseVoList = toHouseVoList(list);
		return houseVoList.get(0);
	}

	@Override
	public List<HouseVo> findHouseByCondition(House house) throws Exception {
		// TODO Auto-generated method stub
		//创建一个对应的HouseVo类
		List<House> houseList = houseDao.findByCondition(house);
		
		return toHouseVoList(houseList);
	}
	
	//写一个把list里面是House转换成HouseVo
	public List<HouseVo> toHouseVoList(List<House> houseList) throws Exception{
		//新的list
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
	public PageBean<HouseVo> findHousePageByCondition(House house,
			Integer currentPage) throws Exception {
		// TODO Auto-generated method stub
		//默认每页的显示为2
		PageBean<House> pageBean = new PageBean<House>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(2);
		
		pageBean = houseDao.findPageByCondition(house, pageBean);
		//新的pagebean
		PageBean<HouseVo> paBean = new PageBean<HouseVo>();
		paBean.setBegin(pageBean.getCurrentPage());
		paBean.setCurrentPage(pageBean.getCurrentPage());
		paBean.setEnd(pageBean.getEnd());
		paBean.setList(this.toHouseVoList(pageBean.getList()));
		paBean.setPageSize(pageBean.getPageSize());
		paBean.setTotalCount(pageBean.getTotalCount());
		paBean.setTotalPage(pageBean.getTotalPage());
		
		return paBean;
	}
	@Override
	public PageBean<HouseVo> findHousePageByCondition2(House house,
			Integer currentPage) throws Exception {
		// TODO Auto-generated method stub
		//默认每页的显示为2
		PageBean<House> pageBean = new PageBean<House>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(2);
		
		pageBean = houseDao.findHouseByCondition(house, pageBean);
		//新的pagebean
		PageBean<HouseVo> paBean = new PageBean<HouseVo>();
		paBean.setBegin(pageBean.getCurrentPage());
		paBean.setCurrentPage(pageBean.getCurrentPage());
		paBean.setEnd(pageBean.getEnd());
		paBean.setList(this.toHouseVoList(pageBean.getList()));
		paBean.setPageSize(pageBean.getPageSize());
		paBean.setTotalCount(pageBean.getTotalCount());
		paBean.setTotalPage(pageBean.getTotalPage());
		
		return paBean;
	}

	@Override
	public PageBean<HouseVo> findPageAllHouse(Integer currentPage) throws Exception {
		// TODO Auto-generated method stub
		//默认每页的显示为2
		PageBean<House> pageBean = new PageBean<House>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(2);
		
		pageBean = houseDao.findPageAll(pageBean);
		//新的pagebean
		PageBean<HouseVo> paBean = new PageBean<HouseVo>();
		paBean.setBegin(pageBean.getCurrentPage());
		paBean.setCurrentPage(pageBean.getCurrentPage());
		paBean.setEnd(pageBean.getEnd());
		paBean.setList(this.toHouseVoList(pageBean.getList()));
		paBean.setPageSize(pageBean.getPageSize());
		paBean.setTotalCount(pageBean.getTotalCount());
		paBean.setTotalPage(pageBean.getTotalPage());
		
		return paBean;
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
