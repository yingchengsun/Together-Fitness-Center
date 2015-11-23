package com.xdsc.service.wsbm.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.xdsc.dao.wsbm.WsbmTabRegapplicantDAO;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.WsbmTabRegapplicantService;

/**excel表格上传
 * @author 苟小龙
 * @version 1.2
 */
public class WsbmTabRegapplicantServiceImpl implements WsbmTabRegapplicantService {
	/**
	 * DAO层对象属性
	 */
	private WsbmTabRegapplicantDAO wsbmTabRegapplicantDao;

	public WsbmTabRegapplicantDAO getWsbmTabRegapplicantDao() {
		return wsbmTabRegapplicantDao;
	}

	public void setWsbmTabRegapplicantDao(WsbmTabRegapplicantDAO wsbmTabRegapplicantDao) {
		this.wsbmTabRegapplicantDao = wsbmTabRegapplicantDao;
	}
	/**删除考生信息
	 * @param wsbmTabRegapplicant 考生对象
	 */
	public void delete(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.wsbmTabRegapplicantDao.removeWsbmTabRegapplicant(wsbmTabRegapplicant);
	}
	/**查找所有考生
	 * @return 考生列表
	 */
	public List<WsbmTabRegapplicant> findAll() {
		return this.wsbmTabRegapplicantDao.findAllWsbmTabRegapplicants();
	}
	/**根据系统注册号查找特定考生
	 * @param id 考生id
	 * @return 考生对象
	 */
	public WsbmTabRegapplicant findWsbmTabRegapplicantById(Integer id) {
		return this.wsbmTabRegapplicantDao.findWsbmTabRegapplicantById(id);
	}

