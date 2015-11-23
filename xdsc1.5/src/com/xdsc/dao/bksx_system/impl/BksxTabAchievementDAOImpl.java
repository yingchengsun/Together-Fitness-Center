package com.xdsc.dao.bksx_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabAchievementDAO;
import com.xdsc.model.BksxTabAchievement;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * ��װ��BksxTabAchievement�Ĳ���
 */
public class BksxTabAchievementDAOImpl extends HibernateDaoSupport implements
		BksxTabAchievementDAO {
	/**
	 * ����һ��BksxTabAchievement����
	 * 
	 * @param achievement
	 *            BksxTabAchievement����
	 * @return boolean
	 */
	public boolean saveAchievement(BksxTabAchievement achievement) {
		this.getHibernateTemplate().save(achievement);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabAchievement����
	 * 
	 * @param achievement
	 *            BksxTabAchievement����
	 * @return boolean
	 */
	public boolean deleteAchievement(BksxTabAchievement achievement) {
		this.getHibernateTemplate().delete(achievement);
		return true;
	}

	/**
	 * ����һ��BksxTabAchievement����
	 * 
	 * @param achievement
	 *            BksxTabAchievement����
	 * @return boolean
	 */
	public boolean updateAchievement(BksxTabAchievement achievement) {
		this.getHibernateTemplate().update(achievement);
		return true;
	}

	/**
	 * ����ID����һ��BksxTabAchievement����
	 * 
	 * @param id
	 *            BksxTabAchievementΨһ��ʶID
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
	 * �õ�һ����������getAllAchievement�����List
	 * 
	 * @return List
	 */
	public List getAllAchievement() {
		String hql = "from BksxTabAchievement";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * @param stuNum
	 *            ѧ��ѧ��
	 * 
	 * ����ѧ��ѧ��stuNum�õ�һ��List
	 */
	public List getAchievementByStuNum(String stuNum) {
		String hql = "from BksxTabAchievement ba where ba.bksxTabSubstugui.tabStudents.FStudentNumber='"
				+ stuNum + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * @param ��ʦ����
	 * @param ��ʦְ��
	 * @return List
	 * 
	 * ���ݽ�ʦ�����ͽ�ʦְ�ƻ�ý�ʦ����ѧ���ĳɼ��б�
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
	 *            ĳ��ĵ�һ��
	 * @param endDate
	 *            ĳ������һ��
	 * @return List
	 * 
	 * ��������������ø��꼶�ĳɼ��б�
	 */
	public List getAchievementByGrade(Date startDate, Date endDate) {
		String hql = "from BksxTabAchievement ba where ba.bksxTabSubstugui.tabStudents.FStudentRegData >= :startDate and ba.bksxTabSubstugui.tabStudents.FStudentRegData <= :endDate ";
		String[] params = { "startDate", "endDate" };
		Object[] args = { startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

	/**
	 * @param ��ʦ����
	 * @return List
	 * 
	 * ���ݽ�ʦ������øý�ʦ����ѧ���ĳɼ��б�
	 */
	public List getAchievementByTeacher(String teacherName) {
		String hql = "from BksxTabAchievement ba where ba.bksxTabSubstugui.FTeacherName='"
				+ teacherName + "'";
		return this.getHibernateTemplate().find(hql);
	}
}
