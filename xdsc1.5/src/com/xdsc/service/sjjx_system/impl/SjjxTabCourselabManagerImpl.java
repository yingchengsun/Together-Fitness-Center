package com.xdsc.service.sjjx_system.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



import com.xdsc.dao.sjjx_system.SjjxTabCourselabDAO;
import com.xdsc.model.BksxTabAchievement;
import com.xdsc.model.SjjxTabCourselab;

import com.xdsc.service.sjjx_system.SjjxTabCourselabManager;


/**对实验安排进行相关操作
 * @author 陈雪
 * @version 1.1
 */
public class SjjxTabCourselabManagerImpl implements SjjxTabCourselabManager  {

	/**
	 * SjjxTabCourselabDAOImpl 的接口
	 */
	private SjjxTabCourselabDAO sjjxTabCourselabDAO;

	/**
	 * 数据访问方法
	 */
	public SjjxTabCourselabDAO getSjjxTabCourselabDAO() {
		return sjjxTabCourselabDAO;
	}

	public void setSjjxTabCourselabDAO(SjjxTabCourselabDAO sjjxTabCourselabDAO) {
		this.sjjxTabCourselabDAO = sjjxTabCourselabDAO;
	}
	

	/**添加一条实验安排信息记录到数据库中
	 * @param courseLab
	 */
	public boolean saveCourseLab(SjjxTabCourselab courseLab){
		return sjjxTabCourselabDAO.saveCourseLab(courseLab);
	}
	


	/**删除数据库一条实验安排信息记录
	 * @param courseLab
	 */
	public boolean deleteCourseLab(SjjxTabCourselab courseLab){
		return sjjxTabCourselabDAO.deleteCourseLab(courseLab);
	}
	


	/**查找到数据库中所有的实验安排记录
	 * @return 返回查到的记录
	 */
	public List<SjjxTabCourselab> getCourseLabList() {
		return sjjxTabCourselabDAO.getCourseLabList();
	}

	/**根据自增的id数据项查到到对应的实验安排记录
	 * @param id
	 * @return 返回查找到的记录 
	 */
	public SjjxTabCourselab getCourseLabById(Integer id) {
		return sjjxTabCourselabDAO.getCourseLabById(id);
	}

	/**根据实验室名称查到到对应的实验安排记录
	 * @param labName
	 * @return 返回查找到的记录 
	 */
	public List<SjjxTabCourselab> getCourseLabByLabName(String labName) {
		return sjjxTabCourselabDAO.getCourseLabByLabName(labName);
	}

	
	/**根据教师姓名查到到对应的实验安排记录
	 * @param teacherName
	 * @return 返回查找到的记录 
	 */
	public List<SjjxTabCourselab> getCourseLabByTeacherName(String teacherName){
	     return sjjxTabCourselabDAO.getCourseLabByTeacherName(teacherName);
	}
	
	/**根据教师登录ID查到到对应的实验安排记录
	 * @param teacherName
	 * @return 返回查找到的记录 
	 */
	public  List<SjjxTabCourselab> getCourseLabByTeacherNum(String teacherNum){
		return sjjxTabCourselabDAO.getCourseLabByTeacherNum(teacherNum);
	}
	
	/**更新一条实验安排记录
	 * @param courseLab
	 */
	public void updateCourseLab(SjjxTabCourselab courseLab) {
		sjjxTabCourselabDAO.updateCourseLab(courseLab);
		
	}

	/**根据实验室编号查到到对应的实验安排记录
	 * @param labId
	 * @return 返回查找到的记录 
	 */
	public List<SjjxTabCourselab> getCourseLabByLabId(int labId) {
	
		return sjjxTabCourselabDAO.getCourseLabByLabId(labId);
	}
	
	
	/**
	 * 构造实验安排表EXCEL文件
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
		cell.setCellValue("日期");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("课程编号");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("任课教师");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("班级");

		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("实验室编号");
		
		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("具体时间");

		List<SjjxTabCourselab> courseLabList = this.getCourseLabList();

		for (int i = 0; i < courseLabList.size(); ++i) {
			SjjxTabCourselab courseLab = courseLabList.get(i);

			row = sheet.createRow(i + 1);

			cell = row.createCell((short) 0);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(courseLab.getFNumber());

			cell = row.createCell((short) 1);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(courseLab.getFDate());

			cell = row.createCell((short) 2);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(courseLab.getTabCourse().getFCourseName());

			cell = row.createCell((short) 3);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(courseLab.getTabTeachers().getFTeacherName());


			cell = row.createCell((short) 4);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(courseLab.getTabClasses().getFClassName());


			cell = row.createCell((short) 5);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(courseLab.getSjjxTabLab().getFLabName());

			cell = row.createCell((short) 6);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(courseLab.getFExactTime());
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
}
