package com.xdsc.service.jiaofu;

import java.util.List;

import com.xdsc.model.JfptTabAssistantapply;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabTeachers;
/**
 * <p>助教权限管理中涉及到的操作，其中包括添加助教、助教权限审批、删除、查找等。<br>
 * @author qianxun
 * @version 1.1
 */
public interface AdminCourseAssistantManager {

	/**
	 * <p>功能：查询助教申请记录信息<br>
	 * @return list 返回相关信息记录集
	 */
	public List<JfptTabAssistantapply> findAssistantapplyInfo();
	/**
	 * <p>功能：根据申请记录对象ID信息查找对象<br>
	 * @param FId 申请记录信息主键号
	 * @return JfptTabAssistantapply 返回查找到的对象
	 */
	public JfptTabAssistantapply findAssistantapplyInfoByID(int FId);
	/**
	 * <p>功能：删除助教申请对象信息<br>
	 * @param jfptTabAssistantapply 助教申请记录信息对象
	 */
	public void deleteAssistantapplyInfo(JfptTabAssistantapply jfptTabAssistantapply);
	/**
	 * <p>功能：添加助教配置信息<br>
	 * @param jfptTabAssistantapply1 助教配置信息对象
	 */
	public void addAssistantInfo(JfptTabAssistantapply jfptTabAssistantapply1);
	/**
	 * <p>功能：根据课程编号查找课程对象信息<br>
	 * @param FCourseNumber 课程编号
	 * @return TabCourse 返回查找到的课程对象
	 */
	public TabCourse findTabCourseInfoByID(String FCourseNumber);
	/**
	 * <p>功能：根据教师职工号查找教师对象<br>
	 * @param FTeacherNumber 教师职工号
	 * @return 返回查找到的教师对象
	 */
	public TabTeachers findTeacherInfoByID(String FTeacherNumber);
}
