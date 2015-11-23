package com.xdsc.service.bksx_system.impl;

import java.util.Date;
import java.util.List;

import com.xdsc.dao.bksx_system.BksxTabWorkdiaryDAO;
import com.xdsc.model.BksxTabWorkdiary;
import com.xdsc.service.bksx_system.BksxTabWorkdiaryManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabWorkdiary����ز���
 */
public class BksxTabWorkdiaryManagerImpl implements BksxTabWorkdiaryManager {
	/**
	 * BksxTabWorkdiaryDAOImpl�ӿ�
	 */
	private BksxTabWorkdiaryDAO bksxTabWorkdiaryDAO;

	/**
	 * bksxTabWorkdiaryDAO���Ե�Set��Get����
	 */
	public BksxTabWorkdiaryDAO getBksxTabWorkdiaryDAO() {
		return bksxTabWorkdiaryDAO;
	}

	public void setBksxTabWorkdiaryDAO(BksxTabWorkdiaryDAO bksxTabWorkdiaryDAO) {
		this.bksxTabWorkdiaryDAO = bksxTabWorkdiaryDAO;
	}

	/**
	 * ����һ��BksxTabWorkdiary����
	 * 
	 * @param diary
	 *            BksxTabWorkdiary����
	 * @return boolean
	 */
	public boolean saveWorkDiary(BksxTabWorkdiary diary) {
		return bksxTabWorkdiaryDAO.saveWorkdiary(diary);
	}

	/**
	 * ɾ��һ��BksxTabWorkdiary����
	 * 
	 * @param diary
	 *            BksxTabWorkdiary����
	 * @return boolean
	 */
	public boolean deleteWorkDiary(BksxTabWorkdiary diary) {
		return bksxTabWorkdiaryDAO.deleteWorkdiary(diary);
	}

	/**
	 * ������־Ψһ��ʶID�õ�һ��BksxTabWorkdiary����
	 * 
	 * @param wid
	 *            BksxTabWorkdiary����ID
	 * @return BksxTabWorkdiary
	 */
	public BksxTabWorkdiary getDiaryById(int wid) {
		return bksxTabWorkdiaryDAO.getDiaryById(wid);
	}

	/**
	 * ����ѧ��ѧ�ŵõ�һ��BksxTabWorkdiary�����б�
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return List
	 */
	public List<BksxTabWorkdiary> getDiaryListByStuNum(String stuNum) {
		return bksxTabWorkdiaryDAO.getDiaryListByStuNum(stuNum);
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
		return bksxTabWorkdiaryDAO.getDiaryListByDate(string, startDate,
				endDate);
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
	public List getDiaryListBySubstuguiID(int substuguiID, Date startDate,
			Date endDate) {
		return bksxTabWorkdiaryDAO.getDiaryListBySubstuguiID(substuguiID,
				startDate, endDate);
	}
}
