package com.fj.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Affiche;
import com.fj.domain.Goods;
import com.fj.domain.GoodsCondition;
import com.fj.domain.Link;
import com.fj.domain.Member;
import com.fj.domain.Order;
import com.fj.domain.OrderDetail;
import com.fj.domain.PageBean;
import com.fj.service.AfficheService;
import com.fj.service.GoodsService;
import com.fj.service.LinkService;
import com.fj.service.MemberService;
import com.fj.service.OrderService;
import com.fj.utils.UniName;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	//���������
	private GoodsService goodsService;
	private LinkService linkService;
	private AfficheService afficheService;
	private OrderService orderService;
	private MemberService memberService;
	private Integer currentPage=1;
	//���������
		private int goodsNumId;
	//������Ʒ
	private Goods goods;
	private Integer[] nums;
	private Integer[] ids;
	
	//���嶩��
	private Order order;
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
	
	//��ѯ�û������ж���
	public String showOrder() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		Set<Order> orderSet = memberService.findMemberById(loginMember.getId()).getOrderSet();
		request.setAttribute("orderSet", orderSet);
		
		this.getLeftDate();
		return "showOrder";
	}
	
	//��ѯ������ϸ
	public String showOrderDetail() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Order findOrderById = orderService.findOrderById(order.getId());
		request.setAttribute("order", findOrderById);
		this.getLeftDate();
		return "showOrderDetail";
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
	
	public String showOrderGoodsInfo() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("goodsNumId", goodsNumId);
		Goods findGoodsById = goodsService.findGoodsById(goods.getId());
		request.setAttribute("goods", findGoodsById);
		this.getLeftDate();
		return "showOrderGoodsInfo";
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
		String result = "��ӹ��ﳵ�ɹ�";
		try {
			//�õ���ǰ�û�
			HttpSession session = ServletActionContext.getRequest().getSession();
			Member loginMember = (Member) session.getAttribute("loginMember");
			Cookie cookie = new Cookie("MobileSales"+loginMember.getName()+goods.getId(), goods.getId()+"");
			
			HttpServletResponse response = ServletActionContext.getResponse();
			//cookie.setPath("/");
			response.addCookie(cookie);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "��ӹ��ﳵʧ��!";
		}
		
		ServletActionContext.getRequest().setAttribute("result", result);
		
		return "addCart";
	}
	
	//�鿴���ﳵ
	public String showCart() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//�õ���ǰ�û�
		Member loginMember = (Member) session.getAttribute("loginMember");
		//�õ��û����͵�����cookies
		Cookie[] cookies = request.getCookies();
		
		//���list���Ҫ�������Ʒ
		List<Goods> goodsList = new ArrayList<Goods>();
		for (int i=0; cookies!=null&&i<cookies.length; i++) {
			if(cookies[i].getName().startsWith(("MobileSales"+loginMember.getName()))){
				//�õ���Ʒ�ı��
				int id = Integer.parseInt(cookies[i].getValue());
				//��ѯ����Ʒ
				Goods findGoodsById = goodsService.findGoodsById(id);
				//���뵽list��
				goodsList.add(findGoodsById);
			}
		}
		
		request.setAttribute("goodsList", goodsList);
		this.getLeftDate();
		return "showCart";
	}
	
	//�����˽���
	public String toCartCheckOut() throws Exception{
		//�õ������
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		//�õ���¼�Ļ�Ա
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		//���ɶ�����
		String orderId = (UniName.getFname()+loginMember.getId());
		request.setAttribute("orderId", orderId);
		
		Set<OrderDetail> orderDetailSet = new HashSet<OrderDetail>();
		
		for(int i=0;i<ids.length;i++){
			OrderDetail orderDetail = new OrderDetail();
			Goods findGoodsById = goodsService.findGoodsById(ids[i]);
			orderDetail.setGoods(findGoodsById);
			orderDetail.setNumber(nums[i]);
			if(findGoodsById.getMark()==0){
				orderDetail.setPrice(findGoodsById.getNowPrice());
			}else {
				orderDetail.setPrice(findGoodsById.getFreePrice());
			}
			orderDetailSet.add(orderDetail);
		}
		
//		��set����session
		session.setAttribute("orderDetailSet", orderDetailSet);
		this.getLeftDate();
		return "cartCheckOut";
	}
	
	//��չ��ﳵ
	public String cartOut() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		//�õ���¼�Ļ�Ա
		Member loginMember = (Member) session.getAttribute("loginMember");
		//�õ��û����͵�����cookies
		Cookie[] cookies = request.getCookies();
		
		for (int i=0; cookies!=null&&i<cookies.length; i++) {
			if(cookies[i].getName().startsWith(("MobileSales"+loginMember.getName()))){
				//cookies[i].setPath("/");
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
			}
		}
		
		return "cartOut";
	}
	
	//�ύ����
	public String commitOrder() throws Exception{
		//�õ������
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String result = "�����ύ�ɹ������ס��Ķ�����";
		try {
			//�õ���¼�Ļ�Ա
			Member loginMember = (Member) session.getAttribute("loginMember");
			order.setMember(loginMember);
			
			//�õ�������ϸ
			Set<OrderDetail> orderDetailSet = (Set<OrderDetail>) session.getAttribute("orderDetailSet");
			
			order.setOrderDetailSet(orderDetailSet);
			orderService.addOrder(order);
			//���cook
			cartOut();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "�����ύʧ��,���Ժ�����!";
		}
		
		request.setAttribute("result", result);
		return "commitOrder";
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer[] getNums() {
		return nums;
	}

	public void setNums(Integer[] nums) {
		this.nums = nums;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public int getGoodsNumId() {
		return goodsNumId;
	}

	public void setGoodsNumId(int goodsNumId) {
		this.goodsNumId = goodsNumId;
	}
	
	
	
}
