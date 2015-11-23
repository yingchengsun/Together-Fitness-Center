package com.xdsc.dao.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabMember;
import com.xdsc.model.BksxTabTeam;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对团队成员的相关操作
 */
public interface BksxTabMemberDAO {

	/**
	 * 保存一个BksxTabMember对象
	 * 
	 * @param member
	 *            成员对象
	 * @return boolean
	 */
	public abstract boolean saveMember(BksxTabMember member);

	/**
	 * 删除一个BksxTabMember对象
	 * 
	 * @param member
	 *            成员对象
	 * @return boolean
	 */
	public abstract boolean deleteMember(BksxTabMember member);

	/**
	 * 更新一个BksxTabMember对象
	 * 
	 * @param member
	 *            成员对象
	 * @return boolean
	 */
	public abstract boolean updateMember(BksxTabMember member);

	/**
	 * 通过队伍ID得到此队伍的成员列表
	 * 
	 * @param teamId
	 *            队伍ID
	 * @return List
	 */
	public abstract List<BksxTabMember> getMemberByTeamId(int teamId);

	/**
	 * 通过学号得到一个成员对象
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return BksxTabMember
	 */
	public abstract BksxTabMember getMemberByStuNum(String stuNum);

	/**
	 * 通过一个队伍对象得到该队伍的成员列表
	 * 
	 * @param bksxTabTeam
	 *            队伍对象
	 * @return List
	 */
	public abstract List<BksxTabMember> getMemberListByTeam(
			BksxTabTeam bksxTabTeam);

}