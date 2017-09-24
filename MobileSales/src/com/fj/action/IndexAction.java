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
	//���������
	private GoodsService goodsService;
	private LinkService linkService;
	private AfficheService afficheService;
	private Integer currentPage=1;
	//������Ʒ
	private Goods goods;
	//����Ʒ�ϼ�ҳ��
	public String toNewGoods() throws Exception{
		//������Ʒ�ķ�ҳ����
		PageBean<Goods> pageBean = new PageBean<Goods>();
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(4);
		PageBean<Goods> newGoodss = goodsService.findGoodsByCreaTime(7, pageBean);
		HttpServletRequest request = ServletActionContext.getRequest();
		//������Ʒ���뵽request
		request.setAttribute("newGoodss", newGoodss);
		this.getLeftDate();
		return "toNewGoods";
	}
	
	//���ؼ���Ʒ����
	public String toFreeGoods() throws Exception{
		//������Ʒ����
		GoodsCondition goodsCondition = new GoodsCondition();
		goodsCondition.setMark(1);
		PageBean<Goods> markGoodss = goodsService.findAllGoods(currentPage, goodsCondition,4);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("markGoodss", markGoodss);
		this.getLeftDate();
		return "toFreeGoods";
	}
	
	//��ϵͳ��ҳ
	public String toIndex() throws Exception{
		//������Ʒ�ķ�ҳ����
		PageBean<Goods> pageBean = new PageBean<Goods>();
		pageBean.setCurrentPage(1);
		pageBean.setPageSize(2);
		PageBean<Goods> newGoodss = goodsService.findGoodsByCreaTime(7, pageBean);
		
		//������Ʒ����
		GoodsCondition goodsCondition = new GoodsCondition();
		goodsCondition.setMark(1);
		PageBean<Goods> markGoodss = goodsService.findAllGoods(1, goodsCondition,2);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		//������Ʒ���뵽request
		request.setAttribute("newGoodss", newGoodss);
		request.setAttribute("markGoodss", markGoodss);
		this.getLeftDate();
		return "toIndex";
	}
	
	//�õ�ҳ����ߵ�����
	public void getLeftDate() throws Exception{
		//�ҵ�����
		List<Link> links = linkService.findAllLink();
		//�ҵ�����
		List<Affiche> affiches = afficheService.findAllAffiche();
		//�õ�ǰʮ���ֻ�����
		PageBean<Goods> pageBean = new PageBean<Goods>();
		pageBean.setCurrentPage(1);
		pageBean.setPageSize(7);
		PageBean<Goods> goodss = goodsService.findGoodsByTheFirstTen(pageBean);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("links", links);
		request.setAttribute("affiches", affiches);
		request.setAttribute("goodss", goodss);
	}
	
	//�������ֻ���ϸҳ��
	public String showGoodsInfo() throws Exception{
		//����id��ѯ������
		Goods findGoodsById = goodsService.findGoodsById(goods.getId());
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("goods", findGoodsById);
		return "showGoodsInfo";
	}
	//���빺�ﳵ
	public String addCart() throws Exception{
		
		
		
		return "addCart";
	}
	
	//������ǰʮ
	public String toGoodsTen() throws Exception{
		//�õ�ǰʮ���ֻ�����
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
