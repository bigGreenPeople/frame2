package com.fj.domain;

import java.util.List;

public class PageHouse {
	//ÿҳ��¼��list����
	private List<HouseVo> houseList;
	//��ǰҳ
	private Integer currentPage;
	//�ܼ�¼��
	private Integer totalCount;
	//ÿҳ��ʾ��¼��
	private Integer pageSize;
	//��ҳ��
	private Integer totalPage;
	//��ʼλ��
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
