package com.fj.domain;

import java.util.Date;

public class House {
	private Integer id;
	private Integer user_id;
	private Integer type_id;
	private String title;
	private String description;
	private Integer price;
	private Date pubDate;
	private Integer floorAge;
	private String contact;
	private Integer street_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public Integer getFloorAge() {
		return floorAge;
	}
	public void setFloorAge(Integer floorAge) {
		this.floorAge = floorAge;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Integer getStreet_id() {
		return street_id;
	}
	public void setStreet_id(Integer street_id) {
		this.street_id = street_id;
	}
	@Override
	public String toString() {
		return "House [id=" + id + ", user_id=" + user_id + ", type_id="
				+ type_id + ", title=" + title + ", description=" + description
				+ ", price=" + price + ", pubDate=" + pubDate + ", floorAge="
				+ floorAge + ", contact=" + contact + ", street_id="
				+ street_id + "]";
	}
	public House(Integer id, Integer user_id, Integer type_id, String title,
			String description, Integer price, Date pubDate, Integer floorAge,
			String contact, Integer street_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.type_id = type_id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubDate = pubDate;
		this.floorAge = floorAge;
		this.contact = contact;
		this.street_id = street_id;
	}
	
	public House() {
		// TODO Auto-generated constructor stub
	}
}
