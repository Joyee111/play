package com.sinosoft.web.shiro;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.subject.WebSubject;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.entity.ResourceEntity;
import com.sinosoft.entity.UserEntity;
import com.sinosoft.entity.UserRoleEntity;
import com.sinosoft.web.service.CheckInfoService;
import com.sinosoft.web.service.ShowPersonInfoService;
import com.sinosoft.web.service.ShowPersonResourceService;
import com.sinosoft.web.service.ShowPersonRoleService;

public class MyRealm extends AuthorizingRealm{
	

	@Autowired
	private CheckInfoService checkInfoService;



	public void setCheckInfoService(CheckInfoService checkInfoService) {
		this.checkInfoService = checkInfoService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();//存储该用户都有什么权限
		String username = (String)principals.fromRealm(getName()).iterator().next();
		UserEntity user = null;
		try {

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationtoken) throws AuthenticationException {
		UsernamePasswordToken token =  (UsernamePasswordToken)authenticationtoken;
		UserEntity user = null;
		String password = new Sha256Hash(token.getPassword()).toHex();
		try {
			user = (UserEntity) checkInfoService.checkInfo(token.getUsername(), password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(user!=null) {
			return new SimpleAccount(user.getUserName(),user.getPassword(),getName());
		}else {
			return null;
			
		}
	}
	@Override
	public boolean isPermitted(PrincipalCollection principals, String permission) {
		boolean flag = false;
		/**
		 * 定义一个url的set
		 */
		Set<String> urlSet = new HashSet<String>();
		/**
		 * 根据用户名称查询该用户的的权限（调用重写方法：doGetAuthorizationInfo）
		 */
		AuthorizationInfo info = getAuthorizationInfo(principals);
		Collection<String> resourceColl = info.getStringPermissions();
		try {
			HttpServletRequest request = (HttpServletRequest) ((WebSubject) SecurityUtils.getSubject())
					.getServletRequest();	
			List<ResourceEntity> resource = null;
			for(ResourceEntity r:resource) {
				if (permission.equals(r.getResourceCode())){
					return true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			return true;
}
	public boolean patternMatch(Collection<String> patternUrlList, String requestUri) {
		boolean flag = false;
		for (String patternUri : patternUrlList) {
			if (StringUtils.isNotEmpty(patternUri)) {
				Pattern pattern = Pattern.compile(patternUri);
				Matcher matcher = pattern.matcher(requestUri);
				if (matcher.matches()) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
}