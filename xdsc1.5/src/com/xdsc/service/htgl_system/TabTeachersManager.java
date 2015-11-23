package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.TabTeachers;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对教师的相关操作
 */
public interface TabTeachersManager {
	/**
	 * 根据教师工号获得一个学生对象
	 * 
	 * @param tId
	 *            教师工号
	 * @return TabTeachers
	 */
	public abstract TabTeachers getTeacherById(String tId);

	/**
	 * 根据教师姓名获得一个教师对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @return List
	 */
	public abstract List getTeacherByName(String teacherName);

	/**
	 * 根据教师姓名，教师职称获得一个教师对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegreen
	 *            教师职称
	 * @return List
	 */
	public abstract List getTeacherByNameDegreen(String teacherName,
			String teacherDegreen);

	/**
	 * 得到所有教师的列表
	 * 
	 * @return List
	 */
	public abstract List getTeacherList();

	public abstract void saveTeacher(TabTeachers teacher);
}