package com.fj.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.bos.dao.IDecidedzoneDao;
import com.fj.bos.dao.ISubareaDao;
import com.fj.bos.domain.Decidedzone;
import com.fj.bos.domain.Subarea;
import com.fj.bos.service.IDecidedzoneService;
import com.fj.bos.service.ISubareaService;
import com.fj.bos.utils.PageBean;

@Service
@Transactional
public class DecidedzoneServiceImpl implements IDecidedzoneService {
	@Autowired
	private IDecidedzoneDao decidedzoneDao;
	@Autowired
	private ISubareaDao subareaDao;
	
	@Override
	public void pageQuery(PageBean pageBean) {
		// TODO Auto-generated method stub
		decidedzoneDao.pageQuery(pageBean);
	}
	
	@Override
	public void save(Decidedzone decidedzone, String[] subareaid) {
		// TODO Auto-generated method stub
		//先保存定区信息
		decidedzoneDao.save(decidedzone);
		//循环遍历关联分区
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			//因为是持久态所有事务已提交就会进行更新(一的那一方已经放弃了维护所有要使用多的一方进行保存)
			subarea.setDecidedzone(decidedzone);
		}
	}

}
