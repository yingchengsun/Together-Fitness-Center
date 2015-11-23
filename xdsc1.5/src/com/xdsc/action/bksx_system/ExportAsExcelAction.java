package com.xdsc.action.bksx_system;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.service.bksx_system.BksxTabAchievementManager;
import com.xdsc.service.bksx_system.BksxTabSubstuguiManager;

/**
 * @author �ｨ��
 * @version 1.1<br>
 *          ��Action���ڵ���Excel����
 */
public class ExportAsExcelAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Spring ע���Service��Ľӿ�
	 */
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private BksxTabAchievementManager bksxTabAchievementManager;

	/**
	 * @return InputStream<br>
	 *         ����ѡ��Excel�Թ�����<br>
	 *         ����ʵ�ֲμ�bksxTabSubstuguiManager.getInputStream()
	 */
	public InputStream getSubstuguiDownloadFile() {
		return bksxTabSubstuguiManager.getInputStream();
	}

	/**
	 * @return InputStream<br>
	 *         ����ɼ�Excel�Թ�����<br>
	 *         ����ʵ�ֲμ�bksxTabAchievementManager.getInputStream()
	 */
	public InputStream getAchieveDownloadFile() {
		return bksxTabAchievementManager.getInputStream();
	}

	/**
	 * @return SUCCESS<br>
	 *         ����Excelѡ����Ϣ
	 */
	public String exportSubstugui() {
		return SUCCESS;
	}

	/**
	 * @return SUCCESS<br>
	 *         ����Excel�ɼ���Ϣ
	 */
	public String exportAchieve() {
		return SUCCESS;
	}

	/**
	 * @return SUCCESS<br>
	 *         ����ѡ���ģ��
	 */
	public String exportEmptySubstugui() {
		return SUCCESS;
	}

	/**
	 * @return SUCCESS<br>
	 *         �����ɼ���ģ��
	 */
	public String exportEmptyAchieve() {
		return SUCCESS;
	}

	/**
	 * @return InputStream<br>
	 *         ����һ��ѡ���Excel��ʽģ��
	 */
	public InputStream getSubstuguiEmptyDownloadFile() {
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

		row = sheet.createRow(1);

		cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(1);

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��ҵ��ƿ���ʾ��");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("Y");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("");

		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("");

		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("Y");

		cell = row.createCell((short) 7);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("");

		cell = row.createCell((short) 8);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("");

		cell = row.createCell((short) 9);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("");

		cell = row.createCell((short) 10);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("B");

		cell = row.createCell((short) 11);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("����");

		cell = row.createCell((short) 12);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��ʦ");

		cell = row.createCell((short) 13);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("����");

		cell = row.createCell((short) 14);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("����");

		cell = row.createCell((short) 15);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("13061999");

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
	 * @return InputStream <br>
	 *         ����һ���ɼ���Excelģ��
	 */
	public InputStream getAchieveEmptyDownloadFile() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ѧ��ѧ��");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���ڳɼ�");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���ڳɼ�");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���ڳɼ�");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���ճɼ�");

		row = sheet.createRow(1);

		cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("13061001");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("75");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("85");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("80");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("����");

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
	 * �����Ա������Get��Set����
	 */
	public BksxTabSubstuguiManager getBksxTabSubstuguiManager() {
		return bksxTabSubstuguiManager;
	}

	public void setBksxTabSubstuguiManager(
			BksxTabSubstuguiManager bksxTabSubstuguiManager) {
		this.bksxTabSubstuguiManager = bksxTabSubstuguiManager;
	}

	public BksxTabAchievementManager getBksxTabAchievementManager() {
		return bksxTabAchievementManager;
	}

	public void setBksxTabAchievementManager(
			BksxTabAchievementManager bksxTabAchievementManager) {
		this.bksxTabAchievementManager = bksxTabAchievementManager;
	}

}
