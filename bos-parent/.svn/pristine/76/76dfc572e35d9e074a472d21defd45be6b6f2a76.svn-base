package com.fj.bos.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fj.bos.domain.Decidedzone;
import com.fj.bos.service.IDecidedzoneService;
import com.fj.bos.web.action.Base.BaseAction;
import com.fj.crm.Customer;
import com.fj.crm.ICustomerService;

@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone> {
	@Autowired
	private IDecidedzoneService decidedzoneService;
	//接受到所有选择的分区id
	private String[] subareaid;
	
	
	public String add(){
		decidedzoneService.save(model, subareaid);
		return LIST;
	}
	
	//得到crm代理对象
	@Autowired
	private ICustomerService proxy;
	
	//查询所有未关联的客户数据
	public String findListNotAssociation(){
		List<Customer> list = proxy.findListNotAssociation();
		java2Json(list, new String[]{});
		return NONE;
	}
	
	//得到
	//查询所有关联到指定定区的客户数据
	public String findListHasAssociation(){
		String id = model.getId();
		List<Customer> list = proxy.findListHasAssociation(id);
		java2Json(list, new String[]{});
		return NONE;
	}
	
	//得到所有选择 的客户
	private List<Integer> customerIds;
	
	//关联客户
	public String assigncustomerstodecidedzone(){
		proxy.assigncustomerstodecidedzone(model.getId(),customerIds);
		return LIST;
	}
	
	//分页
	public String pageQuery(){
		decidedzoneService.pageQuery(pageBean);
		//转换回送
		java2Json(pageBean, new String[]{"decidedzones","currentPage","detachedCriteria","pageSize","subareas"});
		return NONE;
	}
	
	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}

	public void setCustomerIds(List<Integer> customerIds) {
		this.customerIds = customerIds;
	}
	
	
}
