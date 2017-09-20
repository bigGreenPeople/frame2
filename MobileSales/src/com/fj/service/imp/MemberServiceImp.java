package com.fj.service.imp;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.MemberDao;
import com.fj.domain.Member;
import com.fj.service.MemberService;
@Transactional
public class MemberServiceImp implements MemberService {
	//使用的DAo类
	private MemberDao memberDao;
	
	@Override
	public void register(Member member) throws Exception {
		// TODO Auto-generated method stub
		memberDao.add(member);
	}
	
	@Override
	public Member findMemberByName(Member member) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.findOneByCondition(member);
	}
	
	@Override
	public Member findMemberByResult(Member member) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.findOneByCondition(member);
	}
	
	@Override
	public Member login(Member member) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.findOneByCondition(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public void upPass(Member member) throws Exception {
		// TODO Auto-generated method stub
		Member findById = memberDao.findById(member.getId());
		findById.setPassword(member.getPassword());
		memberDao.update(findById);
	}
	@Override
	public Member upDataMember(Member member) throws Exception {
		// TODO Auto-generated method stub
		memberDao.update(member);
		
		return memberDao.findById(member.getId());
	}
	
}
