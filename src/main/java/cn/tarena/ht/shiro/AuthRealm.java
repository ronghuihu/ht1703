package cn.tarena.ht.shiro;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class AuthRealm extends AuthorizingRealm{
	@Resource
	private UserService userService;
	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//得到用户对象
		Subject subject = SecurityUtils.getSubject();
		String username = subject.getSession().getAttribute("username").toString();
		//根据用户名查询角色信息 
		//List<String> roleList = userService.findRoleByUserName(username);
		
		List<String> roleList = new ArrayList<String>();
		roleList.add("货运管理");
		roleList.add("基础信息");
		roleList.add("系统管理");
		//创建授权管理
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		//传入授权管理的集合信息
		info.addStringPermissions(roleList);
		return info;
	}

	@Override
	//登陆认证模块
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken loginToken =  (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
		User user = userService.findUserByUserName(username);
		AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
		return info;
		
	}



	
	
	
}
