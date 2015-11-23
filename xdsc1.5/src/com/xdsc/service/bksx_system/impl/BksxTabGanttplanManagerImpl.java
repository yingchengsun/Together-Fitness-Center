package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabGanttplanDAO;
import com.xdsc.model.BksxTabGanttplan;
import com.xdsc.service.bksx_system.BksxTabGanttplanManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabGanttplan的相关操作
 */
public class BksxTabGanttplanManagerImpl implements BksxTabGanttplanManager {
	private BksxTabGanttplanDAO bksxTabGanttplanDAO;

	public BksxTabGanttplanDAO getBksxTabGanttplanDAO() {
		return bksxTabGanttplanDAO;
	}

	public void setBksxTabGanttplanDAO(BksxTabGanttplanDAO bksxTabGanttplanDAO) {
		this.bksxTabGanttplanDAO = bksxTabGanttplanDAO;
	}

	/**
	 * 保存一个BksxTabGanttplan对象
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan对象
	 * @return boolean
	 * 
	 */
	public boolean saveGanttplan(BksxTabGanttplan bksxTabGanttplan) {
		bksxTabGanttplanDAO.saveGanttplan(bksxTabGanttplan);
		return true;
	}

	/**
	 * 删除一个BksxTabGanttplan对象
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan对象
	 * @return boolean
	 * 
	 */
	public boolean deleteGanttplan(BksxTabGanttplan bksxTabGanttplan) {
		bksxTabGanttplanDAO.deleteGanttplan(bksxTabGanttplan);
		return true;
	}

	/**
	 * 更新一个BksxTabGanttplan对象
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan对象
	 * @return boolean
	 * 
	 */
	public boolean updateGanttplan(BksxTabGanttplan bksxTabGanttplan) {
		bksxTabGanttplanDAO.updateGanttplan(bksxTabGanttplan);
		return true;
	}

	/**
	 * 获取BksxTabGanttplan所有对象
	 * 
	 * @param proId
	 *            项目唯一ID
	 * @return List
	 * 
	 */
	public List<BksxTabGanttplan> getGanttplanListByPro(int proId) {
		return bksxTabGanttplanDAO.getGanttplanListByProId(proId);
	}

	/**
	 * 通过主键获取一个BksxTabGanttplan对象
	 * 
	 * @param FTaskId
	 *            该甘特图某一任务ID
	 * @return BksxTabGanttplan
	 * 
	 */
	public BksxTabGanttplan getGanttplanById(int FTaskId) {
		return bksxTabGanttplanDAO.getGanttplanById(FTaskId);
	}
}
