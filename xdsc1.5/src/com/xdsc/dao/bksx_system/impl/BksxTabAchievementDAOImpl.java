package com.xdsc.dao.bksx_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabAchievementDAO;
import com.xdsc.model.BksxTabAchievement;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 封装对BksxTabAchievement的操作
 */
public class BksxTabAchievementDAOImpl extends HibernateDaoSupport implements
		BksxTabAchievementDAO {
	/**
	 * 保存一个BksxTabAchievement对象
	 * 
	 * @param achievement
	 *            BksxTabAchievement对象
	 * @return boolean
	 */
	public boolean saveAchievement(BksxTabAchievement achievement) {
		this.getHibernateTemplate().save(achievement);
		return true;
	}

	/**
	 * 删除一个BksxTabAchievement对象
	 * 
	 * @param achievement
	 *            BksxTabAchievement对象
	 * @return boolean
	 */
	public boolean deleteAchievement(BksxTabAchievement achievement) {
		this.getHibernateTemplate().delete(achievement);
		return true;
	}

	/**
	 * 更新一个BksxTabAchievement对象
	 * 
	 * @param achievement
	 *            BksxTabAchievement对象
	 * @return boolean
	 */
	public boolean updateAchievement(BksxTabAchievement achievement) {
		this.getHibernateTemplate().update(achievement);
		return true;
	}

	/**
	 * 根据ID返回一个BksxTabAchievement对象
	 * 
	 * @param id
	 *            BksxTabAchievement唯一标识ID
	 * @return BksxTabAchievement
	 */
	public BksxTabAchievement getAchievementByID(int id) {
		String hql = "from BksxTabAchievement ba where ba.FSubStuGuiId=" + id;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabAchievement) this.getHibernateTemplate().find(hql)
					.get(0);
	}

	/**
	 * 得到一个包含所有getAllAchievement对象的List
	 * 
	 * @return List
	 */
	public List getAllAchievement() {
		String hql = "from BksxTabAchievement";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * @param stuNum
	 *            学生学号
	 * 
	 * 根据学生学号stuNum得到一个List
	 */
	public List getAchievementByStuNum(String stuNum) {
		String hql = "from BksxTabAchievement ba where ba.bksxTabSubstugui.tabStudents.FStudentNumber='"
				+ stuNum + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * @param 教师姓名
	 * @param 教师职称
	 * @return List
	 * 
	 * 根据教师姓名和教师职称活动该教师名下学生的成绩列表
	 */
	public List getAchievementByTeacher(String teacherName, String teacherDegree) {
		String hql = "from BksxTabAchievement ba where ba.bksxTabSubstugui.FTeacherName='"
				+ teacherName
				+ "' and ba.bksxTabSubstugui.FTeacherDegreen='"
				+ teacherDegree + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * @param startDate
	 *            某年的第一天
	 * @param endDate
	 *            某年的最后一天
	 * @return List
	 * 
	 * 根据两个参数获得改年级的成绩列表
	 */
	public List getAchievementByGrade(Date startDate, Date endDate) {
		String hql = "from BksxTabAchievement ba where ba.bksxTabSubstugui.tabStudents.FStudentRegData >= :startDate and ba.bksxTabSubstugui.tabStudents.FStudentRegData <= :endDate ";
		String[] params = { "startDate", "endDate" };
		Object[] args = { startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

	/**
	 * @param 教师姓名
	 * @return List
	 * 
	 * 根据教师姓名获得该教师名下学生的成绩列表
	 */
	public List getAchievementByTeacher(String teacherName) {
		String hql = "from BksxTabAchievement ba where ba.bksxTabSubstugui.FTeacherName='"
				+ teacherName + "'";
		return this.getHibernateTemplate().find(hql);
	}
}
