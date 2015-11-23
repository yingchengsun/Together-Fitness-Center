package com.xdsc.dao.bksx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabGanttplanDAO;
import com.xdsc.model.BksxTabGanttplan;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabGanttplan的相关操作
 */
public class BksxTabGanttplanDAOImpl extends HibernateDaoSupport implements
		BksxTabGanttplanDAO {
	/**
	 * 获取BksxTabGanttplan所有对象
	 * 
	 * @param proId
	 *            项目唯一ID
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
	 * 保存一个BksxTabGanttplan对象
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan对象
	 * @return boolean
	 * 
	 */
	public boolean saveGanttplan(BksxTabGanttplan ganttplan) {
		this.getHibernateTemplate().save(ganttplan);
		return true;
	}

	/**
	 * 删除一个BksxTabGanttplan对象
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan对象
	 * @return boolean
	 * 
	 */
	public boolean deleteGanttplan(BksxTabGanttplan ganttplan) {
		this.getHibernateTemplate().delete(ganttplan);
		return true;
	}

	/**
	 * 更新一个BksxTabGanttplan对象
	 * 
	 * @param ganttplan
	 *            BksxTabGanttplan对象
	 * @return boolean
	 * 
	 */
	public boolean updateGanttplan(BksxTabGanttplan ganttplan) {
		this.getHibernateTemplate().update(ganttplan);
		return true;
	}

	/**
	 * 通过主键获取一个BksxTabGanttplan对象
	 * 
	 * @param FTaskId
	 *            该甘特图某一任务ID
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
