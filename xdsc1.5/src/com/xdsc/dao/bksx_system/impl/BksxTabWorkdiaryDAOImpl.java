package com.xdsc.dao.bksx_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabWorkdiaryDAO;
import com.xdsc.model.BksxTabWorkdiary;
/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabWorkdiary的相关操作
 */
public class BksxTabWorkdiaryDAOImpl extends HibernateDaoSupport implements
		BksxTabWorkdiaryDAO {
	/**
	 * 保存一个BksxTabWorkdiary对象
	 * 
	 * @param diary
	 *            BksxTabWorkdiary对象
	 * @return boolean
	 */
	public boolean saveWorkdiary(BksxTabWorkdiary diary) {
		this.getHibernateTemplate().save(diary);
		return true;
	}

	/**
	 * 删除一个BksxTabWorkdiary对象
	 * 
	 * @param diary
	 *            BksxTabWorkdiary对象
	 * @return boolean
	 */
	public boolean deleteWorkdiary(BksxTabWorkdiary diary) {
		this.getHibernateTemplate().delete(diary);
		return true;
	}

	/**
	 * 根据日志唯一标识ID得到一个BksxTabWorkdiary对象
	 * 
	 * @param wid
	 *            BksxTabWorkdiary对象ID
	 * @return BksxTabWorkdiary
	 */
	public BksxTabWorkdiary getDiaryById(int wid) {
		String hql = "from BksxTabWorkdiary bw where bw.FWid=" + wid;
		if (this.getHibernateTemplate().find(hql).isEmpty())
			return null;
		else
			return (BksxTabWorkdiary) this.getHibernateTemplate().find(hql)
					.get(0);
	}

	/**
	 * 根据学生学号得到一个BksxTabWorkdiary对象列表
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return List
	 */
	public List<BksxTabWorkdiary> getDiaryListByStuNum(String stuNum) {
		String hql = "from BksxTabWorkdiary bw where bw.bksxTabSubstugui.tabStudents.FStudentNumber='"
				+ stuNum + "'";
		return this.getHibernateTemplate().find(hql);
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
		String hql = "from BksxTabWorkdiary bw where bw.bksxTabSubstugui.tabStudents.FStudentNumber = :string and bw.FDiaryDate >= :startDate and bw.FDiaryDate <= :endDate";
		String[] params = { "string", "startDate", "endDate" };
		Object[] args = { string, startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
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
	public List getDiaryListBySubstuguiID(int substuguiID, Date startDate, Date endDate) {
		String hql="from BksxTabWorkdiary bw where bw.bksxTabSubstugui.FSubStuGuiId = :substuguiID and bw.FDiaryDate >= :startDate and bw.FDiaryDate <= :endDate";
		String[] params = { "substuguiID", "startDate", "endDate" };
		Object[] args = { substuguiID, startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

}
