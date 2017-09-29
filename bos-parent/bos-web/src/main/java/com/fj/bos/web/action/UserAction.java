package com.fj.bos.web.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.fj.bos.domain.User;
import com.fj.bos.service.IUserService;
import com.fj.bos.web.action.Base.BaseAction;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	//ע��service 
	@Autowired
	private IUserService userService;
	//��������������ҳ���������֤��
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	
	//��¼����
	public String login() throws Exception{
		//�ȴ�session�õ���֤��
		HttpSession session = ServletActionContext.getRequest().getSession();
		String validatecode = (String) session.getAttribute("key");
		if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)){
			//��֤������ȷ
			User user = userService.login(model);
			if(user !=null){
				//������ȷ��ת��������
				ServletActionContext.getRequest().setAttribute("loginUser", user);
				return HOME;
			}else{
				//�������	д�������Ϣ
				this.addFieldError("checkcodeerr", "�������!");
				return LOGIN;
			}
		}else{
			//��֤�����	д�������Ϣ
			this.addFieldError("checkcodeerr", "��֤�����!");
			return LOGIN;
		}
	}
	
	//�˳���¼
	public String logout() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return LOGIN;
	}
}