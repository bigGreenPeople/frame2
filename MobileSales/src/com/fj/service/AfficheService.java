package com.fj.service;

import java.util.List;

import com.fj.domain.Affiche;
import com.fj.domain.PageBean;


public interface AfficheService {
	//��ѯ���й���
	public List<Affiche> findAllAffiche() throws Exception;
	//��ҳ��ѯ���й���
	public PageBean<Affiche> findAllAffiche(PageBean<Affiche> pageBean) throws Exception;
	//��ӹ���
	public void addAffiche(Affiche affiche) throws Exception;
	//ɾ������
	public void deleteAffiche(Affiche affiche) throws Exception;
	//�޸Ĺ���
	public void updateAffiche(Affiche affiche) throws Exception;
	//����id��ѯ����
	public Affiche findAfficheById(int id) throws Exception;
}
