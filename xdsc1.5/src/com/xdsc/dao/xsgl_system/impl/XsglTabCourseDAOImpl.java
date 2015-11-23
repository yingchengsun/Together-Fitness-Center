package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabCourseDAO;
import com.xdsc.model.TabCourse;

public class XsglTabCourseDAOImpl extends HibernateDaoSupport implements
		XsglTabCourseDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabCourseDAO#getCourseByNum(java.lang.String)
	 */
	public TabCourse getCourseByNum(String courseNum) {
		String hql = "from TabCourse tc where tc.FCourseNumber='" + courseNum
				+ "'";
		List list = this.getHibernateTemplate().find(hql);
		if(list.isEmpty()) return null;
		else return (TabCourse)list.get(0);
	}

	public List getAllCourse() {
		String hql = "from TabCourse";
		return this.getHibernateTemplate().find(hql);
	}

}
