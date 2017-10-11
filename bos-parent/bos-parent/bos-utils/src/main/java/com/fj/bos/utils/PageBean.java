package com.fj.bos.utils;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public class PageBean {
	//��ǰҳ
	private int currentPage;
	//ÿҳ��ʾ�ļ�¼
	private int pageSize;
	//��ѯ����
	private DetachedCriteria detachedCriteria;
	//�ܼ�¼��
	private int total;
	//��ǰҳ�ļ�¼����
	private List rows;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}
	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	
}
