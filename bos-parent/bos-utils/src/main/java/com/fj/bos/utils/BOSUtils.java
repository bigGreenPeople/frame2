package com.fj.bos.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fj.bos.domain.User;

/**
 * �˹��������ڻ�ȡ��¼���û���session
 * @author bigGreenPeople
 *
 */
public class BOSUtils {
	//��ȡsession
	public static HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	//��ȡ��¼���û�
	public static User getLoginUser(){
		return (User) getSession().getAttribute("loginUser");
	}
}
