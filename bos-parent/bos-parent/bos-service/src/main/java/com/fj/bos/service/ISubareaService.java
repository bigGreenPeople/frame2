package com.fj.bos.service;

import java.util.List;

import com.fj.bos.domain.Subarea;
import com.fj.bos.utils.PageBean;

public interface ISubareaService {
	//����
	public void save(Subarea model);

	public void pageQuery(PageBean pageBean);
	//��ѯ���еķ���
	public List<Subarea> findAll();
	//��ѯ����û�й����ķ���
	public List<Subarea> findListNotAssociation();
	//��������id��ѯ�����������ж���
	public List<Subarea> findListByDecidedzoneId(String decidedzoneId);
}
