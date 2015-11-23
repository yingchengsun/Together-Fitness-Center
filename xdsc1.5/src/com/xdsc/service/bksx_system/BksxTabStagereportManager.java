package com.xdsc.service.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabStagereport;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabStagereport的相关操作
 */
public interface BksxTabStagereportManager {

	/**
	 * 保存一个BksxTabStagereport对象
	 * 
	 * @param stageReport
	 *            BksxTabStagereport对象
	 * @return boolean
	 */
	public abstract boolean saveStagereport(BksxTabStagereport stageReport);

	/**
	 * 删除一个BksxTabStagereport对象
	 * 
	 * @param stageReport
	 *            BksxTabStagereport对象
	 * @return boolean
	 */
	public abstract boolean deleteStagereport(BksxTabStagereport stageReport);

	/**
	 * 更新一个BksxTabStagereport对象
	 * 
	 * @param stageReport
	 *            BksxTabStagereport对象
	 * @return boolean
	 */
	public abstract boolean updateStagereport(BksxTabStagereport stageReport);

	/**
	 * 根据项目查找该项目下的所有BksxTabStagereport列表
	 * 
	 * @param project
	 *            项目对象
	 * @return List
	 */
	public abstract List<BksxTabStagereport> getReportListByProject(
			BksxTabProject project);

	/**
	 * 根据项目报告唯一ＩＤ查找BksxTabStagereport对象
	 * 
	 * @param rid
	 *            报告唯一ID
	 * @return BksxTabStagereport
	 */
	public abstract BksxTabStagereport getReportById(int rid);

	/**
	 * 根据项目以及开发阶段查找该项目下的所有BksxTabStagereport列表
	 * 
	 * @param project
	 *            项目对象
	 * @param stage
	 *            项目阶段
	 * @return List
	 */
	public abstract List getReportListByStage(BksxTabProject project,
			String stage);

}