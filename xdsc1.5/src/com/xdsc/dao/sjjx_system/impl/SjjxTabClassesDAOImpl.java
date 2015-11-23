package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabClassesDAO;
import com.xdsc.model.TabClasses;

/**对于班级信息进行操作
 * @author 陈雪
 * @version 1.1
 */
public class SjjxTabClassesDAOImpl extends HibernateDaoSupport implements SjjxTabClassesDAO {
		

		/**根据班级名称查找到对应的班级对象
		 *@return 返回查到的记录
		 */
		public TabClasses getClassesByClassName(String className) {
			String hql = "from TabClasses c where c.FClassName='" + className
					+ "'";
			if (this.getHibernateTemplate().find(hql).isEmpty())
				return null;
			else
				return (TabClasses) this.getHibernateTemplate().find(hql).get(0);
		}
		/**根据班级编号查找到对应的班级对象
		 *@return 返回查到的记录
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


