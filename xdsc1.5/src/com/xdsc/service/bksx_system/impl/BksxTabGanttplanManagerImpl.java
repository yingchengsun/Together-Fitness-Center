package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabGanttplanDAO;
import com.xdsc.model.BksxTabGanttplan;
import com.xdsc.service.bksx_system.BksxTabGanttplanManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabGanttplan����ز���
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
	 * ����һ��BksxTabGanttplan����
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan����
	 * @return boolean
	 * 
	 */
	public boolean saveGanttplan(BksxTabGanttplan bksxTabGanttplan) {
		bksxTabGanttplanDAO.saveGanttplan(bksxTabGanttplan);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabGanttplan����
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan����
	 * @return boolean
	 * 
	 */
	public boolean deleteGanttplan(BksxTabGanttplan bksxTabGanttplan) {
		bksxTabGanttplanDAO.deleteGanttplan(bksxTabGanttplan);
		return true;
	}

	/**
	 * ����һ��BksxTabGanttplan����
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan����
	 * @return boolean
	 * 
	 */
	public boolean updateGanttplan(BksxTabGanttplan bksxTabGanttplan) {
		bksxTabGanttplanDAO.updateGanttplan(bksxTabGanttplan);
		return true;
	}

	/**
	 * ��ȡBksxTabGanttplan���ж���
	 * 
	 * @param proId
	 *            ��ĿΨһID
	 * @return List
	 * 
	 */
	public List<BksxTabGanttplan> getGanttplanListByPro(int proId) {
		return bksxTabGanttplanDAO.getGanttplanListByProId(proId);
	}

	/**
	 * ͨ��������ȡһ��BksxTabGanttplan����
	 * 
	 * @param FTaskId
	 *            �ø���ͼĳһ����ID
	 * @return BksxTabGanttplan
	 * 
	 */
	public BksxTabGanttplan getGanttplanById(int FTaskId) {
		return bksxTabGanttplanDAO.getGanttplanById(FTaskId);
	}
}
