package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabGradeDAO;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabGrade;

/**对年级信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabGradeDAOImpl extends HibernateDaoSupport implements SjjxTabGradeDAO{


	
	
	/**根据年级名称查找到对应的记录
	 * @param gradeName
	 * @return 返回年级记录
	 */
	public TabGrade getGradeByGradeId(Integer gradeId) {
		String hql = "from TabGrade c where c.FGradeId='" + gradeId
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabGrade) this.getHibernateTemplate().find(hql).get(0);
	}

	/**根据年级编号查找到对应的记录
	 * @param gradeId
	 * @return 返回年级记录
	 */

	public TabGrade getGradeByGradeName(String gradeName) {
		String hql = "from TabGrade c where c.FGradeName='" + gradeName
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabGrade) this.getHibernateTemplate().find(hql).get(0);
	}

	
	
}
