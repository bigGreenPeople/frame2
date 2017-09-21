package com.fj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.BigType;
import com.fj.domain.PageBean;
import com.fj.domain.SmallType;
import com.fj.service.BigTypeService;
import com.opensymphony.xwork2.ActionSupport;

public class TypeAction extends ActionSupport {
	//�����
	private BigType bigType;
	//С���
	private SmallType smallType;
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
	
	//��ѯ���е�С���
	public String findAllSmallType() throws Exception{
		//�������ǵĲ�ѯ����
		PageBean<SmallType> pageBean = new PageBean<SmallType>();
		//���õ�ǰҳ��ÿҳ������
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<SmallType> smallTypes = bigTypeService.findAllSmallType(pageBean);
		
		//���뵽�������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("smallTypes", smallTypes);
		//��ת
		return "findAllSmallType";
	}
	
	//�����С���ҳ��
	public String toAddSmallType() throws Exception{
		//ȡ�����ô����
		List<BigType> list = bigTypeService.findAllBigType();
		//����request
		if(list!=null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("list", list);
		}
		return "toAddSmallType";
	}
	
	//ɾ�������
	public String deleteBigType() throws Exception{
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			bigTypeService.deleteBigType(bigType);
			result = "ɾ���ɹ�";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "ɾ��ʧ��";
		}
		
		request.setAttribute("result", result);
		return "toBigResult";
	}
	
	//ɾ��С���
	public String deleteSmallType() throws Exception{
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			bigTypeService.deleteSmallType(smallType);;
			result = "ɾ���ɹ�";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "ɾ��ʧ��";
		}
		request.setAttribute("result", result);
		
		return "toSmallResult";
	}
	
	//��Ӵ����
	public String addBigType() throws Exception{
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			bigTypeService.addBigType(bigType);
			result = "��ӳɹ�";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "���ʧ��";
		}
		
		request.setAttribute("result", result);
		return "toBigResult";
	}
	
	//���С���
	public String addSmallType() throws Exception{
		String result = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			bigTypeService.addSmallType(smallType);
			result = "��ӳɹ�";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "���ʧ��";
		}
		
		request.setAttribute("result", result);
		return "toSmallResult";
	}
	public void setBigTypeService(BigTypeService bigTypeService) {
		this.bigTypeService = bigTypeService;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public BigType getBigType() {
		return bigType;
	}

	public void setBigType(BigType bigType) {
		this.bigType = bigType;
	}

	public SmallType getSmallType() {
		return smallType;
	}

	public void setSmallType(SmallType smallType) {
		this.smallType = smallType;
	}
	
	
}
