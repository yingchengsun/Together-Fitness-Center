package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabWorksummaryDAO;
import com.xdsc.model.BksxTabWorksummary;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabWorksummary����ز���
 */
public class BksxTabWorksummaryDAOImpl extends HibernateDaoSupport implements
		BksxTabWorksummaryDAO {
	/**
	 * ����һ��BksxTabWorksummary����
	 * 
	 * @param summary
	 *            BksxTabWorksummary����
	 * @return boolean
	 */
	public boolean saveWorkSummary(BksxTabWorksummary summary) {
		this.getHibernateTemplate().save(summary);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabWorksummary����
	 * 
	 * @param summary
	 *            BksxTabWorksummary����
	 * @return boolean
	 */
	public boolean deleteWorkSummary(BksxTabWorksummary summary) {
		this.getHibernateTemplate().delete(summary);
		return true;
	}

	/**
	 * ����һ��BksxTabWorksummary����
	 * 
	 * @param summary
	 *            BksxTabWorksummary����
	 * @return boolean
	 */
	public boolean updateWorkSummary(BksxTabWorksummary summary) {
		this.getHibernateTemplate().update(summary);
		return true;
	}

	/**
	 * ����ѧ��ѧ�ŵõ�һ��BksxTabWorksummary�����б�
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return List
	 */
	public List<BksxTabWorksummary> getSummaryByStuNum(String stuNum) {
		String hql = "from BksxTabWorksummary bw where bw.bksxTabSubstugui.tabStudents.FStudentNumber='"
				+ stuNum + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ���ݹ����ܽ�Ψһ��ʶID�õ�һ��BksxTabWorksummary����
	 * 
	 * @param FWid
	 *            BksxTabWorksummary����ID
	 * @return BksxTabWorksummary
	 */
	public BksxTabWorksummary getSummaryByID(int FWid) {
		String hql = "from BksxTabWorksummary bw where bw.FWid=" + FWid;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabWorksummary) this.getHibernateTemplate().find(hql)
					.get(0);
	}

	/**
	 * ����ѧ��ѧ���빤���׶εõ�һ��BksxTabWorksummary�����б�
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @param stage
	 *            �����׶�
	 * @return List
	 */
	public List getSummaryByStage(String stuNum, String stage) {
		String hql = "from BksxTabWorksummary bw where bw.bksxTabSubstugui.tabStudents.FStudentNumber='"
				+ stuNum + "' and bw.FSummaryStage='" + stage + "'";
		return this.getHibernateTemplate().find(hql);
	}
}
