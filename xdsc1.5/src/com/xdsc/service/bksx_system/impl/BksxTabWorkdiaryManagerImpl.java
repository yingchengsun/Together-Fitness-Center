package com.xdsc.service.bksx_system.impl;

import java.util.Date;
import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabWorkdiaryDAO;
import com.xdsc.model.BksxTabWorkdiary;
import com.xdsc.service.bksx_system.BksxTabWorkdiaryManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabWorkdiary的相关操作
 */
public class BksxTabWorkdiaryManagerImpl implements BksxTabWorkdiaryManager {
	/**
	 * BksxTabWorkdiaryDAOImpl接口
	 */
	private BksxTabWorkdiaryDAO bksxTabWorkdiaryDAO;

	/**
	 * bksxTabWorkdiaryDAO属性的Set与Get方法
	 */
	public BksxTabWorkdiaryDAO getBksxTabWorkdiaryDAO() {
		return bksxTabWorkdiaryDAO;
	}

	public void setBksxTabWorkdiaryDAO(BksxTabWorkdiaryDAO bksxTabWorkdiaryDAO) {
		this.bksxTabWorkdiaryDAO = bksxTabWorkdiaryDAO;
	}

	/**
	 * 保存一个BksxTabWorkdiary对象
	 * 
	 * @param diary
	 *            BksxTabWorkdiary对象
	 * @return boolean
	 */
	public boolean saveWorkDiary(BksxTabWorkdiary diary) {
		return bksxTabWorkdiaryDAO.saveWorkdiary(diary);
	}

	/**
	 * 删除一个BksxTabWorkdiary对象
	 * 
	 * @param diary
	 *            BksxTabWorkdiary对象
	 * @return boolean
	 */
	public boolean deleteWorkDiary(BksxTabWorkdiary diary) {
		return bksxTabWorkdiaryDAO.deleteWorkdiary(diary);
	}

	/**
	 * 根据日志唯一标识ID得到一个BksxTabWorkdiary对象
	 * 
	 * @param wid
	 *            BksxTabWorkdiary对象ID
	 * @return BksxTabWorkdiary
	 */
	public BksxTabWorkdiary getDiaryById(int wid) {
		return bksxTabWorkdiaryDAO.getDiaryById(wid);
	}

	/**
	 * 根据学生学号得到一个BksxTabWorkdiary对象列表
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return List
	 */
	public List<BksxTabWorkdiary> getDiaryListByStuNum(String stuNum) {
		return bksxTabWorkdiaryDAO.getDiaryListByStuNum(stuNum);
	}

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
	public List getDiaryListByDate(String string, Date startDate, Date endDate) {
		return bksxTabWorkdiaryDAO.getDiaryListByDate(string, startDate,
				endDate);
	}

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
	public List getDiaryListBySubstuguiID(int substuguiID, Date startDate,
			Date endDate) {
		return bksxTabWorkdiaryDAO.getDiaryListBySubstuguiID(substuguiID,
				startDate, endDate);
	}
}
