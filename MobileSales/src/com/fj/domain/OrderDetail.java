package com.fj.domain;

import java.io.Serializable;

/**
 * ������ϸ��
 * @author bigGreenPeople
 *
 */
public class OrderDetail  implements Serializable{
	private Integer id;
	private Double price;
	private Integer number;
	
	//ʵ������
	private Goods goods;
	private Order order;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
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
	
	
	
}
