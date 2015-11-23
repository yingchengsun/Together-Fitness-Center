package com.xdsc.service.bksx_system;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabGanttplanDAO;
import com.xdsc.model.BksxTabGanttplan;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabGanttplan的相关操作
 */
public interface BksxTabGanttplanManager {

	public abstract BksxTabGanttplanDAO getBksxTabGanttplanDAO();

	public abstract void setBksxTabGanttplanDAO(
			BksxTabGanttplanDAO bksxTabGanttplanDAO);

	/**
	 * 保存一个BksxTabGanttplan对象
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan对象
	 * @return boolean
	 * 
	 */
	public abstract boolean saveGanttplan(BksxTabGanttplan bksxTabGanttplan);

	/**
	 * 删除一个BksxTabGanttplan对象
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan对象
	 * @return boolean
	 * 
	 */
	public abstract boolean deleteGanttplan(BksxTabGanttplan bksxTabGanttplan);

	/**
	 * 更新一个BksxTabGanttplan对象
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan对象
	 * @return boolean
	 * 
	 */
	public abstract boolean updateGanttplan(BksxTabGanttplan bksxTabGanttplan);

	/**
	 * 获取BksxTabGanttplan所有对象
	 * 
	 * @param proId
	 *            项目唯一ID
	 * @return List
	 * 
	 */
	public abstract List<BksxTabGanttplan> getGanttplanListByPro(int proId);

	/**
	 * 通过主键获取一个BksxTabGanttplan对象
	 * 
	 * @param FTaskId
	 *            该甘特图某一任务ID
	 * @return BksxTabGanttplan
	 * 
	 */
	public abstract BksxTabGanttplan getGanttplanById(int FTaskId);

}