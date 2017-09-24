package com.fj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Affiche;
import com.fj.domain.Goods;
import com.fj.domain.GoodsCondition;
import com.fj.domain.Link;
import com.fj.domain.PageBean;
import com.fj.service.AfficheService;
import com.fj.service.GoodsService;
import com.fj.service.LinkService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	//定义服务类
	private GoodsService goodsService;
	private LinkService linkService;
	private AfficheService afficheService;
	private Integer currentPage=1;
	//定义商品
	private Goods goods;
	//到新品上架页面
	public String toNewGoods() throws Exception{
		//设置新品的分页条件
		PageBean<Goods> pageBean = new PageBean<Goods>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(4);
		PageBean<Goods> newGoodss = goodsService.findGoodsByCreaTime(7, pageBean);
		HttpServletRequest request = ServletActionContext.getRequest();
		//将新商品放入到request
		request.setAttribute("newGoodss", newGoodss);
		this.getLeftDate();
		return "toNewGoods";
	}
	
	//到特检商品界面
	public String toFreeGoods() throws Exception{
		//设置商品条件
		GoodsCondition goodsCondition = new GoodsCondition();
		goodsCondition.setMark(1);
		PageBean<Goods> markGoodss = goodsService.findAllGoods(currentPage, goodsCondition,4);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("markGoodss", markGoodss);
		this.getLeftDate();
		return "toFreeGoods";
	}
	
	//到系统首页
	public String toIndex() throws Exception{
		//设置新品的分页条件
		PageBean<Goods> pageBean = new PageBean<Goods>();
		pageBean.setCurrentPage(1);
		pageBean.setPageSize(2);
		PageBean<Goods> newGoodss = goodsService.findGoodsByCreaTime(7, pageBean);
		
		//设置商品条件
		GoodsCondition goodsCondition = new GoodsCondition();
		goodsCondition.setMark(1);
		PageBean<Goods> markGoodss = goodsService.findAllGoods(1, goodsCondition,2);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		//将新商品放入到request
		request.setAttribute("newGoodss", newGoodss);
		request.setAttribute("markGoodss", markGoodss);
		this.getLeftDate();
		return "toIndex";
	}
	
	//得到页面左边的数据
	public void getLeftDate() throws Exception{
		//找到链接
		List<Link> links = linkService.findAllLink();
		//找到公告
		List<Affiche> affiches = afficheService.findAllAffiche();
		//得到前十的手机排行
		PageBean<Goods> pageBean = new PageBean<Goods>();
		pageBean.setCurrentPage(1);
		pageBean.setPageSize(7);
		PageBean<Goods> goodss = goodsService.findGoodsByTheFirstTen(pageBean);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("links", links);
		request.setAttribute("affiches", affiches);
		request.setAttribute("goodss", goodss);
	}
	
	//到购买手机详细页面
	public String showGoodsInfo() throws Exception{
		//依靠id查询到对象
		Goods findGoodsById = goodsService.findGoodsById(goods.getId());
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("goods", findGoodsById);
		return "showGoodsInfo";
	}
	//放入购物车
	public String addCart() throws Exception{
		
		
		
		return "addCart";
	}
	
	//到销售前十
	public String toGoodsTen() throws Exception{
		//得到前十的手机排行
		PageBean<Goods> pageBean = new PageBean<Goods>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		PageBean<Goods> goodss = goodsService.findGoodsByTheFirstTen(pageBean);
		
		goodsService.findGoodsByTheFirstTen(pageBean);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("goodssTen", goodss);
		this.getLeftDate();
		return "toGoodsTen";
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

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
}
