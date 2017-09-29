package com.fj.bos.web.action.Base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	//����ģ�Ͷ���
	protected T model;
	public static final String HOME = "home";
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
		//ͨ�����䴴������
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}