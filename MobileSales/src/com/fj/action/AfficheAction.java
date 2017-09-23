package com.fj.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Affiche;
import com.fj.domain.BigType;
import com.fj.domain.PageBean;
import com.fj.service.AfficheService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AfficheAction extends ActionSupport implements ModelDriven<Affiche>{
	//定义服务类
	private AfficheService afficheService;
	//创建接受参数的Affiche
	private Affiche affiche = new Affiche();
	//默认当前页是第一页
	private Integer currentPage=1;
	
	//分页查询所有的公告
	public String findAllAffiche() throws Exception{
		//创建我们的查询条件
		PageBean<Affiche> pageBean = new PageBean<Affiche>();
		//设置当前页和每页的数量
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<Affiche> affiches = afficheService.findAllAffiche(pageBean);
		//放入到域对象里
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("affiches", affiches);
		//跳转
		return "findAllAffiche";
	}
	
	//添加公告
	public String addAffiche() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="添加成功";
		try {
			afficheService.addAffiche(affiche);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="添加失败! ";
		}
		request.setAttribute("result", result);
		return "toAfficheResult";
	}
	
	//到修改界面
	public String toUpdateAffiche() throws Exception{
		
		Affiche findAfficheById = afficheService.findAfficheById(affiche.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("affiche", findAfficheById);
		return "toUpdateAffiche";
	}
	
	//修改公告
	public String updateAffiche() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="修改成功";
		try {
			afficheService.updateAffiche(affiche);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="修改失败!";
		}
		request.setAttribute("result", result);
		return "toAfficheResult";
	}
	
	//查询公告内容
	public String showAfficheInfo() throws Exception{
		Affiche findAfficheById = afficheService.findAfficheById(affiche.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("affiche", findAfficheById);
		return "showAfficheInfo";
	}

	//删除公告
	public String deleteAffiche() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="删除成功";
		try {
			afficheService.deleteAffiche(affiche);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="删除失败!";
		}
		request.setAttribute("result", result);
		return "toAfficheResult";
	}
	
	public void setAfficheService(AfficheService afficheService) {
		this.afficheService = afficheService;
	}

	@Override
	public Affiche getModel() {
		// TODO Auto-generated method stub
		return affiche;
	}
	
	
}
