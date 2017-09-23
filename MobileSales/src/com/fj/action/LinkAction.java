package com.fj.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Affiche;
import com.fj.domain.Link;
import com.fj.domain.PageBean;
import com.fj.service.LinkService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkAction extends ActionSupport implements ModelDriven<Link>{

	//定义Link
	private Link link = new Link();
	//定义服务类
	private LinkService linkService;
	//默认当前页是第一页
	private Integer currentPage=1;
	//查询分页的连接
	
	//分页查询所有的链接
	public String findAllLink() throws Exception{
		//创建我们的查询条件
		PageBean<Link> pageBean = new PageBean<Link>();
		//设置当前页和每页的数量
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<Link> links = linkService.findAllLink(pageBean);
		//放入到域对象里
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("links", links);
		//跳转
		return "findAllLink";
	}
	
	//添加连接
	public String addLink() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="添加成功";
		try {
			linkService.addLink(link);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="添加失败! ";
		}
		request.setAttribute("result", result);
		return "toLinkResult";
	}
	
	//删除连接
	public String deleteLink() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="删除成功";
		try {
			linkService.deleteLink(link);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="删除失败!";
		}
		request.setAttribute("result", result);
		return "toLinkResult";
	}
	
	@Override
	public Link getModel() {
		// TODO Auto-generated method stub
		return link;
	}

	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
