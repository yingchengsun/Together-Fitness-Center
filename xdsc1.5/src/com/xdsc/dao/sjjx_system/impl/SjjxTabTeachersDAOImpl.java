package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabTeachersDAO;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabTeachers;

/**对教师信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabTeachersDAOImpl extends HibernateDaoSupport implements SjjxTabTeachersDAO {
	

	

	/**从数据库中查找到所有的教师记录
	 * @return 查找到的所有记录
	 */
	public List<TabTeachers> getTeacherList() {
		String hql = "from TabTeachers";
		return this.getHibernateTemplate().find(hql);
	}
	


	/**通过教师学工号查找到相应的教师记录
	 * @param teacherNumber
	 * @return 返回查找到的记录
	 */
	public TabTeachers getTeacherByTeacherNumber(String teacherNumber) {
		String hql = "from TabTeachers t where t.FTeacherNumber='" + teacherNumber
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabTeachers) this.getHibernateTemplate().find(hql).get(0);
	}
	


	/**通过教师姓名查找到相应的教师记录
	 * @param teacherName
	 * @return 返回查找到的记录
	 */
	public TabTeachers getTeacherByTeacherName(String teacherName) {
		String hql = "from TabTeachers t where t.FTeacherName='" + teacherName
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabTeachers) this.getHibernateTemplate().find(hql).get(0);
	}


}
