package com.xdsc.dao.bksx_system;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对登录的相关操作
 */
public interface LoginDAO {

	/**
	 * 判断用户是否合法
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            用户密码
	 * @return boolean
	 */
	public abstract boolean userLogin(String username, String password);

	/**
	 * 进一步确认该用户是否是学生
	 * 
	 * @param userNum
	 *            用户名
	 * @return boolean
	 */
	public abstract boolean studentConfirm(String userNum);

	/**
	 * 进一步确认该用户是否是教师
	 * 
	 * @param userNum
	 *            用户名
	 * @return boolean
	 */
	public abstract boolean teacherConfirm(String userNum);

	/**
	 * 进一步确认该用户是否是管理员
	 * 
	 * @param userNum
	 *            用户名
	 * @return boolean
	 */
	public abstract boolean adminConfirm(String username);

}