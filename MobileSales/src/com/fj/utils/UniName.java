package com.fj.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UniName {
	//��̬����  �õ��ϴ��ļ���
	public static String getFname(){
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddhhmmssS");
		Date d=new Date();
		return sf.format(d);
	}
	
	public static String getFname(String fileName){
		String last = fileName.substring(fileName.lastIndexOf("."));
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddhhmmssS");
		Date d=new Date();
		return sf.format(d)+last;
	}
	
	public static void main(String[] args) {
		System.out.println(getFname("fujie.jpg"));
	}
}
