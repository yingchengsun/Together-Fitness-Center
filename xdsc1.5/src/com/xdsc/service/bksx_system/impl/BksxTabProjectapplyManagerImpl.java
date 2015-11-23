package com.xdsc.service.bksx_system.impl;

import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabProjectapplyDAO;
import com.xdsc.model.BksxTabProjectapply;
import com.xdsc.service.bksx_system.BksxTabProjectapplyManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对立项申请的相关操作
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
	 * 保存一个BksxTabProjectapply对象
	 * 
	 * @param apply
	 *            BksxTabProjectapply对象
	 * @return boolean
	 */
	public boolean saveApply(BksxTabProjectapply apply) {
		return bksxTabProjectapplyDAO.addApply(apply);
	}

	/**
	 * 更新一个BksxTabProjectapply对象
	 * 
	 * @param apply
	 *            BksxTabProjectapply对象
	 * @return boolean
	 */
	public boolean updateApply(BksxTabProjectapply apply) {
		return bksxTabProjectapplyDAO.updateApply(apply);
	}

	/**
	 * 删除一个BksxTabProjectapply对象
	 * 
	 * @param apply
	 *            BksxTabProjectapply对象
	 * @return boolean
	 */
	public boolean deleteApply(BksxTabProjectapply apply) {
		return bksxTabProjectapplyDAO.deleteApply(apply);
	}

	/**
	 * 根据教师ID得到申请该教师的立项列表
	 * 
	 * @param teacherNum
	 *            教师工号
	 * @return List
	 */
	public List getApplyByTeacherNum(String teacherNum) {
		return bksxTabProjectapplyDAO.getApplyByTeacherNum(teacherNum);
	}

	/**
	 * 根据学生学号得到一个立项申请列表
	 * 
	 * @param studentNum
	 *            学生学号
	 * @return List
	 */
	public List getApplyByStudentNum(String studentNum) {
		return bksxTabProjectapplyDAO.getApplyByStudentNum(studentNum);
	}

	/**
	 * 根据申请记录ID得到一个BksxTabProjectapply对象
	 * 
	 * @param id
	 *            BksxTabProjectapply对象的ID
	 * @return BksxTabProjectapply
	 */
	public BksxTabProjectapply getApplyByID(int id) {
		return bksxTabProjectapplyDAO.getApplyByID(id);
	}
}
