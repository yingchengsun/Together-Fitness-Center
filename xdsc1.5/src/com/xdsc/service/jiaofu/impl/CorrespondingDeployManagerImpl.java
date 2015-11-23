package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.CorrespondingDeployDAO;
import com.xdsc.model.JfptTabChooseassociate;
import com.xdsc.model.JfptTabStudentassociate;
import com.xdsc.model.JfptTabTeacherassociate;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.jiaofu.CorrespondingDeployManager;
/**
 * <p>功能：涉及对应配置信息中的相关操作方法<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class CorrespondingDeployManagerImpl implements CorrespondingDeployManager{
	/**DAO层对象*/
	private CorrespondingDeployDAO correspondingDeployDAO;

	public CorrespondingDeployDAO getCorrespondingDeployDAO() {
		return correspondingDeployDAO;
	}

	public void setCorrespondingDeployDAO(
			CorrespondingDeployDAO correspondingDeployDAO) {
		this.correspondingDeployDAO = correspondingDeployDAO;
	}
	//-------------------------教师班级课程-------------------------------------
	/**
	 * <p>功能：查询教师配置信息<br>
	 * @return list 查询到的配置信息
	 */
	public List<JfptTabTeacherassociate> findTeacherDeployInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findTeacherDeployInfo();
	}

	/**
	 * <p>功能：通过Id号进行教师信息查询<br>
	 * @param FId 配置信息Id号
	 * @return JfptTabTeacherassociate 返回查询到的教师配置信息
	 */
	public JfptTabTeacherassociate findTeacherDeployInfoByID(int FId) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findTeacherDeployInfoByID(FId);
	}

	/**
	 * <p>功能：删除教师配置信息<br>
	 * @param jfptTabTeacherassociate 教师配置信息
	 */
	public void deleteTeacherDeployInfo(
			JfptTabTeacherassociate jfptTabTeacherassociate) {
		// TODO Auto-generated method stub
		correspondingDeployDAO.deleteTeacherDeployInfo(jfptTabTeacherassociate);
	}

	/**
	 * <p>功能：查询教师信息<br>
	 * @return list 返回查询的教师信息
	 */
	public List<TabTeachers> findlistTeachersInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findlistTeachersInfo();
	}

	
	
	
	//-------------------------学生课程班级-------------------------------------
	/**
	 * <p>功能：查询学生相关的信息配置<br>
	 * @return list 返回学生配置信息
	 */
	public List<JfptTabStudentassociate> findStudentDeployInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findStudentDeployInfo();
	}

	/**
	 * <p>功能：通过Id号进行学生配置信息查询<br>
	 * @param FInt 配置信息Id号
	 * @return JfptTabSudentassociate 学生配置信息
	 */
	public JfptTabStudentassociate findStudentDeployInfoByID(int FInt) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findStudentDeployInfoByID(FInt);
	}

	/**
	 * <p>功能：删除学生配置信息<br>
	 * @param jfptTabStudentassociate 学生配置信息对象
	 */
	public void deleteStudentDeployInfo(
			JfptTabStudentassociate jfptTabStudentassociate) {
		// TODO Auto-generated method stub
		correspondingDeployDAO.deleteStudentDeployInfo(jfptTabStudentassociate);
	}

	
	
	//-------------------------教师课程学生-------------------------------------
	/**
	 * <p>功能：查询选修课程信息配置<br>
	 * @return list 选修课程配置信息
	 */
	public List<JfptTabChooseassociate> findOtherDeployInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findOtherDeployInfo();
	}

	/**
	 * <p>功能：删除选修课程配置信息<br>
	 * @param jfptTabChooseassociate 选修课程配置信息对象
	 */
	public void deleteOtherDeployInfo(
			JfptTabChooseassociate jfptTabChooseassociate) {
		// TODO Auto-generated method stub
		correspondingDeployDAO.deleteOtherDeployInfo(jfptTabChooseassociate);
	}

	/**
	 * <p>功能：根据Id号查询选修课程配置信息<br>
	 * @param FId 选修课程Id号
	 * @return JfptTabChooseassociate 选修课程配置信息
	 */
	public JfptTabChooseassociate findOtherDeployInfoByID(int FId) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findOtherDeployInfoByID(FId);
	}

	/**
	 * <p>功能：查询班级信息<br>
	 * @return list 返回班级信息列表
	 */
	public List<TabClasses> findlistClassesInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findlistClassesInfo();
	}

	/**
	 * <p>功能：查询课程信息<br>
	 * @return list 课程信息
	 */
	public List<TabCourse> findlistCourseInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findlistCourseInfo();
	}

	/**
	 * <p>功能：添加教师配置信息<br>
	 * @param jfptTabTeacherassociate 教师配置信息对象
	 */
	public void addTeacherassociateInfo(
			JfptTabTeacherassociate jfptTabTeacherassociate) {
		// TODO Auto-generated method stub
		correspondingDeployDAO.addTeacherassociateInfo(jfptTabTeacherassociate);
	}

	/**
	 * <p>功能：根据班级Id号查询相关班级对象信息<br>
	 * @param id 班级Id号
	 * @return TabClasses 返回班级信息
	 */
	public TabClasses findClassesInfoByID(String id) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findClassesInfoByID(id);
	}

	/**
	 * <p>功能：根据课程Id号查询课程对象信息<br>
	 * @param id 课程编号
	 * @return TabCourse 返回查询到的课程信息
	 */
	public TabCourse findCourseInfoByID(String id) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findCourseInfoByID(id);
	}

	/**
	 * <p>功能：根据教师职工号查询教师对象信息<br>
	 * @param id 教师职工号
	 * @return TabTeachers 返回教师对象信息
	 */
	public TabTeachers findTeachersInfoByID(String id) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findTeachersInfoByID(id);
	}

	/**
	 * <p>功能：查询学生对象信息<br>
	 * @return list 返回查询到的学生信息
	 */
	public List<TabStudents> findlistStudentsInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findlistStudentsInfo();
	}

	/**
	 * <p>功能：根据学生学号查询班级信息<br>
	 * @param id 班级id号
	 * @return TabClasses 返回班级信息
	 */
	public TabClasses findClassesInfoBySid(String id) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findClassesInfoBySid(id);
	}

	/**
	 * <p>功能：根据学生学号查询学生信息<br>
	 * @param id 学生学号
	 * @return TabStudents 返回学生对象信息
	 */
	public TabStudents findStudentsInfoByID(String id) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findStudentsInfoByID(id);
	}

	/**
	 * <p>功能：添加学生配置信息<br>
	 * @param jfptTabStudentassociate 学生配置信息对象
	 */
	public void addStudentassociateInfo(
			JfptTabStudentassociate jfptTabStudentassociate) {
		// TODO Auto-generated method stub
		correspondingDeployDAO.addStudentassociateInfo(jfptTabStudentassociate);
	}

	/**
	 * <p>功能：添加选修课程配置信息<br>
	 * @param jfptTabChooseassociate 选修课程配置信息
	 */
	public void addChooseassociateInfo(
			JfptTabChooseassociate jfptTabChooseassociate) {
		// TODO Auto-generated method stub
		correspondingDeployDAO.addChooseassociateInfo(jfptTabChooseassociate);
	}
}
