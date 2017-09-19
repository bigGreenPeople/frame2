package com.fj.dao.imp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fj.domain.Member;

public class MemberDaoImpTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() throws Exception {
		MemberDaoImp daoImp = new MemberDaoImp();
		Member m = new Member();
		m.setName("fujie");
		m.setPassword("123");
		
		Member newM = daoImp.findOneByCondition(m);
		System.out.println(newM);
	}

}
