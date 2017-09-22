package com.fj.service;

import com.fj.domain.Member;
import com.fj.domain.PageBean;

public interface MemberService {
	//ע���û�
	public void register(Member member) throws Exception;
	//��¼
	public Member login(Member member) throws Exception;
	//����nameȥ��ѯ�û�
	public Member findMemberByName(Member member) throws Exception;
	//����idȥ��ѯ�û�
	public Member findMemberById(int id) throws Exception;
	//��������𰸲����û�
	public Member findMemberByResult(Member member) throws Exception;
	//�޸�����
	public void upPass(Member member) throws Exception;
	//ɾ���û�
	public void deleteMemberById(int id) throws Exception;
	//�޸��û���Ϣ
	public Member upDataMember(Member member) throws Exception;
	//��ҳ��ѯ�����û�
	public PageBean<Member> findAllGoods(PageBean<Member> pageBean) throws Exception ;
}
