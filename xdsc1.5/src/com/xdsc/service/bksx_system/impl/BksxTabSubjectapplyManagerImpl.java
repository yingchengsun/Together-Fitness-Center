package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabSubjectapplyDAO;
import com.xdsc.model.BksxTabSubjectapply;
import com.xdsc.service.bksx_system.BksxTabSubjectapplyManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabSubjectapply的相关操作
 */
public class BksxTabSubjectapplyManagerImpl implements
		BksxTabSubjectapplyManager {
	/**
	 * BksxTabSubjectapplyDAOImpl 接口
	 */
	private BksxTabSubjectapplyDAO bksxTabSubjectapplyDAO;

	/**
	 * bksxTabSubjectapplyDAO Get与Set方法
	 */
	public BksxTabSubjectapplyDAO getBksxTabSubjectapplyDAO() {
		return bksxTabSubjectapplyDAO;
	}

	public void setBksxTabSubjectapplyDAO(
			BksxTabSubjectapplyDAO bksxTabSubjectapplyDAO) {
		this.bksxTabSubjectapplyDAO = bksxTabSubjectapplyDAO;
	}

	/**
	 * 保存一个BksxTabSubjectapply对象
	 * 
	 * @param apply
	 *            BksxTabSubjectapply对象
	 * @return boolean
	 */
	public boolean saveSubjectApply(BksxTabSubjectapply apply) {
		return bksxTabSubjectapplyDAO.saveSubjectApply(apply);
	}

	/**
	 * 删除一个BksxTabSubjectapply对象
	 * 
	 * @param apply
	 *            BksxTabSubjectapply对象
	 * @return boolean
	 */
	public boolean deleteSubjectApply(BksxTabSubjectapply apply) {
		return bksxTabSubjectapplyDAO.deleteSubjectApply(apply);
	}

	/**
	 * 更新一个BksxTabSubjectapply对象
	 * 
	 * @param apply
	 *            BksxTabSubjectapply对象
	 * @return boolean
	 */
	public boolean updateSubjectApply(BksxTabSubjectapply apply) {
		return bksxTabSubjectapplyDAO.updateSubjectApply(apply);
	}

	/**
	 * 根据记录唯一ID获取一个BksxTabSubjectapply对象
	 * 
	 * @param applyID
	 *            课题申请唯一ＩＤ
	 * @return BksxTabSubjectapply
	 */
	public BksxTabSubjectapply getSubjectApplyListByID(int applyID) {
		return bksxTabSubjectapplyDAO.getSubjectApplyListByID(applyID);
	}

	/**
	 * 根据指导教师姓名与职称获取一个BksxTabSubjectapply对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public List getSubjectApplyByTeacher(String teacherName,
			String teacherDegree) {
		return bksxTabSubjectapplyDAO.getSubjectApplyByTeacher(teacherName,
				teacherDegree);
	}

	/**
	 * 根据学生学号和选题记录ID获取一个BksxTabSubjectapply对象
	 * 
	 * @param studentNumber
	 *            学生学号
	 * @param subStuGuiId
	 *            选题信息ID
	 * @return BksxTabSubjectapply
	 */
	public BksxTabSubjectapply getSubjectApplyByStuSub(String studentNumber,
			Integer subStuGuiId) {
		return bksxTabSubjectapplyDAO.getSubjectApplyByStuSub(studentNumber,
				subStuGuiId);
	}

	/**
	 * 根据指导教师姓名获取一个BksxTabSubjectapply对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public List getSubjectApplyByTeacher(String teacherName) {
		return bksxTabSubjectapplyDAO.getSubjectApplyByTeacher(teacherName);
	}

}
