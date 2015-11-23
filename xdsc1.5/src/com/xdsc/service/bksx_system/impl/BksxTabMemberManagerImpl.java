package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabMemberDAO;
import com.xdsc.model.BksxTabMember;
import com.xdsc.model.BksxTabTeam;
import com.xdsc.service.bksx_system.BksxTabMemberManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶��Ŷӳ�Ա����ز���
 */
public class BksxTabMemberManagerImpl implements BksxTabMemberManager {
	private BksxTabMemberDAO bksxTabMemberDAO;

	public BksxTabMemberDAO getBksxTabMemberDAO() {
		return bksxTabMemberDAO;
	}

	public void setBksxTabMemberDAO(BksxTabMemberDAO bksxTabMemberDAO) {
		this.bksxTabMemberDAO = bksxTabMemberDAO;
	}

	/**
	 * ����һ��BksxTabMember����
	 * 
	 * @param member
	 *            ��Ա����
	 * @return boolean
	 */
	public boolean saveMember(BksxTabMember member) {
		return bksxTabMemberDAO.saveMember(member);
	}

	/**
	 * ɾ��һ��BksxTabMember����
	 * 
	 * @param member
	 *            ��Ա����
	 * @return boolean
	 */
	public boolean deleteMember(BksxTabMember member) {
		return bksxTabMemberDAO.deleteMember(member);
	}

	/**
	 * ����һ��BksxTabMember����
	 * 
	 * @param member
	 *            ��Ա����
	 * @return boolean
	 */
	public boolean updateMember(BksxTabMember member) {
		return bksxTabMemberDAO.updateMember(member);
	}

	/**
	 * ͨ������ID�õ��˶���ĳ�Ա�б�
	 * 
	 * @param teamId
	 *            ����ID
	 * @return List
	 */
	public List<BksxTabMember> getMemberByTeamId(int teamId) {
		return bksxTabMemberDAO.getMemberByTeamId(teamId);
	}

	/**
	 * ͨ��ѧ�ŵõ�һ����Ա����
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return BksxTabMember
	 */
	public BksxTabMember getMemberByStuNum(String stuNum) {
		return bksxTabMemberDAO.getMemberByStuNum(stuNum);
	}

	/**
	 * ͨ��һ���������õ��ö���ĳ�Ա�б�
	 * 
	 * @param bksxTabTeam
	 *            �������
	 * @return List
	 */
	public List<BksxTabMember> getMemberListByTeam(BksxTabTeam bksxTabTeam) {
		return bksxTabMemberDAO.getMemberListByTeam(bksxTabTeam);
	}
}
