package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.TabTeachersDAO;
import com.xdsc.model.TabTeachers;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶Խ�ʦ����ز���
 */
public class TabTeachersDAOImpl extends HibernateDaoSupport implements
		TabTeachersDAO {
	/**
	 * ���ݽ�ʦ���Ż��һ��ѧ������
	 * 
	 * @param tId
	 *            ��ʦ����
	 * @return TabTeachers
	 */
	public TabTeachers getTeacherById(String tId) {
		String hql = "from TabTeachers t where t.FTeacherNumber='" + tId + "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabTeachers) (this.getHibernateTemplate().find(hql).get(0));
	}

	/**
	 * ���ݽ�ʦ�������һ����ʦ�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @return List
	 */
	public List getTeacherByName(String teacherName) {
		String hql = "from TabTeachers t where t.FTeacherName='" + teacherName
				+ "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ���ݽ�ʦ��������ʦְ�ƻ��һ����ʦ�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegreen
	 *            ��ʦְ��
	 * @return List
	 */
	public List getTeacherByNameDegreen(String teacherName,
			String teacherDegreen) {
		String hql = "from TabTeachers t where t.FTeacherName='" + teacherName
				+ "' and t.FTeacherZhiCheng='" + teacherDegreen + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * �õ����н�ʦ���б�
	 * 
	 * @return List
	 */
	public List getTeacherList() {
		String hql = "from TabTeachers";
		return this.getHibernateTemplate().find(hql);
	}

	public void saveTeacher(TabTeachers teacher) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(teacher);
	}
	
	
}
