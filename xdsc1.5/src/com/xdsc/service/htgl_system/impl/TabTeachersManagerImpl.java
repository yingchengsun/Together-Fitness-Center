package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.TabTeachersDAO;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.htgl_system.TabTeachersManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对教师的相关操作
 */
public class TabTeachersManagerImpl implements TabTeachersManager {
	/**
	 * TabTeachersDAOImpl 的接口
	 */
	private TabTeachersDAO tabTeachersDAO;

	/**
	 * tabTeachersDAO属性的Get与Set方法
	 */
	public TabTeachersDAO getTabTeachersDAO() {
		return tabTeachersDAO;
	}

	public void setTabTeachersDAO(TabTeachersDAO tabTeachersDAO) {
		this.tabTeachersDAO = tabTeachersDAO;
	}

	/**
	 * 根据教师工号获得一个学生对象
	 * 
	 * @param tId
	 *            教师工号
	 * @return TabTeachers
	 */
	public TabTeachers getTeacherById(String tId) {
		return tabTeachersDAO.getTeacherById(tId);
	}

	/**
	 * 根据教师姓名获得一个教师对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @return List
	 */
	public List getTeacherByName(String teacherName) {
		return tabTeachersDAO.getTeacherByName(teacherName);
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
		return tabTeachersDAO.getTeacherByNameDegreen(teacherName,
				teacherDegreen);
	}

	/**
	 * 得到所有教师的列表
	 * 
	 * @return List
	 */
	public List getTeacherList() {
		return tabTeachersDAO.getTeacherList();
	}

	public void saveTeacher(TabTeachers teacher) {
		// TODO Auto-generated method stub
		this.tabTeachersDAO.saveTeacher(teacher);
	}
	
	
	
}
