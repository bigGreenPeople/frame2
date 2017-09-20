package com.fj.domain;

import java.io.Serializable;
import java.util.List;
/**
 * 此类用于表示分页的条件
 * 也用于得到分页的结果
 * @author bigGreenPeople
 *
 * @param <T>
 */
public class PageBean<T>  implements Serializable{
	//每页记录的list集合
	private List<T> list;
	//当前页
	private Integer currentPage;
	//每页显示记录数
	private Integer pageSize;
	//总记录数
	private Integer totalCount;
	
	//总页数
	private Integer totalPage;
	//开始位置
	private Integer begin;
	//结束位置
	private Integer end;
	
	
	
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
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
