package com.fj.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.core.bean.TestTb;
import com.fj.core.dao.TestTbDao;
@Service
@Transactional
public class TestTbServiceImpl implements TestTbService {
	@Autowired
	private TestTbDao testTbDao;

	public void add(TestTb testTb) {
		// TODO Auto-generated method stub
		testTbDao.addTestTb(testTb);
	}

}
