package com.xdsc.service.mail_system;

import javax.mail.PasswordAuthentication;

/** ͨ��smtp��������֤����
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public class SmtpAuth extends javax.mail.Authenticator{
	//���������֤����
	/**
	 * �û��� ������
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
