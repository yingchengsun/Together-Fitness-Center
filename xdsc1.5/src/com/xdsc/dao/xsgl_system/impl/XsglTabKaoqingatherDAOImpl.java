package com.xdsc.dao.xsgl_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabKaoqingatherDAO;
import com.xdsc.model.XsglTabKaoqingather;

public class XsglTabKaoqingatherDAOImpl extends HibernateDaoSupport implements
		XsglTabKaoqingatherDAO {

	public boolean saveTotalAttendance(XsglTabKaoqingather toAttend) {
		this.getHibernateTemplate().save(toAttend);
		return true;
	}

	public boolean deleteTotalAttendance(XsglTabKaoqingather toAttend) {
		this.getHibernateTemplate().delete(toAttend);
		return true;
	}

	public boolean updateTotalAttendance(XsglTabKaoqingather toAttend) {
		this.getHibernateTemplate().update(toAttend);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabKaoqingatherDAO#getTotalAttendanceList(com.xdsc.model.XsglTabKaoqingather)
	 */
	public List<XsglTabKaoqingather> getTotalAttendanceList() {
		String hql = "from XsglTabKaoqingather";
		return this.getHibernateTemplate().find(hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabKaoqingatherDAO#getTotalAttendanceByGrade(java.lang.String)
	 */
	public List<XsglTabKaoqingather> getTotalAttendanceByGrade(int gradeId) {
		String hql = "from XsglTabKaoqingather xkg where xkg.tabClasses.tabGrade.FGradeId='"
				+ gradeId + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabKaoqingatherDAO#getTotalAttendanceByCourse(java.lang.String)
	 */
	public List<XsglTabKaoqingather> getTotalAttendanceByCourse(String courseNum) {
		String hql = "from XsglTabKaoqingather xkg where xkg.tabCourse.FCourseNumber='"
				+ courseNum + "'";
		return this.getHibernateTemplate().find(hql);
	}

	public XsglTabKaoqingather getTotalAttendanceByFId(int FId) {
		String hql = "from XsglTabKaoqingather xkg where xkg.FId='" + FId + "'";
		return (XsglTabKaoqingather) this.getHibernateTemplate().find(hql).get(
				0);
	}

	public List<XsglTabKaoqingather> getTotalAttendByDateClassCourse(Date date,
			String classid, String courseNum) {
		String hql = "from XsglTabKaoqingather xkg where xkg.FData=:date and xkg.tabClasses.FClassNumber=:classid and xkg.tabCourse.FCourseNumber=:courseNum";

		String[] params = { "date", "classid", "courseNum" };
		Object[] args = { date, classid, courseNum };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

}
