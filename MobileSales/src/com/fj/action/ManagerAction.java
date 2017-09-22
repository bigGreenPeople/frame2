package com.fj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Manager;
import com.fj.domain.Member;
import com.fj.domain.PageBean;
import com.fj.service.ManagerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ManagerAction extends ActionSupport implements ModelDriven<Manager>{
	//�����ù���Ա
	private Manager manager = new Manager();
	//�����÷�����
	private ManagerService managerService;
	//ԭ��������
	private String old;
	//Ĭ�ϵ�ǰҳ�ǵ�һҳ
	private Integer currentPage=1;
	//��ѯ���еĹ���Ա
	public String findAllManager() throws Exception{
		//�������ǵĲ�ѯ����
		PageBean<Manager> pageBean = new PageBean<Manager>();
		//���õ�ǰҳ��ÿҳ������
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<Manager> managers = managerService.findAllManager(pageBean);
		
		//���뵽�������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("managers", managers);
		
		return "findAllManager";
	}
	
	//ɾ������Ա
	public String deleteManager() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result = "ɾ���ɹ�";
		try {
			managerService.deleteManager(manager);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "ɾ��ʧ��!";
		}
		request.setAttribute("result", result);
		return "toManagerResult";
	}
	
	//��ӹ���Ա
	public String addManager() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result = "��ӳɹ�";
		try {
			managerService.addManager(manager);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "���ʧ��!";
		}
		request.setAttribute("result", result);
		return "toManagerResult";
	}

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
	
	//��ȫ�˳�
	public String managerOut() throws Exception{
		//�õ����ǵ������
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//���session��
		String result = "ע���ɹ�!";
		request.setAttribute("result", result);
		session.removeAttribute("loginManager");
		return "toLandResult";
	}
	//�޸�����
	public String upPass() throws Exception{
		String result = "�޸�����ɹ�,�����µ�¼!";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		try {
			Manager loginManager = (Manager) session.getAttribute("loginManager");
			if(loginManager.getPassword().equals(old)){
				loginManager.setPassword(manager.getPassword());
				managerService.updatePass(loginManager);
				managerOut();
			}else{
				result = "�޸�ʧ��,�������!";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "�޸�ʧ��!";
		}
		request.setAttribute("result", result);
		return "toLandResult";
	}
	
	@Override
	public Manager getModel() {
		// TODO Auto-generated method stub
		return manager;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
	}
	
	
}
