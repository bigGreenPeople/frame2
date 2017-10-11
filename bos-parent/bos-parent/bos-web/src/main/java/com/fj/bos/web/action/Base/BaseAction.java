package com.fj.bos.web.action.Base;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.fj.bos.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	//����ģ�Ͷ���
	protected T model;
	public static final String HOME = "home";
	public static final String LIST = "list";
	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}
	
	
	//�ڹ��췽�����洴����ģ�Ͷ��� 
	public BaseAction() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//���BaseAction�������ķ�������
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		//�������߲�ѯ����
		detachedCriteria = DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(detachedCriteria);
		//ͨ�����䴴������
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	//�Է�ҳ�Ĵ�����г�ȡ
	protected PageBean pageBean = new PageBean();
	//�������߲�ѯ����
	//���������ύ��ѯ����
	protected DetachedCriteria detachedCriteria = null;
	
	//����һ����listת��Ϊjson�ķ���	����Ӧ���ͻ���ҳ��
	public void java2Json(List o ,String[] exclueds){
		//ʹ��json-lib��PageBean����תΪjson��ͨ�������д��ҳ����
		//JSONObject---����һ����תΪjson
		//JSONArray----��������߼��϶���תΪjson
		//���ö����������Щ���Բ�Ҫת��Ϊjson
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(exclueds);
		String json = JSONArray.fromObject(o,jsonConfig).toString();
		
		//��Ӧ
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����һ����objectת��Ϊjson�ķ���  	����Ӧ���ͻ���ҳ��
	public void java2Json(Object o ,String[] exclueds){
		JsonConfig jsonConfig = new JsonConfig();
		//ָ����Щ���Բ���Ҫתjson
		jsonConfig.setExcludes(exclueds);
		String json = JSONObject.fromObject(o,jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPage(int page) {
		this.pageBean.setCurrentPage(page);
	}

	public void setRows(int rows) {
		this.pageBean.setPageSize(rows);
	}
	
	
}
