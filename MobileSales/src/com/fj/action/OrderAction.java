package com.fj.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Order;
import com.fj.domain.PageBean;
import com.fj.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction extends ActionSupport implements ModelDriven<Order>{

	private Order order = new Order();
	//定义服务类
	private OrderService orderService;
	//默认当前页是第一页
	private Integer currentPage=1;
	
	//分页查询所有订单
	public String findAllOrder() throws Exception{
		//创建我们的查询条件
		PageBean<Order> pageBean = new PageBean<Order>();
		//设置当前页和每页的数量
		pageBean.setCurrentPage(currentPage);
		
		PageBean<Order> orders = orderService.findAllOrder(pageBean);
		//放入到域对象里
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("orders", orders);
		//跳转
		return "findAllOrder";
	}
	
	//显示订单详情
	public String showOrderInfo() throws Exception{
		//查询到订单
		Order orderById = orderService.findOrderById(order.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("order", orderById);
		return "showOrderInfo";
	}
	
	//删除订单
	public String deleteOrder() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="删除成功";
		try {
			orderService.deleteOrder(order);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="删除失败! ";
		}
		request.setAttribute("result", result);
		
		return "toOrderResult";
	}
	
	//出货
	public String sendGoods() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="出货成功";
		try {
			orderService.sendGoods(order.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="出货失败! ";
		}
		request.setAttribute("result", result);
		
		return "toOrderResult";
	}
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}


	

	public Integer getCurrentPage() {
		return currentPage;
	}




	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}




	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}
	
}
