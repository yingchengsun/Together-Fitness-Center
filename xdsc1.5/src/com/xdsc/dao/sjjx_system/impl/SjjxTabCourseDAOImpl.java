package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabCourseDAO;
import com.xdsc.model.SjjxTabLab;
import com.xdsc.model.TabCourse;

/**对课程信息记录进行操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabCourseDAOImpl extends HibernateDaoSupport implements SjjxTabCourseDAO {
	

	


	/**根据课程编号查找到对应的课程记录
	 * @param courseNumber
	 * @return 返回查到的记录
	 */
	public TabCourse getCourseByCourseNumber(String courseNumber) {
		String hql = "from TabCourse c where c.FCourseNumber='" + courseNumber
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabCourse) this.getHibernateTemplate().find(hql).get(0);
	}
	

	/**根据课程名称查找到对应的课程记录
	 * @param courseName
	 * @return 返回查到的记录
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
