package com.fj.domain;

import java.io.Serializable;
import java.util.List;
/**
 * �������ڱ�ʾ��ҳ������
 * Ҳ���ڵõ���ҳ�Ľ��
 * @author bigGreenPeople
 *
 * @param <T>
 */
public class PageBean<T>  implements Serializable{
	//ÿҳ��¼��list����
	private List<T> list;
	//��ǰҳ
	private Integer currentPage;
	//ÿҳ��ʾ��¼��
	private Integer pageSize;
	//�ܼ�¼��
	private Integer totalCount;
	
	//��ҳ��
	private Integer totalPage;
	//��ʼλ��
	private Integer begin;
	//����λ��
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
