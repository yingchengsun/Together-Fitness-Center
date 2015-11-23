package com.xdsc.service.bksx_system;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.xdsc.model.BksxTabSubstugui;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabSubstugui的相关操作
 */
public interface BksxTabSubstuguiManager {
	/**
	 * 得到所有选题学生不为空的选题对象列表
	 * 
	 * @return List
	 */
	public abstract List<BksxTabSubstugui> getSubstuguiList();

	/**
	 * 根据选题记录ID查找唯一的BksxTabSubstugui对象
	 * 
	 * @param id
	 *            选题记录唯一ID
	 * @return BksxTabSubstugui
	 */
	public abstract BksxTabSubstugui getSubstuguiById(int id);

	/**
	 * 保存一个BksxTabSubstugui对象
	 * 
	 * @param substugui
	 *            BksxTabSubstugui对象
	 * @return boolean
	 */
	public abstract boolean saveSubstugui(BksxTabSubstugui substugui);

	/**
	 * 删除一个BksxTabSubstugui对象
	 * 
	 * @param substugui
	 *            BksxTabSubstugui对象
	 * @return boolean
	 */
	public abstract boolean deleteSubstugui(BksxTabSubstugui substugui);

	/**
	 * 更新一个BksxTabSubstugui对象
	 * 
	 * @param substugui
	 *            BksxTabSubstugui对象
	 * @return boolean
	 */
	public abstract boolean updateSubstugui(BksxTabSubstugui substugui);

	/**
	 * 根据一条HQL语句查询特定属性的BksxTabSubstugui对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @return List
	 */
	public abstract List getSomeSubstuguiList(String hql);

	/**
	 * 根据学生学号查询返回一个BksxTabSubstugui对象
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return BksxTabSubstugui
	 */
	public abstract BksxTabSubstugui getSubstuguiByStuNum(String stuNum);

	/**
	 * 根据教师姓名与教师职称查询返回一个BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public abstract List getSubstuguiByTeacher(String teacherName,
			String teacherDegree);

	/**
	 * 得到所有的研究型（个人项目）且存在选题学生的BksxTabSubstugui对象列表
	 * 
	 * @return List
	 */
	public abstract List getReacherList();

	/**
	 * 根据教师姓名与教师职称查询返回一个项目型的BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public abstract Set getProjectListByTeacher(String teacherName,
			String teacherDegree);

	/**
	 * 根据教师姓名与教师职称查询返回一个研究型的BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public abstract List getResearchByTeacher(String teacherName,
			String teacherDegree);

	/**
	 * 根据学生年级和课题来源查询返回一个BksxTabSubstugui对象列表
	 * 
	 * @param startDate
	 *            一年的开始日期
	 * @param endDate
	 *            一年的结束日期
	 * @return List
	 */
	public abstract List getSubstuguiListByGradeCategory(Date startDate,
			Date endDate, String substuguiCategory);

	/**
	 * 根据学生年级和课题类型查询返回一个研究型的BksxTabSubstugui对象列表
	 * 
	 * @param startDate
	 *            一年的开始日期
	 * @param endDate
	 *            一年的结束日期
	 * @param subtype
	 *            课题类型
	 * @return List
	 */
	public abstract List getResearchByGrade(Date startDate, Date endDate,
			String subtype);

	/**
	 * 构造课题Excel格式的信息表以供导出
	 * 
	 * @return InputStream
	 * 
	 */
	public abstract InputStream getInputStream();

	/**
	 * 根据课题类型查询返回一个研究型的BksxTabSubstugui对象列表
	 * 
	 * @param subtype
	 *            课题类型
	 * @return List
	 */
	public abstract List getReacherListByType(String type);

	/**
	 * 根据教师姓名与教师职称查询返回一个得到该教师的未被学生选题的课题信息对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public abstract List getNewSubstuguiByTeacher(String teacherName,
			String teacherDegree);

	/**
	 * 返回一个所有教师未被审核课题的对象列表
	 * 
	 * @return List
	 */
	public abstract List getApplySubjectList();

	/**
	 * 返回一个可供选择的毕业设计课题的对象列表
	 * 
	 * @return List
	 */
	public abstract List getAvilableSubjectList();

	/**
	 * 根据教师姓名查询返回一个得到该教师的未被学生选题的课题信息对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public abstract List getNewSubstuguiByTeacher(String teacherName);

	/**
	 * 根据教师姓名查询返回一个BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public abstract List getSubstuguiByTeacher(String teacherName);

	/**
	 * 根据教师姓名查询返回一个项目型的BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public abstract Set getProjectListByTeacher(String teacherName);

	/**
	 * 根据教师姓名查询返回一个研究型的BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public abstract List getResearchByTeacher(String teacherName);

}