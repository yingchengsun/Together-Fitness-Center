package com.xdsc.service.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabChooseassociate;
import com.xdsc.model.JfptTabStudentassociate;
import com.xdsc.model.JfptTabTeacherassociate;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
/**
 * <p>功能：涉及对应配置信息中的相关操作方法<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public interface CorrespondingDeployManager {

	//-------------------------教师班级课程-------------------------------------
	/**
	 * <p>功能：查询教师配置信息<br>
	 * @return list 查询到的配置信息
	 */
	public List<JfptTabTeacherassociate> findTeacherDeployInfo();
	
	/**
	 * <p>功能：通过Id号进行教师信息查询<br>
	 * @param FId 配置信息Id号
	 * @return JfptTabTeacherassociate 返回查询到的教师配置信息
	 */
	public JfptTabTeacherassociate findTeacherDeployInfoByID(int FId);
	
	/**
	 * <p>功能：删除教师配置信息<br>
	 * @param jfptTabTeacherassociate 教师配置信息
	 */
	public void deleteTeacherDeployInfo(JfptTabTeacherassociate jfptTabTeacherassociate);
	
	/**
	 * <p>功能：查询教师信息<br>
	 * @return list 返回查询的教师信息
	 */
	public List<TabTeachers> findlistTeachersInfo();
	
	/**
	 * <p>功能：查询班级信息<br>
	 * @return list 返回班级信息列表
	 */
	public List<TabClasses> findlistClassesInfo();
	
	/**
	 * <p>功能：查询课程信息<br>
	 * @return list 课程信息
	 */
	public List<TabCourse> findlistCourseInfo();

	/**
	 * <p>功能：根据教师职工号查询教师对象信息<br>
	 * @param id 教师职工号
	 * @return TabTeachers 返回教师对象信息
	 */
	public TabTeachers findTeachersInfoByID(String id);
	
	/**
	 * <p>功能：根据班级Id号查询相关班级对象信息<br>
	 * @param id 班级Id号
	 * @return TabClasses 返回班级信息
	 */
	public TabClasses findClassesInfoByID(String id);
	
	/**
	 * <p>功能：根据课程Id号查询课程对象信息<br>
	 * @param id 课程编号
	 * @return TabCourse 返回查询到的课程信息
	 */
	public TabCourse findCourseInfoByID(String id);
	
	/**
	 * <p>功能：添加教师配置信息<br>
	 * @param jfptTabTeacherassociate 教师配置信息对象
	 */
	public void addTeacherassociateInfo(JfptTabTeacherassociate jfptTabTeacherassociate);
	
	//-------------------------学生课程班级-------------------------------------
	/**
	 * <p>功能：查询学生相关的信息配置<br>
	 * @return list 返回学生配置信息
	 */
	public List<JfptTabStudentassociate> findStudentDeployInfo();
	
	/**
	 * <p>功能：通过Id号进行学生配置信息查询<br>
	 * @param FInt 配置信息Id号
	 * @return JfptTabSudentassociate 学生配置信息
	 */
	public JfptTabStudentassociate findStudentDeployInfoByID(int FInt);
	
	/**
	 * <p>功能：删除学生配置信息<br>
	 * @param jfptTabStudentassociate 学生配置信息对象
	 */
	public void deleteStudentDeployInfo(JfptTabStudentassociate jfptTabStudentassociate);
	
	/**
	 * <p>功能：查询学生对象信息<br>
	 * @return list 返回查询到的学生信息
	 */
	public List<TabStudents> findlistStudentsInfo();
	
	/**
	 * <p>功能：根据学生学号查询学生信息<br>
	 * @param id 学生学号
	 * @return TabStudents 返回学生对象信息
	 */
	public TabStudents findStudentsInfoByID(String id);
	
	/**
	 * <p>功能：根据学生学号查询班级信息<br>
	 * @param id 班级id号
	 * @return TabClasses 返回班级信息
	 */
	public TabClasses findClassesInfoBySid(String id);
	
	/**
	 * <p>功能：添加学生配置信息<br>
	 * @param jfptTabStudentassociate 学生配置信息对象
	 */
	public void addStudentassociateInfo(
			JfptTabStudentassociate jfptTabStudentassociate);
	
	//-------------------------教师课程学生-------------------------------------
	/**
	 * <p>功能：查询选修课程信息配置<br>
	 * @return list 选修课程配置信息
	 */
	public List<JfptTabChooseassociate> findOtherDeployInfo();
	
	/**
	 * <p>功能：根据Id号查询选修课程配置信息<br>
	 * @param FId 选修课程Id号
	 * @return JfptTabChooseassociate 选修课程配置信息
	 */
	public JfptTabChooseassociate findOtherDeployInfoByID(int FId);
	
	/**
	 * <p>功能：删除选修课程配置信息<br>
	 * @param jfptTabChooseassociate 选修课程配置信息对象
	 */
	public void deleteOtherDeployInfo(JfptTabChooseassociate jfptTabChooseassociate);
	
	/**
	 * <p>功能：添加选修课程配置信息<br>
	 * @param jfptTabChooseassociate 选修课程配置信息
	 */
	public void addChooseassociateInfo(
			JfptTabChooseassociate jfptTabChooseassociate);
}
