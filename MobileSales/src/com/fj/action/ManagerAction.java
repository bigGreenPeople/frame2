package com.fj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Manager;
import com.fj.service.ManagerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ManagerAction extends ActionSupport implements ModelDriven<Manager>{
	//�����ù���Ա
	private Manager manager = new Manager();
	//�����÷�����
	private ManagerService managerService;

	public String login() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		//�õ���¼���û�
		Manager loginManager = managerService.login(manager);
		//�������Ϊ�շ��뵽session	����ת������ҳ��
		if(loginManager!=null){
			HttpSession session = request.getSession();
			session.setAttribute("loginManager", loginManager);
			
		}else{
			String result = "�˺Ż��������!";
			request.setAttribute("result", result);
		}
		//������ת����¼����
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
