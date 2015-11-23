package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.LoginDAO;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对登录的相关操作
 */
public class LoginDAOImpl extends HibernateDaoSupport implements LoginDAO {
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
		String hql = "from MhqxTabUser mu where mu.FUserNumber='" + username
				+ "' and mu.FUserPassword='" + password + "'";
		List list = this.getHibernateTemplate().find(hql);
		if (list.isEmpty())
			return false;
		return true;
	}

	/**
	 * 进一步确认该用户是否是学生
	 * 
	 * @param userNum
	 *            用户名
	 * @return boolean
	 */
	public boolean studentConfirm(String userNum) {
		String hql = "from TabStudents ts where ts.FStudentNumber='" + userNum
				+ "'";
		List list = this.getHibernateTemplate().find(hql);
		if (list.isEmpty())
			return false;
		return true;
	}

	/**
	 * 进一步确认该用户是否是教师
	 * 
	 * @param userNum
	 *            用户名
	 * @return boolean
	 */
	public boolean teacherConfirm(String userNum) {
		String hql = "from TabTeachers tt where tt.FTeacherNumber='" + userNum
				+ "'";
		List list = this.getHibernateTemplate().find(hql);
		if (list.isEmpty())
			return false;
		return true;
	}

	/**
	 * 进一步确认该用户是否是管理员
	 * 
	 * @param userNum
	 *            用户名
	 * @return boolean
	 */
	public boolean adminConfirm(String username) {
		String hql = "from TabAdministrator ta where ta.FAdminNumber='"
				+ username + "'";
		List list = this.getHibernateTemplate().find(hql);
		if (list.isEmpty())
			return false;
		return true;
	}
}
