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

/**对设备基本信息记录进行操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabEquipmentManagerImpl implements SjjxTabEquipmentManager {

	
	/**
	 * SjjxTabEquipmentDAOImpl 的接口
	 */
	private SjjxTabEquipmentDAO sjjxTabEquipmentDAO;
	
	/**
	 * 数据访问方法
	 */
	public SjjxTabEquipmentDAO getSjjxTabEquipmentDAO() {
		return sjjxTabEquipmentDAO;
	}

	public void setSjjxTabEquipmentDAO(SjjxTabEquipmentDAO sjjxTabEquipmentDAO) {
		this.sjjxTabEquipmentDAO = sjjxTabEquipmentDAO;
	}
	


	/**增添一条设备基本信息到数据库中
	 * @param equip
	 */
	public boolean saveEquip(SjjxTabEquipment equip) {
		return sjjxTabEquipmentDAO.saveEquip(equip);
	}


	/**从数据库中删除一条设备基本信息记录
	 * @param equip
	 */
	public boolean deleteEquip(SjjxTabEquipment equip) {
		return sjjxTabEquipmentDAO.deleteEquip(equip);
	}
	

	/**从数据库中读取所有的设备基本信息记录
	 * @return 返回所有查找到记录
	 */
	public List<SjjxTabEquipment> getEquipList() {
		return sjjxTabEquipmentDAO.getEquipList();
	}

	/**通过设备编号查找到设备记录
	 * @param equipId
	 * @return 返回查找到记录
	 */
	public SjjxTabEquipment getEquipByEquipId(Integer equipId) {
		return sjjxTabEquipmentDAO.getEquipByEquipId(equipId);
	}
	

	/**通过设备类型名称查找该类型所有设备记录
	 * @param equipTypeName
	 * @return 返回所有查找到记录
	 */
	public List<SjjxTabEquipment> getEquipByEquipTypeName(String equipTypeName){
		return sjjxTabEquipmentDAO.getEquipByEquipTypeName(equipTypeName);
	}

	/**通过实验室名称找到该实验室所有设备记录
	 * @param labName
	 * @return 返回所有查找到记录
	 */
	public List<SjjxTabEquipment> getEquipByLabName(String labName){
		return sjjxTabEquipmentDAO.getEquipByLabName(labName);
	}
	
    
	/**更新一条设备记录
	 * @param equip
	 */
	public void updateEquip(SjjxTabEquipment equip) {
		sjjxTabEquipmentDAO.updateEquip(equip);
		
	}
	
	
	/**
	 * 构造设备信息EXCEL文件
	 * 
	 */
	public InputStream getInputStream() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);

		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("领用单位");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("单位名称");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("分类号");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("设备类型");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("设备编号");

		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("设备名称");

		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("设备品牌");

		cell = row.createCell((short) 7);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("设备型号");
		
		cell = row.createCell((short) 8);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("设备规格");
		
		cell = row.createCell((short) 9);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("设备单价");
		
		cell = row.createCell((short) 10);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("国别");
		
		cell = row.createCell((short) 11);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("国别码");
		
		cell = row.createCell((short) 12);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("购买厂家");
		
		cell = row.createCell((short) 13);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("出厂号");
		
		cell = row.createCell((short) 14);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("购置日期");
		
		cell = row.createCell((short) 15);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("领用人");
		
		cell = row.createCell((short) 16);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("经费科目");
		
		cell = row.createCell((short) 17);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("经费科目名");
		
		cell = row.createCell((short) 18);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("使用方向");
		
		cell = row.createCell((short) 19);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("使用方向名");
		
		cell = row.createCell((short) 20);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("科研号");
		
		cell = row.createCell((short) 21);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("单据号");
		
		cell = row.createCell((short) 22);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("经手人");
		
		cell = row.createCell((short) 23);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("入库时间");
		
		cell = row.createCell((short) 24);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("审核");
		
		cell = row.createCell((short) 25);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("资产类别");
		
		cell = row.createCell((short) 26);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("国标分类号");
		
		cell = row.createCell((short) 27);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("记账人");
		
		cell = row.createCell((short) 28);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("输入日期");
		
		cell = row.createCell((short) 29);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("设备来源");
		
		cell = row.createCell((short) 30);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("设备来源名");
		
		cell = row.createCell((short) 31);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("折旧方式");
		
		cell = row.createCell((short) 32);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("折旧方式名");
		
		cell = row.createCell((short) 33);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("财务凭单");
		
		cell = row.createCell((short) 34);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("保修期限");
		
		cell = row.createCell((short) 35);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("实际使用人");
		
		cell = row.createCell((short) 36);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("实验室名称");
		
		cell = row.createCell((short) 37);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("备注");

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
