package com.fj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.BigType;
import com.fj.domain.PageBean;
import com.fj.domain.SmallType;
import com.fj.service.BigTypeService;
import com.opensymphony.xwork2.ActionSupport;

public class TypeAction extends ActionSupport {
	//大类别
	private BigType bigType;
	//小类别
	private SmallType smallType;
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
	
	//查询所有的小类别
	public String findAllSmallType() throws Exception{
		//创建我们的查询条件
		PageBean<SmallType> pageBean = new PageBean<SmallType>();
		//设置当前页和每页的数量
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<SmallType> smallTypes = bigTypeService.findAllSmallType(pageBean);
		
		//放入到域对象里
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("smallTypes", smallTypes);
		//跳转
		return "findAllSmallType";
	}
	
	//到添加小类别页面
	public String toAddSmallType() throws Exception{
		//取得所得大类别
		List<BigType> list = bigTypeService.findAllBigType();
		//放入request
		if(list!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("list", list);
		}
		return "toAddSmallType";
	}
	
	//删除大类别
	public String deleteBigType() throws Exception{
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			bigTypeService.deleteBigType(bigType);
			result = "删除成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "删除失败";
		}
		
		request.setAttribute("result", result);
		return "toBigResult";
	}
	
	//删除小类别
	public String deleteSmallType() throws Exception{
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			bigTypeService.deleteSmallType(smallType);;
			result = "删除成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "删除失败";
		}
		request.setAttribute("result", result);
		
		return "toSmallResult";
	}
	
	//添加大类别
	public String addBigType() throws Exception{
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			bigTypeService.addBigType(bigType);
			result = "添加成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "添加失败";
		}
		
		request.setAttribute("result", result);
		return "toBigResult";
	}
	
	//添加小类别
	public String addSmallType() throws Exception{
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			bigTypeService.addSmallType(smallType);
			result = "添加成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "添加失败";
		}
		
		request.setAttribute("result", result);
		return "toSmallResult";
	}
	public void setBigTypeService(BigTypeService bigTypeService) {
		this.bigTypeService = bigTypeService;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public BigType getBigType() {
		return bigType;
	}

	public void setBigType(BigType bigType) {
		this.bigType = bigType;
	}

	public SmallType getSmallType() {
		return smallType;
	}

	public void setSmallType(SmallType smallType) {
		this.smallType = smallType;
	}
	
	
}
