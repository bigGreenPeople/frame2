package com.fj.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Member;
import com.fj.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MemberAction extends ActionSupport implements ModelDriven<Member>{

	//member接收页面的参数
	private Member member = new Member();
	//使用的业务逻辑类
	private MemberService memberService;
	
	//注册
	public String register() throws Exception{
		memberService.register(member);
		return "toIndex";
	}
	
	//登录
	public String login() throws Exception{
		Member loginMember = memberService.login(member);
		//得到我们的域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//放入到session中	并且跳转界面
		if(loginMember!=null){
			//得到一个登录时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date nowTime = new Date();
			String loginTime = format.format(nowTime);
			session.setAttribute("loginTime", loginTime);
			session.setAttribute("loginMember",loginMember );
			
		}
		
		return "toIndex";
	}
	
	//安全退出
	public String memberOut() throws Exception{
		//得到我们的域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//清空session域
		session.removeAttribute("loginMember");
		return "toIndex";
	}
	
	@Override
	public Member getModel() {
		// TODO Auto-generated method stub
		return member;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
}
