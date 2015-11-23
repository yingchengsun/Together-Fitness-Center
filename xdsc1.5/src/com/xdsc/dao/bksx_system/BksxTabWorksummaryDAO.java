package com.xdsc.dao.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabWorksummary;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabWorksummary的相关操作
 */
public interface BksxTabWorksummaryDAO {
	/**
	 * 保存一个BksxTabWorksummary对象
	 * 
	 * @param summary
	 *            BksxTabWorksummary对象
	 * @return boolean
	 */
	public abstract boolean saveWorkSummary(BksxTabWorksummary summary);

	/**
	 * 删除一个BksxTabWorksummary对象
	 * 
	 * @param summary
	 *            BksxTabWorksummary对象
	 * @return boolean
	 */
	public abstract boolean deleteWorkSummary(BksxTabWorksummary summary);

	/**
	 * 更新一个BksxTabWorksummary对象
	 * 
	 * @param summary
	 *            BksxTabWorksummary对象
	 * @return boolean
	 */
	public abstract boolean updateWorkSummary(BksxTabWorksummary summary);

	/**
	 * 根据学生学号得到一个BksxTabWorksummary对象列表
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return List
	 */
	public abstract List<BksxTabWorksummary> getSummaryByStuNum(String stuNum);

	/**
	 * 根据工作总结唯一标识ID得到一个BksxTabWorksummary对象
	 * 
	 * @param FWid
	 *            BksxTabWorksummary对象ID
	 * @return BksxTabWorksummary
	 */
	public abstract BksxTabWorksummary getSummaryByID(int FWid);

	/**
	 * 根据学生学号与工作阶段得到一个BksxTabWorksummary对象列表
	 * 
	 * @param stuNum
	 *            学生学号
	 * @param stage
	 *            工作阶段
	 * @return List
	 */
	public abstract List getSummaryByStage(String stuNum, String stage);

}