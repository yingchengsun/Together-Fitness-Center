package com.xdsc.service.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabTeam;
import com.xdsc.model.BksxTabTeamapply;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabTeamapply����ز���
 */
public interface BksxTabTeamapplyManager {

	/**
	 * ����һ��BksxTabTeamapply����
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply����
	 * @return boolean
	 */
	public abstract boolean saveApplyInfo(BksxTabTeamapply applyInfo);

	/**
	 * ɾ��һ��BksxTabTeamapply����
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply����
	 * @return boolean
	 */
	public abstract boolean deleteApplyInfo(BksxTabTeamapply applyInfo);

	/**
	 * ����һ��BksxTabTeamapply����
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply����
	 * @return boolean
	 */
	public abstract boolean updateApplyInfo(BksxTabTeamapply applyInfo);

	/**
	 * ����Team����õ������Team��������Ϣ�б�
	 * 
	 * @param team
	 *            BksxTabTeam����
	 * @return List
	 */
	public abstract List<BksxTabTeamapply> getApplyInfoByTeam(BksxTabTeam team);

	/**
	 * ����ѧ��ѧ�ŵõ����������������Ϣ�б�
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return List
	 */
	public abstract List<BksxTabTeamapply> getApplyInfoByStuNum(String stuNum);

	/**
	 * ����������ϢΨһID�õ�����Ϣ�Ķ���
	 * 
	 * @param applyID
	 *            ������ϢΨһ�ɣ�
	 * @return BksxTabTeamapply
	 */
	public abstract BksxTabTeamapply getApplyInfoById(int applyID);

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
	public abstract BksxTabTeamapply getApplyInfoByStuNumStatus(
			String studentNumber, String status, int teamID);

}