package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabTeachersDAO;
import com.xdsc.model.TabTeachers;

public class XsglTabTeachersDAOImpl extends HibernateDaoSupport implements
		XsglTabTeachersDAO {
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system.impl.TabTeachersDAO#getTeacherByTeaNum(java.lang.String)
	 */
	public boolean updateTeacher(TabTeachers teacher){
		this.getHibernateTemplate().update(teacher);
		return true;
	}
	
	public List<TabTeachers> getTeacherByTeaNum(String TeaNum) {
		String hql = "from TabTeachers tt where tt.FTeacherNumber='" + TeaNum
				+ "'";
		return this.getHibernateTemplate().find(hql);
	}

	public TabTeachers getTeacherByTeaName(String teacherName0) {
		String hql = "from TabTeachers tt where tt.FTeacherName='"
				+ teacherName0 + "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabTeachers) this.getHibernateTemplate().find(hql).get(0);
	}

}
