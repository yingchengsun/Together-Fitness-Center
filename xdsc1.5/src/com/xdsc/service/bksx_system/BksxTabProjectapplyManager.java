package com.xdsc.service.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabProjectapply;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对立项申请的相关操作
 */
public interface BksxTabProjectapplyManager {
	/**
	 * 保存一个BksxTabProjectapply对象
	 * 
	 * @param apply
	 *            BksxTabProjectapply对象
	 * @return boolean
	 */
	public abstract boolean saveApply(BksxTabProjectapply apply);

	/**
	 * 更新一个BksxTabProjectapply对象
	 * 
	 * @param apply
	 *            BksxTabProjectapply对象
	 * @return boolean
	 */
	public abstract boolean updateApply(BksxTabProjectapply apply);

	/**
	 * 删除一个BksxTabProjectapply对象
	 * 
	 * @param apply
	 *            BksxTabProjectapply对象
	 * @return boolean
	 */
	public abstract boolean deleteApply(BksxTabProjectapply apply);

	/**
	 * 根据教师ID得到申请该教师的立项列表
	 * 
	 * @param teacherNum
	 *            教师工号
	 * @return List
	 */
	public abstract List getApplyByTeacherNum(String teacherNum);

	/**
	 * 根据学生学号得到一个立项申请列表
	 * 
	 * @param studentNum
	 *            学生学号
	 * @return List
	 */
	public abstract List getApplyByStudentNum(String studentNum);

	/**
	 * 根据申请记录ID得到一个BksxTabProjectapply对象
	 * 
	 * @param id
	 *            BksxTabProjectapply对象的ID
	 * @return BksxTabProjectapply
	 */
	public abstract BksxTabProjectapply getApplyByID(int id);

}