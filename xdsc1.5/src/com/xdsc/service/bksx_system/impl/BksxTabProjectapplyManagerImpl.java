package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabProjectapplyDAO;
import com.xdsc.model.BksxTabProjectapply;
import com.xdsc.service.bksx_system.BksxTabProjectapplyManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶������������ز���
 */
public class BksxTabProjectapplyManagerImpl implements
		BksxTabProjectapplyManager {
	private BksxTabProjectapplyDAO bksxTabProjectapplyDAO;

	public BksxTabProjectapplyDAO getBksxTabProjectapplyDAO() {
		return bksxTabProjectapplyDAO;
	}

	public void setBksxTabProjectapplyDAO(
			BksxTabProjectapplyDAO bksxTabProjectapplyDAO) {
		this.bksxTabProjectapplyDAO = bksxTabProjectapplyDAO;
	}

	/**
	 * ����һ��BksxTabProjectapply����
	 * 
	 * @param apply
	 *            BksxTabProjectapply����
	 * @return boolean
	 */
	public boolean saveApply(BksxTabProjectapply apply) {
		return bksxTabProjectapplyDAO.addApply(apply);
	}

	/**
	 * ����һ��BksxTabProjectapply����
	 * 
	 * @param apply
	 *            BksxTabProjectapply����
	 * @return boolean
	 */
	public boolean updateApply(BksxTabProjectapply apply) {
		return bksxTabProjectapplyDAO.updateApply(apply);
	}

	/**
	 * ɾ��һ��BksxTabProjectapply����
	 * 
	 * @param apply
	 *            BksxTabProjectapply����
	 * @return boolean
	 */
	public boolean deleteApply(BksxTabProjectapply apply) {
		return bksxTabProjectapplyDAO.deleteApply(apply);
	}

	/**
	 * ���ݽ�ʦID�õ�����ý�ʦ�������б�
	 * 
	 * @param teacherNum
	 *            ��ʦ����
	 * @return List
	 */
	public List getApplyByTeacherNum(String teacherNum) {
		return bksxTabProjectapplyDAO.getApplyByTeacherNum(teacherNum);
	}

	/**
	 * ����ѧ��ѧ�ŵõ�һ�����������б�
	 * 
	 * @param studentNum
	 *            ѧ��ѧ��
	 * @return List
	 */
	public List getApplyByStudentNum(String studentNum) {
		return bksxTabProjectapplyDAO.getApplyByStudentNum(studentNum);
	}

	/**
	 * ���������¼ID�õ�һ��BksxTabProjectapply����
	 * 
	 * @param id
	 *            BksxTabProjectapply�����ID
	 * @return BksxTabProjectapply
	 */
	public BksxTabProjectapply getApplyByID(int id) {
		return bksxTabProjectapplyDAO.getApplyByID(id);
	}
}
