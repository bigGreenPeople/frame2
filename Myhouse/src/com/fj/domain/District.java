package com.fj.domain;
//ÇøÓò
public class District {
	private Integer id;
	private String name;
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
	
	public District() {
		// TODO Auto-generated constructor stub
	}
	public District(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "District [id=" + id + ", name=" + name + "]";
	}
	
	
}
