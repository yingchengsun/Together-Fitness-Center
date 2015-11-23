package com.xdsc.service.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabStagereport;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabStagereport����ز���
 */
public interface BksxTabStagereportManager {

	/**
	 * ����һ��BksxTabStagereport����
	 * 
	 * @param stageReport
	 *            BksxTabStagereport����
	 * @return boolean
	 */
	public abstract boolean saveStagereport(BksxTabStagereport stageReport);

	/**
	 * ɾ��һ��BksxTabStagereport����
	 * 
	 * @param stageReport
	 *            BksxTabStagereport����
	 * @return boolean
	 */
	public abstract boolean deleteStagereport(BksxTabStagereport stageReport);

	/**
	 * ����һ��BksxTabStagereport����
	 * 
	 * @param stageReport
	 *            BksxTabStagereport����
	 * @return boolean
	 */
	public abstract boolean updateStagereport(BksxTabStagereport stageReport);

	/**
	 * ������Ŀ���Ҹ���Ŀ�µ�����BksxTabStagereport�б�
	 * 
	 * @param project
	 *            ��Ŀ����
	 * @return List
	 */
	public abstract List<BksxTabStagereport> getReportListByProject(
			BksxTabProject project);

	/**
	 * ������Ŀ����Ψһ�ɣĲ���BksxTabStagereport����
	 * 
	 * @param rid
	 *            ����ΨһID
	 * @return BksxTabStagereport
	 */
	public abstract BksxTabStagereport getReportById(int rid);

	/**
	 * ������Ŀ�Լ������׶β��Ҹ���Ŀ�µ�����BksxTabStagereport�б�
	 * 
	 * @param project
	 *            ��Ŀ����
	 * @param stage
	 *            ��Ŀ�׶�
	 * @return List
	 */
	public abstract List getReportListByStage(BksxTabProject project,
			String stage);

}