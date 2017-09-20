package com.fj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Manager;
import com.fj.service.ManagerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ManagerAction extends ActionSupport implements ModelDriven<Manager>{
	//创建好管理员
	private Manager manager = new Manager();
	//创建好服务类
	private ManagerService managerService;

	public String login() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		//得到登录的用户
		Manager loginManager = managerService.login(manager);
		//如果不是为空放入到session	并跳转到管理页面
		if(loginManager!=null){
			HttpSession session = request.getSession();
			session.setAttribute("loginManager", loginManager);
			
		}else{
			String result = "账号或密码错误!";
			request.setAttribute("result", result);
		}
		//否则跳转到登录界面
		return "toManager";
	}
	
	@Override
	public Manager getModel() {
		// TODO Auto-generated method stub
		return manager;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	
}
