package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabGanttplanDAO;
import com.xdsc.model.BksxTabGanttplan;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabGanttplan����ز���
 */
public class BksxTabGanttplanDAOImpl extends HibernateDaoSupport implements
		BksxTabGanttplanDAO {
	/**
	 * ��ȡBksxTabGanttplan���ж���
	 * 
	 * @param proId
	 *            ��ĿΨһID
	 * @return List
	 * 
	 */
	public List<BksxTabGanttplan> getGanttplanListByProId(int proId) {
		String hql = "from BksxTabGanttplan bg where bg.bksxTabProject.FProjId="
				+ proId;
		List<BksxTabGanttplan> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * ����һ��BksxTabGanttplan����
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan����
	 * @return boolean
	 * 
	 */
	public boolean saveGanttplan(BksxTabGanttplan ganttplan) {
		this.getHibernateTemplate().save(ganttplan);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabGanttplan����
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan����
	 * @return boolean
	 * 
	 */
	public boolean deleteGanttplan(BksxTabGanttplan ganttplan) {
		this.getHibernateTemplate().delete(ganttplan);
		return true;
	}

	/**
	 * ����һ��BksxTabGanttplan����
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan����
	 * @return boolean
	 * 
	 */
	public boolean updateGanttplan(BksxTabGanttplan ganttplan) {
		this.getHibernateTemplate().update(ganttplan);
		return true;
	}

	/**
	 * ͨ��������ȡһ��BksxTabGanttplan����
	 * 
	 * @param FTaskId
	 *            �ø���ͼĳһ����ID
	 * @return BksxTabGanttplan
	 * 
	 */
	public BksxTabGanttplan getGanttplanById(int FTaskId) {
		String hql = "from BksxTabGanttplan bg where bg.FTaskId=" + FTaskId;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else {
			return (BksxTabGanttplan) this.getHibernateTemplate().find(hql)
					.get(0);
		}
	}
}
