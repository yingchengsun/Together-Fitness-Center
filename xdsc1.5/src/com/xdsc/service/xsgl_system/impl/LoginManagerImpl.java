package com.xdsc.service.xsgl_system.impl;

import com.xdsc.dao.xsgl_system.LoginDAO;
import com.xdsc.service.xsgl_system.LoginManager;

public class LoginManagerImpl implements LoginManager {
	private LoginDAO loginDAO;

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.LoginManager#userLogin(java.lang.String, java.lang.String)
	 */
	public boolean userLogin(String username, String password){
		return loginDAO.userLogin(username, password);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.LoginManager#studentConfirm(java.lang.String)
	 */
	public boolean studentConfirm(String userNum){
		return loginDAO.studentConfirm(userNum);
	} 
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.LoginManager#teacherConfirm(java.lang.String)
	 */
	public boolean teacherConfirm(String userNum){
		return loginDAO.teacherConfirm(userNum);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.LoginManager#parentConfirm(java.lang.String)
	 */
	public boolean parentConfirm(String userNum){
		return loginDAO.parentConfirm(userNum);
	}

}
