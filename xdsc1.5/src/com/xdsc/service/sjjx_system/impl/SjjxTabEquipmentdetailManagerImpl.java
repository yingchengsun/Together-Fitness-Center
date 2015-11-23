package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabEquipmentdetailDAO;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.SjjxTabEquipmentdetail;
import com.xdsc.service.sjjx_system.SjjxTabEquipmentdetailManager;

/**对设备调拨等详细信息进行操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabEquipmentdetailManagerImpl implements SjjxTabEquipmentdetailManager {

	/**
	 * SjjxTabEquipmentdetailDAOImpl 的接口
	 */
	private SjjxTabEquipmentdetailDAO sjjxTabEquipmentdetailDAO;

	/**
	 * 数据访问方法
	 */
	public SjjxTabEquipmentdetailDAO getSjjxTabEquipmentdetailDAO() {
		return sjjxTabEquipmentdetailDAO;
	}

	/**
	 * @param sjjxTabEquipmentdetailDAO
	 */
	public void setSjjxTabEquipmentdetailDAO(
			SjjxTabEquipmentdetailDAO sjjxTabEquipmentdetailDAO) {
		this.sjjxTabEquipmentdetailDAO = sjjxTabEquipmentdetailDAO;
	}
	

	/**增添一条设备调拨记录到数据库中
	 * @param equipDetail
	 */
	public boolean saveEquipDetail(SjjxTabEquipmentdetail equipDetail) {
		return sjjxTabEquipmentdetailDAO.saveEquipDetail(equipDetail);
	}



	/**从数据库中删除一条设备调拨记录
	 * @param equipDetail
	 * @return
	 */
	public boolean deleteEquipDetail(SjjxTabEquipmentdetail equipDetail) {
		return sjjxTabEquipmentdetailDAO.deleteEquipDetail(equipDetail);
	}
	

	/**从数据库中读取所有的设备调拨记录
	 * @return 返回所有查找到记录
	 */
	public List<SjjxTabEquipmentdetail> getEquipDetailList() {
		return sjjxTabEquipmentdetailDAO.getEquipDetailList();
	}


	/**通过设备编号查找到设备调拨记录
	 * @param equipId
	 * @return 返回查找到记录
	 */
	public List<SjjxTabEquipmentdetail> getEquipDetailByEquipId(Integer equipId) {
		return sjjxTabEquipmentdetailDAO.getEquipDetailByEquipId(equipId);
	}


	/**更新设备调拨记录
	 * @param equipDetail
	 */
	public void updateEquipDetail(SjjxTabEquipmentdetail equipDetail) {
		sjjxTabEquipmentdetailDAO.updateEquipDetail(equipDetail);
		
	}
	
}
