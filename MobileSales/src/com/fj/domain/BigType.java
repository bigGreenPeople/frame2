package com.fj.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 商品大类别表
 * @author bigGreenPeople
 *
 */
public class BigType  implements Serializable{
	private Integer id;
	private String bigName;
	private Date creaTime = new Date();
	
	//大类别下面的小类别
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
