package com.xdsc.dao.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabMember;
import com.xdsc.model.BksxTabTeam;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶��Ŷӳ�Ա����ز���
 */
public interface BksxTabMemberDAO {

	/**
	 * ����һ��BksxTabMember����
	 * 
	 * @param member
	 *            ��Ա����
	 * @return boolean
	 */
	public abstract boolean saveMember(BksxTabMember member);

	/**
	 * ɾ��һ��BksxTabMember����
	 * 
	 * @param member
	 *            ��Ա����
	 * @return boolean
	 */
	public abstract boolean deleteMember(BksxTabMember member);

	/**
	 * ����һ��BksxTabMember����
	 * 
	 * @param member
	 *            ��Ա����
	 * @return boolean
	 */
	public abstract boolean updateMember(BksxTabMember member);

	/**
	 * ͨ������ID�õ��˶���ĳ�Ա�б�
	 * 
	 * @param teamId
	 *            ����ID
	 * @return List
	 */
	public abstract List<BksxTabMember> getMemberByTeamId(int teamId);

	/**
	 * ͨ��ѧ�ŵõ�һ����Ա����
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return BksxTabMember
	 */
	public abstract BksxTabMember getMemberByStuNum(String stuNum);

	/**
	 * ͨ��һ���������õ��ö���ĳ�Ա�б�
	 * 
	 * @param bksxTabTeam
	 *            �������
	 * @return List
	 */
	public abstract List<BksxTabMember> getMemberListByTeam(
			BksxTabTeam bksxTabTeam);

}