package com.fj.convert;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class DateConvert extends DefaultTypeConverter {
	@Override
	public Object convertValue(Object ob, Class clazz) {
		// TODO Auto-generated method stub
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		if(clazz == Date.class){
			//�������
			String[] params = (String[]) ob;
			try {
				//ת��Ϊʱ��
				return simpleDateFormat.parse(params[0]);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
