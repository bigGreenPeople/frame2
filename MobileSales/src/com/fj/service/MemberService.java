package com.fj.service;

import com.fj.domain.Member;
import com.fj.domain.PageBean;

public interface MemberService {
	//注册用户
	public void register(Member member) throws Exception;
	//登录
	public Member login(Member member) throws Exception;
	//依靠name去查询用户
	public Member findMemberByName(Member member) throws Exception;
	//依靠id去查询用户
	public Member findMemberById(int id) throws Exception;
	//依靠问题答案查找用户
	public Member findMemberByResult(Member member) throws Exception;
	//修改密码
	public void upPass(Member member) throws Exception;
	//删除用户
	public void deleteMemberById(int id) throws Exception;
	//修改用户信息
	public Member upDataMember(Member member) throws Exception;
	//分页查询所有用户
	public PageBean<Member> findAllGoods(PageBean<Member> pageBean) throws Exception ;
}
