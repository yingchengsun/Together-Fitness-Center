package com.xdsc.dao.jiaofu.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.TeacherCourseAssistantDAO;
import com.xdsc.model.JfptTabAssistantapply;
import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;

/**
 * <p>功能：教师管理助教，包括助教的申请、查找、删除等<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherCourseAssistantDAOImpl extends HibernateDaoSupport implements TeacherCourseAssistantDAO{

	/**
	 * <p>功能：根据教师编号查看相关的助教信息<br>
	 * @param FTeacherNumber 教师编号
	 * @return list 返回相关的助教信息
	 */
	public List<JfptTabAssistantapply> findAssistantapplyInfo(String FTeacherNumber) {
		// TODO Auto-generated method stub
		String sql = "from JfptTabAssistantapply where tabTeachers.FTeacherNumber='"+FTeacherNumber+"'";
		List<JfptTabAssistantapply> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>功能：根据助教申请id号查找相关的助教申请信息<br>
	 * @param FId 申请id号
	 * @return JfptTabAssistantapply 返回查找到的对象信息
	 */
	public JfptTabAssistantapply findAssistantapplyInfoByID(int FId) {
		// TODO Auto-generated method stub
		return (JfptTabAssistantapply)this.getHibernateTemplate().get(JfptTabAssistantapply.class, FId);
	}

	/**
	 * <p>功能：根据院外助教编号查找相关的助教信息<br>
	 * @param FAssistantId 院外人员编号
	 * @return JfptTabOtherassist 返回查找到的信息
	 */
	public JfptTabOtherassist findAssistantOtherInfoByID(String FAssistantId) {
		// TODO Auto-generated method stub
		return (JfptTabOtherassist)this.getHibernateTemplate().get(JfptTabOtherassist.class, FAssistantId);
	}

	/**
	 * <p>功能：根据学生学号查找学生信息<br>
	 * @param FAssistantId 学生学号
	 * @return TabStudents 返回查找到的学生信息
	 */
	public TabStudents findAssistantStudentInfoByID(String FAssistantId) {
		// TODO Auto-generated method stub
		return (TabStudents)this.getHibernateTemplate().get(TabStudents.class, FAssistantId);
	}

	/**
	 * <p>功能：根据教师编号查找相关教师信息<br>
	 * @param FAssistantId 教师编号
	 * @return TabTeachers 教师对象信息
	 */
	public TabTeachers findAssistantTeacherInfoByID(String FAssistantId) {
		// TODO Auto-generated method stub
		return (TabTeachers)this.getHibernateTemplate().get(TabTeachers.class, FAssistantId);
	}

	/**
	 * <p>功能：添加助教申请信息<br>
	 * @param jfptTabAssistantapply 助教申请对象信息
	 */
	public void addAssistantapply(JfptTabAssistantapply jfptTabAssistantapply) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabAssistantapply);
	}

	/**
	 * <p>功能：根据课程编号查找课程对象信息<br>
	 * @param FCourseNumber 课程编号
	 * @return TabCourse 返回课程对象信息
	 */
	public TabCourse findCourseInfoByID(String FCourseNumber) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, FCourseNumber);
	}

	/**
	 * <p>功能：根据教师编号查找相关教师信息<br>
	 * @param FTeacherNumber 教师编号
	 * @return TabTeachers 教师对象信息
	 */
	public TabTeachers findTeacherInfoByID(String FTeacherNumber) {
		// TODO Auto-generated method stub
		return (TabTeachers)this.getHibernateTemplate().get(TabTeachers.class, FTeacherNumber);
	}

	public void updateInfo(JfptTabAssistantapply ha) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(ha);
	}
}
