package com.fj.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 商品小类别信息表
 * @author bigGreenPeople
 *
 */
public class SmallType  implements Serializable{
	private Integer id;
	private String smallName;
	private Date creaTime;
	
//	所属的大类别
	private BigType bigType;
//	商品集合
	private Set<Goods> goodsSet = new HashSet<Goods>();
	
	
	
	
	public Set<Goods> getGoodsSet() {
		return goodsSet;
	}
	public void setGoodsSet(Set<Goods> goodsSet) {
		this.goodsSet = goodsSet;
	}
	public BigType getBigType() {
		return bigType;
	}
	public void setBigType(BigType bigType) {
		this.bigType = bigType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSmallName() {
		return smallName;
	}
	public void setSmallName(String smallName) {
		this.smallName = smallName;
	}
	public Date getCreaTime() {
		return creaTime;
	}
	public void setCreaTime(Date creaTime) {
		this.creaTime = creaTime;
	}
	
	
}
