package com.xdsc.service.mail_system;

import javax.mail.PasswordAuthentication;

/** 通过smtp服务器认证的类
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public class SmtpAuth extends javax.mail.Authenticator{
	//用于身份验证的类
	/**
	 * 用户名 和密码
	 */
	private String username;
	private String password;
	
	public SmtpAuth(String username,String password){
		this.username = username;
		this.password = password;
	}
	
	/* (non-Javadoc)
	 * @see javax.mail.Authenticator#getPasswordAuthentication()
	 */
	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(username,password);
	}
}
