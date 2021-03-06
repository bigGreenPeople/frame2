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
	//定义service对象
	private UserService userService;
	
	private User user = new User();
	
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//登录的action
	public String login() throws Exception {
		// TODO Auto-generated method stub
		//创建service
		userService = new UserServiceImpl();
		User loginUser = userService.login(user);
		//如果查出的用户不为空说明登入成功
		if(loginUser!=null){
			//把用户放入到session中以便下次使用
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("loginUser", loginUser);
			//跳转到成功的界面
			return "loginOk";
		}
		//跳转到失败的界面
		return "loginErr";
	}
	
	//注册
	public String register(){
		//创建service
		userService = new UserServiceImpl();
		userService.register(user);
		
		return "registerOk";
	}
	
	//找回密码
	public String reback(){
		//创建service
		userService = new UserServiceImpl();
		User findUser = userService.reback(user);
		
		if(findUser!=null){
//			放入域对象
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("user", findUser);
		}
		
		return "rebackOk";
	}
	
}