	/**存储对象
	 * @param WsbmTabRegapplicant 考生对象
	 */
	public void save(WsbmTabRegapplicant WsbmTabRegapplicant) {
		this.wsbmTabRegapplicantDao.saveWsbmTabRegapplicant(WsbmTabRegapplicant);
	}
	/** 更新考生信息
	 *@param WsbmTabRegapplicant 考生对象
	 */
	public void update(WsbmTabRegapplicant WsbmTabRegapplicant) {
		this.wsbmTabRegapplicantDao.updateWsbmTabRegapplicant(WsbmTabRegapplicant);
	}
	/**获得输入流
	 * @return 输入流对象
	 */
	public InputStream getInputStream() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);


		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("姓名");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("电子信箱");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("系统注册号");
		
		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("性别");
		
		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("出生日期");
		
		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("民族");
		
		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("身份证号");
		
		cell = row.createCell((short) 7);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("档案所在地");

		cell = row.createCell((short) 8);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("职务");
		
		cell = row.createCell((short) 9);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("职称");
		
		cell = row.createCell((short) 10);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("联系电话");
		
		cell = row.createCell((short) 11);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("通讯地址");
		
		cell = row.createCell((short) 12);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("邮政编码");
		
		cell = row.createCell((short) 13);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("政治面貌");
		
		cell = row.createCell((short) 14);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("本科毕业学校");
		
		cell = row.createCell((short) 15);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("本科毕业时间");
		
		cell = row.createCell((short) 16);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("本科毕业专业");
		
		cell = row.createCell((short) 17);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("籍贯");
		
		cell = row.createCell((short) 18);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("获学士学位时间");
		
		cell = row.createCell((short) 19);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("学位证编号");
		
		cell = row.createCell((short) 20);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("毕业证编号");
		
		cell = row.createCell((short) 21);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("全国统考号");
		
		cell = row.createCell((short) 22);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("全国统考专业");
		
		cell = row.createCell((short) 23);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("四级成绩");
		
		cell = row.createCell((short) 24);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("六级成绩");
		
		cell = row.createCell((short) 25);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("简历信息");
		
		cell = row.createCell((short) 26);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("是否通过信息验证");
		
		cell = row.createCell((short) 27);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("是否通过预录取");
		
		cell = row.createCell((short) 28);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("是否已录取");
		
		cell = row.createCell((short) 29);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("是否已交报名费");
		
		cell = row.createCell((short) 30);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("是否愿上辅导班");
		
		cell = row.createCell((short) 31);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("想考专业课科目");
		
		cell = row.createCell((short) 32);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("全国统考数学成绩");
		
		cell = row.createCell((short) 33);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("全国统考英语成绩");
		
		cell = row.createCell((short) 34);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("全国统考专业课成绩");
		
		cell = row.createCell((short) 35);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("简历信息一");
		
		cell = row.createCell((short) 36);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("简历信息二");
		
		cell = row.createCell((short) 37);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("简历信息三");
		
		cell = row.createCell((short) 38);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("简历信息四");
		
		cell = row.createCell((short) 39);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("简历信息五");
		
		cell = row.createCell((short) 40);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("学院准考证号");
		
		cell = row.createCell((short) 41);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("标记一");
		
		cell = row.createCell((short) 42);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("标记二");
		
		cell = row.createCell((short) 43);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("标记三");
		
		
		List<WsbmTabRegapplicant> list = this.findAll();

		for (int i = 0; i < list.size(); ++i) {
			WsbmTabRegapplicant WsbmTabRegapplicant = list.get(i);

			row = sheet.createRow(i + 1);


			cell = row.createCell((short) 0);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegName());

			cell = row.createCell((short) 1);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegEmail());

			cell = row.createCell((short) 2);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegNum());
			
			cell = row.createCell((short) 3);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegSex());
			
			cell = row.createCell((short) 4);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegBirthday().toString());
			
			cell = row.createCell((short) 5);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegNation());
			
			cell = row.createCell((short) 6);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegIdCard());
			
			cell = row.createCell((short) 7);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegLocation());
			
			cell = row.createCell((short) 8);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegWorkDuty());
			
			cell = row.createCell((short) 9);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegWorkTitle());
			
			cell = row.createCell((short) 10);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegTel());
			
			cell = row.createCell((short) 11);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegAddress());
			
			cell = row.createCell((short) 12);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegPostCode());
			
			cell = row.createCell((short) 13);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegPolitical());
			
			cell = row.createCell((short) 14);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegLastGraduInstitu());
			
			cell = row.createCell((short) 15);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegLastGraduDate().toString());
			
			cell = row.createCell((short) 16);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegLastGraduMajor());
			
			cell = row.createCell((short) 17);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegHomeTown());

			cell = row.createCell((short) 18);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegLastBacheDegreeDate().toString());
			
			cell = row.createCell((short) 19);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegXueWeiZhengNum());
		
			cell = row.createCell((short) 20);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegBiYeZhengNum());
			
			cell = row.createCell((short) 21);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegQgtkaoNum());
		
			cell = row.createCell((short) 22);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegQgtkao());
		
			cell = row.createCell((short) 23);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegCet4());
			
			cell = row.createCell((short) 24);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegCet6());
			
			cell = row.createCell((short) 25);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegCv());
			
			cell = row.createCell((short) 26);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegPassAuth());

			cell = row.createCell((short) 27);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegPassPreAd());
		
			cell = row.createCell((short) 28);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegPassFinAd());
			
			cell = row.createCell((short) 29);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegBaoMingFei());
			
			cell = row.createCell((short) 30);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegFuDaoBan());
			
			cell = row.createCell((short) 31);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegZhuanYeKe());
			
			cell = row.createCell((short) 32);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegQgtkaoZhengzhi());
			
			cell = row.createCell((short) 33);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegQgtkaoEnglish());
			
			cell = row.createCell((short) 34);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegQgtkaoZhuanYeKe());
			
			cell = row.createCell((short) 35);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegCv1());
			
			cell = row.createCell((short) 36);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegCv2());
			
			cell = row.createCell((short) 37);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegCv3());
			
			cell = row.createCell((short) 38);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegCv4());
			
			cell = row.createCell((short) 39);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegCv5());
			
			cell = row.createCell((short) 40);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegZhunKaoZhengHao());
			
			cell = row.createCell((short) 41);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegBackUpChar());
			
			cell = row.createCell((short) 42);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegBackUpText());
			
			cell = row.createCell((short) 43);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(WsbmTabRegapplicant.getFAppRegBackUpInt());
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
