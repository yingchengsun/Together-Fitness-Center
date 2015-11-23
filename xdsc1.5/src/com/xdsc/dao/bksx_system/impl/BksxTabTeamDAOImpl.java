package com.xdsc.dao.bksx_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabTeamDAO;
import com.xdsc.model.BksxTabTeam;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabTeam����ز���
 */
public class BksxTabTeamDAOImpl extends HibernateDaoSupport implements
		BksxTabTeamDAO {
	/**
	 * ����һ��BksxTabTeam����
	 * 
	 * @param team
	 *            BksxTabTeam����
	 * @return boolean
	 */
	public boolean saveTeam(BksxTabTeam team) {
		this.getHibernateTemplate().save(team);
		return true;
	}

	/**
	 * �õ����е�BksxTabTeam�����б�
	 * 
	 * @return List
	 */
	public List<BksxTabTeam> getTeamList() {
		String hql = "from BksxTabTeam bt where bt.FTeamMemberNum = 1";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ����teamΨһ��ʶID�õ�һ��BksxTabTeam����
	 * 
	 * @param teamId
	 *            BksxTabTeam����ID
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
	 * ����team���Ƶõ�һ��BksxTabTeam����
	 * 
	 * @param teamName
	 *            BksxTabTeam��������
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
	 * ����һ��BksxTabTeam����
	 * 
	 * @param team
	 *            BksxTabTeam����
	 * @return boolean
	 */
	public void updateTeam(BksxTabTeam team) {
		this.getHibernateTemplate().update(team);
	}

	/**
	 * ����team���Ƶ��ֶ�ģ������һ��BksxTabTeam�����б�
	 * 
	 * @param teamName
	 *            BksxTabTeam�������Ƶ�ȫ���򲿷��ֶ�
	 * @return List
	 */
	public List<BksxTabTeam> getTeamList(String teamName) {
		String hql = "from BksxTabTeam bt where bt.FTeamName like ? and bt.FTeamMemberNum = 1";
		return this.getHibernateTemplate().find(hql, "%" + teamName + "%");
	}

	/**
	 * ����team������ʱ�����һ��BksxTabTeam�����б�
	 * 
	 * @param startDate
	 *            ʱ�����俪ʼ����
	 * @param endDate
	 *            ʱ�������������
	 * @return List
	 */
	public List<BksxTabTeam> getTeamListByDate(Date startDate, Date endDate) {
		String hql = "from BksxTabTeam bt where bt.FTeamCreateDate >= :startDate and bt.FTeamCreateDate <= :endDate and bt.FTeamMemberNum = 1";
		String[] params = { "startDate", "endDate" };
		Object[] args = { startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

	/**
	 * ɾ��һ��BksxTabTeam����
	 * 
	 * @param bksxTabTeam
	 *            BksxTabTeam����
	 * @return boolean
	 */
	public boolean deleteTeam(BksxTabTeam bksxTabTeam) {
		this.getHibernateTemplate().delete(bksxTabTeam);
		return true;
	}
}
