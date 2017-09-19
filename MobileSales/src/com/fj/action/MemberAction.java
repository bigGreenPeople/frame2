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

	//member����ҳ��Ĳ���
	private Member member = new Member();
	//ʹ�õ�ҵ���߼���
	private MemberService memberService;
	
	//ע��
	public String register() throws Exception{
		memberService.register(member);
		return "toIndex";
	}
	
	//��¼
	public String login() throws Exception{
		Member loginMember = memberService.login(member);
		//�õ����ǵ������
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//���뵽session��	������ת����
		if(loginMember!=null){
			//�õ�һ����¼ʱ��
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date nowTime = new Date();
			String loginTime = format.format(nowTime);
			session.setAttribute("loginTime", loginTime);
			session.setAttribute("loginMember",loginMember );
			
		}
		
		return "toIndex";
	}
	
	//��ȫ�˳�
	public String memberOut() throws Exception{
		//�õ����ǵ������
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//���session��
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
