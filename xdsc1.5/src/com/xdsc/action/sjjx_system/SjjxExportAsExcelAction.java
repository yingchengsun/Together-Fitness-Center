package com.xdsc.action.sjjx_system;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.SjjxTabCourselab;
import com.xdsc.service.sjjx_system.SjjxTabCourselabManager;
import com.xdsc.service.sjjx_system.SjjxTabEquipmentManager;


/**����Excel��񵼳���Action
 * @author ��ѩ
 * @version 1.1
 */
public class SjjxExportAsExcelAction extends ActionSupport {
	
	/**
	 * Spring ע���Service��Ľӿ�
	 */
    private SjjxTabCourselabManager sjjxTabCourselabManager;
    private SjjxTabEquipmentManager sjjxTabEquipmentManager;
      
      

    /**����ʵ�鰲��Excel�Թ�����
	 * @return InputStream
	 *         ����ʵ�ֲμ�sjjxTabCourselabManager.getInputStream()
	 */
	public InputStream getCourseLabDownloadFile() {
  		return sjjxTabCourselabManager.getInputStream();
  	}
      
	/** ����Excelʵ�鰲����Ϣ
	 * @return SUCCESS    
	 */
    public String exportCourseLab() {
  		return SUCCESS;
  	}

      
    /**����ʵ�豸��ϢExcel�Թ�����<br>
	 * @return InputStream        
	 *         ����ʵ�ֲμ�sjjxTabEquipmentManager.getInputStream()
	 */
    public InputStream getEquipmentDownloadFile() {
    		return sjjxTabEquipmentManager.getInputStream();
    	}
        
    /** ����Excel�豸��Ϣ
	 * @return SUCCESS    
	 */
    public String exportEquipment() {
    		return SUCCESS;
    	}
     
    /**
	 * �����Ա������Get��Set����
	 */
	public SjjxTabCourselabManager getSjjxTabCourselabManager() {
		return sjjxTabCourselabManager;
	}

	public void setSjjxTabCourselabManager(
			SjjxTabCourselabManager sjjxTabCourselabManager) {
		this.sjjxTabCourselabManager = sjjxTabCourselabManager;
	}
      
	public SjjxTabEquipmentManager getSjjxTabEquipmentManager() {
		return sjjxTabEquipmentManager;
	}

	public void setSjjxTabEquipmentManager(
			SjjxTabEquipmentManager sjjxTabEquipmentManager) {
		this.sjjxTabEquipmentManager = sjjxTabEquipmentManager;
	} 
      
      
      
      
      
      
      
      

	
      
}
