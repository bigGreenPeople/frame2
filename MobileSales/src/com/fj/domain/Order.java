package com.fj.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order  implements Serializable{
	private Integer id;
	private String tel;
	//收获地址
	private String address;
	//付款方式
	private String setMoney;
	//邮寄方式
	private String post;
	//备注信息
	private String bz;
	//是否处理
	private Integer sign=0;
	private Date creaTime = new Date();
	
	private Member member;
	private Set<OrderDetail> orderDetailSet = new HashSet<OrderDetail>();

	public Set<OrderDetail> getOrderDetailSet() {
		return orderDetailSet;
	}

	public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
		this.orderDetailSet = orderDetailSet;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSetMoney() {
		return setMoney;
	}

	public void setSetMoney(String setMoney) {
		this.setMoney = setMoney;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Integer getSign() {
		return sign;
	}

	public void setSign(Integer sign) {
		this.sign = sign;
	}

	public Date getCreaTime() {
		return creaTime;
	}

	public void setCreaTime(Date creaTime) {
		this.creaTime = creaTime;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
}
