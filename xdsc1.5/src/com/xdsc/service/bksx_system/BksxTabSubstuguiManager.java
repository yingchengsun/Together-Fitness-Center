package com.xdsc.service.bksx_system;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.xdsc.model.BksxTabSubstugui;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabSubstugui����ز���
 */
public interface BksxTabSubstuguiManager {
	/**
	 * �õ�����ѡ��ѧ����Ϊ�յ�ѡ������б�
	 * 
	 * @return List
	 */
	public abstract List<BksxTabSubstugui> getSubstuguiList();

	/**
	 * ����ѡ���¼ID����Ψһ��BksxTabSubstugui����
	 * 
	 * @param id
	 *            ѡ���¼ΨһID
	 * @return BksxTabSubstugui
	 */
	public abstract BksxTabSubstugui getSubstuguiById(int id);

	/**
	 * ����һ��BksxTabSubstugui����
	 * 
	 * @param substugui
	 *            BksxTabSubstugui����
	 * @return boolean
	 */
	public abstract boolean saveSubstugui(BksxTabSubstugui substugui);

	/**
	 * ɾ��һ��BksxTabSubstugui����
	 * 
	 * @param substugui
	 *            BksxTabSubstugui����
	 * @return boolean
	 */
	public abstract boolean deleteSubstugui(BksxTabSubstugui substugui);

	/**
	 * ����һ��BksxTabSubstugui����
	 * 
	 * @param substugui
	 *            BksxTabSubstugui����
	 * @return boolean
	 */
	public abstract boolean updateSubstugui(BksxTabSubstugui substugui);

	/**
	 * ����һ��HQL����ѯ�ض����Ե�BksxTabSubstugui�����б�
	 * 
	 * @param hql
	 *            HQL���
	 * @return List
	 */
	public abstract List getSomeSubstuguiList(String hql);

	/**
	 * ����ѧ��ѧ�Ų�ѯ����һ��BksxTabSubstugui����
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return BksxTabSubstugui
	 */
	public abstract BksxTabSubstugui getSubstuguiByStuNum(String stuNum);

	/**
	 * ���ݽ�ʦ�������ʦְ�Ʋ�ѯ����һ��BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public abstract List getSubstuguiByTeacher(String teacherName,
			String teacherDegree);

	/**
	 * �õ����е��о��ͣ�������Ŀ���Ҵ���ѡ��ѧ����BksxTabSubstugui�����б�
	 * 
	 * @return List
	 */
	public abstract List getReacherList();

	/**
	 * ���ݽ�ʦ�������ʦְ�Ʋ�ѯ����һ����Ŀ�͵�BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public abstract Set getProjectListByTeacher(String teacherName,
			String teacherDegree);

	/**
	 * ���ݽ�ʦ�������ʦְ�Ʋ�ѯ����һ���о��͵�BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public abstract List getResearchByTeacher(String teacherName,
			String teacherDegree);

	/**
	 * ����ѧ���꼶�Ϳ�����Դ��ѯ����һ��BksxTabSubstugui�����б�
	 * 
	 * @param startDate
	 *            һ��Ŀ�ʼ����
	 * @param endDate
	 *            һ��Ľ�������
	 * @return List
	 */
	public abstract List getSubstuguiListByGradeCategory(Date startDate,
			Date endDate, String substuguiCategory);

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
	public abstract List getResearchByGrade(Date startDate, Date endDate,
			String subtype);

	/**
	 * �������Excel��ʽ����Ϣ���Թ�����
	 * 
	 * @return InputStream
	 * 
	 */
	public abstract InputStream getInputStream();

	/**
	 * ���ݿ������Ͳ�ѯ����һ���о��͵�BksxTabSubstugui�����б�
	 * 
	 * @param subtype
	 *            ��������
	 * @return List
	 */
	public abstract List getReacherListByType(String type);

	/**
	 * ���ݽ�ʦ�������ʦְ�Ʋ�ѯ����һ���õ��ý�ʦ��δ��ѧ��ѡ��Ŀ�����Ϣ�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public abstract List getNewSubstuguiByTeacher(String teacherName,
			String teacherDegree);

	/**
	 * ����һ�����н�ʦδ����˿���Ķ����б�
	 * 
	 * @return List
	 */
	public abstract List getApplySubjectList();

	/**
	 * ����һ���ɹ�ѡ��ı�ҵ��ƿ���Ķ����б�
	 * 
	 * @return List
	 */
	public abstract List getAvilableSubjectList();

	/**
	 * ���ݽ�ʦ������ѯ����һ���õ��ý�ʦ��δ��ѧ��ѡ��Ŀ�����Ϣ�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public abstract List getNewSubstuguiByTeacher(String teacherName);

	/**
	 * ���ݽ�ʦ������ѯ����һ��BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public abstract List getSubstuguiByTeacher(String teacherName);

	/**
	 * ���ݽ�ʦ������ѯ����һ����Ŀ�͵�BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public abstract Set getProjectListByTeacher(String teacherName);

	/**
	 * ���ݽ�ʦ������ѯ����һ���о��͵�BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public abstract List getResearchByTeacher(String teacherName);

}