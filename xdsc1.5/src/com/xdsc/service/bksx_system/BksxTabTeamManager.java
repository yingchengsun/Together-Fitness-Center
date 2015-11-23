package com.xdsc.service.bksx_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.BksxTabTeam;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabTeam����ز���
 */
public interface BksxTabTeamManager {
	/**
	 * ����һ��BksxTabTeam����
	 * 
	 * @param team
	 *            BksxTabTeam����
	 * @return boolean
	 */
	public abstract boolean saveTeam(BksxTabTeam team);

	/**
	 * �õ����е�BksxTabTeam�����б�
	 * 
	 * @return List
	 */
	public abstract List getTeamList();

	/**
	 * ����teamΨһ��ʶID�õ�һ��BksxTabTeam����
	 * 
	 * @param teamId
	 *            BksxTabTeam����ID
	 * @return BksxTabTeam
	 */
	public abstract BksxTabTeam getTeamById(int teamId);

	/**
	 * ����team���Ƶõ�һ��BksxTabTeam����
	 * 
	 * @param teamName
	 *            BksxTabTeam��������
	 * @return BksxTabTeam
	 */
	public abstract BksxTabTeam getTeamByName(String teamName);

	/**
	 * ����һ��BksxTabTeam����
	 * 
	 * @param team
	 *            BksxTabTeam����
	 * @return boolean
	 */
	public abstract void updateTeam(BksxTabTeam team);

	/**
	 * ����team���Ƶ��ֶ�ģ������һ��BksxTabTeam�����б�
	 * 
	 * @param teamName
	 *            BksxTabTeam�������Ƶ�ȫ���򲿷��ֶ�
	 * @return List
	 */
	public abstract List<BksxTabTeam> getTeamListByName(String teamName);

	/**
	 * ����team������ʱ�����һ��BksxTabTeam�����б�
	 * 
	 * @param startDate
	 *            ʱ�����俪ʼ����
	 * @param endDate
	 *            ʱ�������������
	 * @return List
	 */
	public abstract List<BksxTabTeam> getTeamListByDate(Date startDate,
			Date endDate);

	/**
	 * ɾ��һ��BksxTabTeam����
	 * 
	 * @param bksxTabTeam
	 *            BksxTabTeam����
	 * @return boolean
	 */
	public abstract boolean deleteTeam(BksxTabTeam bksxTabTeam);

}