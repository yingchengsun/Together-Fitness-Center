package com.xdsc.service.bksx_system.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.xdsc.dao.bksx_system.BksxTabSubstuguiDAO;
import com.xdsc.model.BksxTabProject;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对BksxTabSubstugui的相关操作
 */
public class BksxTabSubstuguiManagerImpl implements BksxTabSubstuguiManager {
	/**
	 * BksxTabSubstuguiDAOImpl 接口
	 */
	private BksxTabSubstuguiDAO bksxTabSubstuguiDAO;

	/**
	 * bksxTabSubstuguiDAO Get与Set方法
	 */
	public BksxTabSubstuguiDAO getBksxTabSubstuguiDAO() {
		return bksxTabSubstuguiDAO;
	}

	public void setBksxTabSubstuguiDAO(BksxTabSubstuguiDAO bksxTabSubstuguiDAO) {
		this.bksxTabSubstuguiDAO = bksxTabSubstuguiDAO;
	}

	/**
	 * 得到所有选题学生不为空的选题对象列表
	 * 
	 * @return List
	 */
	public List<BksxTabSubstugui> getSubstuguiList() {
		return bksxTabSubstuguiDAO.getSubstuguiList();
	}

	/**
	 * 根据选题记录ID查找唯一的BksxTabSubstugui对象
	 * 
	 * @param id
	 *            选题记录唯一ID
	 * @return BksxTabSubstugui
	 */
	public BksxTabSubstugui getSubstuguiById(int id) {
		return bksxTabSubstuguiDAO.getSubstuguiById(id);
	}

	/**
	 * 保存一个BksxTabSubstugui对象
	 * 
	 * @param substugui
	 *            BksxTabSubstugui对象
	 * @return boolean
	 */
	public boolean saveSubstugui(BksxTabSubstugui substugui) {
		bksxTabSubstuguiDAO.saveSubstugui(substugui);
		return true;
	}

	/**
	 * 删除一个BksxTabSubstugui对象
	 * 
	 * @param substugui
	 *            BksxTabSubstugui对象
	 * @return boolean
	 */
	public boolean deleteSubstugui(BksxTabSubstugui substugui) {
		bksxTabSubstuguiDAO.deleteSubstugui(substugui);
		return true;
	}

	/**
	 * 更新一个BksxTabSubstugui对象
	 * 
	 * @param substugui
	 *            BksxTabSubstugui对象
	 * @return boolean
	 */
	public boolean updateSubstugui(BksxTabSubstugui substugui) {
		bksxTabSubstuguiDAO.updateSubstugui(substugui);
		return true;
	}

	/**
	 * 根据一条HQL语句查询特定属性的BksxTabSubstugui对象列表
	 * 
	 * @param hql
	 *            HQL语句
	 * @return List
	 */
	public List getSomeSubstuguiList(String hql) {
		return bksxTabSubstuguiDAO.getSomeSubstuguiList(hql);
	}

	/**
	 * 根据学生学号查询返回一个BksxTabSubstugui对象
	 * 
	 * @param stuNum
	 *            学生学号
	 * @return BksxTabSubstugui
	 */
	public BksxTabSubstugui getSubstuguiByStuNum(String stuNum) {
		return bksxTabSubstuguiDAO.getSubstuguiByStuNum(stuNum);
	}

	/**
	 * 根据教师姓名与教师职称查询返回一个BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public List getSubstuguiByTeacher(String teacherName, String teacherDegree) {
		return bksxTabSubstuguiDAO.getSubstuguiByTeacher(teacherName,
				teacherDegree);
	}

	/**
	 * 得到所有的研究型（个人项目）且存在选题学生的BksxTabSubstugui对象列表
	 * 
	 * @return List
	 */
	public List getReacherList() {
		return bksxTabSubstuguiDAO.getReacherList();
	}

	/**
	 * 根据教师姓名与教师职称查询返回一个项目型的BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public Set getProjectListByTeacher(String teacherName, String teacherDegree) {
		List substuguiList = bksxTabSubstuguiDAO.getProjectListByTeacher(
				teacherName, teacherDegree);
		Set projectSet = new HashSet<BksxTabProject>();
		for (int i = 0; i < substuguiList.size(); i++) {
			projectSet.add(((BksxTabSubstugui) substuguiList.get(i))
					.getBksxTabProject());
		}
		return projectSet;
	}

	/**
	 * 根据教师姓名与教师职称查询返回一个研究型的BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public List getResearchByTeacher(String teacherName, String teacherDegree) {
		return bksxTabSubstuguiDAO.getResearchByTeacher(teacherName,
				teacherDegree);
	}

	/**
	 * 根据学生年级和课题来源查询返回一个BksxTabSubstugui对象列表
	 * 
	 * @param startDate
	 *            一年的开始日期
	 * @param endDate
	 *            一年的结束日期
	 * @return List
	 */
	public List getSubstuguiListByGradeCategory(Date startDate, Date endDate,
			String substuguiCategory) {
		return bksxTabSubstuguiDAO.getSubstuguiListByGradeCategory(startDate,
				endDate, substuguiCategory);
	}

