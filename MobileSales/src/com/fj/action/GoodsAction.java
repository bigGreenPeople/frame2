package com.fj.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.BigType;
import com.fj.domain.PageBean;
import com.fj.service.BigTypeService;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport {
	//����������
	private BigTypeService bigTypeService;
	//Ĭ�ϵ�ǰҳ�ǵ�һҳ
	private Integer currentPage=1;
	//��ѯ���еĴ����
	public String findAllBigType() throws Exception{
		//�������ǵĲ�ѯ����
		PageBean<BigType> pageBean = new PageBean<BigType>();
		//���õ�ǰҳ��ÿҳ������
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<BigType> bigTypes = bigTypeService.findAllBigType(pageBean);
		
		//���뵽�������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("bigTypes", bigTypes);
		//��ת
		return "findAllBigType";
	}
	
	
	public void setBigTypeService(BigTypeService bigTypeService) {
		this.bigTypeService = bigTypeService;
	}
	
	
}
