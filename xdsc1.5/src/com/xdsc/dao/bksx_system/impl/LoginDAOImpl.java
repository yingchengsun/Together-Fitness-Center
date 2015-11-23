package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.LoginDAO;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶Ե�¼����ز���
 */
public class LoginDAOImpl extends HibernateDaoSupport implements LoginDAO {
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
		String hql = "from MhqxTabUser mu where mu.FUserNumber='" + username
				+ "' and mu.FUserPassword='" + password + "'";
		List list = this.getHibernateTemplate().find(hql);
		if (list.isEmpty())
			return false;
		return true;
	}

	/**
	 * ��һ��ȷ�ϸ��û��Ƿ���ѧ��
	 * 
	 * @param userNum
	 *            �û���
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
	 * ��һ��ȷ�ϸ��û��Ƿ��ǽ�ʦ
	 * 
	 * @param userNum
	 *            �û���
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
	 * ��һ��ȷ�ϸ��û��Ƿ��ǹ���Ա
	 * 
	 * @param userNum
	 *            �û���
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
