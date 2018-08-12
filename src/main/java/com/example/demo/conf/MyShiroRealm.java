package com.example.demo.conf;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.example.demo.entity.sys.SysPermission;
import com.example.demo.entity.sys.SysRole;
import com.example.demo.entity.sys.UserInfo;
import com.example.demo.service.UserInfoService;

public class MyShiroRealm extends AuthorizingRealm{

	private UserInfoService userInfoService;
	
	public UserInfoService getUsersService() {
		if (userInfoService == null){
			userInfoService = SpringContextHolder.getBean(UserInfoService.class);
		}
		return userInfoService;
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo");
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		UserInfo userInfo=(UserInfo) principals.getPrimaryPrincipal();
		for(SysRole role:userInfo.getRoleList()) {
			authorizationInfo.addRole(role.getRole());
			for(SysPermission p:role.getPermissions()) {
				authorizationInfo.addStringPermission(p.getPermission());
			}
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("-=-=-myShiroRealm.doGETAuthenticationInfo");
		//获取用户输入的账号
		String username=(String)token.getPrincipal();
		System.out.println(token.getCredentials());
		
		//通过username从数据库查找User对象  如果找到 找不到
		//实际项目中  这里可以根据实际情况做缓存 如果不做 shiro自己也是有时间间隔机制 ，2分钟内不会重复执行该方法
		UserInfo userInfo=userInfoService.findByUsername(username);
		System.out.println("------>>userInfo:"+userInfo);
		
		SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
				userInfo,//用户名
				userInfo.getPassword(),//密码
				ByteSource.Util.bytes(userInfo.getSalt()),//salt=username+salt
				getName()   //realm name
				);
		return authenticationInfo;
	}

}
