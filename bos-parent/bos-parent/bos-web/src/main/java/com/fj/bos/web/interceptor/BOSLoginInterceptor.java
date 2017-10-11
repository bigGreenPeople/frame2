package com.fj.bos.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.fj.bos.domain.User;
import com.fj.bos.utils.BOSUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BOSLoginInterceptor extends MethodFilterInterceptor{


	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//��ȡ��session���û�
		User loginUser = BOSUtils.getLoginUser();
		
		if(loginUser == null){
			return "login";
		}
		//����
		return invocation.invoke();
	}

}
