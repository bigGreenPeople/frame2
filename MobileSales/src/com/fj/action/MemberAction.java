package com.fj.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Goods;
import com.fj.domain.Member;
import com.fj.domain.PageBean;
import com.fj.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MemberAction extends ActionSupport implements ModelDriven<Member>{

	//member接收页面的参数
	private Member member = new Member();
	//使用的业务逻辑类
	private MemberService memberService;
	private InputStream inputStream;
	//旧密码
	private String oldPassword;
	//默认当前页是第一页
	private Integer currentPage=1;
	//注册
	public String register() throws Exception{
		memberService.register(member);
		return "toIndex";
	}
	
	//分页显示所有的用户
	public String findAllMember() throws Exception{
		//创建我们的查询条件
		PageBean<Member> pageBean = new PageBean<Member>();
		//设置当前页和每页的数量
		pageBean.setCurrentPage(currentPage);
		pageBean.setPageSize(5);
		
		PageBean<Member> members = memberService.findAllGoods(pageBean);
		
		//放入到域对象里
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("members", members);
		
		return "findAllMember";
	}
	
	//查看用户的详细信息
	public String showMember() throws Exception{
		Member findMemberById = memberService.findMemberById(member.getId());
		ServletActionContext.getRequest().setAttribute("member", findMemberById);
		return "showMember";
	}
	
	
	
//	删除用户
	public String deleteMember() throws Exception{
		String result = "删除会员信息失败，请先删除该会员订货信息!";
		try {
			memberService.deleteMemberById(member.getId());
			result = "删除成功";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		ServletActionContext.getRequest().setAttribute("result", result);
		return "toMemberResult";
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
	
	//查询名称是否存在
	public String findMemberByName() throws Exception{
		String msg = "<font color='red' size='3px'>用户不存在<red>";
		Member findMember = memberService.findMemberByName(member);
		if(findMember!=null){
			msg = "ok";
		}
		byte[] buf = msg.getBytes("utf-8");
		inputStream = new ByteArrayInputStream(buf);
		return "findByName";
	}
	
	//到修改密码提问界面
	public String toQuestion() throws Exception{
		Member findMember = memberService.findMemberByName(member);
		//得到我们的域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("member", findMember);
		return "toQuestion";
	}
	//到修改密码界面
	public String toUpPass() throws Exception{
		Member findMember = memberService.findMemberByResult(member);
		String msg = "回答错误!";
		//得到我们的域对象
		if(findMember!=null){
			msg = findMember.getId().toString();
		}
			
			byte[] buf = msg.getBytes("utf-8");
			inputStream = new ByteArrayInputStream(buf);
			
		
		return "findByName";
	}
	//到修改密码界面
	public String toUpPass2() throws Exception{
		return "toUpPass";
	}
	
	//到修改会员的界面
	public String toUpdataMember() throws Exception{
		//得到我们的域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//得到当前登录的用户
		Member loginMember = (Member) session.getAttribute("loginMember");
		
		if(loginMember!=null){
			return "toUpdataMember";
		}else{
			return "toIndex";
		}
		
	}
	//修改会员
	public String updataMember() throws Exception{
		//得到我们的域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//得到当前登录的用户
		Member loginMember = (Member) session.getAttribute("loginMember");
		//如果密码正确
		if(loginMember.getPassword().equals(oldPassword)){
			memberService.upDataMember(member);
			//退出登录
			return memberOut();
		}else{
			return "toUpdataMember";
		}
		
		
	}
	
	//修改密码
	public String upPass() throws Exception{
		memberService.upPass(member);
		return "upPass";
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

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
}
