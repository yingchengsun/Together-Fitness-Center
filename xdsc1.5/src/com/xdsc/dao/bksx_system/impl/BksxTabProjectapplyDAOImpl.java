package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabProjectapplyDAO;
import com.xdsc.model.BksxTabProjectapply;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶������������ز���
 */
public class BksxTabProjectapplyDAOImpl extends HibernateDaoSupport implements
		BksxTabProjectapplyDAO {
	/**
	 * ����һ��BksxTabProjectapply����
	 * 
	 * @param apply
	 *            BksxTabProjectapply����
	 * @return boolean
	 */
	public boolean addApply(BksxTabProjectapply apply) {
		this.getHibernateTemplate().save(apply);
		return true;
	}

	/**
	 * ����һ��BksxTabProjectapply����
	 * 
	 * @param apply
	 *            BksxTabProjectapply����
	 * @return boolean
	 */
	public boolean updateApply(BksxTabProjectapply apply) {
		this.getHibernateTemplate().update(apply);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabProjectapply����
	 * 
	 * @param apply
	 *            BksxTabProjectapply����
	 * @return boolean
	 */
	public boolean deleteApply(BksxTabProjectapply apply) {
		this.getHibernateTemplate().delete(apply);
		return true;
	}

	/**
	 * ���ݽ�ʦID�õ�����ý�ʦ�������б�
	 * 
	 * @param teacherNum
	 *            ��ʦ����
	 * @return List
	 */
	public List getApplyByTeacherNum(String teacherNum) {
		String hql = "from BksxTabProjectapply bp where bp.tabTeachers.FTeacherNumber='"
				+ teacherNum + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ����ѧ��ѧ�ŵõ�һ�����������б�
	 * 
	 * @param studentNum
	 *            ѧ��ѧ��
	 * @return List
	 */
	public List getApplyByStudentNum(String studentNum) {
		String hql = "from BksxTabProjectapply bp where bp.tabStudents.FStudentNumber='"
				+ studentNum + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ���������¼ID�õ�һ��BksxTabProjectapply����
	 * 
	 * @param id
	 *            BksxTabProjectapply�����ID
	 * @return BksxTabProjectapply
	 */
	public BksxTabProjectapply getApplyByID(int id) {
		String hql = "from BksxTabProjectapply bp where bp.id=" + id;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabProjectapply) this.getHibernateTemplate().find(hql)
					.get(0);
	}
}
