package com.fj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Link;
import com.fj.service.AfficheService;
import com.fj.service.GoodsService;
import com.fj.service.LinkService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	//定义服务类
	private GoodsService goodsService;
	private LinkService linkService;
	private AfficheService afficheService;
	
	//到系统首页
	public String toIndex() throws Exception{
		List<Link> links = linkService.findAllLink();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("links", links);
		return "toIndex";
	}
	
	
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}
	public void setAfficheService(AfficheService afficheService) {
		this.afficheService = afficheService;
	}
}
