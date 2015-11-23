package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabStagereportDAO;
import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabStagereport;
import com.xdsc.service.bksx_system.BksxTabStagereportManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabStagereport的相关操作
 */
public class BksxTabStagereportManagerImpl implements BksxTabStagereportManager {
	/**
	 * BksxTabStagereportDAOImpl接口
	 */
	private BksxTabStagereportDAO bksxTabStagereportDAO;

	/**
	 * bksxTabStagereportDAO属性的Get与Set方法
	 */
	public BksxTabStagereportDAO getBksxTabStagereportDAO() {
		return bksxTabStagereportDAO;
	}

	public void setBksxTabStagereportDAO(
			BksxTabStagereportDAO bksxTabStagereportDAO) {
		this.bksxTabStagereportDAO = bksxTabStagereportDAO;
	}

	/**
	 * 保存一个BksxTabStagereport对象
	 * 
	 * @param stageReport
	 *            BksxTabStagereport对象
	 * @return boolean
	 */
	public boolean saveStagereport(BksxTabStagereport stageReport) {
		return bksxTabStagereportDAO.saveStagereport(stageReport);
	}

	/**
	 * 删除一个BksxTabStagereport对象
	 * 
	 * @param stageReport
	 *            BksxTabStagereport对象
	 * @return boolean
	 */
	public boolean deleteStagereport(BksxTabStagereport stageReport) {
		return bksxTabStagereportDAO.deleteStagereport(stageReport);
	}

	/**
	 * 更新一个BksxTabStagereport对象
	 * 
	 * @param stageReport
	 *            BksxTabStagereport对象
	 * @return boolean
	 */
	public boolean updateStagereport(BksxTabStagereport stageReport) {
		return bksxTabStagereportDAO.updateStagereport(stageReport);
	}

	/**
	 * 根据项目查找该项目下的所有BksxTabStagereport列表
	 * 
	 * @param project
	 *            项目对象
	 * @return List
	 */
	public List<BksxTabStagereport> getReportListByProject(
			BksxTabProject project) {
		return bksxTabStagereportDAO.getReportListByProject(project);
	}

	/**
	 * 根据项目报告唯一ＩＤ查找BksxTabStagereport对象
	 * 
	 * @param rid
	 *            报告唯一ID
	 * @return BksxTabStagereport
	 */
	public BksxTabStagereport getReportById(int rid) {
		return bksxTabStagereportDAO.getReportById(rid);
	}

	/**
	 * 根据项目以及开发阶段查找该项目下的所有BksxTabStagereport列表
	 * 
	 * @param project
	 *            项目对象
	 * @param stage
	 *            项目阶段
	 * @return List
	 */
	public List getReportListByStage(BksxTabProject project, String stage) {
		return bksxTabStagereportDAO.getReportListByStage(project, stage);
	}
}
