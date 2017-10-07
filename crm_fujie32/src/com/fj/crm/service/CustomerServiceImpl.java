package com.fj.crm.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.fj.crm.domain.Customer;

@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	//ע��jdbcTempLate
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> findAll() {
		String sql = "select * from t_customer";
		List<Customer> list = jdbcTemplate.query(sql,new RowMapper<Customer>(){
			@Override
			public Customer mapRow(ResultSet rs, int arg1)
					throws SQLException {
				int id = rs.getInt("id");//�����ֶ����ƴӽ�����л�ȡ��Ӧ��ֵ
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				return new Customer(id, name, station, telephone, address, decidedzone_id);
			}
		});
		return list;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
}
