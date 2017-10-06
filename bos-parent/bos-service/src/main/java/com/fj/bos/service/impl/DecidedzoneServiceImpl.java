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
		//�ȱ��涨����Ϣ
		decidedzoneDao.save(decidedzone);
		//ѭ��������������
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			//��Ϊ�ǳ־�̬�����������ύ�ͻ���и���(һ����һ���Ѿ�������ά������Ҫʹ�ö��һ�����б���)
			subarea.setDecidedzone(decidedzone);
		}
	}

}
