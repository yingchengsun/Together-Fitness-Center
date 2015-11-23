package com.xdsc.service.bksx_system.impl;

import com.xdsc.dao.bksx_system.LoginDAO;
import com.xdsc.service.bksx_system.LoginManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对登录的相关操作
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
	 * 判断用户是否合法
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            用户密码
	 * @return boolean
	 */
	public boolean userLogin(String username, String password) {
		return loginDAO.userLogin(username, password);
	}

	/**
	 * 进一步确认该用户是否是学生
	 * 
	 * @param userNum
	 *            用户名
	 * @return boolean
	 */
	public boolean studentConfirm(String userNum) {
		return loginDAO.studentConfirm(userNum);
	}

	/**
	 * 进一步确认该用户是否是教师
	 * 
	 * @param userNum
	 *            用户名
	 * @return boolean
	 */
	public boolean teacherConfirm(String userNum) {
		return loginDAO.teacherConfirm(userNum);
	}

	/**
	 * 进一步确认该用户是否是管理员
	 * 
	 * @param userNum
	 *            用户名
	 * @return boolean
	 */
	public boolean adminConfirm(String username) {
		return loginDAO.adminConfirm(username);
	}
}
