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
 * @author 孙建波
 * @version 1.1
 * 
 * 封装对BksxTabAchievement的操作
 */
public class BksxTabAchievementManagerImpl implements BksxTabAchievementManager {
	/**
	 * BksxTabAchievementDAOImpl 的接口
	 */
	private BksxTabAchievementDAO bksxTabAchievementDAO;

	/**
	 * 数据访问方法
	 */
	public BksxTabAchievementDAO getBksxTabAchievementDAO() {
		return bksxTabAchievementDAO;
	}

	public void setBksxTabAchievementDAO(
			BksxTabAchievementDAO bksxTabAchievementDAO) {
		this.bksxTabAchievementDAO = bksxTabAchievementDAO;
	}

	/**
	 * 保存一个BksxTabAchievement对象
	 * 
	 * @param achievement
	 *            BksxTabAchievement对象
	 * @return boolean
	 */
	public boolean saveAchievement(BksxTabAchievement achievement) {
		return bksxTabAchievementDAO.saveAchievement(achievement);
	}

	/**
	 * 删除一个BksxTabAchievement对象
	 * 
	 * @param achievement
	 *            BksxTabAchievement对象
	 * @return boolean
	 */
	public boolean deleteAchievement(BksxTabAchievement achievement) {
		return bksxTabAchievementDAO.deleteAchievement(achievement);
	}

	/**
	 * 更新一个BksxTabAchievement对象
	 * 
	 * @param achievement
	 *            BksxTabAchievement对象
	 * @return boolean
	 */
	public boolean updateAchievement(BksxTabAchievement achievement) {
		return bksxTabAchievementDAO.updateAchievement(achievement);
	}

	/**
	 * 根据ID返回一个BksxTabAchievement对象
	 * 
	 * @param id
	 *            BksxTabAchievement唯一标识ID
	 * @return BksxTabAchievement
	 */
	public BksxTabAchievement getAchievementByID(int id) {
		return bksxTabAchievementDAO.getAchievementByID(id);
	}

	/**
	 * 得到一个包含所有getAllAchievement对象的List
	 * 
	 * @return List
	 */
	public List getAllAchievement() {
		return bksxTabAchievementDAO.getAllAchievement();
	}

	/**
	 * @param stuNum
	 *            学生学号
	 * 
	 * 根据学生学号stuNum得到一个List
	 */
	public List getAchievementByStuNum(String stuNum) {
		return bksxTabAchievementDAO.getAchievementByStuNum(stuNum);
	}

	/**
	 * @param 教师姓名
	 * @param 教师职称
	 * @return List
	 * 
	 * 根据教师姓名和教师职称活动该教师名下学生的成绩列表
	 */
	public List getAchievementByTeacher(String teacherName, String teacherDegree) {
		return bksxTabAchievementDAO.getAchievementByTeacher(teacherName,
				teacherDegree);
	}

	/**
	 * @param startDate
	 *            某年的第一天
	 * @param endDate
	 *            某年的最后一天
	 * @return List
	 * 
	 * 根据两个参数获得改年级的成绩列表
	 */
	public List getAchievementByGrade(Date startDate, Date endDate) {
		return bksxTabAchievementDAO.getAchievementByGrade(startDate, endDate);
	}

	/**
	 * 构造成绩EXCEL文件
	 * 
	 */
	public InputStream getInputStream() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("序号");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("课题名称");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("学生学号");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("学生姓名");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("初期成绩");

		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("中期成绩");

		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("后期成绩");

		cell = row.createCell((short) 7);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("最终成绩");

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
	 * @param 教师姓名
	 * @return List
	 * 
	 * 根据教师姓名获得该教师名下学生的成绩列表
	 */
	public List getAchievementByTeacher(String teacherName) {
		return bksxTabAchievementDAO.getAchievementByTeacher(teacherName);
	}
}
