package com.xdsc.service.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabCoursetype;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabTeachers;
/**
 * <p>功能：涉及教辅基本信息管理中的相关操作，如查询课程信息、查询方向信息、查询课程类型、助教信息等，同时对一些<br>
 * 信息进行筛选删除、更新等<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public interface BasicInfoManageManager {

	//--------------------课程相关----------------------
	/**
	 * <p>功能：查询课程基本信息<br>
	 * @return list 课程信息
	 */
	public List<TabCourse> findCourseInfo();
	
	/**
	 * <p>功能：删除课程信息<br>
	 * @param tabCourse 课程信息对象
	 */
	public void deleteCourseInfo(TabCourse tabCourse);
	
	/**
	 * <p>功能：根据课程编号查找课程信息<br>
	 * @param FCourseNumber 课程编号
	 * @return TabCourse 查找到的课程信息对象
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber);
	
	/**
	 * <p>功能：添加课程信息<br>
	 * @param tabCourse　课程类型对象
	 */
	public void addTabCourseInfo(TabCourse tabCourse);
	
	/**
	 * <p>功能：更新课程信息<br>
	 * @param tabCourse 课程信息对象
	 */
	public void updateCourseInfo(TabCourse tabCourse);
	
	/**
     * <p>功能：根据课程名称查找相关的课程信息<br>
     * @param FCourseNameselect 课程名称
     * @return list 查询出来的课程信息
     */
	public List<TabCourse> findCourseInfoByName(String FCourseNameselect);
	
	//--------------------方向相关----------------------
	/**
	 * <p>功能：查找方向信息<br>
	 * @return list 查找到的类型信息
	 */
	public List<TabDirection> findDirectionInfo();
	
	/**
	 * <p>功能：删除方向信息<br>
	 * @param tabDirection 方向类型对象
	 */
	public void deleteDirectionInfo(TabDirection tabDirection);
	
	/**
	 * <p>功能：根据方向Id号查找方向信息<br>
	 * @param FDirectionId 方向Id号
	 * @return TabDirection 返回查找到的方向信息
	 */
	public TabDirection findDirectionByID(int FDirectionId);
	
	/**
	 * <p>功能：添加方向信息<br>
	 * @param tabDirection 方向对象
	 */
	public void addDirectionInfo(TabDirection tabDirection);
	
	//--------------------类型相关----------------------
	/**
	 * <p>功能：查找课程类型信息<br>
	 * @return list 课程类型信息
	 */
	public List<TabCoursetype> findCoursetypeInfo();
	
	/**
	 * <p>功能：根据类型Id号查找课程类型信息<br>
	 * @param FNumber 类型信息ID号
	 * @return TabCoursetype 返回查找到的对象信息
	 */
	public TabCoursetype findCoursetypeInfoByID(int FNumber);
	
	/**
	 * <p>功能：删除课程类型信息<br>
	 * @param tabCoursetype 课程类型对象信息
	 */
	public void deleteCoursetypeInfo(TabCoursetype tabCoursetype);
	
	/**
	 * <p>功能：添加课程类型信息<br>
	 * @param tabCoursetype 课程类型信息
	 */
	public void addTabCoursetype(TabCoursetype tabCoursetype);
	
	//------------------------教师相关------------------------------------------
	/**
	 * <p>功能：查找教师信息<br>
	 * @return list 教师信息
	 */
	public List<TabTeachers> findTeacherInfo();
	
	/**
	 * <p>功能：根据教师职工号查找教师信息<br>
	 * @return TabTeachers 返回教师信息
	 */
	public TabTeachers findTeacherInfoByID(String FTeacherNumber);
	
	/**
	 * <p>功能：删除教师信息<br>
	 * @param tabTeachers 教师信息对象
	 */
	public void deleteTeacherInfo(TabTeachers tabTeachers);
	
	/**
	 * <p>功能：添加教师信息<br>
	 * @param tabTeachers 教师对象信息
	 */
	public void addTeacherInfo(TabTeachers tabTeachers);
	
	//---------------------------------助教相关------------------------------------
	/**
	 * <p>功能：查找院外助教信息<br>
	 * @return list 返回查找到的助教信息
	 */
	public List<JfptTabOtherassist> findOtherInfo();
	
	/**
	 * <p>功能：删除院外助教信息<br>
	 * @param jfptTabOtherassist 院外助教信息
	 */
	public void deleteOtherInfo(JfptTabOtherassist jfptTabOtherassist);
	
	/**
	 * <p>功能：根据院外助教Id号查找其信息<br>
	 * @param FAssistantId 助教Id号
	 * @return JfptTabOtherasist 返回助教信息
	 */
	public JfptTabOtherassist findOtherInfoByID(String FAssistantId);
	
	/**
	 * <p>功能：添加院外助教信息<br>
	 * @param jfptTabOtherassist1 助教对象信息
	 */
	public void addOtherInfo(JfptTabOtherassist jfptTabOtherassist1);
}
