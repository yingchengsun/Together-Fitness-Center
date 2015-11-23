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


/**��ʵ�鰲�Ž�����ز���
 * @author ��ѩ
 * @version 1.1
 */
public class SjjxTabCourselabManagerImpl implements SjjxTabCourselabManager  {

	/**
	 * SjjxTabCourselabDAOImpl �Ľӿ�
	 */
	private SjjxTabCourselabDAO sjjxTabCourselabDAO;

	/**
	 * ���ݷ��ʷ���
	 */
	public SjjxTabCourselabDAO getSjjxTabCourselabDAO() {
		return sjjxTabCourselabDAO;
	}

	public void setSjjxTabCourselabDAO(SjjxTabCourselabDAO sjjxTabCourselabDAO) {
		this.sjjxTabCourselabDAO = sjjxTabCourselabDAO;
	}
	

	/**���һ��ʵ�鰲����Ϣ��¼�����ݿ���
	 * @param courseLab
	 */
	public boolean saveCourseLab(SjjxTabCourselab courseLab){
		return sjjxTabCourselabDAO.saveCourseLab(courseLab);
	}
	


	/**ɾ�����ݿ�һ��ʵ�鰲����Ϣ��¼
	 * @param courseLab
	 */
	public boolean deleteCourseLab(SjjxTabCourselab courseLab){
		return sjjxTabCourselabDAO.deleteCourseLab(courseLab);
	}
	


	/**���ҵ����ݿ������е�ʵ�鰲�ż�¼
	 * @return ���ز鵽�ļ�¼
	 */
	public List<SjjxTabCourselab> getCourseLabList() {
		return sjjxTabCourselabDAO.getCourseLabList();
	}

	/**����������id������鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param id
	 * @return ���ز��ҵ��ļ�¼ 
	 */
	public SjjxTabCourselab getCourseLabById(Integer id) {
		return sjjxTabCourselabDAO.getCourseLabById(id);
	}

	/**����ʵ�������Ʋ鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param labName
	 * @return ���ز��ҵ��ļ�¼ 
	 */
	public List<SjjxTabCourselab> getCourseLabByLabName(String labName) {
		return sjjxTabCourselabDAO.getCourseLabByLabName(labName);
	}

	
	/**���ݽ�ʦ�����鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param teacherName
	 * @return ���ز��ҵ��ļ�¼ 
	 */
	public List<SjjxTabCourselab> getCourseLabByTeacherName(String teacherName){
	     return sjjxTabCourselabDAO.getCourseLabByTeacherName(teacherName);
	}
	
	/**���ݽ�ʦ��¼ID�鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param teacherName
	 * @return ���ز��ҵ��ļ�¼ 
	 */
	public  List<SjjxTabCourselab> getCourseLabByTeacherNum(String teacherNum){
		return sjjxTabCourselabDAO.getCourseLabByTeacherNum(teacherNum);
	}
	
	/**����һ��ʵ�鰲�ż�¼
	 * @param courseLab
	 */
	public void updateCourseLab(SjjxTabCourselab courseLab) {
		sjjxTabCourselabDAO.updateCourseLab(courseLab);
		
	}

	/**����ʵ���ұ�Ų鵽����Ӧ��ʵ�鰲�ż�¼
	 * @param labId
	 * @return ���ز��ҵ��ļ�¼ 
	 */
	public List<SjjxTabCourselab> getCourseLabByLabId(int labId) {
	
		return sjjxTabCourselabDAO.getCourseLabByLabId(labId);
	}
	
	
	/**
	 * ����ʵ�鰲�ű�EXCEL�ļ�
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
		cell.setCellValue("����");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�γ̱��");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�ον�ʦ");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�༶");

		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ʵ���ұ��");
		
		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("����ʱ��");

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
