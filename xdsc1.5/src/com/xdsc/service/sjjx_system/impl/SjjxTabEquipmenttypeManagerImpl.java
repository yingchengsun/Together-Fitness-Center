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

/**���豸������Ϣ��¼���в���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabEquipmenttypeManagerImpl implements SjjxTabEquipmenttypeManager {

	/**
	 * SjjxTabEquipmenttypeDAOImpl �Ľӿ�
	 */
   private SjjxTabEquipmenttypeDAO sjjxTabEquipmenttypeDAO;


   /**
	 * ���ݷ��ʷ���
	 */
   public SjjxTabEquipmenttypeDAO getSjjxTabEquipmenttypeDAO() {
	    return sjjxTabEquipmenttypeDAO;
   }

   public void setSjjxTabEquipmenttypeDAO(SjjxTabEquipmenttypeDAO sjjxTabEquipmenttypeDAO) {
	    this.sjjxTabEquipmenttypeDAO = sjjxTabEquipmenttypeDAO;
   }



   /**����һ���豸������Ϣ�����ݿ���
	 * @param equipType
	 */
   public boolean saveEquipType(SjjxTabEquipmenttype equipType) {
		return sjjxTabEquipmenttypeDAO.saveEquipType(equipType);
   }
	

   /**�����ݿ���ɾ��һ���豸������Ϣ��¼
	 * @param equipType
	 */
   public boolean deleteEquipType(SjjxTabEquipmenttype equipType){
	   return sjjxTabEquipmenttypeDAO.deleteEquiptype(equipType);
   }
   


   /**�����ݿ��ж�ȡ���е��豸���ͼ�¼
	 * @return �������в��ҵ���¼
	 */
   public List<SjjxTabEquipmenttype> getEquipTypeList() {
		return sjjxTabEquipmenttypeDAO.getEquipTypeList();
	}
	


   /**ͨ���豸���ͱ�Ų��ҵ��豸���ͼ�¼
	 * @param equipTypeId
	 * @return ���ز��ҵ���¼
	 */
   public SjjxTabEquipmenttype getEquipTypeByEquipTypeId(Integer equipTypeId) {
		return sjjxTabEquipmenttypeDAO.getEquipTypeByEquipTypeId(equipTypeId);
	}
   

   /**ͨ���豸�������Ʋ��ҵ��豸���ͼ�¼
	 * @param equipTypeName
	 * @return ���ز��ҵ���¼
	 */
   public SjjxTabEquipmenttype getEquipTypeByEquipTypeName(String equipTypeName) {
		return sjjxTabEquipmenttypeDAO.getEquipTypeByEquipTypeName(equipTypeName);
	}

   public List<SjjxTabEquipmenttype> getEquipTypeByEquipTypeName1(String equipTypeName){
	   return sjjxTabEquipmenttypeDAO.getEquipTypeByEquipTypeName1(equipTypeName);
   }
   
   
   /**����һ���豸���ͼ�¼
	 * @param equipType
	 */
   public void updateEquipType(SjjxTabEquipmenttype equipType) {
		sjjxTabEquipmenttypeDAO.updateEquipType(equipType);
		
	}
   
  

   
}
