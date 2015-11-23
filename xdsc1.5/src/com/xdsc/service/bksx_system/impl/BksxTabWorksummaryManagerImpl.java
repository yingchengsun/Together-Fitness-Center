package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabWorksummaryDAO;
import com.xdsc.model.BksxTabWorksummary;
import com.xdsc.service.bksx_system.BksxTabWorksummaryManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabWorksummary����ز���
 */
public class BksxTabWorksummaryManagerImpl implements BksxTabWorksummaryManager {
	/**
	 * BksxTabWorksummaryDAOImpl�ӿ�
	 */
	private BksxTabWorksummaryDAO bksxTabWorksummaryDAO;

	/**
	 * bksxTabWorksummaryDAO���Ե�Get��Set����
	 */
	public BksxTabWorksummaryDAO getBksxTabWorksummaryDAO() {
		return bksxTabWorksummaryDAO;
	}

	public void setBksxTabWorksummaryDAO(
			BksxTabWorksummaryDAO bksxTabWorksummaryDAO) {
		this.bksxTabWorksummaryDAO = bksxTabWorksummaryDAO;
	}

	/**
	 * ����һ��BksxTabWorksummary����
	 * 
	 * @param summary
	 *            BksxTabWorksummary����
	 * @return boolean
	 */
	public boolean saveWorkSummary(BksxTabWorksummary summary) {
		return bksxTabWorksummaryDAO.saveWorkSummary(summary);
	}

	/**
	 * ɾ��һ��BksxTabWorksummary����
	 * 
	 * @param summary
	 *            BksxTabWorksummary����
	 * @return boolean
	 */
	public boolean deleteWorkSummary(BksxTabWorksummary summary) {
		return bksxTabWorksummaryDAO.deleteWorkSummary(summary);
	}

	/**
	 * ����һ��BksxTabWorksummary����
	 * 
	 * @param summary
	 *            BksxTabWorksummary����
	 * @return boolean
	 */
	public boolean updateWorkSummary(BksxTabWorksummary summary) {
		return bksxTabWorksummaryDAO.updateWorkSummary(summary);
	}

	/**
	 * ����ѧ��ѧ�ŵõ�һ��BksxTabWorksummary�����б�
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return List
	 */
	public List<BksxTabWorksummary> getSummaryByStuNum(String stuNum) {
		return bksxTabWorksummaryDAO.getSummaryByStuNum(stuNum);
	}

	/**
	 * ���ݹ����ܽ�Ψһ��ʶID�õ�һ��BksxTabWorksummary����
	 * 
	 * @param FWid
	 *            BksxTabWorksummary����ID
	 * @return BksxTabWorksummary
	 */
	public BksxTabWorksummary getSummaryByID(int FWid) {
		return bksxTabWorksummaryDAO.getSummaryByID(FWid);
	}

	/**
	 * ����ѧ��ѧ���빤���׶εõ�һ��BksxTabWorksummary�����б�
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @param stage
	 *            �����׶�
	 * @return List
	 */
	public List getSummaryByStage(String stuNum, String stage) {
		return bksxTabWorksummaryDAO.getSummaryByStage(stuNum, stage);
	}

}
