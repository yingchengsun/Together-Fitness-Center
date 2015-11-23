package com.xdsc.service.bksx_system.impl;

import java.util.Date;
import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabTeamDAO;
import com.xdsc.model.BksxTabTeam;
import com.xdsc.service.bksx_system.BksxTabTeamManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabTeam����ز���
 */
public class BksxTabTeamManagerImpl implements BksxTabTeamManager {
	/**
	 * BksxTabTeamDAOImpl�Ľӿ�
	 */
	private BksxTabTeamDAO bksxTabTeamDAO;

	/**
	 * bksxTabTeamDAO���Ե�Get��Set����
	 */
	public BksxTabTeamDAO getBksxTabTeamDAO() {
		return bksxTabTeamDAO;
	}

	public void setBksxTabTeamDAO(BksxTabTeamDAO bksxTabTeamDAO) {
		this.bksxTabTeamDAO = bksxTabTeamDAO;
	}

	/**
	 * ����һ��BksxTabTeam����
	 * 
	 * @param team
	 *            BksxTabTeam����
	 * @return boolean
	 */
	public boolean saveTeam(BksxTabTeam team) {
		return bksxTabTeamDAO.saveTeam(team);
	}

	/**
	 * �õ����е�BksxTabTeam�����б�
	 * 
	 * @return List
	 */
	public List getTeamList() {
		return bksxTabTeamDAO.getTeamList();
	}

	/**
	 * ����teamΨһ��ʶID�õ�һ��BksxTabTeam����
	 * 
	 * @param teamId
	 *            BksxTabTeam����ID
	 * @return BksxTabTeam
	 */
	public BksxTabTeam getTeamById(int teamId) {
		return bksxTabTeamDAO.getTeamById(teamId);
	}

	/**
	 * ����team���Ƶõ�һ��BksxTabTeam����
	 * 
	 * @param teamName
	 *            BksxTabTeam��������
	 * @return BksxTabTeam
	 */
	public BksxTabTeam getTeamByName(String teamName) {
		return bksxTabTeamDAO.getTeamByName(teamName);
	}

	/**
	 * ����һ��BksxTabTeam����
	 * 
	 * @param team
	 *            BksxTabTeam����
	 * @return boolean
	 */
	public void updateTeam(BksxTabTeam team) {
		bksxTabTeamDAO.updateTeam(team);
	}

	/**
	 * ����team���Ƶ��ֶ�ģ������һ��BksxTabTeam�����б�
	 * 
	 * @param teamName
	 *            BksxTabTeam�������Ƶ�ȫ���򲿷��ֶ�
	 * @return List
	 */
	public List<BksxTabTeam> getTeamListByName(String teamName) {
		return bksxTabTeamDAO.getTeamList(teamName);
	}

	/**
	 * ����team������ʱ�����һ��BksxTabTeam�����б�
	 * 
	 * @param startDate
	 *            ʱ�����俪ʼ����
	 * @param endDate
	 *            ʱ�������������
	 * @return List
	 */
	public List<BksxTabTeam> getTeamListByDate(Date startDate, Date endDate) {
		return bksxTabTeamDAO.getTeamListByDate(startDate, endDate);
	}

	/**
	 * ɾ��һ��BksxTabTeam����
	 * 
	 * @param bksxTabTeam
	 *            BksxTabTeam����
	 * @return boolean
	 */
	public boolean deleteTeam(BksxTabTeam bksxTabTeam) {
		return bksxTabTeamDAO.deleteTeam(bksxTabTeam);
	}
}
