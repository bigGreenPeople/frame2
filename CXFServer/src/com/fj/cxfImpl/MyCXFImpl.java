package com.fj.cxfImpl;

import com.fj.cxf.MyCXF;

public class MyCXFImpl implements MyCXF {

	@Override
	public String getAge(String name) {
		// TODO Auto-generated method stub
		System.out.println("service 被调用了");
		return "20";
	}

}
