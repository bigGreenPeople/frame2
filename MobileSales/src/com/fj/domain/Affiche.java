package com.fj.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 公告信息表
 * @author bigGreenPeople
 *
 */
public class Affiche implements Serializable{
	private Integer id;
	private String name;//公告标题
	private String content;//公告内容
	private Date issue_Time;//发布时间
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getIssue_Time() {
		return issue_Time;
	}
	public void setIssue_Time(Date issue_Time) {
		this.issue_Time = issue_Time;
	}
	
	
}
