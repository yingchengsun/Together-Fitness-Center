package com.xdsc.service.sjjx_system;

import java.io.InputStream;

import java.util.List;

import com.xdsc.model.SjjxTabCourselab;

/**对实验安排进行相关操作
 * @author 陈雪
 * @version 1.1
 */
public interface SjjxTabCourselabManager {

	/**添加一条实验安排信息记录到数据库中
	 * @param courseLab
	 */
	public abstract boolean saveCourseLab(SjjxTabCourselab courseLab);

	/**删除数据库一条实验安排信息记录
	 * @param courseLab
	 */
	public abstract boolean deleteCourseLab(SjjxTabCourselab courseLab);

	/**查找到数据库中所有的实验安排记录
	 * @return 返回查到的记录
	 */
	public abstract List<SjjxTabCourselab> getCourseLabList();
	
	/**根据自增的id数据项查到到对应的实验安排记录
	 * @param id
	 * @return 返回查找到的记录 
	 */
	public abstract SjjxTabCourselab getCourseLabById(Integer id);

	/**根据实验室名称查到到对应的实验安排记录
	 * @param labName
	 * @return 返回查找到的记录 
	 */
	public abstract List<SjjxTabCourselab> getCourseLabByLabName(String labName);

	
	/**根据教师姓名查到到对应的实验安排记录
	 * @param teacherName
	 * @return 返回查找到的记录 
	 */
	public abstract List<SjjxTabCourselab> getCourseLabByTeacherName(String teacherName);
	
	/**根据教师登录ID查到到对应的实验安排记录
	 * @param teacherName
	 * @return 返回查找到的记录 
	 */
	public abstract List<SjjxTabCourselab> getCourseLabByTeacherNum(String teacherNum);
	
	/**根据实验室编号查到到对应的实验安排记录
	 * @param labId
	 * @return 返回查找到的记录
	 */
	public abstract List<SjjxTabCourselab> getCourseLabByLabId(int labId);
	


	/**更新一条实验安排记录
	 * @param courseLab
	 */
	public abstract void updateCourseLab(SjjxTabCourselab courseLab);
	
	/**
	 * 构造实验安排表excel文件
	 */
	public abstract InputStream getInputStream();

}