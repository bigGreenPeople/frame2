package com.fj.service;

import java.util.List;

import com.fj.domain.Affiche;
import com.fj.domain.PageBean;


public interface AfficheService {
	//查询所有公告
	public List<Affiche> findAllAffiche() throws Exception;
	//分页查询所有公告
	public PageBean<Affiche> findAllAffiche(PageBean<Affiche> pageBean) throws Exception;
	//添加公告
	public void addAffiche(Affiche affiche) throws Exception;
	//删除公告
	public void deleteAffiche(Affiche affiche) throws Exception;
	//修改公告
	public void updateAffiche(Affiche affiche) throws Exception;
	//依靠id查询公告
	public Affiche findAfficheById(int id) throws Exception;
}
