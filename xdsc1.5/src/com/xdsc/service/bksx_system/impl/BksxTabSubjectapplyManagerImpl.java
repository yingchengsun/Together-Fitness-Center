package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabSubjectapplyDAO;
import com.xdsc.model.BksxTabSubjectapply;
import com.xdsc.service.bksx_system.BksxTabSubjectapplyManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabSubjectapply����ز���
 */
public class BksxTabSubjectapplyManagerImpl implements
		BksxTabSubjectapplyManager {
	/**
	 * BksxTabSubjectapplyDAOImpl �ӿ�
	 */
	private BksxTabSubjectapplyDAO bksxTabSubjectapplyDAO;

	/**
	 * bksxTabSubjectapplyDAO Get��Set����
	 */
	public BksxTabSubjectapplyDAO getBksxTabSubjectapplyDAO() {
		return bksxTabSubjectapplyDAO;
	}

	public void setBksxTabSubjectapplyDAO(
			BksxTabSubjectapplyDAO bksxTabSubjectapplyDAO) {
		this.bksxTabSubjectapplyDAO = bksxTabSubjectapplyDAO;
	}

	/**
	 * ����һ��BksxTabSubjectapply����
	 * 
	 * @param apply
	 *            BksxTabSubjectapply����
	 * @return boolean
	 */
	public boolean saveSubjectApply(BksxTabSubjectapply apply) {
		return bksxTabSubjectapplyDAO.saveSubjectApply(apply);
	}

	/**
	 * ɾ��һ��BksxTabSubjectapply����
	 * 
	 * @param apply
	 *            BksxTabSubjectapply����
	 * @return boolean
	 */
	public boolean deleteSubjectApply(BksxTabSubjectapply apply) {
		return bksxTabSubjectapplyDAO.deleteSubjectApply(apply);
	}

	/**
	 * ����һ��BksxTabSubjectapply����
	 * 
	 * @param apply
	 *            BksxTabSubjectapply����
	 * @return boolean
	 */
	public boolean updateSubjectApply(BksxTabSubjectapply apply) {
		return bksxTabSubjectapplyDAO.updateSubjectApply(apply);
	}

	/**
	 * ���ݼ�¼ΨһID��ȡһ��BksxTabSubjectapply����
	 * 
	 * @param applyID
	 *            ��������Ψһ�ɣ�
	 * @return BksxTabSubjectapply
	 */
	public BksxTabSubjectapply getSubjectApplyListByID(int applyID) {
		return bksxTabSubjectapplyDAO.getSubjectApplyListByID(applyID);
	}

	/**
	 * ����ָ����ʦ������ְ�ƻ�ȡһ��BksxTabSubjectapply�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public List getSubjectApplyByTeacher(String teacherName,
			String teacherDegree) {
		return bksxTabSubjectapplyDAO.getSubjectApplyByTeacher(teacherName,
				teacherDegree);
	}

	/**
	 * ����ѧ��ѧ�ź�ѡ���¼ID��ȡһ��BksxTabSubjectapply����
	 * 
	 * @param studentNumber
	 *            ѧ��ѧ��
	 * @param subStuGuiId
	 *            ѡ����ϢID
	 * @return BksxTabSubjectapply
	 */
	public BksxTabSubjectapply getSubjectApplyByStuSub(String studentNumber,
			Integer subStuGuiId) {
		return bksxTabSubjectapplyDAO.getSubjectApplyByStuSub(studentNumber,
				subStuGuiId);
	}

	/**
	 * ����ָ����ʦ������ȡһ��BksxTabSubjectapply�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public List getSubjectApplyByTeacher(String teacherName) {
		return bksxTabSubjectapplyDAO.getSubjectApplyByTeacher(teacherName);
	}

}
