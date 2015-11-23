package com.xdsc.dao.bksx_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabSearchplanDAO;
import com.xdsc.model.BksxTabSearchplan;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabSearchplan����ز���
 */
public class BksxTabSearchplanDAOImpl extends HibernateDaoSupport implements
		BksxTabSearchplanDAO {
	/**
	 * ����һ��BksxTabSearchplan����
	 * 
	 * @param plan
	 *            BksxTabSearchplan����
	 * @return boolean
	 */
	public boolean saveSearchPlan(BksxTabSearchplan plan) {
		this.getHibernateTemplate().save(plan);
		return true;
	}

	/**
	 * ����һ��BksxTabSearchplan����
	 * 
	 * @param plan
	 *            BksxTabSearchplan����
	 * @return boolean
	 */
	public boolean updateSearchPlan(BksxTabSearchplan plan) {
		this.getHibernateTemplate().update(plan);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabSearchplan����
	 * 
	 * @param plan
	 *            BksxTabSearchplan����
	 * @return boolean
	 */
	public boolean deleteSearchPlan(BksxTabSearchplan plan) {
		this.getHibernateTemplate().delete(plan);
		return true;
	}

	/**
	 * ����ѧ��ѧ�ŵõ�һ��������Ŀ�о��ƻ�����
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return BksxTabSearchplan
	 */
	public BksxTabSearchplan getSearchPlanByStuNum(String stuNum) {
		String hql = "from BksxTabSearchplan bs where bs.bksxTabSubstugui.tabStudents.FStudentNumber='"
				+ stuNum + "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabSearchplan) (this.getHibernateTemplate().find(hql)
					.get(0));
	}

	/**
	 * ���ݼ�¼Ψһ��ʾID�õ�һ��BksxTabSearchplan����
	 * 
	 * @param planID
	 *            BksxTabSearchplanΨһID
	 * @return BksxTabSearchplan
	 */
	public BksxTabSearchplan getSearchPlanByID(int planID) {
		String hql = "from BksxTabSearchplan bs where bs.id=" + planID;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabSearchplan) (this.getHibernateTemplate().find(hql)
					.get(0));
	}

	/**
	 * ����ѡ���¼ID���һ��BksxTabSearchplan����
	 * 
	 * @param substuguiID
	 *            ѡ���¼ID
	 * @return BksxTabSearchplan
	 */
	public BksxTabSearchplan getSearchPlanByStustuguiID(int substuguiID) {
		String hql = "from BksxTabSearchplan bs where bs.bksxTabSubstugui.FSubStuGuiId="
				+ substuguiID;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabSearchplan) this.getHibernateTemplate().find(hql)
					.get(0);
	}
}
