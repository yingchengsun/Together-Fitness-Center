package com.xdsc.dao.bksx_system.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.bksx_system.BksxTabWorkdiaryDAO;
import com.xdsc.model.BksxTabWorkdiary;
/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabWorkdiary����ز���
 */
public class BksxTabWorkdiaryDAOImpl extends HibernateDaoSupport implements
		BksxTabWorkdiaryDAO {
	/**
	 * ����һ��BksxTabWorkdiary����
	 * 
	 * @param diary
	 *            BksxTabWorkdiary����
	 * @return boolean
	 */
	public boolean saveWorkdiary(BksxTabWorkdiary diary) {
		this.getHibernateTemplate().save(diary);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabWorkdiary����
	 * 
	 * @param diary
	 *            BksxTabWorkdiary����
	 * @return boolean
	 */
	public boolean deleteWorkdiary(BksxTabWorkdiary diary) {
		this.getHibernateTemplate().delete(diary);
		return true;
	}

	/**
	 * ������־Ψһ��ʶID�õ�һ��BksxTabWorkdiary����
	 * 
	 * @param wid
	 *            BksxTabWorkdiary����ID
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
	 * ����ѧ��ѧ�ŵõ�һ��BksxTabWorkdiary�����б�
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return List
	 */
	public List<BksxTabWorkdiary> getDiaryListByStuNum(String stuNum) {
		String hql = "from BksxTabWorkdiary bw where bw.bksxTabSubstugui.tabStudents.FStudentNumber='"
				+ stuNum + "'";
		return this.getHibernateTemplate().find(hql);
	}
	/**
	 * ����ѧ��ѧ�ţ���������õ�һ��BksxTabWorkdiary�����б�
	 * 
	 * @param string
	 *            ѧ��ѧ��
	 * @param startDate
	 *            ����ʱ�����俪ʼ����
	 * @param endDate
	 *            ����ʱ�����俪ʼ����
	 * @return List
	 */
	public List getDiaryListByDate(String string, Date startDate, Date endDate) {
		String hql = "from BksxTabWorkdiary bw where bw.bksxTabSubstugui.tabStudents.FStudentNumber = :string and bw.FDiaryDate >= :startDate and bw.FDiaryDate <= :endDate";
		String[] params = { "string", "startDate", "endDate" };
		Object[] args = { string, startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}
	/**
	 * ����ѡ����Ϣ����������õ�һ��BksxTabWorkdiary�����б�
	 * 
	 * @param substuguiID
	 *            ѡ����Ϣ�ɣ�
	 * @param startDate
	 *            ����ʱ�����俪ʼ����
	 * @param endDate
	 *            ����ʱ�����俪ʼ����
	 * @return List
	 */
	public List getDiaryListBySubstuguiID(int substuguiID, Date startDate, Date endDate) {
		String hql="from BksxTabWorkdiary bw where bw.bksxTabSubstugui.FSubStuGuiId = :substuguiID and bw.FDiaryDate >= :startDate and bw.FDiaryDate <= :endDate";
		String[] params = { "substuguiID", "startDate", "endDate" };
		Object[] args = { substuguiID, startDate, endDate };
		return this.getHibernateTemplate().findByNamedParam(hql, params, args);
	}

}
