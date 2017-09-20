package com.fj.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
	private InputStream inputStream;
	//������
	private String oldPassword;
	
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
	
	//��ѯ�����Ƿ����
	public String findMemberByName() throws Exception{
		String msg = "<font color='red' size='3px'>�û�������<red>";
		Member findMember = memberService.findMemberByName(member);
		if(findMember!=null){
			msg = "ok";
		}
		byte[] buf = msg.getBytes("utf-8");
		inputStream = new ByteArrayInputStream(buf);
		return "findByName";
	}
	
	//���޸��������ʽ���
	public String toQuestion() throws Exception{
		Member findMember = memberService.findMemberByName(member);
		//�õ����ǵ������
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("member", findMember);
		return "toQuestion";
	}
	//���޸��������
	public String toUpPass() throws Exception{
		Member findMember = memberService.findMemberByResult(member);
		String msg = "�ش����!";
		//�õ����ǵ������
		if(findMember!=null){
			msg = findMember.getId().toString();
		}
			
			byte[] buf = msg.getBytes("utf-8");
			inputStream = new ByteArrayInputStream(buf);
			
		
		return "findByName";
	}
	//���޸��������
	public String toUpPass2() throws Exception{
		return "toUpPass";
	}
	
	//���޸Ļ�Ա�Ľ���
	public String toUpdataMember() throws Exception{
		//�õ����ǵ������
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//�õ���ǰ��¼���û�
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		if(loginMember!=null){
			return "toUpdataMember";
		}else{
			return "toIndex";
		}
		
	}
	//�޸Ļ�Ա
	public String updataMember() throws Exception{
		//�õ����ǵ������
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//�õ���ǰ��¼���û�
		Member loginMember = (Member) session.getAttribute("loginMember");
		//���������ȷ
		if(loginMember.getPassword().equals(oldPassword)){
			memberService.upDataMember(member);
			//�˳���¼
			return memberOut();
		}else{
			return "toUpdataMember";
		}
		
		
	}
	
	//�޸�����
	public String upPass() throws Exception{
		memberService.upPass(member);
		return "upPass";
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	
}
