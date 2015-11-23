package com.xdsc.service.bksx_system.impl;

import com.xdsc.dao.bksx_system.BksxTabSearchplanDAO;
import com.xdsc.model.BksxTabSearchplan;
import com.xdsc.service.bksx_system.BksxTabSearchplanManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabSearchplan的相关操作
 */
public class BksxTabSearchplanManagerImpl implements BksxTabSearchplanManager {
	/**
	 * BksxTabSearchplanDAOImpl的接口
	 */
	private BksxTabSearchplanDAO bksxTabSearchplanDAO;

	/**
	 * bksxTabSearchplanDAO的Get与Set方法
	 */
	public BksxTabSearchplanDAO getBksxTabSearchplanDAO() {
		return bksxTabSearchplanDAO;
	}

	public void setBksxTabSearchplanDAO(
			BksxTabSearchplanDAO bksxTabSearchplanDAO) {
		this.bksxTabSearchplanDAO = bksxTabSearchplanDAO;
	}

	/**
	 * 保存一个BksxTabSearchplan对象
	 * 
	 * @param plan
	 *            BksxTabSearchplan对象
	 * @return boolean
	 */
	public boolean saveSearchPlan(BksxTabSearchplan plan) {
		return bksxTabSearchplanDAO.saveSearchPlan(plan);
	}

	/**
	 * 更新一个BksxTabSearchplan对象
	 * 
	 * @param plan
	 *            BksxTabSearchplan对象
	 * @return boolean
	 */
	public boolean updateSearchPlan(BksxTabSearchplan plan) {
		return bksxTabSearchplanDAO.updateSearchPlan(plan);
	}

	/**
	 * 删除一个BksxTabSearchplan对象
	 * 
	 * @param plan
	 *            BksxTabSearchplan对象
	 * @return boolean
	 */
	public boolean deleteSearchPlan(BksxTabSearchplan plan) {
		return bksxTabSearchplanDAO.deleteSearchPlan(plan);
	}

	/**
	 * 根据学生学号得到一个个人项目研究计划对象
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return BksxTabSearchplan
	 */
	public BksxTabSearchplan getSearchPlanByStuNum(String stuNum) {
		return bksxTabSearchplanDAO.getSearchPlanByStuNum(stuNum);
	}

	/**
	 * 根据记录唯一标示ID得到一个BksxTabSearchplan对象
	 * 
	 * @param planID
	 *            BksxTabSearchplan唯一ID
	 * @return BksxTabSearchplan
	 */
	public BksxTabSearchplan getSearchPlanByID(int planID) {
		return this.getBksxTabSearchplanDAO().getSearchPlanByID(planID);
	}

	/**
	 * 根据选题记录ID获得一个BksxTabSearchplan对象
	 * 
	 * @param substuguiID
	 *            选题记录ID
	 * @return BksxTabSearchplan
	 */
	public BksxTabSearchplan getSearchPlanByStustuguiID(int substuguiID) {
		return bksxTabSearchplanDAO.getSearchPlanByStustuguiID(substuguiID);
	}
}
