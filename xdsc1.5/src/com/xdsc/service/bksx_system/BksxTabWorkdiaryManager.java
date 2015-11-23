package com.xdsc.service.bksx_system;

import java.util.Date;
import java.util.List;

import com.xdsc.model.BksxTabWorkdiary;
/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabWorkdiary����ز���
 */
public interface BksxTabWorkdiaryManager {
	/**
	 * ����һ��BksxTabWorkdiary����
	 * 
	 * @param diary
	 *            BksxTabWorkdiary����
	 * @return boolean
	 */
	public abstract boolean saveWorkDiary(BksxTabWorkdiary diary);
	/**
	 * ɾ��һ��BksxTabWorkdiary����
	 * 
	 * @param diary
	 *            BksxTabWorkdiary����
	 * @return boolean
	 */
	public abstract boolean deleteWorkDiary(BksxTabWorkdiary diary);
	/**
	 * ������־Ψһ��ʶID�õ�һ��BksxTabWorkdiary����
	 * 
	 * @param wid
	 *            BksxTabWorkdiary����ID
	 * @return BksxTabWorkdiary
	 */
	public abstract BksxTabWorkdiary getDiaryById(int wid);
	/**
	 * ����ѧ��ѧ�ŵõ�һ��BksxTabWorkdiary�����б�
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return List
	 */
	public abstract List<BksxTabWorkdiary> getDiaryListByStuNum(String stuNum);
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
	public abstract List getDiaryListByDate(String string, Date startDate,
			Date endDate);
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
	public abstract List getDiaryListBySubstuguiID(int substuguiID,
			Date startDate, Date endDate);

}