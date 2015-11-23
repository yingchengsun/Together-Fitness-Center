package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.TabTeachersDAO;
import com.xdsc.model.TabTeachers;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对教师的相关操作
 */
public class TabTeachersDAOImpl extends HibernateDaoSupport implements
		TabTeachersDAO {
	/**
	 * 根据教师工号获得一个学生对象
	 * 
	 * @param tId
	 *            教师工号
	 * @return TabTeachers
	 */
	public TabTeachers getTeacherById(String tId) {
		String hql = "from TabTeachers t where t.FTeacherNumber='" + tId + "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabTeachers) (this.getHibernateTemplate().find(hql).get(0));
	}

	/**
	 * 根据教师姓名获得一个教师对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @return List
	 */
	public List getTeacherByName(String teacherName) {
		String hql = "from TabTeachers t where t.FTeacherName='" + teacherName
				+ "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据教师姓名，教师职称获得一个教师对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegreen
	 *            教师职称
	 * @return List
	 */
	public List getTeacherByNameDegreen(String teacherName,
			String teacherDegreen) {
		String hql = "from TabTeachers t where t.FTeacherName='" + teacherName
				+ "' and t.FTeacherZhiCheng='" + teacherDegreen + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 得到所有教师的列表
	 * 
	 * @return List
	 */
	public List getTeacherList() {
		String hql = "from TabTeachers";
		return this.getHibernateTemplate().find(hql);
	}

	public void saveTeacher(TabTeachers teacher) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(teacher);
	}
	
	
}
