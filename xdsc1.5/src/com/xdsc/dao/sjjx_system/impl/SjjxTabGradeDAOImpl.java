package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabGradeDAO;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabGrade;

/**���꼶��Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabGradeDAOImpl extends HibernateDaoSupport implements SjjxTabGradeDAO{


	
	
	/**�����꼶���Ʋ��ҵ���Ӧ�ļ�¼
	 * @param gradeName
	 * @return �����꼶��¼
	 */
	public TabGrade getGradeByGradeId(Integer gradeId) {
		String hql = "from TabGrade c where c.FGradeId='" + gradeId
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabGrade) this.getHibernateTemplate().find(hql).get(0);
	}

	/**�����꼶��Ų��ҵ���Ӧ�ļ�¼
	 * @param gradeId
	 * @return �����꼶��¼
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
