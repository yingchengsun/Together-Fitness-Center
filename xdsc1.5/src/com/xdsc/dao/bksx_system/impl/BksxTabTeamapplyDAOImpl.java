package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabTeamapplyDAO;
import com.xdsc.model.BksxTabTeam;
import com.xdsc.model.BksxTabTeamapply;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabTeamapply的相关操作
 */
public class BksxTabTeamapplyDAOImpl extends HibernateDaoSupport implements
		BksxTabTeamapplyDAO {

	/**
	 * 保存一个BksxTabTeamapply对象
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply对象
	 * @return boolean
	 */
	public boolean saveApplyInfo(BksxTabTeamapply applyInfo) {
		this.getHibernateTemplate().save(applyInfo);
		return true;
	}

	/**
	 * 删除一个BksxTabTeamapply对象
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply对象
	 * @return boolean
	 */
	public boolean deleteApplyInfo(BksxTabTeamapply applyInfo) {
		this.getHibernateTemplate().delete(applyInfo);
		return true;
	}

	/**
	 * 更新一个BksxTabTeamapply对象
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply对象
	 * @return boolean
	 */
	public boolean updateApplyInfo(BksxTabTeamapply applyInfo) {
		this.getHibernateTemplate().update(applyInfo);
		return true;
	}

	/**
	 * 根据Team对象得到申请该Team的申请信息列表
	 * 
	 * @param team
	 *            BksxTabTeam对象
	 * @return List
	 */
	public List<BksxTabTeamapply> getApplyInfoByTeam(BksxTabTeam team) {
		String hql = "from BksxTabTeamapply bt where bt.bksxTabTeam.FTeamId="
				+ team.getFTeamId() + " and bt.FResult='待审核'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据学生学号得到该生的入队申请信息列表
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return List
	 */
	public List<BksxTabTeamapply> getApplyInfoByStuNum(String stuNum) {
		String hql = "from BksxTabTeamapply bt where bt.tabStudents.FStudentNumber='"
				+ stuNum + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 根据申请信息唯一ID得到该信息的对象
	 * 
	 * @param applyID
	 *            申请信息唯一ＩＤ
	 * @return BksxTabTeamapply
	 */
	public BksxTabTeamapply getApplyInfoById(int applyID) {
		String hql = "from BksxTabTeamapply bt where bt.FAid=" + applyID;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabTeamapply) (this.getHibernateTemplate().find(hql)
					.get(0));
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
		String hql = "from BksxTabTeamapply bt where bt.bksxTabTeam.FTeamId="
				+ teamID + " and bt.tabStudents.FStudentNumber='"
				+ studentNumber + "' and bt.FResult='" + status + "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabTeamapply) this.getHibernateTemplate().find(hql)
					.get(0);
	}
}
