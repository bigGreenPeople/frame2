package com.fj.service;

import com.fj.domain.Member;

public interface MemberService {
	//ע���û�
	public void register(Member member) throws Exception;
	//��¼
	public Member login(Member member) throws Exception;
}
