package com.fj.service.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.OrderDao;
import com.fj.domain.Order;
import com.fj.domain.PageBean;
import com.fj.service.OrderService;
@Transactional
public class OrderServiceImp implements OrderService {
	
	private OrderDao orderDao;

	
	@Override
	public Order findOrderById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findById(id);
	}
	@Override
	public List<Order> findAllOrder() throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findAll();
	}

	@Override
	public PageBean<Order> findAllOrder(PageBean<Order> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return orderDao.findPageBeanAll(pageBean);
	}
	
	@Override
	public void sendGoods(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Order findById = orderDao.findById(id);
		findById.setSign(1);
		orderDao.update(findById);
	}

	@Override
	public void addOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		orderDao.add(order);
	}

	@Override
	public void deleteOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		Order findById = orderDao.findById(order.getId());
		orderDao.delete(findById);
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	
	
	
}
