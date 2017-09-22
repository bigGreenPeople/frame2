package com.fj.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Goods  implements Serializable{
	private Integer id;
	private String goodsName;
	//��������
	private String goodsFrom;
	//��Ʒ����
	private String introduce;
	private Date creaTime = new Date();
	//��Ʒ����
	private Double nowPrice;
	//��Ʒ�ؼ�
	private Double freePrice;
	//����	��ʼ0
	private Integer number=0;
	//��ƷͼƬ
	private String pirture;
	//�Ƿ��ؼ�	0�����ؼ� 1���ؼ�
	private Integer mark=0;
	
	//һ�Զ������
	//private BigType bigType;
	private SmallType smallType;
	
	//������ϸ
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
