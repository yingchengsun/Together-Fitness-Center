package com.xdsc.service.bksx_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.BksxTabWorkdiary;
/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabWorkdiary的相关操作
 */
public interface BksxTabWorkdiaryManager {
	/**
	 * 保存一个BksxTabWorkdiary对象
	 * 
	 * @param diary
	 *            BksxTabWorkdiary对象
	 * @return boolean
	 */
	public abstract boolean saveWorkDiary(BksxTabWorkdiary diary);
	/**
	 * 删除一个BksxTabWorkdiary对象
	 * 
	 * @param diary
	 *            BksxTabWorkdiary对象
	 * @return boolean
	 */
	public abstract boolean deleteWorkDiary(BksxTabWorkdiary diary);
	/**
	 * 根据日志唯一标识ID得到一个BksxTabWorkdiary对象
	 * 
	 * @param wid
	 *            BksxTabWorkdiary对象ID
	 * @return BksxTabWorkdiary
	 */
	public abstract BksxTabWorkdiary getDiaryById(int wid);
	/**
	 * 根据学生学号得到一个BksxTabWorkdiary对象列表
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return List
	 */
	public abstract List<BksxTabWorkdiary> getDiaryListByStuNum(String stuNum);
	/**
	 * 根据学生学号，日期区间得到一个BksxTabWorkdiary对象列表
	 * 
	 * @param string
	 *            学生学号
	 * @param startDate
	 *            查找时间区间开始日期
	 * @param endDate
	 *            查找时间区间开始日期
	 * @return List
	 */
	public abstract List getDiaryListByDate(String string, Date startDate,
			Date endDate);
	/**
	 * 根据选题信息，日期区间得到一个BksxTabWorkdiary对象列表
	 * 
	 * @param substuguiID
	 *            选题信息ＩＤ
	 * @param startDate
	 *            查找时间区间开始日期
	 * @param endDate
	 *            查找时间区间开始日期
	 * @return List
	 */
	public abstract List getDiaryListBySubstuguiID(int substuguiID,
			Date startDate, Date endDate);

}