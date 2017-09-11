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
	//����������
	private HouseService houseService = new HouseServiceImp();
//	private TypeService typeService = new TypeServiceImp();
//	private StreetService streetService = new StreetServiceImp();
//	private DistrictService districtService = new DistrictServiceImp();
	// ����һ����ǰҳ  Ĭ���ǵ�һҳ	���Ҫ��ת�����ҳ����������� ?currentPage=Ҫ��ת��ҳ��
	private Integer currentPage = 1;
	
	//����House����
	private House house = new House();
	//������Ա�ķ���
	public String toUserHouseList() throws Exception{
		//�ȵõ�session������û�
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Users loginUser = (Users) session.getAttribute("loginUser");
//		����һ������
		House tempH = new House();
		tempH.setUser_id(loginUser.getId());
		//�õ�user�ķ���
		List<HouseVo> list = houseService.findHouseByCondition(tempH);
		//����ѯ������Ϣ���뵽request��
		request.setAttribute("list", list);
		return "toUserHouseList";
	}
	
	//����ͨ�û��ķ��ݽ���
	public String toHouselist() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		List<HouseVo> list = houseService.findAllHouse();
		//����ѯ������Ϣ���뵽request��
		request.setAttribute("list", list);
		return "toHouselist";
	}

	@Override
	public House getModel() {
		// TODO Auto-generated method stub
		return house;
	}
}
