package com.xdsc.service.bksx_system.impl;

import com.xdsc.dao.bksx_system.BksxTabSearchplanDAO;
import com.xdsc.model.BksxTabSearchplan;
import com.xdsc.service.bksx_system.BksxTabSearchplanManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabSearchplan����ز���
 */
public class BksxTabSearchplanManagerImpl implements BksxTabSearchplanManager {
	/**
	 * BksxTabSearchplanDAOImpl�Ľӿ�
	 */
	private BksxTabSearchplanDAO bksxTabSearchplanDAO;

	/**
	 * bksxTabSearchplanDAO��Get��Set����
	 */
	public BksxTabSearchplanDAO getBksxTabSearchplanDAO() {
		return bksxTabSearchplanDAO;
	}

	public void setBksxTabSearchplanDAO(
			BksxTabSearchplanDAO bksxTabSearchplanDAO) {
		this.bksxTabSearchplanDAO = bksxTabSearchplanDAO;
	}

	/**
	 * ����һ��BksxTabSearchplan����
	 * 
	 * @param plan
	 *            BksxTabSearchplan����
	 * @return boolean
	 */
	public boolean saveSearchPlan(BksxTabSearchplan plan) {
		return bksxTabSearchplanDAO.saveSearchPlan(plan);
	}

	/**
	 * ����һ��BksxTabSearchplan����
	 * 
	 * @param plan
	 *            BksxTabSearchplan����
	 * @return boolean
	 */
	public boolean updateSearchPlan(BksxTabSearchplan plan) {
		return bksxTabSearchplanDAO.updateSearchPlan(plan);
	}

	/**
	 * ɾ��һ��BksxTabSearchplan����
	 * 
	 * @param plan
	 *            BksxTabSearchplan����
	 * @return boolean
	 */
	public boolean deleteSearchPlan(BksxTabSearchplan plan) {
		return bksxTabSearchplanDAO.deleteSearchPlan(plan);
	}

	/**
	 * ����ѧ��ѧ�ŵõ�һ��������Ŀ�о��ƻ�����
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return BksxTabSearchplan
	 */
	public BksxTabSearchplan getSearchPlanByStuNum(String stuNum) {
		return bksxTabSearchplanDAO.getSearchPlanByStuNum(stuNum);
	}

	/**
	 * ���ݼ�¼Ψһ��ʾID�õ�һ��BksxTabSearchplan����
	 * 
	 * @param planID
	 *            BksxTabSearchplanΨһID
	 * @return BksxTabSearchplan
	 */
	public BksxTabSearchplan getSearchPlanByID(int planID) {
		return this.getBksxTabSearchplanDAO().getSearchPlanByID(planID);
	}

	/**
	 * ����ѡ���¼ID���һ��BksxTabSearchplan����
	 * 
	 * @param substuguiID
	 *            ѡ���¼ID
	 * @return BksxTabSearchplan
	 */
	public BksxTabSearchplan getSearchPlanByStustuguiID(int substuguiID) {
		return bksxTabSearchplanDAO.getSearchPlanByStustuguiID(substuguiID);
	}
}
