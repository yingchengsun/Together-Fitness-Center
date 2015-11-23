package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabTeamapplyDAO;
import com.xdsc.model.BksxTabTeam;
import com.xdsc.model.BksxTabTeamapply;
import com.xdsc.service.bksx_system.BksxTabTeamapplyManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabTeamapply����ز���
 */
public class BksxTabTeamapplyManagerImpl implements BksxTabTeamapplyManager {
	/**
	 * BksxTabTeamapplyDAOImpl����
	 */
	private BksxTabTeamapplyDAO bksxTabTeamapplyDAO;

	/**
	 * bksxTabTeamapplyDAO����Get��set����
	 */
	public BksxTabTeamapplyDAO getBksxTabTeamapplyDAO() {
		return bksxTabTeamapplyDAO;
	}

	public void setBksxTabTeamapplyDAO(BksxTabTeamapplyDAO bksxTabTeamapplyDAO) {
		this.bksxTabTeamapplyDAO = bksxTabTeamapplyDAO;
	}

	/**
	 * ����һ��BksxTabTeamapply����
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply����
	 * @return boolean
	 */
	public boolean saveApplyInfo(BksxTabTeamapply applyInfo) {
		return bksxTabTeamapplyDAO.saveApplyInfo(applyInfo);
	}

	/**
	 * ɾ��һ��BksxTabTeamapply����
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply����
	 * @return boolean
	 */
	public boolean deleteApplyInfo(BksxTabTeamapply applyInfo) {
		return bksxTabTeamapplyDAO.deleteApplyInfo(applyInfo);
	}

	/**
	 * ����һ��BksxTabTeamapply����
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply����
	 * @return boolean
	 */
	public boolean updateApplyInfo(BksxTabTeamapply applyInfo) {
		return bksxTabTeamapplyDAO.updateApplyInfo(applyInfo);
	}

	/**
	 * ����Team����õ������Team��������Ϣ�б�
	 * 
	 * @param team
	 *            BksxTabTeam����
	 * @return List
	 */
	public List<BksxTabTeamapply> getApplyInfoByTeam(BksxTabTeam team) {
		return bksxTabTeamapplyDAO.getApplyInfoByTeam(team);
	}

	/**
	 * ����ѧ��ѧ�ŵõ����������������Ϣ�б�
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return List
	 */
	public List<BksxTabTeamapply> getApplyInfoByStuNum(String stuNum) {
		return bksxTabTeamapplyDAO.getApplyInfoByStuNum(stuNum);
	}

	/**
	 * ����������ϢΨһID�õ�����Ϣ�Ķ���
	 * 
	 * @param applyID
	 *            ������ϢΨһ�ɣ�
	 * @return BksxTabTeamapply
	 */
	public BksxTabTeamapply getApplyInfoById(int applyID) {
		return bksxTabTeamapplyDAO.getApplyInfoById(applyID);
	}

	/**
	 * ����ѧ��ѧ���Լ�����״̬�Լ�����ID�õ�����Ϣ�Ķ���
	 * 
	 * @param teamID
	 *            ����ID
	 * @param status
	 *            ��׼״̬
	 * @param studentNumber
	 *            ѧ��ѧ��
	 * @return BksxTabTeamapply
	 */
	public BksxTabTeamapply getApplyInfoByStuNumStatus(String studentNumber,
			String status, int teamID) {
		return bksxTabTeamapplyDAO.getApplyInfoByStuNumStatus(studentNumber,
				status, teamID);
	}
}
