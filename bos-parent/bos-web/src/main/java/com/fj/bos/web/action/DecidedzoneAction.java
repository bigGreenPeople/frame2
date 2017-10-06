package com.fj.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fj.bos.domain.Decidedzone;
import com.fj.bos.service.IDecidedzoneService;
import com.fj.bos.web.action.Base.BaseAction;

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
}
