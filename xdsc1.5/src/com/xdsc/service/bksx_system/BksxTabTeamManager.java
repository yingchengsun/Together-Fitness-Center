package com.xdsc.service.bksx_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.BksxTabTeam;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabTeam的相关操作
 */
public interface BksxTabTeamManager {
	/**
	 * 保存一个BksxTabTeam对象
	 * 
	 * @param team
	 *            BksxTabTeam对象
	 * @return boolean
	 */
	public abstract boolean saveTeam(BksxTabTeam team);

	/**
	 * 得到所有的BksxTabTeam对象列表
	 * 
	 * @return List
	 */
	public abstract List getTeamList();

	/**
	 * 根据team唯一标识ID得到一个BksxTabTeam对象
	 * 
	 * @param teamId
	 *            BksxTabTeam对象ID
	 * @return BksxTabTeam
	 */
	public abstract BksxTabTeam getTeamById(int teamId);

	/**
	 * 根据team名称得到一个BksxTabTeam对象
	 * 
	 * @param teamName
	 *            BksxTabTeam对象名称
	 * @return BksxTabTeam
	 */
	public abstract BksxTabTeam getTeamByName(String teamName);

	/**
	 * 更新一个BksxTabTeam对象
	 * 
	 * @param team
	 *            BksxTabTeam对象
	 * @return boolean
	 */
	public abstract void updateTeam(BksxTabTeam team);

	/**
	 * 根据team名称的字段模糊查找一个BksxTabTeam对象列表
	 * 
	 * @param teamName
	 *            BksxTabTeam对象名称的全部或部分字段
	 * @return List
	 */
	public abstract List<BksxTabTeam> getTeamListByName(String teamName);

	/**
	 * 根据team创建的时间查找一个BksxTabTeam对象列表
	 * 
	 * @param startDate
	 *            时间区间开始日期
	 * @param endDate
	 *            时间区间结束日期
	 * @return List
	 */
	public abstract List<BksxTabTeam> getTeamListByDate(Date startDate,
			Date endDate);

	/**
	 * 删除一个BksxTabTeam对象
	 * 
	 * @param bksxTabTeam
	 *            BksxTabTeam对象
	 * @return boolean
	 */
	public abstract boolean deleteTeam(BksxTabTeam bksxTabTeam);

}