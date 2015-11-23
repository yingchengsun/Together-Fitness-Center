package com.xdsc.dao.htgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.htgl_system.TabStudentsDAO;
import com.xdsc.model.TabStudents;
/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�ѧ������ز���
 */
public class TabStudentsDAOImpl extends HibernateDaoSupport implements
		TabStudentsDAO {
	/**
	 * ����ѧ��ѧ�Ż��һ��ѧ������
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return TabStudents
	 */
	public TabStudents getStudentById(String stuNum) {
		String hql = "from TabStudents ts where ts.FStudentNumber='" + stuNum
				+ "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (TabStudents) (this.getHibernateTemplate().find(hql).get(0));
	}
	/**
	 * �õ�����ѧ�����б�
	 * 
	 * @return List
	 */
	public List getStudentList() {
		String hql = "from TabStudents";
		return this.getHibernateTemplate().find(hql);
	}
	public void saveStudent(TabStudents student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(student);
	}
	
	
}
