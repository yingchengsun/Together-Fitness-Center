package com.xdsc.service.bksx_system.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.xdsc.dao.bksx_system.BksxTabAchievementDAO;
import com.xdsc.model.BksxTabAchievement;
import com.xdsc.service.bksx_system.BksxTabAchievementManager;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * ��װ��BksxTabAchievement�Ĳ���
 */
public class BksxTabAchievementManagerImpl implements BksxTabAchievementManager {
	/**
	 * BksxTabAchievementDAOImpl �Ľӿ�
	 */
	private BksxTabAchievementDAO bksxTabAchievementDAO;

	/**
	 * ���ݷ��ʷ���
	 */
	public BksxTabAchievementDAO getBksxTabAchievementDAO() {
		return bksxTabAchievementDAO;
	}

	public void setBksxTabAchievementDAO(
			BksxTabAchievementDAO bksxTabAchievementDAO) {
		this.bksxTabAchievementDAO = bksxTabAchievementDAO;
	}

	/**
	 * ����һ��BksxTabAchievement����
	 * 
	 * @param achievement
	 *            BksxTabAchievement����
	 * @return boolean
	 */
	public boolean saveAchievement(BksxTabAchievement achievement) {
		return bksxTabAchievementDAO.saveAchievement(achievement);
	}

	/**
	 * ɾ��һ��BksxTabAchievement����
	 * 
	 * @param achievement
	 *            BksxTabAchievement����
	 * @return boolean
	 */
	public boolean deleteAchievement(BksxTabAchievement achievement) {
		return bksxTabAchievementDAO.deleteAchievement(achievement);
	}

	/**
	 * ����һ��BksxTabAchievement����
	 * 
	 * @param achievement
	 *            BksxTabAchievement����
	 * @return boolean
	 */
	public boolean updateAchievement(BksxTabAchievement achievement) {
		return bksxTabAchievementDAO.updateAchievement(achievement);
	}

	/**
	 * ����ID����һ��BksxTabAchievement����
	 * 
	 * @param id
	 *            BksxTabAchievementΨһ��ʶID
	 * @return BksxTabAchievement
	 */
	public BksxTabAchievement getAchievementByID(int id) {
		return bksxTabAchievementDAO.getAchievementByID(id);
	}

	/**
	 * �õ�һ����������getAllAchievement�����List
	 * 
	 * @return List
	 */
	public List getAllAchievement() {
		return bksxTabAchievementDAO.getAllAchievement();
	}

	/**
	 * @param stuNum
	 *            ѧ��ѧ��
	 * 
	 * ����ѧ��ѧ��stuNum�õ�һ��List
	 */
	public List getAchievementByStuNum(String stuNum) {
		return bksxTabAchievementDAO.getAchievementByStuNum(stuNum);
	}

	/**
	 * @param ��ʦ����
	 * @param ��ʦְ��
	 * @return List
	 * 
	 * ���ݽ�ʦ�����ͽ�ʦְ�ƻ�ý�ʦ����ѧ���ĳɼ��б�
	 */
	public List getAchievementByTeacher(String teacherName, String teacherDegree) {
		return bksxTabAchievementDAO.getAchievementByTeacher(teacherName,
				teacherDegree);
	}

	/**
	 * @param startDate
	 *            ĳ��ĵ�һ��
	 * @param endDate
	 *            ĳ������һ��
	 * @return List
	 * 
	 * ��������������ø��꼶�ĳɼ��б�
	 */
	public List getAchievementByGrade(Date startDate, Date endDate) {
		return bksxTabAchievementDAO.getAchievementByGrade(startDate, endDate);
	}

	/**
	 * ����ɼ�EXCEL�ļ�
	 * 
	 */
	public InputStream getInputStream() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��������");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ѧ��ѧ��");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ѧ������");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���ڳɼ�");

		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���ڳɼ�");

		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���ڳɼ�");

		cell = row.createCell((short) 7);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���ճɼ�");

		List<BksxTabAchievement> achieveList = this.getAllAchievement();

		for (int i = 0; i < achieveList.size(); ++i) {
			BksxTabAchievement achieve = achieveList.get(i);

			row = sheet.createRow(i + 1);

			cell = row.createCell((short) 0);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(i + 1);

			cell = row.createCell((short) 1);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(achieve.getBksxTabSubstugui().getFSubjectName());

			cell = row.createCell((short) 2);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(achieve.getBksxTabSubstugui().getTabStudents()
					.getFStudentNumber());

			cell = row.createCell((short) 3);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(achieve.getBksxTabSubstugui().getFStudentName());

			cell = row.createCell((short) 4);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(achieve.getFFirstScore());

			cell = row.createCell((short) 5);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(achieve.getFSecondScore());

			cell = row.createCell((short) 6);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(achieve.getFThirdScore());

			cell = row.createCell((short) 7);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(achieve.getFFinalScore());

		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();

		try {
			wb.write(os);
		} catch (Exception e) {
			e.printStackTrace();
		}

		byte[] content = os.toByteArray();

		InputStream is = new ByteArrayInputStream(content);

		return is;
	}

	/**
	 * @param ��ʦ����
	 * @return List
	 * 
	 * ���ݽ�ʦ������øý�ʦ����ѧ���ĳɼ��б�
	 */
	public List getAchievementByTeacher(String teacherName) {
		return bksxTabAchievementDAO.getAchievementByTeacher(teacherName);
	}
}
