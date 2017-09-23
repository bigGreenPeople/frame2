package com.fj.service;

import java.util.List;

import com.fj.domain.Order;
import com.fj.domain.PageBean;

public interface OrderService {
	//��ѯ���ж���
	public List<Order> findAllOrder() throws Exception;
	//��ҳ��ѯ���ж���
	public PageBean<Order> findAllOrder(PageBean<Order> pageBean) throws Exception;
	//��Ӷ���
	public void addOrder(Order order) throws Exception;
	//ɾ������
	public void deleteOrder(Order order) throws Exception;
	//����
	public void sendGoods(Integer id) throws Exception;
	//����idȥ��ѯ
	public Order findOrderById(Integer id) throws Exception;
}
