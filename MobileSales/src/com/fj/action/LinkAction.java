package com.fj.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Affiche;
import com.fj.domain.Link;
import com.fj.domain.PageBean;
import com.fj.service.LinkService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkAction extends ActionSupport implements ModelDriven<Link>{

	//����Link
	private Link link = new Link();
	//���������
	private LinkService linkService;
	//Ĭ�ϵ�ǰҳ�ǵ�һҳ
	private Integer currentPage=1;
	//��ѯ��ҳ������
	
	//��ҳ��ѯ���е�����
	public String findAllLink() throws Exception{
		//�������ǵĲ�ѯ����
		PageBean<Link> pageBean = new PageBean<Link>();
		//���õ�ǰҳ��ÿҳ������
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<Link> links = linkService.findAllLink(pageBean);
		//���뵽�������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("links", links);
		//��ת
		return "findAllLink";
	}
	
	//�������
	public String addLink() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="��ӳɹ�";
		try {
			linkService.addLink(link);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="���ʧ��! ";
		}
		request.setAttribute("result", result);
		return "toLinkResult";
	}
	
	//ɾ������
	public String deleteLink() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="ɾ���ɹ�";
		try {
			linkService.deleteLink(link);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="ɾ��ʧ��!";
		}
		request.setAttribute("result", result);
		return "toLinkResult";
	}
	
	@Override
	public Link getModel() {
		// TODO Auto-generated method stub
		return link;
	}

	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
