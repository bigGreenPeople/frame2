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
	//定义服务类
	private GoodsService goodsService;
	private LinkService linkService;
	private AfficheService afficheService;
	private OrderService orderService;
	private MemberService memberService;
	private Integer currentPage=1;
	//定义好排名
		private int goodsNumId;
	//定义商品
	private Goods goods;
	private Integer[] nums;
	private Integer[] ids;
	
	//定义订单
	private Order order;
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
	
	//查询用户的所有订单
	public String showOrder() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		Set<Order> orderSet = memberService.findMemberById(loginMember.getId()).getOrderSet();
		request.setAttribute("orderSet", orderSet);
		
		this.getLeftDate();
		return "showOrder";
	}
	
	//查询订单明细
	public String showOrderDetail() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Order findOrderById = orderService.findOrderById(order.getId());
		request.setAttribute("order", findOrderById);
		this.getLeftDate();
		return "showOrderDetail";
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
	
	public String showOrderGoodsInfo() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("goodsNumId", goodsNumId);
		Goods findGoodsById = goodsService.findGoodsById(goods.getId());
		request.setAttribute("goods", findGoodsById);
		this.getLeftDate();
		return "showOrderGoodsInfo";
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
		String result = "添加购物车成功";
		try {
			//得到当前用户
			HttpSession session = ServletActionContext.getRequest().getSession();
			Member loginMember = (Member) session.getAttribute("loginMember");
			Cookie cookie = new Cookie("MobileSales"+loginMember.getName()+goods.getId(), goods.getId()+"");
			
			HttpServletResponse response = ServletActionContext.getResponse();
			//cookie.setPath("/");
			response.addCookie(cookie);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "添加购物车失败!";
		}
		
		ServletActionContext.getRequest().setAttribute("result", result);
		
		return "addCart";
	}
	
	//查看购物车
	public String showCart() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//得到当前用户
		Member loginMember = (Member) session.getAttribute("loginMember");
		//得到用户发送的所有cookies
		Cookie[] cookies = request.getCookies();
		
		//这个list存放要购买的商品
		List<Goods> goodsList = new ArrayList<Goods>();
		for (int i=0; cookies!=null&&i<cookies.length; i++) {
			if(cookies[i].getName().startsWith(("MobileSales"+loginMember.getName()))){
				//得到商品的编号
				int id = Integer.parseInt(cookies[i].getValue());
				//查询到商品
				Goods findGoodsById = goodsService.findGoodsById(id);
				//放入到list中
				goodsList.add(findGoodsById);
			}
		}
		
		request.setAttribute("goodsList", goodsList);
		this.getLeftDate();
		return "showCart";
	}
	
	//到结账界面
	public String toCartCheckOut() throws Exception{
		//得到域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		//得到登录的会员
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		//生成订单号
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
		
//		将set放入session
		session.setAttribute("orderDetailSet", orderDetailSet);
		this.getLeftDate();
		return "cartCheckOut";
	}
	
	//清空购物车
	public String cartOut() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		//得到登录的会员
		Member loginMember = (Member) session.getAttribute("loginMember");
		//得到用户发送的所有cookies
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
	
	//提交订单
	public String commitOrder() throws Exception{
		//得到域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String result = "订单提交成功，请记住你的订单号";
		try {
			//得到登录的会员
			Member loginMember = (Member) session.getAttribute("loginMember");
			order.setMember(loginMember);
			
			//得到订单明细
			Set<OrderDetail> orderDetailSet = (Set<OrderDetail>) session.getAttribute("orderDetailSet");
			
			order.setOrderDetailSet(orderDetailSet);
			orderService.addOrder(order);
			//清除cook
			cartOut();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "订单提交失败,请稍候再试!";
		}
		
		request.setAttribute("result", result);
		return "commitOrder";
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
