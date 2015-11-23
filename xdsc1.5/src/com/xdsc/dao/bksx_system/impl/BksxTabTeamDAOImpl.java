package com.xdsc.dao.bksx_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabTeamDAO;
import com.xdsc.model.BksxTabTeam;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabTeam的相关操作
 */
public class BksxTabTeamDAOImpl extends HibernateDaoSupport implements
		BksxTabTeamDAO {
	/**
	 * 保存一个BksxTabTeam对象
	 * 
	 * @param team
	 *            BksxTabTeam对象
	 * @return boolean
	 */
	public boolean saveTeam(BksxTabTeam team) {
		this.getHibernateTemplate().save(team);
		return true;
	}

	/**
	 * 得到所有的BksxTabTeam对象列表
	 * 
	 * @return List
	 */
	public List<BksxTabTeam> getTeamList() {
		String hql = "from BksxTabTeam bt where bt.FTeamMemberNum = 1";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据team唯一标识ID得到一个BksxTabTeam对象
	 * 
	 * @param teamId
	 *            BksxTabTeam对象ID
	 * @return BksxTabTeam
	 */
	public BksxTabTeam getTeamById(int teamId) {
		String hql = "from BksxTabTeam bt where bt.FTeamId=" + teamId;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabTeam) (this.getHibernateTemplate().find(hql).get(0));
	}

	/**
	 * 根据team名称得到一个BksxTabTeam对象
	 * 
	 * @param teamName
	 *            BksxTabTeam对象名称
	 * @return BksxTabTeam
	 */
	public BksxTabTeam getTeamByName(String teamName) {
		String hql = "from BksxTabTeam bt where bt.FTeamName='" + teamName
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabTeam) (this.getHibernateTemplate().find(hql).get(0));
	}

	/**
	 * 更新一个BksxTabTeam对象
	 * 
	 * @param team
	 *            BksxTabTeam对象
	 * @return boolean
	 */
	public void updateTeam(BksxTabTeam team) {
		this.getHibernateTemplate().update(team);
	}

	/**
	 * 根据team名称的字段模糊查找一个BksxTabTeam对象列表
	 * 
	 * @param teamName
	 *            BksxTabTeam对象名称的全部或部分字段
	 * @return List
	 */
	public List<BksxTabTeam> getTeamList(String teamName) {
		String hql = "from BksxTabTeam bt where bt.FTeamName like ? and bt.FTeamMemberNum = 1";
		return this.getHibernateTemplate().find(hql, "%" + teamName + "%");
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
		String hql = "from BksxTabTeam bt where bt.FTeamCreateDate >= :startDate and bt.FTeamCreateDate <= :endDate and bt.FTeamMemberNum = 1";
		String[] params = { "startDate", "endDate" };
		Object[] args = { startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

	/**
	 * 删除一个BksxTabTeam对象
	 * 
	 * @param bksxTabTeam
	 *            BksxTabTeam对象
	 * @return boolean
	 */
	public boolean deleteTeam(BksxTabTeam bksxTabTeam) {
		this.getHibernateTemplate().delete(bksxTabTeam);
		return true;
	}
}
