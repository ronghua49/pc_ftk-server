package com.risepu.ftk.server.service;

import java.util.Map;

import net.lc4ever.framework.remote.annotation.Remote;

import  com.risepu.ftk.server.web.b.dto.LoginResult;

@Remote(path="/org")
public interface OrganizationService {
	
	 /**
	  * 
	  * @param phone 手机号
	  * @param code 验证码
	  * @param password 密码
	  * @return
	  */
	public String orgReg(String phone,String password);
	
	/**
	 *  
	 * @param phoneOrName 
	 * @param password
	 * @return LoginResult 登录返回结果
	 * 
	 */
	public LoginResult orgLogin(String phoneOrName,String password); 
	
	/**
	 * 
	 * @param phone 手机号
	 * @param newPwd 新密码
	 * @return
	 */
	public String changePwd(String phone,String newPwd);
	
	/**
	 * 企业认证
	 */
	
	
	

}
