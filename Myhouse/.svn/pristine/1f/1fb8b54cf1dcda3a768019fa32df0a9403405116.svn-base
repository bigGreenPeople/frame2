package com.fj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.District;
import com.fj.domain.House;
import com.fj.domain.HouseVo;
import com.fj.domain.PageBean;
import com.fj.domain.Street;
import com.fj.domain.Type;
import com.fj.domain.Users;
import com.fj.service.*;
import com.fj.service.Imp.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class HouseAction extends ActionSupport implements ModelDriven<House>{
	//创建服务类
	private HouseService houseService = new HouseServiceImp();
	private TypeService typeService = new TypeServiceImp();
	private StreetService streetService = new StreetServiceImp();
	private DistrictService districtService = new DistrictServiceImp();
	// 定义一个当前页  默认是第一页	如果要跳转到别的页面就这样传参 ?currentPage=要跳转的页面
	private Integer currentPage = 1;
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	//创建House对象
	private House house = new House();
	//到管理员的房屋
	public String toUserHouseList() throws Exception{
		//先得到session里面的用户
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Users loginUser = (Users) session.getAttribute("loginUser");
//		创建一个条件
		House tempH = new House();
		tempH.setUser_id(loginUser.getId());
		//得到user的房屋
		//List<HouseVo> list = houseService.findHouseByCondition(tempH);
		PageBean<HouseVo> pageBean = houseService.findHousePageByCondition(tempH, currentPage);
		//将查询到的信息放入到request中
		request.setAttribute("pageBean", pageBean);
		return "toUserHouseList";
	}
	//条件查询房屋
	public String toHouselistByCondition() throws Exception{
		
		return "toHouselist";
	}
	
	//到普通用户的房屋界面
	public String toHouselist() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		PageBean<HouseVo> pageBean = houseService.findHousePageByCondition2(house, currentPage);
		//得到区域和街道
		List<Type> types = typeService.findAllType();
		List<Street> streets = streetService.findAllStreet();
		List<District> districts = districtService.findAllDistrict();
		
		//放入域对象
		request.setAttribute("types", types);
		request.setAttribute("streets", streets);
		request.setAttribute("districts", districts);
		//将查询到的信息放入到request中
		request.setAttribute("pageBean", pageBean);
		return "toHouselist";
	}
	
	//搜索房屋
	public String findHouse() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		PageBean<HouseVo> pageBean = houseService.findHousePageByCondition2(house, currentPage);
		//得到区域和街道
		List<Type> types = typeService.findAllType();
		List<Street> streets = streetService.findAllStreet();
		List<District> districts = districtService.findAllDistrict();
		
		//放入域对象
		request.setAttribute("types", types);
		request.setAttribute("streets", streets);
		request.setAttribute("districts", districts);
		//将查询到的信息放入到request中
		request.setAttribute("pageBean", pageBean);
		return "toHouselist";
	}
	
	//显示房屋的详细信息
	public String showHouseInfo() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HouseVo houseVo = houseService.findHouseById(house.getId());
		request.setAttribute("houseVo", houseVo);
		return "showHouseInfo";
	}
	
	//到发布房屋界面
	public String toPublishHouse() throws Exception{
		
		//得到区域和街道
		List<Type> types = typeService.findAllType();
		List<Street> streets = streetService.findAllStreet();
		List<District> districts = districtService.findAllDistrict();
		
		//放入域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("types", types);
		request.setAttribute("streets", streets);
		request.setAttribute("districts", districts);
		
		return "toPublishHouse";
	}
	
	//发布房屋信息
	public String publishHouse() throws Exception{
		
		//取出session的user将它的id放入到house_user_id
		Users user = (Users) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		house.setUser_id(user.getId());
		
		int num = houseService.addHouse(house);
		if(num>0){
			return "publishHouseOk";
		}else{
			return NONE;
		}
		
	}
	
	//到修改房屋的界面
	public String toUpdateHouse() throws Exception{
		//得到区域和街道
		List<Type> types = typeService.findAllType();
		List<Street> streets = streetService.findAllStreet();
		List<District> districts = districtService.findAllDistrict();
		House houseById = houseService.findHouseById(house.getId());
		
		//放入域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("types", types);
		request.setAttribute("streets", streets);
		request.setAttribute("districts", districts);
		request.setAttribute("house", houseById);
		
		return "toUpdateHouse";
	}
	
	//修改房屋
	public String updateHouse() throws Exception{
		//取出session的user将它的id放入到house_user_id
//		Users user = (Users) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
//		house.setUser_id(user.getId());
		int num = houseService.updateHouse(house);
		if(num>0){
			return "updateHouseOk";
		}else{
			return NONE;
		}
	}
	
	//删除
	public String deleteHouse() throws Exception{
		int num = houseService.removeHouse(house.getId());
		
		if(num>0){
			return "deleteOk";
		}else{
			return NONE;
		}
		
	}

	@Override
	public House getModel() {
		// TODO Auto-generated method stub
		return house;
	}
}
