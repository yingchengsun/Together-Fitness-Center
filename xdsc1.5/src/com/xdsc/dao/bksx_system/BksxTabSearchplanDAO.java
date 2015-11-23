package com.xdsc.dao.bksx_system;

import com.xdsc.model.BksxTabSearchplan;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabSearchplan的相关操作
 */
public interface BksxTabSearchplanDAO {

	/**
	 * 保存一个BksxTabSearchplan对象
	 * 
	 * @param plan
	 *            BksxTabSearchplan对象
	 * @return boolean
	 */
	public abstract boolean saveSearchPlan(BksxTabSearchplan plan);

	/**
	 * 更新一个BksxTabSearchplan对象
	 * 
	 * @param plan
	 *            BksxTabSearchplan对象
	 * @return boolean
	 */
	public abstract boolean updateSearchPlan(BksxTabSearchplan plan);

	/**
	 * 删除一个BksxTabSearchplan对象
	 * 
	 * @param plan
	 *            BksxTabSearchplan对象
	 * @return boolean
	 */
	public abstract boolean deleteSearchPlan(BksxTabSearchplan plan);

	/**
	 * 根据学生学号得到一个个人项目研究计划对象
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return BksxTabSearchplan
	 */
	public abstract BksxTabSearchplan getSearchPlanByStuNum(String stuNum);

	/**
	 * 根据记录唯一标示ID得到一个BksxTabSearchplan对象
	 * 
	 * @param planID
	 *            BksxTabSearchplan唯一ID
	 * @return BksxTabSearchplan
	 */
	public abstract BksxTabSearchplan getSearchPlanByID(int planID);

	/**
	 * 根据选题记录ID获得一个BksxTabSearchplan对象
	 * 
	 * @param substuguiID
	 *            选题记录ID
	 * @return BksxTabSearchplan
	 */
	public abstract BksxTabSearchplan getSearchPlanByStustuguiID(int substuguiID);

}