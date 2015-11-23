package com.xdsc.dao.bksx_system;

import java.util.List;

import com.xdsc.model.TabStudents;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对学生的相关操作
 */
public interface TabStudentsDAO {

	/**
	 * 根据学生学号获得一个学生对象
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return TabStudents
	 */
	public abstract TabStudents getStudentById(String stuNum);

	/**
	 * 得到所有学生的列表
	 * 
	 * @return List
	 */
	public abstract List getStudentList();

}