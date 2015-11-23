package com.xdsc.dao.bksx_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabProjectDAO;
import com.xdsc.model.BksxTabProject;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶���Ŀ��صĲ���
 */
public class BksxTabProjectDAOImpl extends HibernateDaoSupport implements
		BksxTabProjectDAO {
	/**
	 * ������ĿID�õ�һ��BksxTabProject����
	 * 
	 * @param proId
	 *            ��ĿID
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
	 * ����һ��BksxTabProject����
	 * 
	 * @param project
	 *            ��Ŀ����
	 * @return boolean
	 */
	public boolean saveProject(BksxTabProject project) {
		this.getHibernateTemplate().save(project);
		return true;
	}

	/**
	 * ����һ��BksxTabProject����
	 * 
	 * @param bksxTabProject
	 *            ��Ŀ����
	 * @return
	 */
	public void updateProject(BksxTabProject bksxTabProject) {
		this.getHibernateTemplate().update(bksxTabProject);
	}

	/**
	 * �õ�������Ŀ�б�
	 * 
	 * @return List
	 */
	public List getProjectList() {
		String hql = "from BksxTabProject";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ���ݲ�ѯHQL���õ�һ����Ŀ�б�
	 * 
	 * @param hql
	 *            HQL���
	 * @return List
	 */
	public List getProjectList(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * �����꼶�����Եõ�һ����Ŀ�б�
	 * 
	 * @param startDate
	 *            ��ʼʱ��
	 * @param endDate
	 *            ����ʱ��
	 * @param attributeType
	 *            ������
	 * @param attribute
	 *            ����ֵ
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
