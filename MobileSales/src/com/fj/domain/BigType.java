package com.fj.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * ��Ʒ������
 * @author bigGreenPeople
 *
 */
public class BigType {
	private Integer id;
	private String bigName;
	private Date creaTime;
	
	//����������С���
	private Set<SmallType> smallTypesSet = new HashSet<SmallType>();
	
	
	
	public Set<SmallType> getSmallTypesSet() {
		return smallTypesSet;
	}
	public void setSmallTypesSet(Set<SmallType> smallTypesSet) {
		this.smallTypesSet = smallTypesSet;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBigName() {
		return bigName;
	}
	public void setBigName(String bigName) {
		this.bigName = bigName;
	}
	public Date getCreaTime() {
		return creaTime;
	}
	public void setCreaTime(Date creaTime) {
		this.creaTime = creaTime;
	}
	
	
}