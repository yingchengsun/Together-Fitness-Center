package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabSubjectapplyDAO;
import com.xdsc.model.BksxTabSubjectapply;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabSubjectapply����ز���
 */
public class BksxTabSubjectapplyDAOImpl extends HibernateDaoSupport implements
		BksxTabSubjectapplyDAO {
	/**
	 * ����һ��BksxTabSubjectapply����
	 * 
	 * @param apply
	 *            BksxTabSubjectapply����
	 * @return boolean
	 */
	public boolean saveSubjectApply(BksxTabSubjectapply apply) {
		this.getHibernateTemplate().save(apply);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabSubjectapply����
	 * 
	 * @param apply
	 *            BksxTabSubjectapply����
	 * @return boolean
	 */
	public boolean deleteSubjectApply(BksxTabSubjectapply apply) {
		this.getHibernateTemplate().delete(apply);
		return true;
	}

	/**
	 * ����һ��BksxTabSubjectapply����
	 * 
	 * @param apply
	 *            BksxTabSubjectapply����
	 * @return boolean
	 */
	public boolean updateSubjectApply(BksxTabSubjectapply apply) {
		this.getHibernateTemplate().update(apply);
		return true;
	}

	/**
	 * ���ݼ�¼ΨһID��ȡһ��BksxTabSubjectapply����
	 * 
	 * @param applyID
	 *            ��������Ψһ�ɣ�
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
	 * ����ָ����ʦ������ְ�ƻ�ȡһ��BksxTabSubjectapply�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
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
	 * ����ѧ��ѧ�ź�ѡ���¼ID��ȡһ��BksxTabSubjectapply����
	 * 
	 * @param studentNumber
	 *            ѧ��ѧ��
	 * @param subStuGuiId
	 *            ѡ����ϢID
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
	 * ����ָ����ʦ������ȡһ��BksxTabSubjectapply�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public List getSubjectApplyByTeacher(String teacherName) {
		String hql = "from BksxTabSubjectapply sa where sa.bksxTabSubstugui.FTeacherName='"
				+ teacherName + "'";
		return this.getHibernateTemplate().find(hql);
	}
}
