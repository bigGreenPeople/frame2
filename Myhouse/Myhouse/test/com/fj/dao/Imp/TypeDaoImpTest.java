package com.fj.dao.Imp;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.fj.domain.Type;

public class TypeDaoImpTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws SQLException {
		TypeDaoImp typeDaoImp = new TypeDaoImp();
		Type type = typeDaoImp.findById(2);
		System.out.println(type);
	}

}
