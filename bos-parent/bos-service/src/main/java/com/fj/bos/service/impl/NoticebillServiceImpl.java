package com.fj.bos.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.bos.dao.IDecidedzoneDao;
import com.fj.bos.dao.INoticebillDao;
import com.fj.bos.dao.IWorkbillDao;
import com.fj.bos.domain.Decidedzone;
import com.fj.bos.domain.Noticebill;
import com.fj.bos.domain.Staff;
import com.fj.bos.domain.User;
import com.fj.bos.domain.Workbill;
import com.fj.bos.service.INoticebillService;
import com.fj.bos.utils.BOSUtils;
import com.fj.crm.ICustomerService;
@Service
@Transactional
public class NoticebillServiceImpl implements INoticebillService {

	@Autowired
	private INoticebillDao noticebillDao;
	@Autowired
	private IDecidedzoneDao decidedzoneDao; 
	@Autowired
	private IWorkbillDao workbillDao;
	@Autowired
	private ICustomerService customerService;

	/**
	 * ����ҵ��֪ͨ�������г����Զ��ֵ�
	 */
	public void save(Noticebill model) {
		//�õ���¼���û�����ҵ��֪ͨ������������
		User user = BOSUtils.getLoginUser();
		model.setUser(user);
		noticebillDao.save(model);
		//�õ�����ĵ�ַ Ȼ���ѯ����ַ���ڵĶ���id(����Ҫȥcrm��ѯ��Ϊ�ͻ������д˵�ַ�Ļ�˵���п��Ա���𵽶���)
		String pickaddress = model.getPickaddress();
		String decidedzoneId = customerService.findDecidedzoneIdByAddress(pickaddress);
		//���id��Ϊnull˵���п��Ա����˵�ַ   ���п����Զ��ֵ�
		if(decidedzoneId!=null){
			//��ѯ������
			Decidedzone decidedzone = decidedzoneDao.findById(decidedzoneId);
			//��ѯ����������Ŀ��Ա
			Staff staff = decidedzone.getStaff();
			//����staff���Ա
			model.setStaff(staff);
			//�Զ��ֵ��ɹ����÷ֵ�����
			model.setOrdertype(Noticebill.ORDERTYPE_AUTO);
			
			//Ϊ���Ա����һ������
			Workbill workbill = new Workbill();
			workbill.setAttachbilltimes(0);//׷������
			workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));//����ʱ�䣬��ǰϵͳʱ��
			workbill.setNoticebill(model);//��������ҳ��֪ͨ��
			workbill.setPickstate(Workbill.PICKSTATE_NO);//ȡ��״̬
			workbill.setRemark(model.getRemark());//��ע��Ϣ
			workbill.setStaff(staff);//��������ȡ��Ա
			workbill.setType(Workbill.TYPE_1);//��������
			//���湤��
			workbillDao.save(workbill);
			//���ö���ƽ̨  ֪ͨ���Ա
		}else{
			//û�в�ѯ������
			model.setOrdertype(Noticebill.ORDERTYPE_MAN);
		}
	}

}
