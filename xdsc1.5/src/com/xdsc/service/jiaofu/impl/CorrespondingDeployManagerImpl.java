package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.CorrespondingDeployDAO;
import com.xdsc.model.JfptTabChooseassociate;
import com.xdsc.model.JfptTabStudentassociate;
import com.xdsc.model.JfptTabTeacherassociate;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabStudents;
import com.xdsc.model.TabTeachers;
import com.xdsc.service.jiaofu.CorrespondingDeployManager;
/**
 * <p>���ܣ��漰��Ӧ������Ϣ�е���ز�������<br>
 * @author qianxun
 * @version 1.1
 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
 */
public class CorrespondingDeployManagerImpl implements CorrespondingDeployManager{
	/**DAO�����*/
	private CorrespondingDeployDAO correspondingDeployDAO;

	public CorrespondingDeployDAO getCorrespondingDeployDAO() {
		return correspondingDeployDAO;
	}

	public void setCorrespondingDeployDAO(
			CorrespondingDeployDAO correspondingDeployDAO) {
		this.correspondingDeployDAO = correspondingDeployDAO;
	}
	//-------------------------��ʦ�༶�γ�-------------------------------------
	/**
	 * <p>���ܣ���ѯ��ʦ������Ϣ<br>
	 * @return list ��ѯ����������Ϣ
	 */
	public List<JfptTabTeacherassociate> findTeacherDeployInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findTeacherDeployInfo();
	}

	/**
	 * <p>���ܣ�ͨ��Id�Ž��н�ʦ��Ϣ��ѯ<br>
	 * @param FId ������ϢId��
	 * @return JfptTabTeacherassociate ���ز�ѯ���Ľ�ʦ������Ϣ
	 */
	public JfptTabTeacherassociate findTeacherDeployInfoByID(int FId) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findTeacherDeployInfoByID(FId);
	}

	/**
	 * <p>���ܣ�ɾ����ʦ������Ϣ<br>
	 * @param jfptTabTeacherassociate ��ʦ������Ϣ
	 */
	public void deleteTeacherDeployInfo(
			JfptTabTeacherassociate jfptTabTeacherassociate) {
		// TODO Auto-generated method stub
		correspondingDeployDAO.deleteTeacherDeployInfo(jfptTabTeacherassociate);
	}

	/**
	 * <p>���ܣ���ѯ��ʦ��Ϣ<br>
	 * @return list ���ز�ѯ�Ľ�ʦ��Ϣ
	 */
	public List<TabTeachers> findlistTeachersInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findlistTeachersInfo();
	}

	
	
	
	//-------------------------ѧ���γ̰༶-------------------------------------
	/**
	 * <p>���ܣ���ѯѧ����ص���Ϣ����<br>
	 * @return list ����ѧ��������Ϣ
	 */
	public List<JfptTabStudentassociate> findStudentDeployInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findStudentDeployInfo();
	}

	/**
	 * <p>���ܣ�ͨ��Id�Ž���ѧ��������Ϣ��ѯ<br>
	 * @param FInt ������ϢId��
	 * @return JfptTabSudentassociate ѧ��������Ϣ
	 */
	public JfptTabStudentassociate findStudentDeployInfoByID(int FInt) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findStudentDeployInfoByID(FInt);
	}

	/**
	 * <p>���ܣ�ɾ��ѧ��������Ϣ<br>
	 * @param jfptTabStudentassociate ѧ��������Ϣ����
	 */
	public void deleteStudentDeployInfo(
			JfptTabStudentassociate jfptTabStudentassociate) {
		// TODO Auto-generated method stub
		correspondingDeployDAO.deleteStudentDeployInfo(jfptTabStudentassociate);
	}

	
	
	//-------------------------��ʦ�γ�ѧ��-------------------------------------
	/**
	 * <p>���ܣ���ѯѡ�޿γ���Ϣ����<br>
	 * @return list ѡ�޿γ�������Ϣ
	 */
	public List<JfptTabChooseassociate> findOtherDeployInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findOtherDeployInfo();
	}

	/**
	 * <p>���ܣ�ɾ��ѡ�޿γ�������Ϣ<br>
	 * @param jfptTabChooseassociate ѡ�޿γ�������Ϣ����
	 */
	public void deleteOtherDeployInfo(
			JfptTabChooseassociate jfptTabChooseassociate) {
		// TODO Auto-generated method stub
		correspondingDeployDAO.deleteOtherDeployInfo(jfptTabChooseassociate);
	}

	/**
	 * <p>���ܣ�����Id�Ų�ѯѡ�޿γ�������Ϣ<br>
	 * @param FId ѡ�޿γ�Id��
	 * @return JfptTabChooseassociate ѡ�޿γ�������Ϣ
	 */
	public JfptTabChooseassociate findOtherDeployInfoByID(int FId) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findOtherDeployInfoByID(FId);
	}

	/**
	 * <p>���ܣ���ѯ�༶��Ϣ<br>
	 * @return list ���ذ༶��Ϣ�б�
	 */
	public List<TabClasses> findlistClassesInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findlistClassesInfo();
	}

	/**
	 * <p>���ܣ���ѯ�γ���Ϣ<br>
	 * @return list �γ���Ϣ
	 */
	public List<TabCourse> findlistCourseInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findlistCourseInfo();
	}

	/**
	 * <p>���ܣ���ӽ�ʦ������Ϣ<br>
	 * @param jfptTabTeacherassociate ��ʦ������Ϣ����
	 */
	public void addTeacherassociateInfo(
			JfptTabTeacherassociate jfptTabTeacherassociate) {
		// TODO Auto-generated method stub
		correspondingDeployDAO.addTeacherassociateInfo(jfptTabTeacherassociate);
	}

	/**
	 * <p>���ܣ����ݰ༶Id�Ų�ѯ��ذ༶������Ϣ<br>
	 * @param id �༶Id��
	 * @return TabClasses ���ذ༶��Ϣ
	 */
	public TabClasses findClassesInfoByID(String id) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findClassesInfoByID(id);
	}

	/**
	 * <p>���ܣ����ݿγ�Id�Ų�ѯ�γ̶�����Ϣ<br>
	 * @param id �γ̱��
	 * @return TabCourse ���ز�ѯ���Ŀγ���Ϣ
	 */
	public TabCourse findCourseInfoByID(String id) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findCourseInfoByID(id);
	}

	/**
	 * <p>���ܣ����ݽ�ʦְ���Ų�ѯ��ʦ������Ϣ<br>
	 * @param id ��ʦְ����
	 * @return TabTeachers ���ؽ�ʦ������Ϣ
	 */
	public TabTeachers findTeachersInfoByID(String id) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findTeachersInfoByID(id);
	}

	/**
	 * <p>���ܣ���ѯѧ��������Ϣ<br>
	 * @return list ���ز�ѯ����ѧ����Ϣ
	 */
	public List<TabStudents> findlistStudentsInfo() {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findlistStudentsInfo();
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų�ѯ�༶��Ϣ<br>
	 * @param id �༶id��
	 * @return TabClasses ���ذ༶��Ϣ
	 */
	public TabClasses findClassesInfoBySid(String id) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findClassesInfoBySid(id);
	}

	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų�ѯѧ����Ϣ<br>
	 * @param id ѧ��ѧ��
	 * @return TabStudents ����ѧ��������Ϣ
	 */
	public TabStudents findStudentsInfoByID(String id) {
		// TODO Auto-generated method stub
		return correspondingDeployDAO.findStudentsInfoByID(id);
	}

	/**
	 * <p>���ܣ����ѧ��������Ϣ<br>
	 * @param jfptTabStudentassociate ѧ��������Ϣ����
	 */
	public void addStudentassociateInfo(
			JfptTabStudentassociate jfptTabStudentassociate) {
		// TODO Auto-generated method stub
		correspondingDeployDAO.addStudentassociateInfo(jfptTabStudentassociate);
	}

	/**
	 * <p>���ܣ����ѡ�޿γ�������Ϣ<br>
	 * @param jfptTabChooseassociate ѡ�޿γ�������Ϣ
	 */
	public void addChooseassociateInfo(
			JfptTabChooseassociate jfptTabChooseassociate) {
		// TODO Auto-generated method stub
		correspondingDeployDAO.addChooseassociateInfo(jfptTabChooseassociate);
	}
}
