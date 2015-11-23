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
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶�BksxTabSubstugui����ز���
 */
public class BksxTabSubstuguiManagerImpl implements BksxTabSubstuguiManager {
	/**
	 * BksxTabSubstuguiDAOImpl �ӿ�
	 */
	private BksxTabSubstuguiDAO bksxTabSubstuguiDAO;

	/**
	 * bksxTabSubstuguiDAO Get��Set����
	 */
	public BksxTabSubstuguiDAO getBksxTabSubstuguiDAO() {
		return bksxTabSubstuguiDAO;
	}

	public void setBksxTabSubstuguiDAO(BksxTabSubstuguiDAO bksxTabSubstuguiDAO) {
		this.bksxTabSubstuguiDAO = bksxTabSubstuguiDAO;
	}

	/**
	 * �õ�����ѡ��ѧ����Ϊ�յ�ѡ������б�
	 * 
	 * @return List
	 */
	public List<BksxTabSubstugui> getSubstuguiList() {
		return bksxTabSubstuguiDAO.getSubstuguiList();
	}

	/**
	 * ����ѡ���¼ID����Ψһ��BksxTabSubstugui����
	 * 
	 * @param id
	 *            ѡ���¼ΨһID
	 * @return BksxTabSubstugui
	 */
	public BksxTabSubstugui getSubstuguiById(int id) {
		return bksxTabSubstuguiDAO.getSubstuguiById(id);
	}

	/**
	 * ����һ��BksxTabSubstugui����
	 * 
	 * @param substugui
	 *            BksxTabSubstugui����
	 * @return boolean
	 */
	public boolean saveSubstugui(BksxTabSubstugui substugui) {
		bksxTabSubstuguiDAO.saveSubstugui(substugui);
		return true;
	}

	/**
	 * ɾ��һ��BksxTabSubstugui����
	 * 
	 * @param substugui
	 *            BksxTabSubstugui����
	 * @return boolean
	 */
	public boolean deleteSubstugui(BksxTabSubstugui substugui) {
		bksxTabSubstuguiDAO.deleteSubstugui(substugui);
		return true;
	}

	/**
	 * ����һ��BksxTabSubstugui����
	 * 
	 * @param substugui
	 *            BksxTabSubstugui����
	 * @return boolean
	 */
	public boolean updateSubstugui(BksxTabSubstugui substugui) {
		bksxTabSubstuguiDAO.updateSubstugui(substugui);
		return true;
	}

	/**
	 * ����һ��HQL����ѯ�ض����Ե�BksxTabSubstugui�����б�
	 * 
	 * @param hql
	 *            HQL���
	 * @return List
	 */
	public List getSomeSubstuguiList(String hql) {
		return bksxTabSubstuguiDAO.getSomeSubstuguiList(hql);
	}

	/**
	 * ����ѧ��ѧ�Ų�ѯ����һ��BksxTabSubstugui����
	 * 
	 * @param stuNum
	 *            ѧ��ѧ��
	 * @return BksxTabSubstugui
	 */
	public BksxTabSubstugui getSubstuguiByStuNum(String stuNum) {
		return bksxTabSubstuguiDAO.getSubstuguiByStuNum(stuNum);
	}

	/**
	 * ���ݽ�ʦ�������ʦְ�Ʋ�ѯ����һ��BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public List getSubstuguiByTeacher(String teacherName, String teacherDegree) {
		return bksxTabSubstuguiDAO.getSubstuguiByTeacher(teacherName,
				teacherDegree);
	}

	/**
	 * �õ����е��о��ͣ�������Ŀ���Ҵ���ѡ��ѧ����BksxTabSubstugui�����б�
	 * 
	 * @return List
	 */
	public List getReacherList() {
		return bksxTabSubstuguiDAO.getReacherList();
	}

