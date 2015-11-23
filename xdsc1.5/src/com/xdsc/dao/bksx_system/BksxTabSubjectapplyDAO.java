package com.xdsc.dao.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabSubjectapply;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabSubjectapply����ز���
 */
public interface BksxTabSubjectapplyDAO {
	/**
	 * ����һ��BksxTabSubjectapply����
	 * 
	 * @param apply
	 *            BksxTabSubjectapply����
	 * @return boolean
	 */
	public abstract boolean saveSubjectApply(BksxTabSubjectapply apply);

	/**
	 * ɾ��һ��BksxTabSubjectapply����
	 * 
	 * @param apply
	 *            BksxTabSubjectapply����
	 * @return boolean
	 */
	public abstract boolean deleteSubjectApply(BksxTabSubjectapply apply);

	/**
	 * ����һ��BksxTabSubjectapply����
	 * 
	 * @param apply
	 *            BksxTabSubjectapply����
	 * @return boolean
	 */
	public abstract boolean updateSubjectApply(BksxTabSubjectapply apply);

	/**
	 * ���ݼ�¼ΨһID��ȡһ��BksxTabSubjectapply����
	 * 
	 * @param applyID
	 *            ��������Ψһ�ɣ�
	 * @return BksxTabSubjectapply
	 */
	public abstract BksxTabSubjectapply getSubjectApplyListByID(int applyID);

	/**
	 * ����ָ����ʦ������ְ�ƻ�ȡһ��BksxTabSubjectapply�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public abstract List getSubjectApplyByTeacher(String teacherName,
			String teacherDegree);

	/**
	 * ����ѧ��ѧ�ź�ѡ���¼ID��ȡһ��BksxTabSubjectapply����
	 * 
	 * @param studentNumber
	 *            ѧ��ѧ��
	 * @param subStuGuiId
	 *            ѡ����ϢID
	 * @return BksxTabSubjectapply
	 */
	public abstract BksxTabSubjectapply getSubjectApplyByStuSub(
			String studentNumber, Integer subStuGuiId);

	/**
	 * ����ָ����ʦ������ȡһ��BksxTabSubjectapply�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public abstract List getSubjectApplyByTeacher(String teacherName);

}