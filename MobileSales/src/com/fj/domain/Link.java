package com.fj.domain;

import java.io.Serializable;

/**
 * �������ӱ�
 * @author bigGreenPeople
 *
 */
public class Link  implements Serializable{
	private Integer id;
	private String linkName;//��������
	private String linkAddress;//���ӵ�ַ
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getLinkAddress() {
		return linkAddress;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	
	
}
