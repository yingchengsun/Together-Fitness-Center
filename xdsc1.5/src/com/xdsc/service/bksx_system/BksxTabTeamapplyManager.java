package com.xdsc.service.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabTeam;
import com.xdsc.model.BksxTabTeamapply;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabTeamapply的相关操作
 */
public interface BksxTabTeamapplyManager {

	/**
	 * 保存一个BksxTabTeamapply对象
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply对象
	 * @return boolean
	 */
	public abstract boolean saveApplyInfo(BksxTabTeamapply applyInfo);

	/**
	 * 删除一个BksxTabTeamapply对象
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply对象
	 * @return boolean
	 */
	public abstract boolean deleteApplyInfo(BksxTabTeamapply applyInfo);

	/**
	 * 更新一个BksxTabTeamapply对象
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply对象
	 * @return boolean
	 */
	public abstract boolean updateApplyInfo(BksxTabTeamapply applyInfo);

	/**
	 * 根据Team对象得到申请该Team的申请信息列表
	 * 
	 * @param team
	 *            BksxTabTeam对象
	 * @return List
	 */
	public abstract List<BksxTabTeamapply> getApplyInfoByTeam(BksxTabTeam team);

	/**
	 * 根据学生学号得到该生的入队申请信息列表
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return List
	 */
	public abstract List<BksxTabTeamapply> getApplyInfoByStuNum(String stuNum);

	/**
	 * 根据申请信息唯一ID得到该信息的对象
	 * 
	 * @param applyID
	 *            申请信息唯一ＩＤ
	 * @return BksxTabTeamapply
	 */
	public abstract BksxTabTeamapply getApplyInfoById(int applyID);

	/**
	 * 根据学生学号以及申请状态以及队伍ID得到该信息的对象
	 * 
	 * @param teamID
	 *            队伍ID
	 * @param status
	 *            批准状态
	 * @param studentNumber
	 *            学生学号
	 * @return BksxTabTeamapply
	 */
	public abstract BksxTabTeamapply getApplyInfoByStuNumStatus(
			String studentNumber, String status, int teamID);

}