package com.fj.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("cxf.xml");
		MyCXF myCXF = (MyCXF) ac.getBean("myclient");
		
		//调用方法
		String age = myCXF.getAge("付杰");
		System.out.println(age);
	}
}
