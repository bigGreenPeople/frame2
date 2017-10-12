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
	//ע��service
	@Autowired
	private IFunctionService functionService;
	
	//�õ����еĸ��ڵ�
	public String listajax(){
		List<Function> list = functionService.findAll();
		this.java2Json(list, new String[]{"parentFunction","roles"});
		return NONE;
	}
	//���
	public String save(){
		functionService.save(model);
		return LIST;
	}
	
	//��ҳ��ѯ
	public String pageQuery(){
		//page��ע�뵽��ģ����������
		String page = model.getPage();
		pageBean.setCurrentPage(Integer.parseInt(page));
		
		functionService.pageQuery(pageBean);
		this.java2Json(pageBean, new String[]{"children","parentFunction","roles"});
		return NONE;
	}
}
