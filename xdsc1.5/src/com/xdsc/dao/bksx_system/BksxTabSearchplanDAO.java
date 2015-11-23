package com.xdsc.dao.bksx_system;

import com.xdsc.model.BksxTabSearchplan;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabSearchplan����ز���
 */
public interface BksxTabSearchplanDAO {

	/**
	 * ����һ��BksxTabSearchplan����
	 * 
	 * @param plan
	 *            BksxTabSearchplan����
	 * @return boolean
	 */
	public abstract boolean saveSearchPlan(BksxTabSearchplan plan);

	/**
	 * ����һ��BksxTabSearchplan����
	 * 
	 * @param plan
	 *            BksxTabSearchplan����
	 * @return boolean
	 */
	public abstract boolean updateSearchPlan(BksxTabSearchplan plan);

	/**
	 * ɾ��һ��BksxTabSearchplan����
	 * 
	 * @param plan
	 *            BksxTabSearchplan����
	 * @return boolean
	 */
	public abstract boolean deleteSearchPlan(BksxTabSearchplan plan);

	/**
	 * ����ѧ��ѧ�ŵõ�һ��������Ŀ�о��ƻ�����
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return BksxTabSearchplan
	 */
	public abstract BksxTabSearchplan getSearchPlanByStuNum(String stuNum);

	/**
	 * ���ݼ�¼Ψһ��ʾID�õ�һ��BksxTabSearchplan����
	 * 
	 * @param planID
	 *            BksxTabSearchplanΨһID
	 * @return BksxTabSearchplan
	 */
	public abstract BksxTabSearchplan getSearchPlanByID(int planID);

	/**
	 * ����ѡ���¼ID���һ��BksxTabSearchplan����
	 * 
	 * @param substuguiID
	 *            ѡ���¼ID
	 * @return BksxTabSearchplan
	 */
	public abstract BksxTabSearchplan getSearchPlanByStustuguiID(int substuguiID);

}