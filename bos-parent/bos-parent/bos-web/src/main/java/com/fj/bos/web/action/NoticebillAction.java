package com.fj.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fj.bos.domain.Noticebill;
import com.fj.bos.service.INoticebillService;
import com.fj.bos.web.action.Base.BaseAction;
import com.fj.crm.Customer;
import com.fj.crm.ICustomerService;
@Controller
@Scope("prototype")
public class NoticebillAction extends BaseAction<Noticebill>{
	//注入crm服务对象
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private INoticebillService noticebillService;
	/**
	 * 保存一个业务通知单  并且尝试自动分单
	 */
	public String add(){
		noticebillService.save(model);
		return LIST;
	}
	
	/**
	 * 根据客户手机号得到客户的信息
	 */
	public String findCustomerByTelephone(){
		//得到手机关联的客户
		Customer customer = customerService.findCustomerByTelephone(model.getTelephone());
		//转为json格式并且回写
		this.java2Json(customer, new String[]{});
		return NONE;
	}
}