	/**
	 * ���ݽ�ʦ�������ʦְ�Ʋ�ѯ����һ����Ŀ�͵�BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
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
	 * ���ݽ�ʦ�������ʦְ�Ʋ�ѯ����һ���о��͵�BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public List getResearchByTeacher(String teacherName, String teacherDegree) {
		return bksxTabSubstuguiDAO.getResearchByTeacher(teacherName,
				teacherDegree);
	}

	/**
	 * ����ѧ���꼶�Ϳ�����Դ��ѯ����һ��BksxTabSubstugui�����б�
	 * 
	 * @param startDate
	 *            һ��Ŀ�ʼ����
	 * @param endDate
	 *            һ��Ľ�������
	 * @return List
	 */
	public List getSubstuguiListByGradeCategory(Date startDate, Date endDate,
			String substuguiCategory) {
		return bksxTabSubstuguiDAO.getSubstuguiListByGradeCategory(startDate,
				endDate, substuguiCategory);
	}

	/**
	 * ����ѧ���꼶�Ϳ������Ͳ�ѯ����һ���о��͵�BksxTabSubstugui�����б�
	 * 
	 * @param startDate
	 *            һ��Ŀ�ʼ����
	 * @param endDate
	 *            һ��Ľ�������
	 * @param subtype
	 *            ��������
	 * @return List
	 */
	public List getResearchByGrade(Date startDate, Date endDate, String subtype) {
		return bksxTabSubstuguiDAO.getResearchByGrade(startDate, endDate,
				subtype);
	}

	/**
	 * �������Excel��ʽ����Ϣ���Թ�����
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
		cell.setCellValue("���");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��������");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("Ӳ��");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��Ӳ���");

		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��������");

		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("����");

		cell = row.createCell((short) 7);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ģ��");

		cell = row.createCell((short) 8);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ʵ���ҽ���");

		cell = row.createCell((short) 9);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("����");

		cell = row.createCell((short) 10);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�Ѷȵȼ�");

		cell = row.createCell((short) 11);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��ʦ����");

		cell = row.createCell((short) 12);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��ʦְ��");

		cell = row.createCell((short) 13);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�����ص�");

		cell = row.createCell((short) 14);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ѧ������");

		cell = row.createCell((short) 15);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ѧ��ѧ��");

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
	 * ���ݿ������Ͳ�ѯ����һ���о��͵�BksxTabSubstugui�����б�
	 * 
	 * @param subtype
	 *            ��������
	 * @return List
	 */
	public List getReacherListByType(String type) {
		return bksxTabSubstuguiDAO.getReacherListByType(type);
	}

	/**
	 * ���ݽ�ʦ�������ʦְ�Ʋ�ѯ����һ���õ��ý�ʦ��δ��ѧ��ѡ��Ŀ�����Ϣ�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * @param teacherDegree
	 *            ��ʦְ��
	 * @return List
	 */
	public List getNewSubstuguiByTeacher(String teacherName,
			String teacherDegree) {
		return bksxTabSubstuguiDAO.getNewSubstuguiByTeacher(teacherName,
				teacherDegree);
	}

	/**
	 * ����һ�����н�ʦδ����˿���Ķ����б�
	 * 
	 * @return List
	 */
	public List getApplySubjectList() {
		return bksxTabSubstuguiDAO.getApplySubjectList();
	}

	/**
	 * ����һ���ɹ�ѡ��ı�ҵ��ƿ���Ķ����б�
	 * 
	 * @return List
	 */
	public List getAvilableSubjectList() {
		return bksxTabSubstuguiDAO.getAvilableSubjectList();
	}

	/**
	 * ���ݽ�ʦ������ѯ����һ���õ��ý�ʦ��δ��ѧ��ѡ��Ŀ�����Ϣ�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public List getNewSubstuguiByTeacher(String teacherName) {
		return bksxTabSubstuguiDAO.getNewSubstuguiByTeacher(teacherName);
	}

	/**
	 * ���ݽ�ʦ������ѯ����һ��BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public List getSubstuguiByTeacher(String teacherName) {
		return bksxTabSubstuguiDAO.getSubstuguiByTeacher(teacherName);
	}

	/**
	 * ���ݽ�ʦ������ѯ����һ����Ŀ�͵�BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
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
	 * ���ݽ�ʦ������ѯ����һ���о��͵�BksxTabSubstugui�����б�
	 * 
	 * @param teacherName
	 *            ��ʦ����
	 * 
	 * @return List
	 */
	public List getResearchByTeacher(String teacherName) {
		return bksxTabSubstuguiDAO.getResearchByTeacher(teacherName);
	}
}
