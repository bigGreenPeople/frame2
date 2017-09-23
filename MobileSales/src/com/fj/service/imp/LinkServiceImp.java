package com.fj.service.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.LinkDao;
import com.fj.domain.Link;
import com.fj.domain.PageBean;
import com.fj.service.LinkService;
@Transactional
public class LinkServiceImp implements LinkService {
	
	private LinkDao linkDao;

	@Override
	public List<Link> findAllLink() throws Exception {
		// TODO Auto-generated method stub
		return linkDao.findAll();
	}

	@Override
	public PageBean<Link> findAllLink(PageBean<Link> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return linkDao.findPageBeanAll(pageBean);
	}

	@Override
	public void addLink(Link link) throws Exception {
		// TODO Auto-generated method stub
		linkDao.add(link);
	}

	@Override
	public void deleteLink(Link link) throws Exception {
		// TODO Auto-generated method stub
		linkDao.delete(link);
	}

	public void setLinkDao(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	
	
}
