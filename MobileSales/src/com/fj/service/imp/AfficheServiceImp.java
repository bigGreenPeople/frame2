package com.fj.service.imp;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.AfficheDao;
import com.fj.domain.Affiche;
import com.fj.domain.PageBean;
import com.fj.service.AfficheService;
@Transactional
public class AfficheServiceImp implements AfficheService {
	
	private AfficheDao afficheDao;

	@Override
	public List<Affiche> findAllAffiche() throws Exception {
		// TODO Auto-generated method stub
		return afficheDao.findAll();
	}

	@Override
	public PageBean<Affiche> findAllAffiche(PageBean<Affiche> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return afficheDao.findPageBeanAll(pageBean);
	}

	@Override
	public void updateAffiche(Affiche affiche) throws Exception {
		// TODO Auto-generated method stub
		//先查询
		Affiche findById = afficheDao.findById(affiche.getId());
		//将要更新的数据添加进去
		findById.setContent(affiche.getContent());
		findById.setName(affiche.getName());
		//更新数据
		afficheDao.update(findById);
	}
	
	@Override
	public void addAffiche(Affiche affiche) throws Exception {
		// TODO Auto-generated method stub
		afficheDao.add(affiche);
	}

	@Override
	public void deleteAffiche(Affiche affiche) throws Exception {
		// TODO Auto-generated method stub
		afficheDao.delete(affiche);
	}

	@Override
	public Affiche findAfficheById(int id) throws Exception {
		// TODO Auto-generated method stub
		return afficheDao.findById(id);
	}

	public void setAfficheDao(AfficheDao afficheDao) {
		this.afficheDao = afficheDao;
	}

	
}
