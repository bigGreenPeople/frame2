package com.fj.domain;

public class Users {
	private Integer id;
	private String name;
	private String password;
	private String telePhone;
	private String username;
	private String isAdmin;
	
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
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public Users(Integer id, String name, String password, String telePhone,
			String username, String isAdmin) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.telePhone = telePhone;
		this.username = username;
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", password=" + password
				+ ", telePhone=" + telePhone + ", username=" + username
				+ ", isAdmin=" + isAdmin + "]";
	}
	
	
}
