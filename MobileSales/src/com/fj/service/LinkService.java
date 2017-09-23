package com.fj.service;

import java.util.List;

import com.fj.domain.Link;
import com.fj.domain.PageBean;

public interface LinkService {
	//��ѯ��������
	public List<Link> findAllLink() throws Exception;
	//��ҳ��ѯ��������
	public PageBean<Link> findAllLink(PageBean<Link> pageBean) throws Exception;
	//�������
	public void addLink(Link link) throws Exception;
	//ɾ������
	public void deleteLink(Link link) throws Exception;
}
