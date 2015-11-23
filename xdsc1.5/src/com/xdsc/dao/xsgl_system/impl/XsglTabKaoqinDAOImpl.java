package com.xdsc.dao.xsgl_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.XsglTabKaoqinDAO;
import com.xdsc.model.XsglTabKaoqin;

public class XsglTabKaoqinDAOImpl extends HibernateDaoSupport implements XsglTabKaoqinDAO {
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabKaoqinDAO#saveAttendance(com.xdsc.model.XsglTabKaoqin)
	 */
	public boolean saveAttendance(XsglTabKaoqin attend){
		this.getHibernateTemplate().save(attend);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabKaoqinDAO#deleteAttendance(com.xdsc.model.XsglTabKaoqin)
	 */
	public boolean deleteAttendance(XsglTabKaoqin attend){
		this.getHibernateTemplate().delete(attend);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabKaoqinDAO#updateAttendance(com.xdsc.model.XsglTabKaoqin)
	 */
	public boolean updateAttendance(XsglTabKaoqin attend){
		this.getHibernateTemplate().update(attend);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabKaoqinDAO#getAttendanceByStuNum(java.lang.String)
	 */
	public XsglTabKaoqin getAttendanceByFId(int fid){
		String hql="from XsglTabKaoqin xk where xk.FId='"+fid+"'";
		return (XsglTabKaoqin)this.getHibernateTemplate().find(hql).get(0);
	}
	
	public List<XsglTabKaoqin> getAttendanceByStuNum(String stuNum){
		String hql="from XsglTabKaoqin xk where xk.tabStudents.FStudentNumber='"+stuNum+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabKaoqinDAO#getAttendanceByClass(java.lang.String)
	 */
	public List<XsglTabKaoqin> getAttendanceByClass(String classid){
		String hql="from XsglTabKaoqin xk where xk.tabStudents.tabClasses.FClassNumber='"+classid+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabKaoqinDAO#getAttendanceByGrade(java.lang.String)
	 */
	public List<XsglTabKaoqin> getAttendanceByGrade(String gradeId){
		String hql="from XsglTabKaoqin xk where xk.tabStudents.tabClasses.tabGrade.FGradeId='"+gradeId+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.XsglTabKaoqinDAO#getAttendanceByCourse(java.lang.String)
	 */
	public List<XsglTabKaoqin> getAttendanceByCourse(String courseNum){
		String hql="from XsglTabKaoqin xk where xk.tabCourse.FCourseNumber='"+courseNum+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabKaoqin> getAttendanceList(){
		String hql="from XsglTabKaoqin";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabKaoqin> getAttendByDateClassCourse(Date date,String classid,String courseNum){
		String hql="from XsglTabKaoqin xk where xk.FData=:date and xk.tabStudents.tabClasses.FClassNumber=:classid and xk.tabCourse.FCourseNumber=:courseNum";
		String[] params = { "date", "classid", "courseNum" };
		Object[] args = { date, classid, courseNum };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}
	
	public List<XsglTabKaoqin> getAttendByStuName(String stuName){
		String hql="from XsglTabKaoqin xk where xk.tabStudents.FStudentName='"+stuName+"'";
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<XsglTabKaoqin> getAttendByStuDateCourse(Date date,String courseNum,String stuNum){
		String hql="from XsglTabKaoqin xk where xk.FData=:date and xk.tabCourse.FCourseNumber=:courseNum and xk.tabStudents.FStudentNumber=:stuNum";
		String[] params = { "date", "courseNum", "stuNum" };
		Object[] args = { date, courseNum, stuNum };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

}
