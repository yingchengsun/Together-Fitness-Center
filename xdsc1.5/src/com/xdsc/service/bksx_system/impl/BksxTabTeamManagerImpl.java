package com.xdsc.service.bksx_system.impl;

import java.util.Date;
import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabTeamDAO;
import com.xdsc.model.BksxTabTeam;
import com.xdsc.service.bksx_system.BksxTabTeamManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabTeam的相关操作
 */
public class BksxTabTeamManagerImpl implements BksxTabTeamManager {
	/**
	 * BksxTabTeamDAOImpl的接口
	 */
	private BksxTabTeamDAO bksxTabTeamDAO;

	/**
	 * bksxTabTeamDAO属性的Get与Set方法
	 */
	public BksxTabTeamDAO getBksxTabTeamDAO() {
		return bksxTabTeamDAO;
	}

	public void setBksxTabTeamDAO(BksxTabTeamDAO bksxTabTeamDAO) {
		this.bksxTabTeamDAO = bksxTabTeamDAO;
	}

	/**
	 * 保存一个BksxTabTeam对象
	 * 
	 * @param team
	 *            BksxTabTeam对象
	 * @return boolean
	 */
	public boolean saveTeam(BksxTabTeam team) {
		return bksxTabTeamDAO.saveTeam(team);
	}

	/**
	 * 得到所有的BksxTabTeam对象列表
	 * 
	 * @return List
	 */
	public List getTeamList() {
		return bksxTabTeamDAO.getTeamList();
	}

	/**
	 * 根据team唯一标识ID得到一个BksxTabTeam对象
	 * 
	 * @param teamId
	 *            BksxTabTeam对象ID
	 * @return BksxTabTeam
	 */
	public BksxTabTeam getTeamById(int teamId) {
		return bksxTabTeamDAO.getTeamById(teamId);
	}

	/**
	 * 根据team名称得到一个BksxTabTeam对象
	 * 
	 * @param teamName
	 *            BksxTabTeam对象名称
	 * @return BksxTabTeam
	 */
	public BksxTabTeam getTeamByName(String teamName) {
		return bksxTabTeamDAO.getTeamByName(teamName);
	}

	/**
	 * 更新一个BksxTabTeam对象
	 * 
	 * @param team
	 *            BksxTabTeam对象
	 * @return boolean
	 */
	public void updateTeam(BksxTabTeam team) {
		bksxTabTeamDAO.updateTeam(team);
	}

	/**
	 * 根据team名称的字段模糊查找一个BksxTabTeam对象列表
	 * 
	 * @param teamName
	 *            BksxTabTeam对象名称的全部或部分字段
	 * @return List
	 */
	public List<BksxTabTeam> getTeamListByName(String teamName) {
		return bksxTabTeamDAO.getTeamList(teamName);
	}

	/**
	 * 根据team创建的时间查找一个BksxTabTeam对象列表
	 * 
	 * @param startDate
	 *            时间区间开始日期
	 * @param endDate
	 *            时间区间结束日期
	 * @return List
	 */
	public List<BksxTabTeam> getTeamListByDate(Date startDate, Date endDate) {
		return bksxTabTeamDAO.getTeamListByDate(startDate, endDate);
	}

	/**
	 * 删除一个BksxTabTeam对象
	 * 
	 * @param bksxTabTeam
	 *            BksxTabTeam对象
	 * @return boolean
	 */
	public boolean deleteTeam(BksxTabTeam bksxTabTeam) {
		return bksxTabTeamDAO.deleteTeam(bksxTabTeam);
	}
}
