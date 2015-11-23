package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabDirectionDAO;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabDirection;

/***��רҵ������Ϣ���в���
 * @author ��ѩ
 * @version 1.1
 */
public class SjjxTabDirectionDAOImpl extends HibernateDaoSupport implements SjjxTabDirectionDAO{


	
	/**����רҵ�������Ʋ��ҵ���Ӧ�ļ�¼
	 * @param directionName
	 * @return ���ض�Ӧ��¼
	 */
	public TabDirection getDirectionByDirectionName(String directionName) {
		String hql = "from TabDirection c where c.FDirectionName='" + directionName
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabDirection) this.getHibernateTemplate().find(hql).get(0);
	}
	/**����רҵ�����Ų��ҵ���Ӧ�ļ�¼
	 * @param directionId
	 * @return ���ض�Ӧ��¼
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
