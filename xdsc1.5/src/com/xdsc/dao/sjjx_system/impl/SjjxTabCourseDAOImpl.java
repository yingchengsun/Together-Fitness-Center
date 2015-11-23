package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabCourseDAO;
import com.xdsc.model.SjjxTabLab;
import com.xdsc.model.TabCourse;

/**�Կγ���Ϣ��¼���в���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabCourseDAOImpl extends HibernateDaoSupport implements SjjxTabCourseDAO {
	

	


	/**���ݿγ̱�Ų��ҵ���Ӧ�Ŀγ̼�¼
	 * @param courseNumber
	 * @return ���ز鵽�ļ�¼
	 */
	public TabCourse getCourseByCourseNumber(String courseNumber) {
		String hql = "from TabCourse c where c.FCourseNumber='" + courseNumber
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabCourse) this.getHibernateTemplate().find(hql).get(0);
	}
	

	/**���ݿγ����Ʋ��ҵ���Ӧ�Ŀγ̼�¼
	 * @param courseName
	 * @return ���ز鵽�ļ�¼
	 */
	public TabCourse getCourseByCourseName(String courseName) {
		String hql = "from TabCourse c where c.FCourseName='" + courseName
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabCourse) this.getHibernateTemplate().find(hql).get(0);
	}
	

}
