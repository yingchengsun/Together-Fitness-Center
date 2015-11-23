package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabWorksummaryDAO;
import com.xdsc.model.BksxTabWorksummary;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabWorksummary的相关操作
 */
public class BksxTabWorksummaryDAOImpl extends HibernateDaoSupport implements
		BksxTabWorksummaryDAO {
	/**
	 * 保存一个BksxTabWorksummary对象
	 * 
	 * @param summary
	 *            BksxTabWorksummary对象
	 * @return boolean
	 */
	public boolean saveWorkSummary(BksxTabWorksummary summary) {
		this.getHibernateTemplate().save(summary);
		return true;
	}

	/**
	 * 删除一个BksxTabWorksummary对象
	 * 
	 * @param summary
	 *            BksxTabWorksummary对象
	 * @return boolean
	 */
	public boolean deleteWorkSummary(BksxTabWorksummary summary) {
		this.getHibernateTemplate().delete(summary);
		return true;
	}

	/**
	 * 更新一个BksxTabWorksummary对象
	 * 
	 * @param summary
	 *            BksxTabWorksummary对象
	 * @return boolean
	 */
	public boolean updateWorkSummary(BksxTabWorksummary summary) {
		this.getHibernateTemplate().update(summary);
		return true;
	}

	/**
	 * 根据学生学号得到一个BksxTabWorksummary对象列表
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return List
	 */
	public List<BksxTabWorksummary> getSummaryByStuNum(String stuNum) {
		String hql = "from BksxTabWorksummary bw where bw.bksxTabSubstugui.tabStudents.FStudentNumber='"
				+ stuNum + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据工作总结唯一标识ID得到一个BksxTabWorksummary对象
	 * 
	 * @param FWid
	 *            BksxTabWorksummary对象ID
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
	 * 根据学生学号与工作阶段得到一个BksxTabWorksummary对象列表
	 * 
	 * @param stuNum
	 *            学生学号
	 * @param stage
	 *            工作阶段
	 * @return List
	 */
	public List getSummaryByStage(String stuNum, String stage) {
		String hql = "from BksxTabWorksummary bw where bw.bksxTabSubstugui.tabStudents.FStudentNumber='"
				+ stuNum + "' and bw.FSummaryStage='" + stage + "'";
		return this.getHibernateTemplate().find(hql);
	}
}