	/**
	 * 根据学生年级和课题类型查询返回一个研究型的BksxTabSubstugui对象列表
	 * 
	 * @param startDate
	 *            一年的开始日期
	 * @param endDate
	 *            一年的结束日期
	 * @param subtype
	 *            课题类型
	 * @return List
	 */
	public List getResearchByGrade(Date startDate, Date endDate, String subtype) {
		return bksxTabSubstuguiDAO.getResearchByGrade(startDate, endDate,
				subtype);
	}

	/**
	 * 构造课题Excel格式的信息表以供导出
	 * 
	 * @return InputStream
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
		cell.setCellValue("软件");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("硬件");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("软硬结合");

		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("文献综述");

		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("科研");

		cell = row.createCell((short) 7);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("模拟");

		cell = row.createCell((short) 8);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("实验室建设");

		cell = row.createCell((short) 9);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("其他");

		cell = row.createCell((short) 10);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("难度等级");

		cell = row.createCell((short) 11);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("导师姓名");

		cell = row.createCell((short) 12);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("导师职称");

		cell = row.createCell((short) 13);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("工作地点");

		cell = row.createCell((short) 14);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("学生姓名");

		cell = row.createCell((short) 15);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("学生学号");

		List<BksxTabSubstugui> substuguiList = this.getSubstuguiList();

		for (int i = 0; i < substuguiList.size(); ++i) {
			BksxTabSubstugui substugui = substuguiList.get(i);

			row = sheet.createRow(i + 1);

			cell = row.createCell((short) 0);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(i + 1);

			cell = row.createCell((short) 1);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFSubjectName());

			cell = row.createCell((short) 2);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFIsSoftware());

			cell = row.createCell((short) 3);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFIsHardware());

			cell = row.createCell((short) 4);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFIsSoftHard());

			cell = row.createCell((short) 5);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFIsDocument());

			cell = row.createCell((short) 6);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFIsResearch());

			cell = row.createCell((short) 7);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFIsSimulation());

			cell = row.createCell((short) 8);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFIsLab());

			cell = row.createCell((short) 9);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFIsOthers());

			cell = row.createCell((short) 10);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFLevel());

			cell = row.createCell((short) 11);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFTeacherName());

			cell = row.createCell((short) 12);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFTeacherDegreen());

			cell = row.createCell((short) 13);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFWorkPlace());

			cell = row.createCell((short) 14);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getFStudentName());

			cell = row.createCell((short) 15);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(substugui.getTabStudents().getFStudentNumber());

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
	 * 根据课题类型查询返回一个研究型的BksxTabSubstugui对象列表
	 * 
	 * @param subtype
	 *            课题类型
	 * @return List
	 */
	public List getReacherListByType(String type) {
		return bksxTabSubstuguiDAO.getReacherListByType(type);
	}

	/**
	 * 根据教师姓名与教师职称查询返回一个得到该教师的未被学生选题的课题信息对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * @param teacherDegree
	 *            教师职称
	 * @return List
	 */
	public List getNewSubstuguiByTeacher(String teacherName,
			String teacherDegree) {
		return bksxTabSubstuguiDAO.getNewSubstuguiByTeacher(teacherName,
				teacherDegree);
	}

	/**
	 * 返回一个所有教师未被审核课题的对象列表
	 * 
	 * @return List
	 */
	public List getApplySubjectList() {
		return bksxTabSubstuguiDAO.getApplySubjectList();
	}

	/**
	 * 返回一个可供选择的毕业设计课题的对象列表
	 * 
	 * @return List
	 */
	public List getAvilableSubjectList() {
		return bksxTabSubstuguiDAO.getAvilableSubjectList();
	}

	/**
	 * 根据教师姓名查询返回一个得到该教师的未被学生选题的课题信息对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public List getNewSubstuguiByTeacher(String teacherName) {
		return bksxTabSubstuguiDAO.getNewSubstuguiByTeacher(teacherName);
	}

	/**
	 * 根据教师姓名查询返回一个BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public List getSubstuguiByTeacher(String teacherName) {
		return bksxTabSubstuguiDAO.getSubstuguiByTeacher(teacherName);
	}

	/**
	 * 根据教师姓名查询返回一个项目型的BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public Set getProjectListByTeacher(String teacherName) {
		List substuguiList = bksxTabSubstuguiDAO
				.getProjectListByTeacher(teacherName);
		Set projectSet = new HashSet<BksxTabProject>();
		for (int i = 0; i < substuguiList.size(); i++) {
			projectSet.add(((BksxTabSubstugui) substuguiList.get(i))
					.getBksxTabProject());
		}
		return projectSet;
	}

	/**
	 * 根据教师姓名查询返回一个研究型的BksxTabSubstugui对象列表
	 * 
	 * @param teacherName
	 *            教师姓名
	 * 
	 * @return List
	 */
	public List getResearchByTeacher(String teacherName) {
		return bksxTabSubstuguiDAO.getResearchByTeacher(teacherName);
	}
}
