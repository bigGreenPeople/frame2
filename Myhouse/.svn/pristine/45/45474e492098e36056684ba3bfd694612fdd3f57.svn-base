package com.fj.utils;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Before;
import org.junit.Test;



import com.fj.domain.Users;

public class TxQueryRunnerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
	}
	public static void main(String[] args) {
		QueryRunner qr = new TxQueryRunner();
		
		String sql = "select * from users";
		try {
			List<Users> list = qr.query(JdbcUtils.getConnection(), sql, new BeanListHandler<Users>(Users.class));
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
