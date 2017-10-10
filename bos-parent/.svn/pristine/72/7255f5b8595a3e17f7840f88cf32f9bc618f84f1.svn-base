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
	 * 保存业务通知单，还有尝试自动分单
	 */
	public void save(Noticebill model) {
		//得到登录的用户给此业务通知单设置受理人
		User user = BOSUtils.getLoginUser();
		model.setUser(user);
		noticebillDao.save(model);
		//得到区间的地址 然后查询到地址所在的定区id(这里要去crm查询因为客户里面有此地址的话说明有快递员负责到定区)
		String pickaddress = model.getPickaddress();
		String decidedzoneId = customerService.findDecidedzoneIdByAddress(pickaddress);
		//如果id不为null说明有快递员负责此地址   所有可以自动分单
		if(decidedzoneId!=null){
			//查询到定区
			Decidedzone decidedzone = decidedzoneDao.findById(decidedzoneId);
			//查询到定区负责的快递员
			Staff staff = decidedzone.getStaff();
			//设置staff快递员
			model.setStaff(staff);
			//自动分单成功设置分单类型
			model.setOrdertype(Noticebill.ORDERTYPE_AUTO);
			
			//为快递员产生一个工单
			Workbill workbill = new Workbill();
			workbill.setAttachbilltimes(0);//追单次数
			workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));//创建时间，当前系统时间
			workbill.setNoticebill(model);//工单关联页面通知单
			workbill.setPickstate(Workbill.PICKSTATE_NO);//取件状态
			workbill.setRemark(model.getRemark());//备注信息
			workbill.setStaff(staff);//工单关联取派员
			workbill.setType(Workbill.TYPE_1);//工单类型
			//保存工单
			workbillDao.save(workbill);
			//调用短信平台  通知快递员
		}else{
			//没有查询到定区
			model.setOrdertype(Noticebill.ORDERTYPE_MAN);
		}
	}

}
