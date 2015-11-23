package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabStagereportDAO;
import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabStagereport;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabStagereport的相关操作
 */
public class BksxTabStagereportDAOImpl extends HibernateDaoSupport implements
		BksxTabStagereportDAO {
	/**
	 * 保存一个BksxTabStagereport对象
	 * 
	 * @param stageReport
	 *            BksxTabStagereport对象
	 * @return boolean
	 */
	public boolean saveStagereport(BksxTabStagereport stageReport) {
		this.getHibernateTemplate().save(stageReport);
		return true;
	}

	/**
	 * 删除一个BksxTabStagereport对象
	 * 
	 * @param stageReport
	 *            BksxTabStagereport对象
	 * @return boolean
	 */
	public boolean deleteStagereport(BksxTabStagereport stageReport) {
		this.getHibernateTemplate().delete(stageReport);
		return true;
	}

	/**
	 * 更新一个BksxTabStagereport对象
	 * 
	 * @param stageReport
	 *            BksxTabStagereport对象
	 * @return boolean
	 */
	public boolean updateStagereport(BksxTabStagereport stageReport) {
		this.getHibernateTemplate().update(stageReport);
		return true;
	}

	/**
	 * 根据项目查找该项目下的所有BksxTabStagereport列表
	 * 
	 * @param project
	 *            项目对象
	 * @return List
	 */
	public List<BksxTabStagereport> getReportListByProject(
			BksxTabProject project) {
		if (project != null) {
			String hql = "from BksxTabStagereport bs where bs.bksxTabProject.FProjId="
					+ project.getFProjId();
			return this.getHibernateTemplate().find(hql);
		} else
			return null;
	}

	/**
	 * 根据项目报告唯一ＩＤ查找BksxTabStagereport对象
	 * 
	 * @param rid
	 *            报告唯一ID
	 * @return BksxTabStagereport
	 */
	public BksxTabStagereport getReportById(int rid) {
		String hql = "from BksxTabStagereport bs where bs.FSid=" + rid;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabStagereport) (this.getHibernateTemplate().find(hql)
					.get(0));
	}

	/**
	 * 根据项目以及开发阶段查找该项目下的所有BksxTabStagereport列表
	 * 
	 * @param project
	 *            项目对象
	 * @param stage
	 *            项目阶段
	 * @return List
	 */
	public List getReportListByStage(BksxTabProject project, String stage) {
		String hql = "from BksxTabStagereport bs where bs.bksxTabProject.FProjId="
				+ project.getFProjId() + " and bs.FReportStage='" + stage + "'";
		return this.getHibernateTemplate().find(hql);
	}

}
