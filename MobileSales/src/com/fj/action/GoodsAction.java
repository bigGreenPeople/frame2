package com.fj.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.BigType;
import com.fj.domain.PageBean;
import com.fj.service.BigTypeService;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport {
	//创建服务类
	private BigTypeService bigTypeService;
	//默认当前页是第一页
	private Integer currentPage=1;
	//查询所有的大类别
	public String findAllBigType() throws Exception{
		//创建我们的查询条件
		PageBean<BigType> pageBean = new PageBean<BigType>();
		//设置当前页和每页的数量
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<BigType> bigTypes = bigTypeService.findAllBigType(pageBean);
		
		//放入到域对象里
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("bigTypes", bigTypes);
		//跳转
		return "findAllBigType";
	}
	
	
	public void setBigTypeService(BigTypeService bigTypeService) {
		this.bigTypeService = bigTypeService;
	}
	
	
}
