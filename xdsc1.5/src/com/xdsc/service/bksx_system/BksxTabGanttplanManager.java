package com.xdsc.service.bksx_system;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabGanttplanDAO;
import com.xdsc.model.BksxTabGanttplan;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabGanttplan����ز���
 */
public interface BksxTabGanttplanManager {

	public abstract BksxTabGanttplanDAO getBksxTabGanttplanDAO();

	public abstract void setBksxTabGanttplanDAO(
			BksxTabGanttplanDAO bksxTabGanttplanDAO);

	/**
	 * ����һ��BksxTabGanttplan����
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan����
	 * @return boolean
	 * 
	 */
	public abstract boolean saveGanttplan(BksxTabGanttplan bksxTabGanttplan);

	/**
	 * ɾ��һ��BksxTabGanttplan����
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan����
	 * @return boolean
	 * 
	 */
	public abstract boolean deleteGanttplan(BksxTabGanttplan bksxTabGanttplan);

	/**
	 * ����һ��BksxTabGanttplan����
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan����
	 * @return boolean
	 * 
	 */
	public abstract boolean updateGanttplan(BksxTabGanttplan bksxTabGanttplan);

	/**
	 * ��ȡBksxTabGanttplan���ж���
	 * 
	 * @param proId
	 *            ��ĿΨһID
	 * @return List
	 * 
	 */
	public abstract List<BksxTabGanttplan> getGanttplanListByPro(int proId);

	/**
	 * ͨ��������ȡһ��BksxTabGanttplan����
	 * 
	 * @param FTaskId
	 *            �ø���ͼĳһ����ID
	 * @return BksxTabGanttplan
	 * 
	 */
	public abstract BksxTabGanttplan getGanttplanById(int FTaskId);

}