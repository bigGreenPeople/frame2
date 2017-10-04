package com.fj.bos.web.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fj.bos.domain.User;
import com.fj.bos.service.IUserService;
import com.fj.bos.utils.BOSUtils;
import com.fj.bos.web.action.Base.BaseAction;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	//注入service 
	@Autowired
	private IUserService userService;
	//属性驱动，接收页面输入的验证码
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	
	//登录方法
	public String login() throws Exception{
		//先从session得到验证码
		HttpSession session = ServletActionContext.getRequest().getSession();
		String validatecode = (String) session.getAttribute("key");
		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)){
			//验证密码正确
			User user = userService.login(model);
			if(user !=null){
				//密码正确跳转到主界面
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
				return HOME;
			}else{
				//密码错误	写入错误信息
				this.addFieldError("checkcodeerr", "密码错误!");
				return LOGIN;
			}
		}else{
			//验证码错误	写入错误信息
			this.addFieldError("checkcodeerr", "验证码错误!");
			return LOGIN;
		}
	}
	
	//退出登录
	public String logout() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return LOGIN;
	}
	
	/**
	 * 修改密码
	 */
	public String editPassword() throws Exception{
		//回调的信息
		String f = "1";
		
		//获得当前用户
		User loginUser = BOSUtils.getLoginUser();
		
		try {
			userService.editPassword(loginUser.getId(),model.getPassword());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			f = "0";
		}
		//指定回收的数据是文本格式
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		
		return NONE;
	}
}
