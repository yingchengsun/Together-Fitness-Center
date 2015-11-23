package com.xdsc.dao.xsgl_system;

public interface LoginDAO {

	public abstract boolean userLogin(String username, String password);

	/* (non-Javadoc)
	 * @see com.xdsc.dao.bksx_system.impl.LoginDAO#studentConfirm(java.lang.String)
	 */
	public abstract boolean studentConfirm(String userNum);

	/* (non-Javadoc)
	 * @see com.xdsc.dao.bksx_system.impl.LoginDAO#teacherConfirm(java.lang.String)
	 */
	public abstract boolean teacherConfirm(String userNum);

	public abstract boolean parentConfirm(String userNum);

}