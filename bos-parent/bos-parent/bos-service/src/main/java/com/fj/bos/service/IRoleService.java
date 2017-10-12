package com.fj.bos.service;

import java.util.List;

import com.fj.bos.domain.Role;
import com.fj.bos.utils.PageBean;

public interface IRoleService {
	//±£´æ½ÇÉ«
	public void save(Role role,String functionIds);

	public void pageQuery(PageBean pageBean);

	public List<Role> finAll();
}
