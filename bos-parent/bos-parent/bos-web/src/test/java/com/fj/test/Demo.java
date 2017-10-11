package com.fj.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fj.crm.Customer;
import com.fj.crm.ICustomerService;



public class Demo {
	public static void main(String[] args) {
		System.err.println("das");
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICustomerService myCXF = (ICustomerService) ac.getBean("crmClient");
		
		//调用方法
		List<Customer> lsit = myCXF.findAll();
		for (Customer customer : lsit) {
			System.out.println(customer);
		}
	}
}
