package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabWorksummaryDAO;
import com.xdsc.model.BksxTabWorksummary;
import com.xdsc.service.bksx_system.BksxTabWorksummaryManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabWorksummary的相关操作
 */
public class BksxTabWorksummaryManagerImpl implements BksxTabWorksummaryManager {
	/**
	 * BksxTabWorksummaryDAOImpl接口
	 */
	private BksxTabWorksummaryDAO bksxTabWorksummaryDAO;

	/**
	 * bksxTabWorksummaryDAO属性的Get与Set方法
	 */
	public BksxTabWorksummaryDAO getBksxTabWorksummaryDAO() {
		return bksxTabWorksummaryDAO;
	}

	public void setBksxTabWorksummaryDAO(
			BksxTabWorksummaryDAO bksxTabWorksummaryDAO) {
		this.bksxTabWorksummaryDAO = bksxTabWorksummaryDAO;
	}

	/**
	 * 保存一个BksxTabWorksummary对象
	 * 
	 * @param summary
	 *            BksxTabWorksummary对象
	 * @return boolean
	 */
	public boolean saveWorkSummary(BksxTabWorksummary summary) {
		return bksxTabWorksummaryDAO.saveWorkSummary(summary);
	}

	/**
	 * 删除一个BksxTabWorksummary对象
	 * 
	 * @param summary
	 *            BksxTabWorksummary对象
	 * @return boolean
	 */
	public boolean deleteWorkSummary(BksxTabWorksummary summary) {
		return bksxTabWorksummaryDAO.deleteWorkSummary(summary);
	}

	/**
	 * 更新一个BksxTabWorksummary对象
	 * 
	 * @param summary
	 *            BksxTabWorksummary对象
	 * @return boolean
	 */
	public boolean updateWorkSummary(BksxTabWorksummary summary) {
		return bksxTabWorksummaryDAO.updateWorkSummary(summary);
	}

	/**
	 * 根据学生学号得到一个BksxTabWorksummary对象列表
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return List
	 */
	public List<BksxTabWorksummary> getSummaryByStuNum(String stuNum) {
		return bksxTabWorksummaryDAO.getSummaryByStuNum(stuNum);
	}

	/**
	 * 根据工作总结唯一标识ID得到一个BksxTabWorksummary对象
	 * 
	 * @param FWid
	 *            BksxTabWorksummary对象ID
	 * @return BksxTabWorksummary
	 */
	public BksxTabWorksummary getSummaryByID(int FWid) {
		return bksxTabWorksummaryDAO.getSummaryByID(FWid);
	}

	/**
	 * 根据学生学号与工作阶段得到一个BksxTabWorksummary对象列表
	 * 
	 * @param stuNum
	 *            学生学号
	 * @param stage
	 *            工作阶段
	 * @return List
	 */
	public List getSummaryByStage(String stuNum, String stage) {
		return bksxTabWorksummaryDAO.getSummaryByStage(stuNum, stage);
	}

}
