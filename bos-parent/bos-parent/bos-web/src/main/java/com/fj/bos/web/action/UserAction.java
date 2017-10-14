package com.fj.bos.web.action;

import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fj.bos.domain.User;
import com.fj.bos.service.IUserService;
import com.fj.bos.utils.BOSUtils;
import com.fj.bos.utils.MD5Utils;
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
			//��֤������ȷswing GUI
			/*User user = userService.login(model);
			if(user !=null){
				//������ȷ��ת��������
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
				return HOME;
			}else{
				//�������	д�������Ϣ
				this.addFieldError("checkcodeerr", "�������!");
				return LOGIN;
			}*/
			//ʹ��shiro��ܽ���У��
			//��ȡ��ǰ�û�����
			Subject subject = SecurityUtils.getSubject();
			//�û���������	����shiro������˺�(�������ڱȽ�  �˺����ڲ�ѯ����ȷ������)
			UsernamePasswordToken token = new UsernamePasswordToken(model.getUsername(), MD5Utils.md5(model.getPassword()));
			try {
				//��ǰ�û�ȥ��֤(�����֤ʧ�ܽ����׳��쳣)
				subject.login(token);
				//�õ���֤���û�
				User loginUser = (User) subject.getPrincipal();
				ServletActionContext.getRequest().getSession().setAttribute("loginUser", loginUser);
				return HOME;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				//�������	д�������Ϣ
				this.addFieldError("checkcodeerr", "�˺Ż��������!");
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
	
	/**
	 * �޸�����
	 */
	public String editPassword() throws Exception{
		//�ص�����Ϣ
		String f = "1";
		
		//��õ�ǰ�û�
		User loginUser = BOSUtils.getLoginUser();
		
		try {
			userService.editPassword(loginUser.getId(),model.getPassword());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			f = "0";
		}
		//ָ�����յ��������ı���ʽ
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(f);
		
		return NONE;
	}
	//�õ�Ҫ�����Ľ�ɫid
	private String[] roleIds;
	//�����û�
	public String add(){
		userService.save(model,roleIds);
		return LIST;
	}

	public String pageQuery(){
		//�õ����е�user
		userService.pageQuery(pageBean);
		java2Json(pageBean, new String[]{"roles","noticebills"});
		return NONE;
	}

	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	
	
}