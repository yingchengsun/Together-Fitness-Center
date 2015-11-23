package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabMemberDAO;
import com.xdsc.model.BksxTabMember;
import com.xdsc.model.BksxTabTeam;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶��Ŷӳ�Ա����ز���
 */
public class BksxTabMemberDAOImpl extends HibernateDaoSupport implements
		BksxTabMemberDAO {
	/**
	 * ����һ��BksxTabMember����
	 * 
	 * @param member
	 *            ��Ա����
	 * @return boolean
	 */
	public boolean saveMember(BksxTabMember member) {
		this.getHibernateTemplate().save(member);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabMember����
	 * 
	 * @param member
	 *            ��Ա����
	 * @return boolean
	 */
	public boolean deleteMember(BksxTabMember member) {
		this.getHibernateTemplate().delete(member);
		return true;
	}

	/**
	 * ����һ��BksxTabMember����
	 * 
	 * @param member
	 *            ��Ա����
	 * @return boolean
	 */
	public boolean updateMember(BksxTabMember member) {
		this.getHibernateTemplate().update(member);
		return true;
	}

	/**
	 * ͨ������ID�õ��˶���ĳ�Ա�б�
	 * 
	 * @param teamId
	 *            ����ID
	 * @return List
	 */
	public List<BksxTabMember> getMemberByTeamId(int teamId) {
		String hql = "from BksxTabMember bm where bm.bksxTabTeam.FTeamId="
				+ teamId;
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ͨ��ѧ�ŵõ�һ����Ա����
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
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
	 * ͨ��һ���������õ��ö���ĳ�Ա�б�
	 * 
	 * @param bksxTabTeam
	 *            �������
	 * @return List
	 */
	public List<BksxTabMember> getMemberListByTeam(BksxTabTeam bksxTabTeam) {
		String hql = "from BksxTabMember bm where bm.bksxTabTeam.FTeamId="
				+ bksxTabTeam.getFTeamId();
		return this.getHibernateTemplate().find(hql);
	}

}
