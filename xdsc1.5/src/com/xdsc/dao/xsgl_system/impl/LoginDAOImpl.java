package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.LoginDAO;

public class LoginDAOImpl extends HibernateDaoSupport implements LoginDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.LoginDAO#userLogin(java.lang.String, java.lang.String)
	 */
	public boolean userLogin(String username, String password){
		String hql = "from MhqxTabUser mu where mu.FUserNumber='"+username+"' and mu.FUserPassword='"+password+"'";
		List list = this.getHibernateTemplate().find(hql);
		if(list.isEmpty())
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.bksx_system.impl.LoginDAO#studentConfirm(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.LoginDAO#studentConfirm(java.lang.String)
	 */
	public boolean studentConfirm(String userNum){
		String hql="from TabStudents ts where ts.FStudentNumber='"+userNum+"'";
		List list=this.getHibernateTemplate().find(hql);
		if(list.isEmpty())
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.bksx_system.impl.LoginDAO#teacherConfirm(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.LoginDAO#teacherConfirm(java.lang.String)
	 */
	public boolean teacherConfirm(String userNum){
		String hql="from TabTeachers tt where tt.FTeacherNumber='"+userNum+"'";
		List list=this.getHibernateTemplate().find(hql);
		if(list.isEmpty())
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.LoginDAO#parentConfirm(java.lang.String)
	 */
	public boolean parentConfirm(String userNum){
		String hql="from XsglTabParents tp where tp.FParentId='"+userNum+"'";
		List list=this.getHibernateTemplate().find(hql);
		if(list.isEmpty())
			return false;
		return true;
	}
}
