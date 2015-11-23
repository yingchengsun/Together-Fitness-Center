package com.xdsc.service.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabProjectapply;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶������������ز���
 */
public interface BksxTabProjectapplyManager {
	/**
	 * ����һ��BksxTabProjectapply����
	 * 
	 * @param apply
	 *            BksxTabProjectapply����
	 * @return boolean
	 */
	public abstract boolean saveApply(BksxTabProjectapply apply);

	/**
	 * ����һ��BksxTabProjectapply����
	 * 
	 * @param apply
	 *            BksxTabProjectapply����
	 * @return boolean
	 */
	public abstract boolean updateApply(BksxTabProjectapply apply);

	/**
	 * ɾ��һ��BksxTabProjectapply����
	 * 
	 * @param apply
	 *            BksxTabProjectapply����
	 * @return boolean
	 */
	public abstract boolean deleteApply(BksxTabProjectapply apply);

	/**
	 * ���ݽ�ʦID�õ�����ý�ʦ�������б�
	 * 
	 * @param teacherNum
	 *            ��ʦ����
	 * @return List
	 */
	public abstract List getApplyByTeacherNum(String teacherNum);

	/**
	 * ����ѧ��ѧ�ŵõ�һ�����������б�
	 * 
	 * @param studentNum
	 *            ѧ��ѧ��
	 * @return List
	 */
	public abstract List getApplyByStudentNum(String studentNum);

	/**
	 * ���������¼ID�õ�һ��BksxTabProjectapply����
	 * 
	 * @param id
	 *            BksxTabProjectapply�����ID
	 * @return BksxTabProjectapply
	 */
	public abstract BksxTabProjectapply getApplyByID(int id);

}