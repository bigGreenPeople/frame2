package com.fj.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Goods  implements Serializable{
	private Integer id;
	private String goodsName;
	//生产厂家
	private String goodsFrom;
	//商品介绍
	private String introduce;
	private Date creaTime = new Date();
	//商品定价
	private Double nowPrice;
	//商品特价
	private Double freePrice;
	//数量	初始0
	private Integer number=0;
	//商品图片
	private String pirture;
	//是否特价	0不是特价 1是特价
	private Integer mark=0;
	
	//一对多的属性
	//private BigType bigType;
	private SmallType smallType;
	
	//订单明细
	private Set<OrderDetail> orderDetailSet = new HashSet<OrderDetail>();
	
	
	public Set<OrderDetail> getOrderDetailSet() {
		return orderDetailSet;
	}

	public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
		this.orderDetailSet = orderDetailSet;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsFrom() {
		return goodsFrom;
	}

	public void setGoodsFrom(String goodsFrom) {
		this.goodsFrom = goodsFrom;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Date getCreaTime() {
		return creaTime;
	}

	public void setCreaTime(Date creaTime) {
		this.creaTime = creaTime;
	}

	public Double getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(Double nowPrice) {
		this.nowPrice = nowPrice;
	}

	public Double getFreePrice() {
		return freePrice;
	}

	public void setFreePrice(Double freePrice) {
		this.freePrice = freePrice;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPirture() {
		return pirture;
	}

	public void setPirture(String pirture) {
		this.pirture = pirture;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public SmallType getSmallType() {
		return smallType;
	}

	public void setSmallType(SmallType smallType) {
		this.smallType = smallType;
	}
	
	
	
}
