package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabDirectionDAO;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabDirection;

/***对专业方向信息进行操作
 * @author 陈雪
 * @version 1.1
 */
public class SjjxTabDirectionDAOImpl extends HibernateDaoSupport implements SjjxTabDirectionDAO{


	
	/**根据专业方向名称查找到对应的记录
	 * @param directionName
	 * @return 返回对应记录
	 */
	public TabDirection getDirectionByDirectionName(String directionName) {
		String hql = "from TabDirection c where c.FDirectionName='" + directionName
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabDirection) this.getHibernateTemplate().find(hql).get(0);
	}
	/**根据专业方向编号查找到对应的记录
	 * @param directionId
	 * @return 返回对应记录
	 */
	public TabDirection getDirectionByDirectionId(String directionId) {
		String hql = "from TabDirection c where c.FDirectionId='" + directionId
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabDirection) this.getHibernateTemplate().find(hql).get(0);
	}

	
}
