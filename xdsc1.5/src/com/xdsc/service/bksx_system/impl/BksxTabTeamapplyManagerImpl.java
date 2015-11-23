package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabTeamapplyDAO;
import com.xdsc.model.BksxTabTeam;
import com.xdsc.model.BksxTabTeamapply;
import com.xdsc.service.bksx_system.BksxTabTeamapplyManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabTeamapply的相关操作
 */
public class BksxTabTeamapplyManagerImpl implements BksxTabTeamapplyManager {
	/**
	 * BksxTabTeamapplyDAOImpl对象
	 */
	private BksxTabTeamapplyDAO bksxTabTeamapplyDAO;

	/**
	 * bksxTabTeamapplyDAO属性Get与set方法
	 */
	public BksxTabTeamapplyDAO getBksxTabTeamapplyDAO() {
		return bksxTabTeamapplyDAO;
	}

	public void setBksxTabTeamapplyDAO(BksxTabTeamapplyDAO bksxTabTeamapplyDAO) {
		this.bksxTabTeamapplyDAO = bksxTabTeamapplyDAO;
	}

	/**
	 * 保存一个BksxTabTeamapply对象
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply对象
	 * @return boolean
	 */
	public boolean saveApplyInfo(BksxTabTeamapply applyInfo) {
		return bksxTabTeamapplyDAO.saveApplyInfo(applyInfo);
	}

	/**
	 * 删除一个BksxTabTeamapply对象
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply对象
	 * @return boolean
	 */
	public boolean deleteApplyInfo(BksxTabTeamapply applyInfo) {
		return bksxTabTeamapplyDAO.deleteApplyInfo(applyInfo);
	}

	/**
	 * 更新一个BksxTabTeamapply对象
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply对象
	 * @return boolean
	 */
	public boolean updateApplyInfo(BksxTabTeamapply applyInfo) {
		return bksxTabTeamapplyDAO.updateApplyInfo(applyInfo);
	}

	/**
	 * 根据Team对象得到申请该Team的申请信息列表
	 * 
	 * @param team
	 *            BksxTabTeam对象
	 * @return List
	 */
	public List<BksxTabTeamapply> getApplyInfoByTeam(BksxTabTeam team) {
		return bksxTabTeamapplyDAO.getApplyInfoByTeam(team);
	}

	/**
	 * 根据学生学号得到该生的入队申请信息列表
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return List
	 */
	public List<BksxTabTeamapply> getApplyInfoByStuNum(String stuNum) {
		return bksxTabTeamapplyDAO.getApplyInfoByStuNum(stuNum);
	}

	/**
	 * 根据申请信息唯一ID得到该信息的对象
	 * 
	 * @param applyID
	 *            申请信息唯一ＩＤ
	 * @return BksxTabTeamapply
	 */
	public BksxTabTeamapply getApplyInfoById(int applyID) {
		return bksxTabTeamapplyDAO.getApplyInfoById(applyID);
	}

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
	public BksxTabTeamapply getApplyInfoByStuNumStatus(String studentNumber,
			String status, int teamID) {
		return bksxTabTeamapplyDAO.getApplyInfoByStuNumStatus(studentNumber,
				status, teamID);
	}
}
