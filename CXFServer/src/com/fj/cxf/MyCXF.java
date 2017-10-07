package com.fj.cxf;

import javax.jws.WebService;

@WebService
public interface MyCXF {
	public String getAge(String name);
}
