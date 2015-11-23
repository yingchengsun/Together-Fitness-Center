package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabStagereportDAO;
import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabStagereport;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabStagereport����ز���
 */
public class BksxTabStagereportDAOImpl extends HibernateDaoSupport implements
		BksxTabStagereportDAO {
	/**
	 * ����һ��BksxTabStagereport����
	 * 
	 * @param stageReport
	 *            BksxTabStagereport����
	 * @return boolean
	 */
	public boolean saveStagereport(BksxTabStagereport stageReport) {
		this.getHibernateTemplate().save(stageReport);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabStagereport����
	 * 
	 * @param stageReport
	 *            BksxTabStagereport����
	 * @return boolean
	 */
	public boolean deleteStagereport(BksxTabStagereport stageReport) {
		this.getHibernateTemplate().delete(stageReport);
		return true;
	}

	/**
	 * ����һ��BksxTabStagereport����
	 * 
	 * @param stageReport
	 *            BksxTabStagereport����
	 * @return boolean
	 */
	public boolean updateStagereport(BksxTabStagereport stageReport) {
		this.getHibernateTemplate().update(stageReport);
		return true;
	}

	/**
	 * ������Ŀ���Ҹ���Ŀ�µ�����BksxTabStagereport�б�
	 * 
	 * @param project
	 *            ��Ŀ����
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
	 * ������Ŀ����Ψһ�ɣĲ���BksxTabStagereport����
	 * 
	 * @param rid
	 *            ����ΨһID
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
	 * ������Ŀ�Լ������׶β��Ҹ���Ŀ�µ�����BksxTabStagereport�б�
	 * 
	 * @param project
	 *            ��Ŀ����
	 * @param stage
	 *            ��Ŀ�׶�
	 * @return List
	 */
	public List getReportListByStage(BksxTabProject project, String stage) {
		String hql = "from BksxTabStagereport bs where bs.bksxTabProject.FProjId="
				+ project.getFProjId() + " and bs.FReportStage='" + stage + "'";
		return this.getHibernateTemplate().find(hql);
	}

}
