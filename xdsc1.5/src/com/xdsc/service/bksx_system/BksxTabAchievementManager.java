package com.xdsc.service.bksx_system;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.xdsc.model.BksxTabAchievement;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * ��װ��BksxTabAchievement�Ĳ���
 */
public interface BksxTabAchievementManager {
	/**
	 * ����һ��BksxTabAchievement����
	 * 
	 * @param achievement
	 *            BksxTabAchievement����
	 * @return boolean
	 */
	public abstract boolean saveAchievement(BksxTabAchievement achievement);

	/**
	 * ɾ��һ��BksxTabAchievement����
	 * 
	 * @param achievement
	 *            BksxTabAchievement����
	 * @return boolean
	 */
	public abstract boolean deleteAchievement(BksxTabAchievement achievement);

	/**
	 * ����һ��BksxTabAchievement����
	 * 
	 * @param achievement
	 *            BksxTabAchievement����
	 * @return boolean
	 */
	public abstract boolean updateAchievement(BksxTabAchievement achievement);

	/**
	 * ����ID����һ��BksxTabAchievement����
	 * 
	 * @param id
	 *            BksxTabAchievementΨһ��ʶID
	 * @return BksxTabAchievement
	 */
	public abstract BksxTabAchievement getAchievementByID(int id);

	/**
	 * �õ�һ����������getAllAchievement�����List
	 * 
	 * @return List
	 */
	public abstract List getAllAchievement();

	/**
	 * @param stuNum
	 *            ѧ��ѧ��
	 * 
	 * ����ѧ��ѧ��stuNum�õ�һ��List
	 */
	public abstract List getAchievementByStuNum(String stuNum);

	/**
	 * @param ��ʦ����
	 * @param ��ʦְ��
	 * @return List
	 * 
	 * ���ݽ�ʦ�����ͽ�ʦְ�ƻ�ý�ʦ����ѧ���ĳɼ��б�
	 */
	public abstract List getAchievementByTeacher(String teacherName,
			String teacherDegree);

	/**
	 * @param startDate
	 *            ĳ��ĵ�һ��
	 * @param endDate
	 *            ĳ������һ��
	 * @return List
	 * 
	 * ��������������ø��꼶�ĳɼ��б�
	 */
	public abstract List getAchievementByGrade(Date startDate, Date endDate);

	/**
	 * ����ɼ�EXCEL�ļ�
	 */
	public abstract InputStream getInputStream();

	/**
	 * @param ��ʦ����
	 * @return List
	 * 
	 * ���ݽ�ʦ������øý�ʦ����ѧ���ĳɼ��б�
	 */
	public abstract List getAchievementByTeacher(String teacherName);

}