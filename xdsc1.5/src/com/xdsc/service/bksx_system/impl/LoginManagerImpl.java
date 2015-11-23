package com.xdsc.service.bksx_system.impl;

import com.xdsc.dao.bksx_system.LoginDAO;
import com.xdsc.service.bksx_system.LoginManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶Ե�¼����ز���
 */
public class LoginManagerImpl implements LoginManager {
	private LoginDAO loginDAO;

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	/**
	 * �ж��û��Ƿ�Ϸ�
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            �û�����
	 * @return boolean
	 */
	public boolean userLogin(String username, String password) {
		return loginDAO.userLogin(username, password);
	}

	/**
	 * ��һ��ȷ�ϸ��û��Ƿ���ѧ��
	 * 
	 * @param userNum
	 *            �û���
	 * @return boolean
	 */
	public boolean studentConfirm(String userNum) {
		return loginDAO.studentConfirm(userNum);
	}

	/**
	 * ��һ��ȷ�ϸ��û��Ƿ��ǽ�ʦ
	 * 
	 * @param userNum
	 *            �û���
	 * @return boolean
	 */
	public boolean teacherConfirm(String userNum) {
		return loginDAO.teacherConfirm(userNum);
	}

	/**
	 * ��һ��ȷ�ϸ��û��Ƿ��ǹ���Ա
	 * 
	 * @param userNum
	 *            �û���
	 * @return boolean
	 */
	public boolean adminConfirm(String username) {
		return loginDAO.adminConfirm(username);
	}
}
