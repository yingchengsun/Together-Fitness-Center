package com.xdsc.dao.bksx_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.BksxTabProject;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶���Ŀ��صĲ���
 */
public interface BksxTabProjectDAO {

	/**
	 * ������ĿID�õ�һ��BksxTabProject����
	 * 
	 * @param proId
	 *            ��ĿID
	 * @return BksxTabProject
	 */
	public abstract BksxTabProject getProjectById(int proId);

	/**
	 * ����һ��BksxTabProject����
	 * 
	 * @param project
	 *            ��Ŀ����
	 * @return boolean
	 */
	public abstract boolean saveProject(BksxTabProject project);

	/**
	 * ����һ��BksxTabProject����
	 * 
	 * @param bksxTabProject
	 *            ��Ŀ����
	 * @return
	 */
	public abstract void updateProject(BksxTabProject bksxTabProject);

	/**
	 * �õ�������Ŀ�б�
	 * 
	 * @return List
	 */
	public abstract List getProjectList();

	/**
	 * ���ݲ�ѯHQL���õ�һ����Ŀ�б�
	 * 
	 * @param hql
	 *            HQL���
	 * @return List
	 */
	public abstract List getProjectList(String hql);

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
	public abstract List getProjectByGradeAttribute(Date startDate,
			Date endDate, String attributeType, String attribute);

}