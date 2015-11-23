package com.xdsc.dao.sjjx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.sjjx_system.SjjxTabTeachersDAO;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabTeachers;

/**�Խ�ʦ��Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabTeachersDAOImpl extends HibernateDaoSupport implements SjjxTabTeachersDAO {
	

	

	/**�����ݿ��в��ҵ����еĽ�ʦ��¼
	 * @return ���ҵ������м�¼
	 */
	public List<TabTeachers> getTeacherList() {
		String hql = "from TabTeachers";
		return this.getHibernateTemplate().find(hql);
	}
	


	/**ͨ����ʦѧ���Ų��ҵ���Ӧ�Ľ�ʦ��¼
	 * @param teacherNumber
	 * @return ���ز��ҵ��ļ�¼
	 */
	public TabTeachers getTeacherByTeacherNumber(String teacherNumber) {
		String hql = "from TabTeachers t where t.FTeacherNumber='" + teacherNumber
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabTeachers) this.getHibernateTemplate().find(hql).get(0);
	}
	


	/**ͨ����ʦ�������ҵ���Ӧ�Ľ�ʦ��¼
	 * @param teacherName
	 * @return ���ز��ҵ��ļ�¼
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
