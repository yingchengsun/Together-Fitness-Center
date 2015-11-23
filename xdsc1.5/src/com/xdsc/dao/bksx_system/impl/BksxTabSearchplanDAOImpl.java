package com.xdsc.dao.bksx_system.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabSearchplanDAO;
import com.xdsc.model.BksxTabSearchplan;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabSearchplan的相关操作
 */
public class BksxTabSearchplanDAOImpl extends HibernateDaoSupport implements
		BksxTabSearchplanDAO {
	/**
	 * 保存一个BksxTabSearchplan对象
	 * 
	 * @param plan
	 *            BksxTabSearchplan对象
	 * @return boolean
	 */
	public boolean saveSearchPlan(BksxTabSearchplan plan) {
		this.getHibernateTemplate().save(plan);
		return true;
	}

	/**
	 * 更新一个BksxTabSearchplan对象
	 * 
	 * @param plan
	 *            BksxTabSearchplan对象
	 * @return boolean
	 */
	public boolean updateSearchPlan(BksxTabSearchplan plan) {
		this.getHibernateTemplate().update(plan);
		return true;
	}

	/**
	 * 删除一个BksxTabSearchplan对象
	 * 
	 * @param plan
	 *            BksxTabSearchplan对象
	 * @return boolean
	 */
	public boolean deleteSearchPlan(BksxTabSearchplan plan) {
		this.getHibernateTemplate().delete(plan);
		return true;
	}

	/**
	 * 根据学生学号得到一个个人项目研究计划对象
	 * 
	 * @param stuNum
	 *            学生学号
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
	 * 根据记录唯一标示ID得到一个BksxTabSearchplan对象
	 * 
	 * @param planID
	 *            BksxTabSearchplan唯一ID
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
	 * 根据选题记录ID获得一个BksxTabSearchplan对象
	 * 
	 * @param substuguiID
	 *            选题记录ID
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
