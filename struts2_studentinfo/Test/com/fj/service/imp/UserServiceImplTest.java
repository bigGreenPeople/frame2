package com.fj.service.imp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fj.domain.User;
import com.fj.service.UserService;

public class UserServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		User user = new User();
		
		user.setUname("fujie");
		user.setUpass("123456");
		
		UserService userService = new UserServiceImpl();
		userService.login(user);
		
		
	}

}
