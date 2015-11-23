package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabCourseDAO;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.TabCourse;
import com.xdsc.service.sjjx_system.SjjxTabCourseManager;

/**对课程信息记录进行操作
 * @author ChenXue
 *@version 1.1
 */
public class SjjxTabCourseManagerImpl implements SjjxTabCourseManager {
	
	
	/**
	 * SjjxTabCourseDAOImpl 的接口
	 */
	private SjjxTabCourseDAO sjjxTabCourseDAO;


	/**
	 * 数据访问方法
	 */
	public SjjxTabCourseDAO getSjjxTabCourseDAO() {
		return sjjxTabCourseDAO;
	}


	public void setSjjxTabCourseDAO(SjjxTabCourseDAO sjjxTabCourseDAO) {
		this.sjjxTabCourseDAO = sjjxTabCourseDAO;
	}
	
	
	/**根据课程编号查找到对应的课程记录
	 * @param courseNumber
	 * @return 返回查到的记录
	 */
	public TabCourse getCourseByCourseNumber(String courseNumber) {
		return sjjxTabCourseDAO.getCourseByCourseNumber(courseNumber);
	}
	


	/**根据课程名称查找到对应的课程记录
	 * @param courseName
	 * @return 返回查到的记录
	 */
	public TabCourse getCourseByCourseName(String courseName) {
		return sjjxTabCourseDAO.getCourseByCourseName(courseName);
	}


		

}
