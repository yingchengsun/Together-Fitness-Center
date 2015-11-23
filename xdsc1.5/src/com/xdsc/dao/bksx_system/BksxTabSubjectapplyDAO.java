package com.xdsc.dao.bksx_system;

import java.util.List;

import com.xdsc.model.BksxTabSubjectapply;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabSubjectapply的相关操作
 */
public interface BksxTabSubjectapplyDAO {
	/**
	 * 保存一个BksxTabSubjectapply对象
	 * 
	 * @param apply
	 *            BksxTabSubjectapply对象
	 * @return boolean
	 */
	public abstract boolean saveSubjectApply(BksxTabSubjectapply apply);

	/**
	 * 删除一个BksxTabSubjectapply对象
	 * 
	 * @param apply
	 *            BksxTabSubjectapply对象
	 * @return boolean
	 */
	public abstract boolean deleteSubjectApply(BksxTabSubjectapply apply);

	/**
	 * 更新一个BksxTabSubjectapply对象
	 * 
	 * @param apply
	 *            BksxTabSubjectapply对象
	 * @return boolean
	 */
	public abstract boolean updateSubjectApply(BksxTabSubjectapply apply);

	/**
	 * 根据记录唯一ID获取一个BksxTabSubjectapply对象
	 * 
	 * @param applyID
	 *            课题申请唯一ＩＤ
	 * @return BksxTabSubjectapply
	 */
	public abstract BksxTabSubjectapply getSubjectApplyListByID(int applyID);

	/**
	 * 根据指导教师姓名与职称获取一个BksxTabSubjectapply对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public abstract List getSubjectApplyByTeacher(String teacherName,
			String teacherDegree);

	/**
	 * 根据学生学号和选题记录ID获取一个BksxTabSubjectapply对象
	 * 
	 * @param studentNumber
	 *            学生学号
	 * @param subStuGuiId
	 *            选题信息ID
	 * @return BksxTabSubjectapply
	 */
	public abstract BksxTabSubjectapply getSubjectApplyByStuSub(
			String studentNumber, Integer subStuGuiId);

	/**
	 * 根据指导教师姓名获取一个BksxTabSubjectapply对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public abstract List getSubjectApplyByTeacher(String teacherName);

}