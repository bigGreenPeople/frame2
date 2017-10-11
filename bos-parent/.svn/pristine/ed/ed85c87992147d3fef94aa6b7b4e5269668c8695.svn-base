package com.fj.bos.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.fj.bos.dao.IUserDao;
import com.fj.bos.domain.User;

/**
 * 自定义realm，并注入给安全管理器
 * @author bigGreenPeople
 *
 */
public class BOSRealm extends AuthorizingRealm{
	
	@Autowired
	private IUserDao userDao;
	/**
	 * 返回空的话说明认证失败
	 */
	//认证(登录  判断你是否是超级管理员  判断你要没有删除的权限)
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//转换
		UsernamePasswordToken mytoken = (UsernamePasswordToken)token;
		//得到用户名(在action中已经设置了|)
		String username = mytoken.getUsername();
		//调用dao去查询
		User user = userDao.findUserByUserName(username);
		//如果不为空则说明有此账号进行认证
		if(user!=null){
			//交给SimpleAuthenticationInfo去判断账号密码是否相等(不相等将会抛出异常)
			AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
			return info;
		}
		return null;
	}
	
	//授权
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//得到令牌信息
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//为用户授权
		info.addStringPermission("staff-list");
		return info;
	}

}
