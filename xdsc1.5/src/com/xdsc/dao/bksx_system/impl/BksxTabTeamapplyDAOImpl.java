package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabTeamapplyDAO;
import com.xdsc.model.BksxTabTeam;
import com.xdsc.model.BksxTabTeamapply;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabTeamapply����ز���
 */
public class BksxTabTeamapplyDAOImpl extends HibernateDaoSupport implements
		BksxTabTeamapplyDAO {

	/**
	 * ����һ��BksxTabTeamapply����
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply����
	 * @return boolean
	 */
	public boolean saveApplyInfo(BksxTabTeamapply applyInfo) {
		this.getHibernateTemplate().save(applyInfo);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabTeamapply����
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply����
	 * @return boolean
	 */
	public boolean deleteApplyInfo(BksxTabTeamapply applyInfo) {
		this.getHibernateTemplate().delete(applyInfo);
		return true;
	}

	/**
	 * ����һ��BksxTabTeamapply����
	 * 
	 * @param applyInfo
	 *            BksxTabTeamapply����
	 * @return boolean
	 */
	public boolean updateApplyInfo(BksxTabTeamapply applyInfo) {
		this.getHibernateTemplate().update(applyInfo);
		return true;
	}

	/**
	 * ����Team����õ������Team��������Ϣ�б�
	 * 
	 * @param team
	 *            BksxTabTeam����
	 * @return List
	 */
	public List<BksxTabTeamapply> getApplyInfoByTeam(BksxTabTeam team) {
		String hql = "from BksxTabTeamapply bt where bt.bksxTabTeam.FTeamId="
				+ team.getFTeamId() + " and bt.FResult='�����'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ����ѧ��ѧ�ŵõ����������������Ϣ�б�
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return List
	 */
	public List<BksxTabTeamapply> getApplyInfoByStuNum(String stuNum) {
		String hql = "from BksxTabTeamapply bt where bt.tabStudents.FStudentNumber='"
				+ stuNum + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ����������ϢΨһID�õ�����Ϣ�Ķ���
	 * 
	 * @param applyID
	 *            ������ϢΨһ�ɣ�
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
	 * ����ѧ��ѧ���Լ�����״̬�Լ�����ID�õ�����Ϣ�Ķ���
	 * 
	 * @param teamID
	 *            ����ID
	 * @param status
	 *            ��׼״̬
	 * @param studentNumber
	 *            ѧ��ѧ��
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
