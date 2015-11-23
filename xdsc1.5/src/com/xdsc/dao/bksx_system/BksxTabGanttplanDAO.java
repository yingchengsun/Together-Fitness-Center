package com.xdsc.dao.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabGanttplan;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabGanttplan的相关操作
 */
public interface BksxTabGanttplanDAO {
	/**
	 * 获取BksxTabGanttplan所有对象
	 * 
	 * @param proId
	 *            项目唯一ID
	 * @return List
	 * 
	 */
	public abstract List<BksxTabGanttplan> getGanttplanListByProId(int proId);

	/**
	 * 保存一个BksxTabGanttplan对象
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan对象
	 * @return boolean
	 * 
	 */
	public abstract boolean saveGanttplan(BksxTabGanttplan ganttplan);

	/**
	 * 删除一个BksxTabGanttplan对象
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan对象
	 * @return boolean
	 * 
	 */
	public abstract boolean deleteGanttplan(BksxTabGanttplan ganttplan);

	/**
	 * 更新一个BksxTabGanttplan对象
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan对象
	 * @return boolean
	 * 
	 */
	public abstract boolean updateGanttplan(BksxTabGanttplan ganttplan);

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