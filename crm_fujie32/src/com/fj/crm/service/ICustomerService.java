package com.fj.crm.service;

import java.util.List;

import javax.jws.WebService;

import com.fj.crm.domain.Customer;

@WebService
public interface ICustomerService {
	public List<Customer> findAll();
}
