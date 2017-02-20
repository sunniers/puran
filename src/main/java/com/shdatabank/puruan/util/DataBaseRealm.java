package com.shdatabank.puruan.util;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.druid.util.StringUtils;
import com.shdatabank.puruan.model.User;
import com.shdatabank.puruan.service.LoginService;

/**
 * shiro realm实现
 * @author 周宇
 *
 */
public class DataBaseRealm extends AuthorizingRealm{
	//登录服务
	@Autowired
	private LoginService loginService;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null) return null;
		String currentUsername = (String)super.getAvailablePrincipal(principals);
		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
		if(this.logger.isDebugEnabled()){
			this.logger.debug("Current Login Name :"+currentUsername);
		}
		return simpleAuthorInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		if (authcToken == null) return null;
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
        Session session = SecurityUtils.getSubject().getSession();
        
        String temp = "";
        for(char c : token.getPassword()){
            temp += c;
        }
        if(this.logger.isDebugEnabled()){
            this.logger.debug("用户登录Host["+token.getHost()+"]");
        }
        User lab = null;
        try{
        	User user = new User();
        	user.setUserName(token.getUsername());
        	user.setUserPwd(temp);
        	lab = loginService.selectUserRealm(user);
        }catch(Exception e){
        	e.printStackTrace();
        }
        if(this.logger.isDebugEnabled()){
            this.logger.debug("");
        }
        if(null != lab ){
            
            String username = lab.getUserName();
            if(StringUtils.isEmpty(username)){
            	username = lab.getSid();
            }
            session.setAttribute(SystemConstant.session_account_id,lab.getSid());
            session.setAttribute(SystemConstant.session_detail_name,username);
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(token.getUsername(),temp,this.getName());
            return simpleAuthenticationInfo;
        }else{
        	System.out.println("----------realm---------------------------->");
        	this.logger.error("msg");       	
        	System.out.println("msg");
        	System.out.println("----------realm---------------------------->");
            if(this.logger.isDebugEnabled()){
                this.logger.debug("失败原因:"+ "");
            //lab.getMessage());
            }
            throw new IncorrectCredentialsException("");
            		//lab.getMessage());//账号被锁定
        }
	}
	
}
