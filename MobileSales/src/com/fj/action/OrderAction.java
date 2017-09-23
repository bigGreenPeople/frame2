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
	//���������
	private OrderService orderService;
	//Ĭ�ϵ�ǰҳ�ǵ�һҳ
	private Integer currentPage=1;
	
	//��ҳ��ѯ���ж���
	public String findAllOrder() throws Exception{
		//�������ǵĲ�ѯ����
		PageBean<Order> pageBean = new PageBean<Order>();
		//���õ�ǰҳ��ÿҳ������
		pageBean.setCurrentPage(currentPage);
		
		PageBean<Order> orders = orderService.findAllOrder(pageBean);
		//���뵽�������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("orders", orders);
		//��ת
		return "findAllOrder";
	}
	
	//��ʾ��������
	public String showOrderInfo() throws Exception{
		//��ѯ������
		Order orderById = orderService.findOrderById(order.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("order", orderById);
		return "showOrderInfo";
	}
	
	//ɾ������
	public String deleteOrder() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="ɾ���ɹ�";
		try {
			orderService.deleteOrder(order);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="ɾ��ʧ��! ";
		}
		request.setAttribute("result", result);
		
		return "toOrderResult";
	}
	
	//����
	public String sendGoods() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="�����ɹ�";
		try {
			orderService.sendGoods(order.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="����ʧ��! ";
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
