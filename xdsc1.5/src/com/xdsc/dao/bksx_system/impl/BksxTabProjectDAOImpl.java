package com.xdsc.dao.bksx_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabProjectDAO;
import com.xdsc.model.BksxTabProject;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对项目相关的操作
 */
public class BksxTabProjectDAOImpl extends HibernateDaoSupport implements
		BksxTabProjectDAO {
	/**
	 * 根据项目ID得到一个BksxTabProject对象
	 * 
	 * @param proId
	 *            项目ID
	 * @return BksxTabProject
	 */
	public BksxTabProject getProjectById(int proId) {
		String hql = "from BksxTabProject bp where bp.FProjId=" + proId;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabProject) (this.getHibernateTemplate().find(hql)
					.get(0));
	}

	/**
	 * 保存一个BksxTabProject对象
	 * 
	 * @param project
	 *            项目对象
	 * @return boolean
	 */
	public boolean saveProject(BksxTabProject project) {
		this.getHibernateTemplate().save(project);
		return true;
	}

	/**
	 * 更新一个BksxTabProject对象
	 * 
	 * @param bksxTabProject
	 *            项目对象
	 * @return
	 */
	public void updateProject(BksxTabProject bksxTabProject) {
		this.getHibernateTemplate().update(bksxTabProject);
	}

	/**
	 * 得到所有项目列表
	 * 
	 * @return List
	 */
	public List getProjectList() {
		String hql = "from BksxTabProject";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据查询HQL语句得到一个项目列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @return List
	 */
	public List getProjectList(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据年级、属性得到一个项目列表
	 * 
	 * @param startDate
	 *            开始时间
	 * @param endDate
	 *            结束时间
	 * @param attributeType
	 *            属性名
	 * @param attribute
	 *            属性值
	 * @return List
	 */
	public List getProjectByGradeAttribute(Date startDate, Date endDate,
			String attributeType, String attribute) {
		String hql = "from BksxTabProject bp where bp.bksxTabTeam.FTeamCreateDate >= :startDate and bp.bksxTabTeam.FTeamCreateDate <= :endDate and bp."
				+ attributeType + "='" + attribute + "'";
		String[] params = { "startDate", "endDate" };
		Object[] args = { startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}
}
