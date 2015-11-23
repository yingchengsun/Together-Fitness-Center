package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.TabStudentsDAO;
import com.xdsc.model.TabStudents;
/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对学生的相关操作
 */
public class TabStudentsDAOImpl extends HibernateDaoSupport implements
		TabStudentsDAO {
	/**
	 * 根据学生学号获得一个学生对象
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return TabStudents
	 */
	public TabStudents getStudentById(String stuNum) {
		String hql = "from TabStudents ts where ts.FStudentNumber='" + stuNum
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabStudents) (this.getHibernateTemplate().find(hql).get(0));
	}
	/**
	 * 得到所有学生的列表
	 * 
	 * @return List
	 */
	public List getStudentList() {
		String hql = "from TabStudents";
		return this.getHibernateTemplate().find(hql);
	}
	public void saveStudent(TabStudents student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(student);
	}
	
	
}
