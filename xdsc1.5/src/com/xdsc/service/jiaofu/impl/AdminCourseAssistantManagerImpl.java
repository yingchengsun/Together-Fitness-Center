package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.AdminCourseAssistantDAO;
import com.xdsc.model.JfptTabAssistantapply;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.jiaofu.AdminCourseAssistantManager;
/**
 * <p>助教权限管理中涉及到的操作，其中包括添加助教、助教权限审批、删除、查找等。<br>
 * @author qianxun
 * @version 1.1
 */
public class AdminCourseAssistantManagerImpl implements AdminCourseAssistantManager{

	/**Dao层对象*/
	private AdminCourseAssistantDAO adminCourseAssistantDAO;

	public AdminCourseAssistantDAO getAdminCourseAssistantDAO() {
		return adminCourseAssistantDAO;
	}

	public void setAdminCourseAssistantDAO(
			AdminCourseAssistantDAO adminCourseAssistantDAO) {
		this.adminCourseAssistantDAO = adminCourseAssistantDAO;
	}

	/**
	 * <p>功能：查询助教申请记录信息<br>
	 * @return list 返回相关信息记录集
	 */
	public List<JfptTabAssistantapply> findAssistantapplyInfo() {
		// TODO Auto-generated method stub
		return adminCourseAssistantDAO.findAssistantapplyInfo();
	}

	/**
	 * <p>功能：根据申请记录对象ID信息查找对象<br>
	 * @param FId 申请记录信息主键号
	 * @return JfptTabAssistantapply 返回查找到的对象
	 */
	public JfptTabAssistantapply findAssistantapplyInfoByID(int FId) {
		// TODO Auto-generated method stub
		return adminCourseAssistantDAO.findAssistantapplyInfoByID(FId);
	}

	/**
	 * <p>功能：删除助教申请对象信息<br>
	 * @param jfptTabAssistantapply 助教申请记录信息对象
	 */
	public void deleteAssistantapplyInfo(
			JfptTabAssistantapply jfptTabAssistantapply) {
		// TODO Auto-generated method stub
		adminCourseAssistantDAO.deleteAssistantapplyInfo(jfptTabAssistantapply);
	}

	/**
	 * <p>功能：添加助教配置信息<br>
	 * @param jfptTabAssistantapply1 助教配置信息对象
	 */
	public void addAssistantInfo(JfptTabAssistantapply jfptTabAssistantapply1) {
		// TODO Auto-generated method stub
		adminCourseAssistantDAO.addAssistantInfo(jfptTabAssistantapply1);
	}

	/**
	 * <p>功能：根据课程编号查找课程对象信息<br>
	 * @param FCourseNumber 课程编号
	 * @return TabCourse 返回查找到的课程对象
	 */
	public TabCourse findTabCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return adminCourseAssistantDAO.findTabCourseInfoByID(FCourseNumber);
	}

	/**
	 * <p>功能：根据教师职工号查找教师对象<br>
	 * @param FTeacherNumber 教师职工号
	 * @return 返回查找到的教师对象
	 */
	public TabTeachers findTeacherInfoByID(String FTeacherNumber) {
		// TODO Auto-generated method stub
		return adminCourseAssistantDAO.findTeacherInfoByID(FTeacherNumber);
	}
}
