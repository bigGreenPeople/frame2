package com.fj.service;

import java.util.List;

import com.fj.domain.Order;
import com.fj.domain.PageBean;

public interface OrderService {
	//查询所有订单
	public List<Order> findAllOrder() throws Exception;
	//分页查询所有订单
	public PageBean<Order> findAllOrder(PageBean<Order> pageBean) throws Exception;
	//添加订单
	public void addOrder(Order order) throws Exception;
	//删除订单
	public void deleteOrder(Order order) throws Exception;
	//出货
	public void sendGoods(Integer id) throws Exception;
	//依靠id去查询
	public Order findOrderById(Integer id) throws Exception;
}
