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
	//创建好管理员
	private Manager manager = new Manager();
	//创建好服务类
	private ManagerService managerService;
	//原来的密码
	private String old;
	//默认当前页是第一页
	private Integer currentPage=1;
	//查询所有的管理员
	public String findAllManager() throws Exception{
		//创建我们的查询条件
		PageBean<Manager> pageBean = new PageBean<Manager>();
		//设置当前页和每页的数量
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<Manager> managers = managerService.findAllManager(pageBean);
		
		//放入到域对象里
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("managers", managers);
		
		return "findAllManager";
	}
	
	//删除管理员
	public String deleteManager() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result = "删除成功";
		try {
			managerService.deleteManager(manager);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "删除失败!";
		}
		request.setAttribute("result", result);
		return "toManagerResult";
	}
	
	//添加管理员
	public String addManager() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result = "添加成功";
		try {
			managerService.addManager(manager);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "添加失败!";
		}
		request.setAttribute("result", result);
		return "toManagerResult";
	}

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
	
	//安全退出
	public String managerOut() throws Exception{
		//得到我们的域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//清空session域
		String result = "注销成功!";
		request.setAttribute("result", result);
		session.removeAttribute("loginManager");
		return "toLandResult";
	}
	//修改密码
	public String upPass() throws Exception{
		String result = "修改密码成功,请重新登录!";
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		try {
			Manager loginManager = (Manager) session.getAttribute("loginManager");
			if(loginManager.getPassword().equals(old)){
				loginManager.setPassword(manager.getPassword());
				managerService.updatePass(loginManager);
				managerOut();
			}else{
				result = "修改失败,密码错误!";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "修改失败!";
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
