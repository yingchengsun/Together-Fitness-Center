package com.xdsc.service.sjjx_system.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



import com.xdsc.dao.sjjx_system.SjjxTabEquipmentDAO;
import com.xdsc.model.SjjxTabCourselab;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.service.sjjx_system.SjjxTabEquipmentManager;

/**���豸������Ϣ��¼���в���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabEquipmentManagerImpl implements SjjxTabEquipmentManager {

	
	/**
	 * SjjxTabEquipmentDAOImpl �Ľӿ�
	 */
	private SjjxTabEquipmentDAO sjjxTabEquipmentDAO;
	
	/**
	 * ���ݷ��ʷ���
	 */
	public SjjxTabEquipmentDAO getSjjxTabEquipmentDAO() {
		return sjjxTabEquipmentDAO;
	}

	public void setSjjxTabEquipmentDAO(SjjxTabEquipmentDAO sjjxTabEquipmentDAO) {
		this.sjjxTabEquipmentDAO = sjjxTabEquipmentDAO;
	}
	


	/**����һ���豸������Ϣ�����ݿ���
	 * @param equip
	 */
	public boolean saveEquip(SjjxTabEquipment equip) {
		return sjjxTabEquipmentDAO.saveEquip(equip);
	}


	/**�����ݿ���ɾ��һ���豸������Ϣ��¼
	 * @param equip
	 */
	public boolean deleteEquip(SjjxTabEquipment equip) {
		return sjjxTabEquipmentDAO.deleteEquip(equip);
	}
	

	/**�����ݿ��ж�ȡ���е��豸������Ϣ��¼
	 * @return �������в��ҵ���¼
	 */
	public List<SjjxTabEquipment> getEquipList() {
		return sjjxTabEquipmentDAO.getEquipList();
	}

	/**ͨ���豸��Ų��ҵ��豸��¼
	 * @param equipId
	 * @return ���ز��ҵ���¼
	 */
	public SjjxTabEquipment getEquipByEquipId(Integer equipId) {
		return sjjxTabEquipmentDAO.getEquipByEquipId(equipId);
	}
	

	/**ͨ���豸�������Ʋ��Ҹ����������豸��¼
	 * @param equipTypeName
	 * @return �������в��ҵ���¼
	 */
	public List<SjjxTabEquipment> getEquipByEquipTypeName(String equipTypeName){
		return sjjxTabEquipmentDAO.getEquipByEquipTypeName(equipTypeName);
	}

	/**ͨ��ʵ���������ҵ���ʵ���������豸��¼
	 * @param labName
	 * @return �������в��ҵ���¼
	 */
	public List<SjjxTabEquipment> getEquipByLabName(String labName){
		return sjjxTabEquipmentDAO.getEquipByLabName(labName);
	}
	
    
	/**����һ���豸��¼
	 * @param equip
	 */
	public void updateEquip(SjjxTabEquipment equip) {
		sjjxTabEquipmentDAO.updateEquip(equip);
		
	}
	
	
	/**
	 * �����豸��ϢEXCEL�ļ�
	 * 
	 */
	public InputStream getInputStream() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���õ�λ");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��λ����");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�����");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�豸����");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�豸���");

		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�豸����");

		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�豸Ʒ��");

		cell = row.createCell((short) 7);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�豸�ͺ�");
		
		cell = row.createCell((short) 8);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�豸���");
		
		cell = row.createCell((short) 9);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�豸����");
		
		cell = row.createCell((short) 10);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("����");
		
		cell = row.createCell((short) 11);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("������");
		
		cell = row.createCell((short) 12);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���򳧼�");
		
		cell = row.createCell((short) 13);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("������");
		
		cell = row.createCell((short) 14);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��������");
		
		cell = row.createCell((short) 15);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("������");
		
		cell = row.createCell((short) 16);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���ѿ�Ŀ");
		
		cell = row.createCell((short) 17);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���ѿ�Ŀ��");
		
		cell = row.createCell((short) 18);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ʹ�÷���");
		
		cell = row.createCell((short) 19);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ʹ�÷�����");
		
		cell = row.createCell((short) 20);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���к�");
		
		cell = row.createCell((short) 21);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���ݺ�");
		
		cell = row.createCell((short) 22);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("������");
		
		cell = row.createCell((short) 23);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���ʱ��");
		
		cell = row.createCell((short) 24);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("���");
		
		cell = row.createCell((short) 25);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�ʲ����");
		
		cell = row.createCell((short) 26);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��������");
		
		cell = row.createCell((short) 27);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("������");
		
		cell = row.createCell((short) 28);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��������");
		
		cell = row.createCell((short) 29);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�豸��Դ");
		
		cell = row.createCell((short) 30);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�豸��Դ��");
		
		cell = row.createCell((short) 31);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�۾ɷ�ʽ");
		
		cell = row.createCell((short) 32);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("�۾ɷ�ʽ��");
		
		cell = row.createCell((short) 33);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("����ƾ��");
		
		cell = row.createCell((short) 34);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��������");
		
		cell = row.createCell((short) 35);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ʵ��ʹ����");
		
		cell = row.createCell((short) 36);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("ʵ��������");
		
		cell = row.createCell((short) 37);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("��ע");

		List<SjjxTabEquipment> equipmentList = this.getEquipList();

		for (int i = 0; i < equipmentList.size(); ++i) {
			SjjxTabEquipment equipment = equipmentList.get(i);

			row = sheet.createRow(i + 1);

			cell = row.createCell((short) 0);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFDepartmentId());

			cell = row.createCell((short) 1);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFDepartmentName());

			cell = row.createCell((short) 2);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFTypeId());

			cell = row.createCell((short) 3);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getSjjxTabEquipmenttype().getFEquTypeName());

			cell = row.createCell((short) 4);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFEquId());

			cell = row.createCell((short) 5);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFEquName());

			cell = row.createCell((short) 6);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFEquBrand());

			cell = row.createCell((short) 7);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFEquPattern());
			
			cell = row.createCell((short) 8);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFEquStandard());
			
			cell = row.createCell((short) 9);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFEquPrice());
			
			cell = row.createCell((short) 10);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFCountry());
			
			cell = row.createCell((short) 11);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFCountryId());
			
			cell = row.createCell((short) 12);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFEquBuyCompany());
			
			cell = row.createCell((short) 13);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFChuChangId());
			
			cell = row.createCell((short) 14);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFEquBuyTime());
		
			
			cell = row.createCell((short) 15);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFPersonL());
			
			cell = row.createCell((short) 16);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFFundsId());
			
			cell = row.createCell((short) 17);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFFundsName());
			
			cell = row.createCell((short) 18);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFUseDirectionId());
			
			cell = row.createCell((short) 19);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFUseDirectionName());
			
			cell = row.createCell((short) 20);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFKeYanId());
			
			cell = row.createCell((short) 21);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFDanJuId());
			
			cell = row.createCell((short) 22);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFPersonJ());
			
			cell = row.createCell((short) 23);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFRuKuTime());
			
			cell = row.createCell((short) 24);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFShenHe());
			
			cell = row.createCell((short) 25);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFZiChanType());
			
			cell = row.createCell((short) 26);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFGuoBiaoId());
			
			cell = row.createCell((short) 27);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFJiZhangRen());
			
			cell = row.createCell((short) 28);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFShuRuTime());
			
			cell = row.createCell((short) 29);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFEquSourceId());
			
			cell = row.createCell((short) 30);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFEquSourceName());
			
			cell = row.createCell((short) 31);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFZheJiuId());
			
			cell = row.createCell((short) 32);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFZheJiuName());
			
			cell = row.createCell((short) 33);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFCaiWuPingDan());
			
			cell = row.createCell((short) 34);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFBaoXiuDate());
			
			cell = row.createCell((short) 35);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFPersonS());
			
			cell = row.createCell((short) 36);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getSjjxTabLab().getFLabName());
			
			cell = row.createCell((short) 37);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(equipment.getFRemarks());
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
