package com.xdsc.dao.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabWorksummary;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabWorksummary����ز���
 */
public interface BksxTabWorksummaryDAO {
	/**
	 * ����һ��BksxTabWorksummary����
	 * 
	 * @param summary
	 *            BksxTabWorksummary����
	 * @return boolean
	 */
	public abstract boolean saveWorkSummary(BksxTabWorksummary summary);

	/**
	 * ɾ��һ��BksxTabWorksummary����
	 * 
	 * @param summary
	 *            BksxTabWorksummary����
	 * @return boolean
	 */
	public abstract boolean deleteWorkSummary(BksxTabWorksummary summary);

	/**
	 * ����һ��BksxTabWorksummary����
	 * 
	 * @param summary
	 *            BksxTabWorksummary����
	 * @return boolean
	 */
	public abstract boolean updateWorkSummary(BksxTabWorksummary summary);

	/**
	 * ����ѧ��ѧ�ŵõ�һ��BksxTabWorksummary�����б�
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return List
	 */
	public abstract List<BksxTabWorksummary> getSummaryByStuNum(String stuNum);

	/**
	 * ���ݹ����ܽ�Ψһ��ʶID�õ�һ��BksxTabWorksummary����
	 * 
	 * @param FWid
	 *            BksxTabWorksummary����ID
	 * @return BksxTabWorksummary
	 */
	public abstract BksxTabWorksummary getSummaryByID(int FWid);

	/**
	 * ����ѧ��ѧ���빤���׶εõ�һ��BksxTabWorksummary�����б�
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @param stage
	 *            �����׶�
	 * @return List
	 */
	public abstract List getSummaryByStage(String stuNum, String stage);

}