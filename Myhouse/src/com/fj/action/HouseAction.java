package com.fj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.House;
import com.fj.domain.HouseVo;
import com.fj.domain.Users;
import com.fj.service.*;
import com.fj.service.Imp.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class HouseAction extends ActionSupport implements ModelDriven<House>{
	//创建服务类
	private HouseService houseService = new HouseServiceImp();
//	private TypeService typeService = new TypeServiceImp();
//	private StreetService streetService = new StreetServiceImp();
//	private DistrictService districtService = new DistrictServiceImp();
	// 定义一个当前页  默认是第一页	如果要跳转到别的页面就这样传参 ?currentPage=要跳转的页面
	private Integer currentPage = 1;
	
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
		List<HouseVo> list = houseService.findHouseByCondition(tempH);
		//将查询到的信息放入到request中
		request.setAttribute("list", list);
		return "toUserHouseList";
	}
	
	//到普通用户的房屋界面
	public String toHouselist() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		List<HouseVo> list = houseService.findAllHouse();
		//将查询到的信息放入到request中
		request.setAttribute("list", list);
		return "toHouselist";
	}

	@Override
	public House getModel() {
		// TODO Auto-generated method stub
		return house;
	}
}
