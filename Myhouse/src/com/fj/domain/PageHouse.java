package com.fj.domain;

import java.util.List;

public class PageHouse {
	//每页记录的list集合
	private List<HouseVo> houseList;
	//当前页
	private Integer currentPage;
	//总记录数
	private Integer totalCount;
	//每页显示记录数
	private Integer pageSize;
	//总页数
	private Integer totalPage;
	//开始位置
	private Integer begin;
	
	public List<HouseVo> getHouseList() {
		return houseList;
	}
	public void setHouseList(List<HouseVo> houseList) {
		this.houseList = houseList;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	
	
}
