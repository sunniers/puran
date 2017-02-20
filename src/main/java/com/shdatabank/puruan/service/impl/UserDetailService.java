package com.shdatabank.puruan.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.FrontUserService;


@Repository("userDetailService")
public class UserDetailService implements UserDetailsService {
	@Autowired
    private FrontUserService userService;//与数据库操作的
//    User user=new User();
	// 登录验证
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//			System.err.println("-----------MyUserDetailServiceImpl loadUserByUsername ----------- ");
			
			//取得用户的权限
			User users = userService.getUserByName(username);
			if  (users==null){  
	            throw new UsernameNotFoundException(username+" not exist!"); 
			}
			Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(users);
			// 封装成spring security的user
			org.springframework.security.core.userdetails.User userdetail = new org.springframework.security.core.userdetails.User(
					users.getUserName(), 
					users.getUserPwd(),
					true, 
					true, 
					true,
					true, 
					grantedAuths	//用户的权限
				);
			return userdetail;
		}

		// 取得用户的权限
		private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
//			List<Resources> resources = resourcesDao.getUserResources(String.valueOf(user.getId()));
			Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
//			for (Resources res : resources) {
				// TODO:ZZQ 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
				// 关联代码：applicationContext-security.xml
				// 关联代码：com.huaxin.security.MySecurityMetadataSource#loadResourceDefine
//				authSet.add(new SimpleGrantedAuthority("ROLE_" + res.getResKey()));
//			}
			
			authSet.add(new SimpleGrantedAuthority("ROLE_USER"));
			return authSet;
		}
}
