package com.fj.action;

import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Student;
import com.fj.domain.User;
import com.fj.service.UserService;
import com.fj.service.imp.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	//����service����
	private UserService userService;
	private User user = new User();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//��¼��action
	public String login() throws Exception {
		// TODO Auto-generated method stub
		//����service
		userService = new UserServiceImpl();
		User loginUser = userService.login(user);
		//���������û���Ϊ��˵������ɹ�
		if(loginUser!=null){
			//���û����뵽session���Ա��´�ʹ��
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("loginUser", loginUser);
			//ȡ��ѧ����Ϣ
			List<Student> list = userService.findAllStu();
			request.setAttribute("list", list);
			//��ת���ɹ��Ľ���
			return "loginOk";
		}
		//��ת��ʧ�ܵĽ���
		return "loginErr";
	}
}
