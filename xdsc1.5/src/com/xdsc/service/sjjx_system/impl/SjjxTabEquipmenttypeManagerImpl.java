package com.xdsc.service.sjjx_system.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



import com.xdsc.dao.sjjx_system.SjjxTabEquipmenttypeDAO;
import com.xdsc.model.BksxTabSubstugui;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.SjjxTabEquipmenttype;
import com.xdsc.service.sjjx_system.SjjxTabEquipmenttypeManager;

/**对设备类型信息记录进行操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabEquipmenttypeManagerImpl implements SjjxTabEquipmenttypeManager {

	/**
	 * SjjxTabEquipmenttypeDAOImpl 的接口
	 */
   private SjjxTabEquipmenttypeDAO sjjxTabEquipmenttypeDAO;


   /**
	 * 数据访问方法
	 */
   public SjjxTabEquipmenttypeDAO getSjjxTabEquipmenttypeDAO() {
	    return sjjxTabEquipmenttypeDAO;
   }

   public void setSjjxTabEquipmenttypeDAO(SjjxTabEquipmenttypeDAO sjjxTabEquipmenttypeDAO) {
	    this.sjjxTabEquipmenttypeDAO = sjjxTabEquipmenttypeDAO;
   }



   /**增添一条设备类型信息到数据库中
	 * @param equipType
	 */
   public boolean saveEquipType(SjjxTabEquipmenttype equipType) {
		return sjjxTabEquipmenttypeDAO.saveEquipType(equipType);
   }
	

   /**从数据库中删除一条设备类型信息记录
	 * @param equipType
	 */
   public boolean deleteEquipType(SjjxTabEquipmenttype equipType){
	   return sjjxTabEquipmenttypeDAO.deleteEquiptype(equipType);
   }
   


   /**从数据库中读取所有的设备类型记录
	 * @return 返回所有查找到记录
	 */
   public List<SjjxTabEquipmenttype> getEquipTypeList() {
		return sjjxTabEquipmenttypeDAO.getEquipTypeList();
	}
	


   /**通过设备类型编号查找到设备类型记录
	 * @param equipTypeId
	 * @return 返回查找到记录
	 */
   public SjjxTabEquipmenttype getEquipTypeByEquipTypeId(Integer equipTypeId) {
		return sjjxTabEquipmenttypeDAO.getEquipTypeByEquipTypeId(equipTypeId);
	}
   

   /**通过设备类型名称查找到设备类型记录
	 * @param equipTypeName
	 * @return 返回查找到记录
	 */
   public SjjxTabEquipmenttype getEquipTypeByEquipTypeName(String equipTypeName) {
		return sjjxTabEquipmenttypeDAO.getEquipTypeByEquipTypeName(equipTypeName);
	}

   public List<SjjxTabEquipmenttype> getEquipTypeByEquipTypeName1(String equipTypeName){
	   return sjjxTabEquipmenttypeDAO.getEquipTypeByEquipTypeName1(equipTypeName);
   }
   
   
   /**更新一条设备类型记录
	 * @param equipType
	 */
   public void updateEquipType(SjjxTabEquipmenttype equipType) {
		sjjxTabEquipmenttypeDAO.updateEquipType(equipType);
		
	}
   
  

   
}
