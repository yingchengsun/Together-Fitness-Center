package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.TabStudentsDAO;
import com.xdsc.model.TabStudents;
import com.xdsc.service.htgl_system.TabStudentsManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对学生的相关操作
 */
public class TabStudentsManagerImpl implements TabStudentsManager {
	/**
	 * TabStudentsDAOImpl接口
	 */
	private TabStudentsDAO tabStudentsDAO;

	/**
	 * tabStudentsDAO属性的Get与Set方法
	 */
	public TabStudentsDAO getTabStudentsDAO() {
		return tabStudentsDAO;
	}

	public void setTabStudentsDAO(TabStudentsDAO tabStudentsDAO) {
		this.tabStudentsDAO = tabStudentsDAO;
	}

	/**
	 * 根据学生学号获得一个学生对象
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return TabStudents
	 */
	public TabStudents getStudentById(String stuNum) {
		return tabStudentsDAO.getStudentById(stuNum);
	}

	/**
	 * 得到所有学生的列表
	 * 
	 * @return List
	 */
	public List getStudentList() {
		return tabStudentsDAO.getStudentList();
	}

	public void saveStudent(TabStudents student) {
		// TODO Auto-generated method stub
		this.tabStudentsDAO.saveStudent(student);
	}
}
