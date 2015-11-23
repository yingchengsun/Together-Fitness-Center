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


/**进行Excel表格导出的Action
 * @author 陈雪
 * @version 1.1
 */
public class SjjxExportAsExcelAction extends ActionSupport {
	
	/**
	 * Spring 注入的Service层的接口
	 */
    private SjjxTabCourselabManager sjjxTabCourselabManager;
    private SjjxTabEquipmentManager sjjxTabEquipmentManager;
      
      

    /**构造实验安排Excel以供导出
	 * @return InputStream
	 *         具体实现参见sjjxTabCourselabManager.getInputStream()
	 */
	public InputStream getCourseLabDownloadFile() {
  		return sjjxTabCourselabManager.getInputStream();
  	}
      
	/** 导出Excel实验安排信息
	 * @return SUCCESS    
	 */
    public String exportCourseLab() {
  		return SUCCESS;
  	}

      
    /**构造实设备信息Excel以供导出<br>
	 * @return InputStream        
	 *         具体实现参见sjjxTabEquipmentManager.getInputStream()
	 */
    public InputStream getEquipmentDownloadFile() {
    		return sjjxTabEquipmentManager.getInputStream();
    	}
        
    /** 导出Excel设备信息
	 * @return SUCCESS    
	 */
    public String exportEquipment() {
    		return SUCCESS;
    	}
     
    /**
	 * 该类成员方法的Get与Set方法
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
