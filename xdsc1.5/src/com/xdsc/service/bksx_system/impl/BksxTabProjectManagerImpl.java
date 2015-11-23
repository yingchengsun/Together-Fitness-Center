package com.xdsc.service.bksx_system.impl;

import java.util.Date;
import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabProjectDAO;
import com.xdsc.model.BksxTabProject;
import com.xdsc.service.bksx_system.BksxTabProjectManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶���Ŀ��صĲ���
 */
public class BksxTabProjectManagerImpl implements BksxTabProjectManager {
	BksxTabProjectDAO bksxTabProjectDAO;

	public BksxTabProjectDAO getBksxTabProjectDAO() {
		return bksxTabProjectDAO;
	}

	public void setBksxTabProjectDAO(BksxTabProjectDAO bksxTabProjectDAO) {
		this.bksxTabProjectDAO = bksxTabProjectDAO;
	}

	/**
	 * ������ĿID�õ�һ��BksxTabProject����
	 * 
	 * @param proId
	 *            ��ĿID
	 * @return BksxTabProject
	 */
	public BksxTabProject getProjectById(int proId) {
		return bksxTabProjectDAO.getProjectById(proId);
	}

	/**
	 * ����һ��BksxTabProject����
	 * 
	 * @param project
	 *            ��Ŀ����
	 * @return boolean
	 */
	public boolean saveProject(BksxTabProject project) {
		return bksxTabProjectDAO.saveProject(project);
	}

	/**
	 * ����һ��BksxTabProject����
	 * 
	 * @param bksxTabProject
	 *            ��Ŀ����
	 * @return
	 */
	public void updateProject(BksxTabProject bksxTabProject) {
		bksxTabProjectDAO.updateProject(bksxTabProject);
	}

	/**
	 * �õ�������Ŀ�б�
	 * 
	 * @return List
	 */
	public List getProjectList() {
		return bksxTabProjectDAO.getProjectList();
	}

	/**
	 * ���ݲ�ѯHQL���õ�һ����Ŀ�б�
	 * 
	 * @param hql
	 *            HQL���
	 * @return List
	 */
	public List getProjectList(String hql) {
		return bksxTabProjectDAO.getProjectList(hql);
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
		return bksxTabProjectDAO.getProjectByGradeAttribute(startDate, endDate,
				attributeType, attribute);
	}
}
