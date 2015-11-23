package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabMemberDAO;
import com.xdsc.model.BksxTabMember;
import com.xdsc.model.BksxTabTeam;
import com.xdsc.service.bksx_system.BksxTabMemberManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对团队成员的相关操作
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
	 * 保存一个BksxTabMember对象
	 * 
	 * @param member
	 *            成员对象
	 * @return boolean
	 */
	public boolean saveMember(BksxTabMember member) {
		return bksxTabMemberDAO.saveMember(member);
	}

	/**
	 * 删除一个BksxTabMember对象
	 * 
	 * @param member
	 *            成员对象
	 * @return boolean
	 */
	public boolean deleteMember(BksxTabMember member) {
		return bksxTabMemberDAO.deleteMember(member);
	}

	/**
	 * 更新一个BksxTabMember对象
	 * 
	 * @param member
	 *            成员对象
	 * @return boolean
	 */
	public boolean updateMember(BksxTabMember member) {
		return bksxTabMemberDAO.updateMember(member);
	}

	/**
	 * 通过队伍ID得到此队伍的成员列表
	 * 
	 * @param teamId
	 *            队伍ID
	 * @return List
	 */
	public List<BksxTabMember> getMemberByTeamId(int teamId) {
		return bksxTabMemberDAO.getMemberByTeamId(teamId);
	}

	/**
	 * 通过学号得到一个成员对象
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return BksxTabMember
	 */
	public BksxTabMember getMemberByStuNum(String stuNum) {
		return bksxTabMemberDAO.getMemberByStuNum(stuNum);
	}

	/**
	 * 通过一个队伍对象得到该队伍的成员列表
	 * 
	 * @param bksxTabTeam
	 *            队伍对象
	 * @return List
	 */
	public List<BksxTabMember> getMemberListByTeam(BksxTabTeam bksxTabTeam) {
		return bksxTabMemberDAO.getMemberListByTeam(bksxTabTeam);
	}
}
