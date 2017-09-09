package com.fj.action;

import java.sql.ResultSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Student;
import com.fj.domain.User;
import com.fj.service.StudentService;
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
			//��ת���ɹ��Ľ���
			return "loginOk";
		}
		//��ת��ʧ�ܵĽ���
		return "loginErr";
	}
	
	//ע��
	public String register(){
		//����service
		userService = new UserServiceImpl();
		userService.register(user);
		
		return "registerOk";
	}
	
	//�һ�����
	public String reback(){
		//����service
		userService = new UserServiceImpl();
		User findUser = userService.reback(user);
		
		if(findUser!=null){
//			���������
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("user", findUser);
		}
		
		return "rebackOk";
	}
	
}
