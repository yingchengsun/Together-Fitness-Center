package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabClassesDAO;
import com.xdsc.model.TabClasses;

/**���ڰ༶��Ϣ���в���
 * @author ��ѩ
 * @version 1.1
 */
public class SjjxTabClassesDAOImpl extends HibernateDaoSupport implements SjjxTabClassesDAO {
		

		/**���ݰ༶���Ʋ��ҵ���Ӧ�İ༶����
		 *@return ���ز鵽�ļ�¼
		 */
		public TabClasses getClassesByClassName(String className) {
			String hql = "from TabClasses c where c.FClassName='" + className
					+ "'";
			if (this.getHibernateTemplate().find(hql).isEmpty())
				return null;
			else
				return (TabClasses) this.getHibernateTemplate().find(hql).get(0);
		}
		/**���ݰ༶��Ų��ҵ���Ӧ�İ༶����
		 *@return ���ز鵽�ļ�¼
		 */
		public TabClasses getClassesByClassNum(String classNum) {
			String hql = "from TabClasses c where c.FClassNumber='" + classNum
					+ "'";
			if (this.getHibernateTemplate().find(hql).isEmpty())
				return null;
			else
				return (TabClasses) this.getHibernateTemplate().find(hql).get(0);
		}

	}


