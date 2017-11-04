package com.fj;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fj.common.junit.SpringJunitTest;
import com.fj.core.bean.TestTb;
import com.fj.core.service.TestTbService;

public class TestTestTb extends SpringJunitTest {
	
	@Autowired
	private TestTbService testTbService;
	
	@Test
	public void testAdd() throws Exception {
		TestTb testTb = new TestTb();
		testTb.setName("付杰2");
		testTbService.add(testTb);
	}

}
