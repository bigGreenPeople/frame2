package com.fj.service;

import java.util.List;

import com.fj.domain.Link;
import com.fj.domain.PageBean;

public interface LinkService {
	//查询所有链接
	public List<Link> findAllLink() throws Exception;
	//分页查询所有链接
	public PageBean<Link> findAllLink(PageBean<Link> pageBean) throws Exception;
	//添加链接
	public void addLink(Link link) throws Exception;
	//删除链接
	public void deleteLink(Link link) throws Exception;
}
