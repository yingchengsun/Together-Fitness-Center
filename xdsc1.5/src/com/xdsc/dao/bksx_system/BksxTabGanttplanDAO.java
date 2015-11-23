package com.xdsc.dao.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabGanttplan;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabGanttplan����ز���
 */
public interface BksxTabGanttplanDAO {
	/**
	 * ��ȡBksxTabGanttplan���ж���
	 * 
	 * @param proId
	 *            ��ĿΨһID
	 * @return List
	 * 
	 */
	public abstract List<BksxTabGanttplan> getGanttplanListByProId(int proId);

	/**
	 * ����һ��BksxTabGanttplan����
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan����
	 * @return boolean
	 * 
	 */
	public abstract boolean saveGanttplan(BksxTabGanttplan ganttplan);

	/**
	 * ɾ��һ��BksxTabGanttplan����
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan����
	 * @return boolean
	 * 
	 */
	public abstract boolean deleteGanttplan(BksxTabGanttplan ganttplan);

	/**
	 * ����һ��BksxTabGanttplan����
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan����
	 * @return boolean
	 * 
	 */
	public abstract boolean updateGanttplan(BksxTabGanttplan ganttplan);

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