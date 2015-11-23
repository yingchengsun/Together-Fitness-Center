package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabMemberDAO;
import com.xdsc.model.BksxTabMember;
import com.xdsc.model.BksxTabTeam;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对团队成员的相关操作
 */
public class BksxTabMemberDAOImpl extends HibernateDaoSupport implements
		BksxTabMemberDAO {
	/**
	 * 保存一个BksxTabMember对象
	 * 
	 * @param member
	 *            成员对象
	 * @return boolean
	 */
	public boolean saveMember(BksxTabMember member) {
		this.getHibernateTemplate().save(member);
		return true;
	}

	/**
	 * 删除一个BksxTabMember对象
	 * 
	 * @param member
	 *            成员对象
	 * @return boolean
	 */
	public boolean deleteMember(BksxTabMember member) {
		this.getHibernateTemplate().delete(member);
		return true;
	}

	/**
	 * 更新一个BksxTabMember对象
	 * 
	 * @param member
	 *            成员对象
	 * @return boolean
	 */
	public boolean updateMember(BksxTabMember member) {
		this.getHibernateTemplate().update(member);
		return true;
	}

	/**
	 * 通过队伍ID得到此队伍的成员列表
	 * 
	 * @param teamId
	 *            队伍ID
	 * @return List
	 */
	public List<BksxTabMember> getMemberByTeamId(int teamId) {
		String hql = "from BksxTabMember bm where bm.bksxTabTeam.FTeamId="
				+ teamId;
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * 通过学号得到一个成员对象
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return BksxTabMember
	 */
	public BksxTabMember getMemberByStuNum(String stuNum) {
		String hql = "from BksxTabMember bm where bm.FStudentNumber='" + stuNum
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabMember) (this.getHibernateTemplate().find(hql)
					.get(0));
	}

	/**
	 * 通过一个队伍对象得到该队伍的成员列表
	 * 
	 * @param bksxTabTeam
	 *            队伍对象
	 * @return List
	 */
	public List<BksxTabMember> getMemberListByTeam(BksxTabTeam bksxTabTeam) {
		String hql = "from BksxTabMember bm where bm.bksxTabTeam.FTeamId="
				+ bksxTabTeam.getFTeamId();
		return this.getHibernateTemplate().find(hql);
	}

}
