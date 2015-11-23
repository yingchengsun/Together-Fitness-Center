package com.xdsc.service.jiaofu;

import java.util.List;

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
public interface CorrespondingDeployManager {

	//-------------------------��ʦ�༶�γ�-------------------------------------
	/**
	 * <p>���ܣ���ѯ��ʦ������Ϣ<br>
	 * @return list ��ѯ����������Ϣ
	 */
	public List<JfptTabTeacherassociate> findTeacherDeployInfo();
	
	/**
	 * <p>���ܣ�ͨ��Id�Ž��н�ʦ��Ϣ��ѯ<br>
	 * @param FId ������ϢId��
	 * @return JfptTabTeacherassociate ���ز�ѯ���Ľ�ʦ������Ϣ
	 */
	public JfptTabTeacherassociate findTeacherDeployInfoByID(int FId);
	
	/**
	 * <p>���ܣ�ɾ����ʦ������Ϣ<br>
	 * @param jfptTabTeacherassociate ��ʦ������Ϣ
	 */
	public void deleteTeacherDeployInfo(JfptTabTeacherassociate jfptTabTeacherassociate);
	
	/**
	 * <p>���ܣ���ѯ��ʦ��Ϣ<br>
	 * @return list ���ز�ѯ�Ľ�ʦ��Ϣ
	 */
	public List<TabTeachers> findlistTeachersInfo();
	
	/**
	 * <p>���ܣ���ѯ�༶��Ϣ<br>
	 * @return list ���ذ༶��Ϣ�б�
	 */
	public List<TabClasses> findlistClassesInfo();
	
	/**
	 * <p>���ܣ���ѯ�γ���Ϣ<br>
	 * @return list �γ���Ϣ
	 */
	public List<TabCourse> findlistCourseInfo();

	/**
	 * <p>���ܣ����ݽ�ʦְ���Ų�ѯ��ʦ������Ϣ<br>
	 * @param id ��ʦְ����
	 * @return TabTeachers ���ؽ�ʦ������Ϣ
	 */
	public TabTeachers findTeachersInfoByID(String id);
	
	/**
	 * <p>���ܣ����ݰ༶Id�Ų�ѯ��ذ༶������Ϣ<br>
	 * @param id �༶Id��
	 * @return TabClasses ���ذ༶��Ϣ
	 */
	public TabClasses findClassesInfoByID(String id);
	
	/**
	 * <p>���ܣ����ݿγ�Id�Ų�ѯ�γ̶�����Ϣ<br>
	 * @param id �γ̱��
	 * @return TabCourse ���ز�ѯ���Ŀγ���Ϣ
	 */
	public TabCourse findCourseInfoByID(String id);
	
	/**
	 * <p>���ܣ���ӽ�ʦ������Ϣ<br>
	 * @param jfptTabTeacherassociate ��ʦ������Ϣ����
	 */
	public void addTeacherassociateInfo(JfptTabTeacherassociate jfptTabTeacherassociate);
	
	//-------------------------ѧ���γ̰༶-------------------------------------
	/**
	 * <p>���ܣ���ѯѧ����ص���Ϣ����<br>
	 * @return list ����ѧ��������Ϣ
	 */
	public List<JfptTabStudentassociate> findStudentDeployInfo();
	
	/**
	 * <p>���ܣ�ͨ��Id�Ž���ѧ��������Ϣ��ѯ<br>
	 * @param FInt ������ϢId��
	 * @return JfptTabSudentassociate ѧ��������Ϣ
	 */
	public JfptTabStudentassociate findStudentDeployInfoByID(int FInt);
	
	/**
	 * <p>���ܣ�ɾ��ѧ��������Ϣ<br>
	 * @param jfptTabStudentassociate ѧ��������Ϣ����
	 */
	public void deleteStudentDeployInfo(JfptTabStudentassociate jfptTabStudentassociate);
	
	/**
	 * <p>���ܣ���ѯѧ��������Ϣ<br>
	 * @return list ���ز�ѯ����ѧ����Ϣ
	 */
	public List<TabStudents> findlistStudentsInfo();
	
	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų�ѯѧ����Ϣ<br>
	 * @param id ѧ��ѧ��
	 * @return TabStudents ����ѧ��������Ϣ
	 */
	public TabStudents findStudentsInfoByID(String id);
	
	/**
	 * <p>���ܣ�����ѧ��ѧ�Ų�ѯ�༶��Ϣ<br>
	 * @param id �༶id��
	 * @return TabClasses ���ذ༶��Ϣ
	 */
	public TabClasses findClassesInfoBySid(String id);
	
	/**
	 * <p>���ܣ����ѧ��������Ϣ<br>
	 * @param jfptTabStudentassociate ѧ��������Ϣ����
	 */
	public void addStudentassociateInfo(
			JfptTabStudentassociate jfptTabStudentassociate);
	
	//-------------------------��ʦ�γ�ѧ��-------------------------------------
	/**
	 * <p>���ܣ���ѯѡ�޿γ���Ϣ����<br>
	 * @return list ѡ�޿γ�������Ϣ
	 */
	public List<JfptTabChooseassociate> findOtherDeployInfo();
	
	/**
	 * <p>���ܣ�����Id�Ų�ѯѡ�޿γ�������Ϣ<br>
	 * @param FId ѡ�޿γ�Id��
	 * @return JfptTabChooseassociate ѡ�޿γ�������Ϣ
	 */
	public JfptTabChooseassociate findOtherDeployInfoByID(int FId);
	
	/**
	 * <p>���ܣ�ɾ��ѡ�޿γ�������Ϣ<br>
	 * @param jfptTabChooseassociate ѡ�޿γ�������Ϣ����
	 */
	public void deleteOtherDeployInfo(JfptTabChooseassociate jfptTabChooseassociate);
	
	/**
	 * <p>���ܣ����ѡ�޿γ�������Ϣ<br>
	 * @param jfptTabChooseassociate ѡ�޿γ�������Ϣ
	 */
	public void addChooseassociateInfo(
			JfptTabChooseassociate jfptTabChooseassociate);
}
