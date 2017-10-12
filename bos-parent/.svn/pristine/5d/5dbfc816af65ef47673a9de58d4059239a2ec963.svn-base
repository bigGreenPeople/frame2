package com.fj.bos.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fj.bos.domain.Function;
import com.fj.bos.service.IFunctionService;
import com.fj.bos.web.action.Base.BaseAction;
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function>{
	//注入service
	@Autowired
	private IFunctionService functionService;
	
	//得到所有的父节点
	public String listajax(){
		List<Function> list = functionService.findAll();
		this.java2Json(list, new String[]{"parentFunction","roles"});
		return NONE;
	}
	//添加
	public String save(){
		functionService.save(model);
		return LIST;
	}
	
	//分页查询
	public String pageQuery(){
		//page被注入到了模型驱动里面
		String page = model.getPage();
		pageBean.setCurrentPage(Integer.parseInt(page));
		
		functionService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"children","parentFunction","roles"});
		return NONE;
	}
}
