package com.fj.domain;
/*
 * 这个是商品查询的条件
 * */
public class GoodsCondition {
	//商品名称
	private String goodsName;
	//商品大类别Id
	private Integer bigType_id;
	//商品小类别Id
	private Integer smallType_id;
	//特价
	private Integer mark;
	
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getBigType_id() {
		return bigType_id;
	}
	public void setBigType_id(Integer bigType_id) {
		this.bigType_id = bigType_id;
	}
	public Integer getSmallType_id() {
		return smallType_id;
	}
	public void setSmallType_id(Integer smallType_id) {
		this.smallType_id = smallType_id;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
	
}
