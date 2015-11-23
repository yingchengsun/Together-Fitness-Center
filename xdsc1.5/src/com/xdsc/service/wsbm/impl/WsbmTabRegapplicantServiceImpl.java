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

/**excel����ϴ�
 * @author ��С��
 * @version 1.2
 */
public class WsbmTabRegapplicantServiceImpl implements WsbmTabRegapplicantService {
	/**
	 * DAO���������
	 */
	private WsbmTabRegapplicantDAO wsbmTabRegapplicantDao;

	public WsbmTabRegapplicantDAO getWsbmTabRegapplicantDao() {
		return wsbmTabRegapplicantDao;
	}

	public void setWsbmTabRegapplicantDao(WsbmTabRegapplicantDAO wsbmTabRegapplicantDao) {
		this.wsbmTabRegapplicantDao = wsbmTabRegapplicantDao;
	}
	/**ɾ��������Ϣ
	 * @param wsbmTabRegapplicant ��������
	 */
	public void delete(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.wsbmTabRegapplicantDao.removeWsbmTabRegapplicant(wsbmTabRegapplicant);
	}
	/**�������п���
	 * @return �����б�
	 */
	public List<WsbmTabRegapplicant> findAll() {
		return this.wsbmTabRegapplicantDao.findAllWsbmTabRegapplicants();
	}
	/**����ϵͳע��Ų����ض�����
	 * @param id ����id
	 * @return ��������
	 */
	public WsbmTabRegapplicant findWsbmTabRegapplicantById(Integer id) {
		return this.wsbmTabRegapplicantDao.findWsbmTabRegapplicantById(id);
	}

	/**�洢����
	 * @param WsbmTabRegapplicant ��������
	 */
	public void save(WsbmTabRegapplicant WsbmTabRegapplicant) {
		this.wsbmTabRegapplicantDao.saveWsbmTabRegapplicant(WsbmTabRegapplicant);
	}
	/** ���¿�����Ϣ
	 *@param WsbmTabRegapplicant ��������
	 */
	public void update(WsbmTabRegapplicant WsbmTabRegapplicant) {
		this.wsbmTabRegapplicantDao.updateWsbmTabRegapplicant(WsbmTabRegapplicant);
	}
	/**���������
	 * @return ����������
	 */
	public InputStream getInputStream() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);


		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("����");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��������");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ϵͳע���");
		
		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�Ա�");
		
		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��������");
		
		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("����");
		
		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���֤��");
		
		cell = row.createCell((short) 7);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�������ڵ�");

		cell = row.createCell((short) 8);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ְ��");
		
		cell = row.createCell((short) 9);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ְ��");
		
		cell = row.createCell((short) 10);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��ϵ�绰");
		
		cell = row.createCell((short) 11);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ͨѶ��ַ");
		
		cell = row.createCell((short) 12);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��������");
		
		cell = row.createCell((short) 13);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("������ò");
		
		cell = row.createCell((short) 14);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���Ʊ�ҵѧУ");
		
		cell = row.createCell((short) 15);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���Ʊ�ҵʱ��");
		
		cell = row.createCell((short) 16);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���Ʊ�ҵרҵ");
		
		cell = row.createCell((short) 17);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("����");
		
		cell = row.createCell((short) 18);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��ѧʿѧλʱ��");
		
		cell = row.createCell((short) 19);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ѧλ֤���");
		
		cell = row.createCell((short) 20);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��ҵ֤���");
		
		cell = row.createCell((short) 21);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ȫ��ͳ����");
		
		cell = row.createCell((short) 22);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ȫ��ͳ��רҵ");
		
		cell = row.createCell((short) 23);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�ļ��ɼ�");
		
		cell = row.createCell((short) 24);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�����ɼ�");
		
		cell = row.createCell((short) 25);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("������Ϣ");
		
		cell = row.createCell((short) 26);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�Ƿ�ͨ����Ϣ��֤");
		
		cell = row.createCell((short) 27);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�Ƿ�ͨ��Ԥ¼ȡ");
		
		cell = row.createCell((short) 28);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�Ƿ���¼ȡ");
		
		cell = row.createCell((short) 29);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�Ƿ��ѽ�������");
		
		cell = row.createCell((short) 30);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�Ƿ�Ը�ϸ�����");
		
		cell = row.createCell((short) 31);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�뿼רҵ�ο�Ŀ");
		
		cell = row.createCell((short) 32);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ȫ��ͳ����ѧ�ɼ�");
		
		cell = row.createCell((short) 33);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ȫ��ͳ��Ӣ��ɼ�");
		
		cell = row.createCell((short) 34);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ȫ��ͳ��רҵ�γɼ�");
		
		cell = row.createCell((short) 35);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("������Ϣһ");
		
		cell = row.createCell((short) 36);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("������Ϣ��");
		
		cell = row.createCell((short) 37);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("������Ϣ��");
		
		cell = row.createCell((short) 38);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("������Ϣ��");
		
		cell = row.createCell((short) 39);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("������Ϣ��");
		
		cell = row.createCell((short) 40);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ѧԺ׼��֤��");
		
		cell = row.createCell((short) 41);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���һ");
		
		cell = row.createCell((short) 42);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��Ƕ�");
		
		cell = row.createCell((short) 43);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�����");
		
		
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
