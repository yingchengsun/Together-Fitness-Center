package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabTeacherstotypeDAO;
import com.xdsc.model.TabTeacherstotype;

/**对教师信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabTeacherstotypeDAOImpl extends HibernateDaoSupport implements SjjxTabTeacherstotypeDAO{

	
	/**通过教师类型查找到教师记录列表
	 * @param teacherName
	 * @return 返回列表
	 */
	public List<TabTeacherstotype> getTeacherByType() {
		String hql = "from TabTeacherstotype";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return this.getHibernateTemplate().find(hql);
	}
}
