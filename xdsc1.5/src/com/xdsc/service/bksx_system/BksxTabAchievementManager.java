package com.xdsc.service.bksx_system;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.xdsc.model.BksxTabAchievement;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 封装对BksxTabAchievement的操作
 */
public interface BksxTabAchievementManager {
	/**
	 * 保存一个BksxTabAchievement对象
	 * 
	 * @param achievement
	 *            BksxTabAchievement对象
	 * @return boolean
	 */
	public abstract boolean saveAchievement(BksxTabAchievement achievement);

	/**
	 * 删除一个BksxTabAchievement对象
	 * 
	 * @param achievement
	 *            BksxTabAchievement对象
	 * @return boolean
	 */
	public abstract boolean deleteAchievement(BksxTabAchievement achievement);

	/**
	 * 更新一个BksxTabAchievement对象
	 * 
	 * @param achievement
	 *            BksxTabAchievement对象
	 * @return boolean
	 */
	public abstract boolean updateAchievement(BksxTabAchievement achievement);

	/**
	 * 根据ID返回一个BksxTabAchievement对象
	 * 
	 * @param id
	 *            BksxTabAchievement唯一标识ID
	 * @return BksxTabAchievement
	 */
	public abstract BksxTabAchievement getAchievementByID(int id);

	/**
	 * 得到一个包含所有getAllAchievement对象的List
	 * 
	 * @return List
	 */
	public abstract List getAllAchievement();

	/**
	 * @param stuNum
	 *            学生学号
	 * 
	 * 根据学生学号stuNum得到一个List
	 */
	public abstract List getAchievementByStuNum(String stuNum);

	/**
	 * @param 教师姓名
	 * @param 教师职称
	 * @return List
	 * 
	 * 根据教师姓名和教师职称活动该教师名下学生的成绩列表
	 */
	public abstract List getAchievementByTeacher(String teacherName,
			String teacherDegree);

	/**
	 * @param startDate
	 *            某年的第一天
	 * @param endDate
	 *            某年的最后一天
	 * @return List
	 * 
	 * 根据两个参数获得改年级的成绩列表
	 */
	public abstract List getAchievementByGrade(Date startDate, Date endDate);

	/**
	 * 构造成绩EXCEL文件
	 */
	public abstract InputStream getInputStream();

	/**
	 * @param 教师姓名
	 * @return List
	 * 
	 * 根据教师姓名获得该教师名下学生的成绩列表
	 */
	public abstract List getAchievementByTeacher(String teacherName);

}