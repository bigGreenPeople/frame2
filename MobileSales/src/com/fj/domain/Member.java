package com.fj.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 存储会员的信息表
 * @author bigGreenPeople
 *
 */
public class Member  implements Serializable{
	private Integer id;
	//账号名
	private String name;
	//密码
	private String password;
	//真实姓名
	private String reallyName;
	//年龄
	private Integer age;
	//职业
	private String profession;
	//邮箱
	private String email;
	//问题
	private String question;
	//问题答案
	private String result;
	
	//order的集合
	private Set<Order> orderSet = new HashSet<Order>();
	
	
	
	public Set<Order> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReallyName() {
		return reallyName;
	}
	public void setReallyName(String reallyName) {
		this.reallyName = reallyName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
