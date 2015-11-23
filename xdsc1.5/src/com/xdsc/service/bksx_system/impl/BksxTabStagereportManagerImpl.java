package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabStagereportDAO;
import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabStagereport;
import com.xdsc.service.bksx_system.BksxTabStagereportManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabStagereport����ز���
 */
public class BksxTabStagereportManagerImpl implements BksxTabStagereportManager {
	/**
	 * BksxTabStagereportDAOImpl�ӿ�
	 */
	private BksxTabStagereportDAO bksxTabStagereportDAO;

	/**
	 * bksxTabStagereportDAO���Ե�Get��Set����
	 */
	public BksxTabStagereportDAO getBksxTabStagereportDAO() {
		return bksxTabStagereportDAO;
	}

	public void setBksxTabStagereportDAO(
			BksxTabStagereportDAO bksxTabStagereportDAO) {
		this.bksxTabStagereportDAO = bksxTabStagereportDAO;
	}

	/**
	 * ����һ��BksxTabStagereport����
	 * 
	 * @param stageReport
	 *            BksxTabStagereport����
	 * @return boolean
	 */
	public boolean saveStagereport(BksxTabStagereport stageReport) {
		return bksxTabStagereportDAO.saveStagereport(stageReport);
	}

	/**
	 * ɾ��һ��BksxTabStagereport����
	 * 
	 * @param stageReport
	 *            BksxTabStagereport����
	 * @return boolean
	 */
	public boolean deleteStagereport(BksxTabStagereport stageReport) {
		return bksxTabStagereportDAO.deleteStagereport(stageReport);
	}

	/**
	 * ����һ��BksxTabStagereport����
	 * 
	 * @param stageReport
	 *            BksxTabStagereport����
	 * @return boolean
	 */
	public boolean updateStagereport(BksxTabStagereport stageReport) {
		return bksxTabStagereportDAO.updateStagereport(stageReport);
	}

	/**
	 * ������Ŀ���Ҹ���Ŀ�µ�����BksxTabStagereport�б�
	 * 
	 * @param project
	 *            ��Ŀ����
	 * @return List
	 */
	public List<BksxTabStagereport> getReportListByProject(
			BksxTabProject project) {
		return bksxTabStagereportDAO.getReportListByProject(project);
	}

	/**
	 * ������Ŀ����Ψһ�ɣĲ���BksxTabStagereport����
	 * 
	 * @param rid
	 *            ����ΨһID
	 * @return BksxTabStagereport
	 */
	public BksxTabStagereport getReportById(int rid) {
		return bksxTabStagereportDAO.getReportById(rid);
	}

	/**
	 * ������Ŀ�Լ������׶β��Ҹ���Ŀ�µ�����BksxTabStagereport�б�
	 * 
	 * @param project
	 *            ��Ŀ����
	 * @param stage
	 *            ��Ŀ�׶�
	 * @return List
	 */
	public List getReportListByStage(BksxTabProject project, String stage) {
		return bksxTabStagereportDAO.getReportListByStage(project, stage);
	}
}
