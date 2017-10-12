package com.fj.bos.web.action;

import java.util.List;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fj.bos.domain.Role;
import com.fj.bos.service.IRoleService;
import com.fj.bos.web.action.Base.BaseAction;

@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	//注入service 
	@Autowired
	private IRoleService roleService;
	
	//得到关联的所有权限id
	private String functionIds;
	
	public String add(){
		roleService.save(model, functionIds);
		return LIST;
	}
	
	//得到所有的Role
	public String listajax(){
		List<Role> list = roleService.finAll();
		java2Json(list, new String[]{"functions","users"});
		return NONE;
	}
	
	//分页查询
	public String pageQuery(){
		roleService.pageQuery(pageBean);
		java2Json(pageBean, new String[]{"functions","users"});
		return NONE;
	}
	
	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	}
	
	
	
}
