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
 * @author 孙建波
 * @version 1.1<br>
 *          此Action用于导出Excel数据
 */
public class ExportAsExcelAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Spring 注入的Service层的接口
	 */
	private BksxTabSubstuguiManager bksxTabSubstuguiManager;
	private BksxTabAchievementManager bksxTabAchievementManager;

	/**
	 * @return InputStream<br>
	 *         构造选题Excel以供导出<br>
	 *         具体实现参见bksxTabSubstuguiManager.getInputStream()
	 */
	public InputStream getSubstuguiDownloadFile() {
		return bksxTabSubstuguiManager.getInputStream();
	}

	/**
	 * @return InputStream<br>
	 *         构造成绩Excel以供导出<br>
	 *         具体实现参见bksxTabAchievementManager.getInputStream()
	 */
	public InputStream getAchieveDownloadFile() {
		return bksxTabAchievementManager.getInputStream();
	}

	/**
	 * @return SUCCESS<br>
	 *         导出Excel选题信息
	 */
	public String exportSubstugui() {
		return SUCCESS;
	}

	/**
	 * @return SUCCESS<br>
	 *         导出Excel成绩信息
	 */
	public String exportAchieve() {
		return SUCCESS;
	}

	/**
	 * @return SUCCESS<br>
	 *         导出选题表模板
	 */
	public String exportEmptySubstugui() {
		return SUCCESS;
	}

	/**
	 * @return SUCCESS<br>
	 *         导出成绩表模板
	 */
	public String exportEmptyAchieve() {
		return SUCCESS;
	}

	/**
	 * @return InputStream<br>
	 *         导出一个选题表Excel格式模板
	 */
	public InputStream getSubstuguiEmptyDownloadFile() {
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

		row = sheet.createRow(1);

		cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(1);

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("毕业设计课题示例");

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
		cell.setCellValue("张三");

		cell = row.createCell((short) 12);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("讲师");

		cell = row.createCell((short) 13);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("西安");

		cell = row.createCell((short) 14);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("李四");

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
	 *         导出一个成绩表Excel模板
	 */
	public InputStream getAchieveEmptyDownloadFile() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("学生学号");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("初期成绩");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("中期成绩");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("后期成绩");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("最终成绩");

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
		cell.setCellValue("优秀");

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
	 * 该类成员方法的Get与Set方法
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
