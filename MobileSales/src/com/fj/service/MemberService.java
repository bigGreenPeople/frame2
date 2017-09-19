package com.fj.service;

import com.fj.domain.Member;

public interface MemberService {
	//×¢²áÓÃ»§
	public void register(Member member) throws Exception;
	//µÇÂ¼
	public Member login(Member member) throws Exception;
}
