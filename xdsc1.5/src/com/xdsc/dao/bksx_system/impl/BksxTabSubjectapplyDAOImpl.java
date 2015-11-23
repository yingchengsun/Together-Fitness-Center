package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabSubjectapplyDAO;
import com.xdsc.model.BksxTabSubjectapply;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabSubjectapply的相关操作
 */
public class BksxTabSubjectapplyDAOImpl extends HibernateDaoSupport implements
		BksxTabSubjectapplyDAO {
	/**
	 * 保存一个BksxTabSubjectapply对象
	 * 
	 * @param apply
	 *            BksxTabSubjectapply对象
	 * @return boolean
	 */
	public boolean saveSubjectApply(BksxTabSubjectapply apply) {
		this.getHibernateTemplate().save(apply);
		return true;
	}

	/**
	 * 删除一个BksxTabSubjectapply对象
	 * 
	 * @param apply
	 *            BksxTabSubjectapply对象
	 * @return boolean
	 */
	public boolean deleteSubjectApply(BksxTabSubjectapply apply) {
		this.getHibernateTemplate().delete(apply);
		return true;
	}

	/**
	 * 更新一个BksxTabSubjectapply对象
	 * 
	 * @param apply
	 *            BksxTabSubjectapply对象
	 * @return boolean
	 */
	public boolean updateSubjectApply(BksxTabSubjectapply apply) {
		this.getHibernateTemplate().update(apply);
		return true;
	}

	/**
	 * 根据记录唯一ID获取一个BksxTabSubjectapply对象
	 * 
	 * @param applyID
	 *            课题申请唯一ＩＤ
	 * @return BksxTabSubjectapply
	 */
	public BksxTabSubjectapply getSubjectApplyListByID(int applyID) {
		String hql = "from BksxTabSubjectapply sa where sa.id=" + applyID;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabSubjectapply) this.getHibernateTemplate().find(hql)
					.get(0);
	}

	/**
	 * 根据指导教师姓名与职称获取一个BksxTabSubjectapply对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public List getSubjectApplyByTeacher(String teacherName,
			String teacherDegree) {
		String hql = "from BksxTabSubjectapply sa where sa.bksxTabSubstugui.FTeacherName='"
				+ teacherName
				+ "' and sa.bksxTabSubstugui.FTeacherDegreen='"
				+ teacherDegree + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据学生学号和选题记录ID获取一个BksxTabSubjectapply对象
	 * 
	 * @param studentNumber
	 *            学生学号
	 * @param subStuGuiId
	 *            选题信息ID
	 * @return BksxTabSubjectapply
	 */
	public BksxTabSubjectapply getSubjectApplyByStuSub(String studentNumber,
			Integer subStuGuiId) {
		String hql = "from BksxTabSubjectapply sa where sa.bksxTabSubstugui.FSubStuGuiId="
				+ subStuGuiId
				+ " and sa.tabStudents.FStudentNumber='"
				+ studentNumber + "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabSubjectapply) this.getHibernateTemplate().find(hql)
					.get(0);
	}

	/**
	 * 根据指导教师姓名获取一个BksxTabSubjectapply对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public List getSubjectApplyByTeacher(String teacherName) {
		String hql = "from BksxTabSubjectapply sa where sa.bksxTabSubstugui.FTeacherName='"
				+ teacherName + "'";
		return this.getHibernateTemplate().find(hql);
	}
}
