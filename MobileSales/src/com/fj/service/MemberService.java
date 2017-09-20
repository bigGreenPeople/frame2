package com.fj.service;

import com.fj.domain.Member;

public interface MemberService {
	//ע���û�
	public void register(Member member) throws Exception;
	//��¼
	public Member login(Member member) throws Exception;
	//����nameȥ��ѯ�û�
	public Member findMemberByName(Member member) throws Exception;
	//��������𰸲����û�
	public Member findMemberByResult(Member member) throws Exception;
	//�޸�����
	public void upPass(Member member) throws Exception;
	//�޸��û���Ϣ
	public Member upDataMember(Member member) throws Exception;
}
