package com.fj.bos.web.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.fj.bos.domain.Staff;
import com.fj.bos.service.IStaffService;
import com.fj.bos.utils.PageBean;
import com.fj.bos.web.action.Base.BaseAction;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
	//ע��ע��
	@Autowired
	private IStaffService staffService;
	
	public String add(){
		staffService.save(model);
		return LIST;
	}
	
	//��ҳ��ѯ
	//@RequiresPermissions("staff-list")
	public String pageQuery() throws IOException{
		staffService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","decidedzones"});
		return NONE;
	}
	
	private String ids;
	
	//����ɾ������
	//ֻ��ӵ��staff-deleteȨ�޵�  �û��ſ���ʹ�ô˷���
	@RequiresPermissions("staff-delete")
	public String deleteBatch(){
		staffService.deleteBatch(ids);
		return LIST;
	}
	
	public String edit(){
		//������id��ѯ��staff
		Staff staff = staffService.findById(model.getId());
		//ʹ��ҳ���ύ�����ݽ��и���
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setHaspda(model.getHaspda());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staffService.update(staff);
		
		return LIST;
	}
	
	//ajax�������еĿ��Ա(û������)
	public String listajax(){
		List<Staff> list = staffService.findListNotDelete();
		//��listת��Ϊjson 	������Ӧ
		java2Json(list, new String[]{"decidedzones"});
		return NONE;
	}
	


	public String getIds() {
		return ids;
	}


	public void setIds(String ids) {
		this.ids = ids;
	}
}