package com.xdsc.dao.wzmh_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wzmh_system.EntityDAO;
import com.xdsc.model.JfptTabOtherassist;
import com.xdsc.model.TabAdministrator;
import com.xdsc.model.TabCompany;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.model.TabUndergraduate;
import com.xdsc.model.XsglTabParents;

/**
 * ��ɫ���ϲ�ѯ
 * 
 * @author �·�
 * 
 */
public class EntityDAOImpl extends HibernateDaoSupport implements EntityDAO {
	/**
	 * �����ʺŲ�ѯ����Ա
	 * 
	 * @param �ʺ�
	 * @return ����Աʵ��
	 */
	public TabAdministrator findAdministratorByID(String id) {
		String hql = "from TabAdministrator  where FAdminNumber=?";
		List<TabAdministrator> list = getHibernateTemplate().find(hql, id);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * �����ʺŲ�ѯѧ��
	 * 
	 * @param �ʺ�
	 * @return ѧ��ʵ��
	 */
	public TabStudents findStudentByID(String id) {
		String hql = "from TabStudents stu where stu.FStudentNumber=?";
		List<TabStudents> list = getHibernateTemplate().find(hql, id);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * �����ʺŲ�ѯ��ҵ
	 * 
	 * @param �ʺ�
	 * @return ��ҵʵ��
	 */
	public TabCompany findCompanyByID(String id) {
		String hql = "from TabCompany where FCompanyNumber=?";
		List<TabCompany> list = getHibernateTemplate().find(hql, id);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * �����ʺŲ�ѯ����
	 * 
	 * @param �ʺ�
	 * @return ����ʵ��
	 */
	public JfptTabOtherassist findOtherassistByID(String id) {
		String hql = "from JfptTabOtherassist where FAssistantId=?";
		List<JfptTabOtherassist> list = getHibernateTemplate().find(hql, id);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * �����ʺŲ�ѯ�ҳ�
	 * 
	 * @param �ʺ�
	 * @return �ҳ�ʵ��
	 */
	public XsglTabParents findParentsByID(String id) {
		String hql = "from XsglTabParents where FParentId=?";
		List<XsglTabParents> list = getHibernateTemplate().find(hql, id);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * �����ʺŲ�ѯ�о���
	 * 
	 * @param �ʺ�
	 * @return �о���ʵ��
	 */
	public TabPostgraduate findPostgraduateByID(String id) {
		String hql = "from TabPostgraduate where FStudentNumber=?";
		List<TabPostgraduate> list = getHibernateTemplate().find(hql, id);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * �����ʺŲ�ѯ��ʦ
	 * 
	 * @param �ʺ�
	 * @return ��ʦʵ��
	 */

	public TabTeachers findTeacherByID(String id) {
		String hql = "from TabTeachers where FTeacherNumber=?";
		List<TabTeachers> list = getHibernateTemplate().find(hql, id);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * �����ʺŲ�ѯ������
	 * 
	 * @param �ʺ�
	 * @return ������ʵ��
	 */
	public TabUndergraduate findUndergraduateByID(String id) {
		String hql = "from TabUndergraduate where FStudentNumber=?";
		List<TabUndergraduate> list = getHibernateTemplate().find(hql, id);
		return list.isEmpty() ? null : list.get(0);
	}

}
