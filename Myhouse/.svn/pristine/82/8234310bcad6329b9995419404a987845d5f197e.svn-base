package com.fj.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Users;
import com.fj.domain.UsersVo;
import com.fj.service.UserSevice;
import com.fj.service.Imp.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<Users>{	
	//定义Users
	private UsersVo user = new UsersVo();
	
	
	//使用Service
	private UserSevice userSevice = new UserServiceImpl();
	
	//登录 
	public String login() throws Exception{
		Users loginUser = userSevice.login(user);
		//如果不为空说明登录成功
		if(loginUser!=null){
			//放入到session 以便下次使用
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("loginUser", loginUser);
			//如果是管理用户跳转到管理界面
			if("Y".equals(loginUser.getIsAdmin())){
				return "manage";
			}else{
				return "house_list";
			}
		}
		return "login";
	}
	
	//注册
	public String register() throws Exception{
		
		int num = userSevice.register(user);
		
		if(num>0){
			//跳转到注册成功界面
			return "registerOk";
		}else{
			//跳转回注册界面
			return "register";
		}
		
	}

	@Override
	public Users getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	

}
