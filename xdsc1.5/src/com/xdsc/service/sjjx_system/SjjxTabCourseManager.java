package com.xdsc.service.sjjx_system;

import java.util.List;

import com.xdsc.model.TabCourse;

/**对课程信息记录进行操作
 * @author ChenXue
 * @version 1.1
 */
public interface SjjxTabCourseManager {

	
	/**根据课程编号查找到对应的课程记录
	 * @param courseNumber
	 * @return 返回查到的记录
	 */
	public abstract TabCourse getCourseByCourseNumber(String courseNumber);

	/**根据课程名称查找到对应的课程记录
	 * @param courseName
	 * @return 返回查到的记录
	 */
	public abstract TabCourse getCourseByCourseName(String courseName);

	

}