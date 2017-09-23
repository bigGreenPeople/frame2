package com.fj.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Affiche;
import com.fj.domain.BigType;
import com.fj.domain.PageBean;
import com.fj.service.AfficheService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AfficheAction extends ActionSupport implements ModelDriven<Affiche>{
	//���������
	private AfficheService afficheService;
	//�������ܲ�����Affiche
	private Affiche affiche = new Affiche();
	//Ĭ�ϵ�ǰҳ�ǵ�һҳ
	private Integer currentPage=1;
	
	//��ҳ��ѯ���еĹ���
	public String findAllAffiche() throws Exception{
		//�������ǵĲ�ѯ����
		PageBean<Affiche> pageBean = new PageBean<Affiche>();
		//���õ�ǰҳ��ÿҳ������
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<Affiche> affiches = afficheService.findAllAffiche(pageBean);
		//���뵽�������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("affiches", affiches);
		//��ת
		return "findAllAffiche";
	}
	
	//��ӹ���
	public String addAffiche() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="��ӳɹ�";
		try {
			afficheService.addAffiche(affiche);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="���ʧ��! ";
		}
		request.setAttribute("result", result);
		return "toAfficheResult";
	}
	
	//���޸Ľ���
	public String toUpdateAffiche() throws Exception{
		
		Affiche findAfficheById = afficheService.findAfficheById(affiche.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("affiche", findAfficheById);
		return "toUpdateAffiche";
	}
	
	//�޸Ĺ���
	public String updateAffiche() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="�޸ĳɹ�";
		try {
			afficheService.updateAffiche(affiche);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="�޸�ʧ��!";
		}
		request.setAttribute("result", result);
		return "toAfficheResult";
	}
	
	//��ѯ��������
	public String showAfficheInfo() throws Exception{
		Affiche findAfficheById = afficheService.findAfficheById(affiche.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("affiche", findAfficheById);
		return "showAfficheInfo";
	}

	//ɾ������
	public String deleteAffiche() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String result="ɾ���ɹ�";
		try {
			afficheService.deleteAffiche(affiche);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="ɾ��ʧ��!";
		}
		request.setAttribute("result", result);
		return "toAfficheResult";
	}
	
	public void setAfficheService(AfficheService afficheService) {
		this.afficheService = afficheService;
	}

	@Override
	public Affiche getModel() {
		// TODO Auto-generated method stub
		return affiche;
	}
	
	
}
