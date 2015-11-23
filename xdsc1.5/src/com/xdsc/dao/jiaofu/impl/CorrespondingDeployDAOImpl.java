package com.xdsc.dao.jiaofu.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.jiaofu.CorrespondingDeployDAO;
import com.xdsc.model.JfptTabChooseassociate;
import com.xdsc.model.JfptTabStudentassociate;
import com.xdsc.model.JfptTabTeacherassociate;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;

/**
 * <p>���ܣ��漰��Ӧ������Ϣ�е���ز�������<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class CorrespondingDeployDAOImpl extends HibernateDaoSupport implements CorrespondingDeployDAO{

	//-------------------------��ʦ�༶�γ�-------------------------------------
	/**
	 * <p>���ܣ���ѯ��ʦ������Ϣ<br>
	 * @return list ��ѯ����������Ϣ
	 */
	public List<JfptTabTeacherassociate> findTeacherDeployInfo() {
		// TODO Auto-generated method stub
		String sql = "from JfptTabTeacherassociate";
		List<JfptTabTeacherassociate> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ�ͨ��Id�Ž��н�ʦ��Ϣ��ѯ<br>
	 * @param FId ������ϢId��
	 * @return JfptTabTeacherassociate ���ز�ѯ���Ľ�ʦ������Ϣ
	 */
	public JfptTabTeacherassociate findTeacherDeployInfoByID(int FId) {
		// TODO Auto-generated method stub
		return (JfptTabTeacherassociate)this.getHibernateTemplate().get(JfptTabTeacherassociate.class, FId);
	}

	/**
	 * <p>���ܣ�ɾ����ʦ������Ϣ<br>
	 * @param jfptTabTeacherassociate ��ʦ������Ϣ
	 */
	public void deleteTeacherDeployInfo(
			JfptTabTeacherassociate jfptTabTeacherassociate) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(jfptTabTeacherassociate);
	}

	/**
	 * <p>���ܣ���ѯ�༶��Ϣ<br>
	 * @return list ���ذ༶��Ϣ�б�
	 */
	public List<TabClasses> findlistClassesInfo() {
		// TODO Auto-generated method stub
		String sql = "from TabClasses";
		List<TabClasses> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ���ѯ�γ���Ϣ<br>
	 * @return list �γ���Ϣ
	 */
	public List<TabCourse> findlistCourseInfo() {
		// TODO Auto-generated method stub
		String sql = "from TabCourse";
		List<TabCourse> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ���ѯ��ʦ��Ϣ<br>
	 * @return list ���ز�ѯ�Ľ�ʦ��Ϣ
	 */
	public List<TabTeachers> findlistTeachersInfo() {
		// TODO Auto-generated method stub
		String sql = "from TabTeachers";
		List<TabTeachers> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	
	//-------------------------ѧ���γ̰༶-------------------------------------
	/**
	 * <p>���ܣ���ѯѧ����ص���Ϣ����<br>
	 * @return list ����ѧ��������Ϣ
	 */
	public List<JfptTabStudentassociate> findStudentDeployInfo() {
		// TODO Auto-generated method stub
		String sql = "from JfptTabStudentassociate";
		List<JfptTabStudentassociate> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ�ͨ��Id�Ž���ѧ��������Ϣ��ѯ<br>
	 * @param FInt ������ϢId��
	 * @return JfptTabSudentassociate ѧ��������Ϣ
	 */
	public JfptTabStudentassociate findStudentDeployInfoByID(int FInt) {
		// TODO Auto-generated method stub
		return (JfptTabStudentassociate)this.getHibernateTemplate().get(JfptTabStudentassociate.class, FInt);
	}

	/**
	 * <p>���ܣ�ɾ��ѧ��������Ϣ<br>
	 * @param jfptTabStudentassociate ѧ��������Ϣ����
	 */
	public void deleteStudentDeployInfo(
			JfptTabStudentassociate jfptTabStudentassociate) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(jfptTabStudentassociate);
	}

	//-------------------------��ʦ�γ�ѧ��-------------------------------------
	/**
	 * <p>���ܣ���ѯѡ�޿γ���Ϣ����<br>
	 * @return list ѡ�޿γ�������Ϣ
	 */
	public List<JfptTabChooseassociate> findOtherDeployInfo() {
		// TODO Auto-generated method stub
		String sql = "from JfptTabChooseassociate";
		List<JfptTabChooseassociate> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ�����Id�Ų�ѯѡ�޿γ�������Ϣ<br>
	 * @param FId ѡ�޿γ�Id��
	 * @return JfptTabChooseassociate ѡ�޿γ�������Ϣ
	 */
	public JfptTabChooseassociate findOtherDeployInfoByID(int FId) {
		// TODO Auto-generated method stub
		return (JfptTabChooseassociate)this.getHibernateTemplate().get(JfptTabChooseassociate.class, FId);
	}

	/**
	 * <p>���ܣ�ɾ��ѡ�޿γ�������Ϣ<br>
	 * @param jfptTabChooseassociate ѡ�޿γ�������Ϣ����
	 */
	public void deleteOtherDeployInfo(
			JfptTabChooseassociate jfptTabChooseassociate) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(jfptTabChooseassociate);
	}

	/**
	 * <p>���ܣ���ӽ�ʦ������Ϣ<br>
	 * @param jfptTabTeacherassociate ��ʦ������Ϣ����
	 */
	public void addTeacherassociateInfo(
			JfptTabTeacherassociate jfptTabTeacherassociate) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabTeacherassociate);
	}

	/**
	 * <p>���ܣ����ݰ༶Id�Ų�ѯ��ذ༶������Ϣ<br>
	 * @param id �༶Id��
	 * @return TabClasses ���ذ༶��Ϣ
	 */
	public TabClasses findClassesInfoByID(String id) {
		// TODO Auto-generated method stub
		return (TabClasses)this.getHibernateTemplate().get(TabClasses.class, id);
	}

	/**
	 * <p>���ܣ����ݿγ�Id�Ų�ѯ�γ̶�����Ϣ<br>
	 * @param id �γ̱��
	 * @return TabCourse ���ز�ѯ���Ŀγ���Ϣ
	 */
	public TabCourse findCourseInfoByID(String id) {
		// TODO Auto-generated method stub
		return (TabCourse)this.getHibernateTemplate().get(TabCourse.class, id);
	}

	/**
	 * <p>���ܣ����ݽ�ʦְ���Ų�ѯ��ʦ������Ϣ<br>
	 * @param id ��ʦְ����
	 * @return TabTeachers ���ؽ�ʦ������Ϣ
	 */
	public TabTeachers findTeachersInfoByID(String id) {
		// TODO Auto-generated method stub
		return (TabTeachers)this.getHibernateTemplate().get(TabTeachers.class, id);
	}

	/**
	 * <p>���ܣ���ѯѧ��������Ϣ<br>
	 * @return list ���ز�ѯ����ѧ����Ϣ
	 */
	public List<TabStudents> findlistStudentsInfo() {
		// TODO Auto-generated method stub
		String sql = "from TabStudents";
		List<TabStudents> list = this.getHibernateTemplate().find(sql);
		return list;
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų�ѯ�༶��Ϣ<br>
	 * @param id �༶id��
	 * @return TabClasses ���ذ༶��Ϣ
	 */
	public TabClasses findClassesInfoBySid(String id) {
		// TODO Auto-generated method stub
		String cid = ((TabStudents)this.getHibernateTemplate().get(TabStudents.class, id)).getTabClasses().getFClassNumber();
		return (TabClasses)this.getHibernateTemplate().get(TabClasses.class, cid);
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų�ѯѧ����Ϣ<br>
	 * @param id ѧ��ѧ��
	 * @return TabStudents ����ѧ��������Ϣ
	 */
	public TabStudents findStudentsInfoByID(String id) {
		// TODO Auto-generated method stub
		return (TabStudents)this.getHibernateTemplate().get(TabStudents.class, id);
	}

	/**
	 * <p>���ܣ����ѧ��������Ϣ<br>
	 * @param jfptTabStudentassociate ѧ��������Ϣ����
	 */
	public void addStudentassociateInfo(
			JfptTabStudentassociate jfptTabStudentassociate) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabStudentassociate);
	}

	/**
	 * <p>���ܣ����ѡ�޿γ�������Ϣ<br>
	 * @param jfptTabChooseassociate ѡ�޿γ�������Ϣ
	 */
	public void addChooseassociateInfo(
			JfptTabChooseassociate jfptTabChooseassociate) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(jfptTabChooseassociate);
	}
}
