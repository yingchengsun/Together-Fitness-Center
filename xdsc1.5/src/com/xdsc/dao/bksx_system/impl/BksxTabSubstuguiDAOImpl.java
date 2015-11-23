package com.xdsc.dao.bksx_system.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabSubstuguiDAO;
import com.xdsc.model.BksxTabSubstugui;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabSubstugui����ز���
 */
public class BksxTabSubstuguiDAOImpl extends HibernateDaoSupport implements
		BksxTabSubstuguiDAO {

	/**
	 * �õ�����ѡ��ѧ����Ϊ�յ�ѡ������б�
	 * 
	 * @return List
	 */
	public List<BksxTabSubstugui> getSubstuguiList() {
		String hql = "from BksxTabSubstugui bs where bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ����ѡ���¼ID����Ψһ��BksxTabSubstugui����
	 * 
	 * @param id
	 *            ѡ���¼ΨһID
	 * @return BksxTabSubstugui
	 */
	public BksxTabSubstugui getSubstuguiById(int id) {
		String hql = "from BksxTabSubstugui bs where bs.FSubStuGuiId=" + id;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabSubstugui) (this.getHibernateTemplate().find(hql)
					.get(0));
	}

	/**
	 * ����һ��BksxTabSubstugui����
	 * 
	 * @param substugui
	 *            BksxTabSubstugui����
	 * @return boolean
	 */
	public boolean saveSubstugui(BksxTabSubstugui substugui) {
		this.getHibernateTemplate().save(substugui);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabSubstugui����
	 * 
	 * @param substugui
	 *            BksxTabSubstugui����
	 * @return boolean
	 */
	public boolean deleteSubstugui(BksxTabSubstugui substugui) {
		this.getHibernateTemplate().delete(substugui);
		return true;
	}

	/**
	 * ����һ��BksxTabSubstugui����
	 * 
	 * @param substugui
	 *            BksxTabSubstugui����
	 * @return boolean
	 */
	public boolean updateSubstugui(BksxTabSubstugui substugui) {
		this.getHibernateTemplate().update(substugui);
		return true;
	}

	/**
	 * ����һ��HQL����ѯ�ض����Ե�BksxTabSubstugui�����б�
	 * 
	 * @param hql
	 *            HQL���
	 * @return List
	 */
	public List<BksxTabSubstugui> getSomeSubstuguiList(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ����ѧ��ѧ�Ų�ѯ����һ��BksxTabSubstugui����
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return BksxTabSubstugui
	 */
	public BksxTabSubstugui getSubstuguiByStuNum(String stuNum) {
		String hql = "from BksxTabSubstugui bs where bs.tabStudents.FStudentNumber='"
				+ stuNum + "'";
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabSubstugui) (this.getHibernateTemplate().find(hql)
					.get(0));
	}

	/**
	 * ���ݽ�ʦ�������ʦְ�Ʋ�ѯ����һ��BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public List getSubstuguiByTeacher(String teacherName, String teacherDegree) {
		String hql = "from BksxTabSubstugui bs where bs.FTeacherName='"
				+ teacherName + "' and bs.FTeacherDegreen='" + teacherDegree
				+ "' and bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * �õ����е��о��ͣ�������Ŀ���Ҵ���ѡ��ѧ����BksxTabSubstugui�����б�
	 * 
	 * @return List
	 */
	public List getReacherList() {
		String hql = "from BksxTabSubstugui bs where bs.bksxTabProject = null and bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ���ݽ�ʦ�������ʦְ�Ʋ�ѯ����һ����Ŀ�͵�BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public List getProjectListByTeacher(String teacherName, String teacherDegree) {
		String hql = "from BksxTabSubstugui bs where bs.bksxTabProject != null and bs.FTeacherName='"
				+ teacherName
				+ "' and bs.FTeacherDegreen='"
				+ teacherDegree
				+ "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ���ݽ�ʦ�������ʦְ�Ʋ�ѯ����һ���о��͵�BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public List getResearchByTeacher(String teacherName, String teacherDegree) {
		String hql = "from BksxTabSubstugui bs where bs.FTeacherName='"
				+ teacherName + "' and bs.FTeacherDegreen='" + teacherDegree
				+ "' and bs.bksxTabProject = null and bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ����ѧ���꼶�Ϳ�����Դ��ѯ����һ��BksxTabSubstugui�����б�
	 * 
	 * @param startDate
	 *            һ��Ŀ�ʼ����
	 * @param endDate
	 *            һ��Ľ�������
	 * @return List
	 */
	public List getSubstuguiListByGradeCategory(Date startDate, Date endDate,
			String substuguiCategory) {
		String hql = "from BksxTabSubstugui bs where bs.tabStudents.FStudentRegData >= :startDate and bs.tabStudents.FStudentRegData <= :endDate and bs."
				+ substuguiCategory + "='Y'";
		String[] params = { "startDate", "endDate" };
		Object[] args = { startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

	/**
	 * ����ѧ���꼶�Ϳ������Ͳ�ѯ����һ���о��͵�BksxTabSubstugui�����б�
	 * 
	 * @param startDate
	 *            һ��Ŀ�ʼ����
	 * @param endDate
	 *            һ��Ľ�������
	 * @param subtype
	 *            ��������
	 * @return List
	 */
	public List getResearchByGrade(Date startDate, Date endDate, String subtype) {
		String hql = "from BksxTabSubstugui bs where bs.tabStudents.FStudentRegData >= :startDate and bs.tabStudents.FStudentRegData <= :endDate and bs."
				+ subtype + "='Y' and bs.bksxTabProject = null";
		String[] params = { "startDate", "endDate" };
		Object[] args = { startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

	/**
	 * ���ݿ������Ͳ�ѯ����һ���о��͵�BksxTabSubstugui�����б�
	 * 
	 * @param subtype
	 *            ��������
	 * @return List
	 */
	public List getReacherListByType(String type) {
		String hql = "from BksxTabSubstugui bs where bs."
				+ type
				+ "='Y' and bs.bksxTabProject = null and bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ���ݽ�ʦ�������ʦְ�Ʋ�ѯ����һ���õ��ý�ʦ��δ��ѧ��ѡ��Ŀ�����Ϣ�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public List getNewSubstuguiByTeacher(String teacherName,
			String teacherDegree) {
		String hql = "from BksxTabSubstugui bs where bs.tabStudents = null and bs.FTeacherName='"
				+ teacherName
				+ "' and bs.FTeacherDegreen='"
				+ teacherDegree
				+ "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ����һ�����н�ʦδ����˿���Ķ����б�
	 * 
	 * @return List
	 */
	public List getApplySubjectList() {
		String hql = "from BksxTabSubstugui bs where bs.FIsChecked = '�����'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ����һ���ɹ�ѡ��ı�ҵ��ƿ���Ķ����б�
	 * 
	 * @return List
	 */
	public List getAvilableSubjectList() {
		String hql = "from BksxTabSubstugui bs where bs.FIsChecked = '��ͨ��' and bs.tabStudents = null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ���ݽ�ʦ������ѯ����һ���õ��ý�ʦ��δ��ѧ��ѡ��Ŀ�����Ϣ�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @return List
	 */
	public List getNewSubstuguiByTeacher(String teacherName) {
		String hql = "from BksxTabSubstugui bs where bs.tabStudents = null and bs.FTeacherName='"
				+ teacherName + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ���ݽ�ʦ������ѯ����һ��BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public List getSubstuguiByTeacher(String teacherName) {
		String hql = "from BksxTabSubstugui bs where bs.FTeacherName='"
				+ teacherName + "' and bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ���ݽ�ʦ������ѯ����һ����Ŀ�͵�BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public List getProjectListByTeacher(String teacherName) {
		String hql = "from BksxTabSubstugui bs where bs.bksxTabProject != null and bs.FTeacherName='"
				+ teacherName + "'";
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * ���ݽ�ʦ������ѯ����һ���о��͵�BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public List getResearchByTeacher(String teacherName) {
		String hql = "from BksxTabSubstugui bs where bs.FTeacherName='"
				+ teacherName
				+ "' and bs.bksxTabProject = null and bs.tabStudents != null";
		return this.getHibernateTemplate().find(hql);
	}
}
