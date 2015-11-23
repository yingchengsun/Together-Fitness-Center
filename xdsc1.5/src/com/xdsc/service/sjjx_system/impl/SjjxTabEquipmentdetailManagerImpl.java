package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabEquipmentdetailDAO;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.SjjxTabEquipmentdetail;
import com.xdsc.service.sjjx_system.SjjxTabEquipmentdetailManager;

/**���豸��������ϸ��Ϣ���в���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabEquipmentdetailManagerImpl implements SjjxTabEquipmentdetailManager {

	/**
	 * SjjxTabEquipmentdetailDAOImpl �Ľӿ�
	 */
	private SjjxTabEquipmentdetailDAO sjjxTabEquipmentdetailDAO;

	/**
	 * ���ݷ��ʷ���
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
	

	/**����һ���豸������¼�����ݿ���
	 * @param equipDetail
	 */
	public boolean saveEquipDetail(SjjxTabEquipmentdetail equipDetail) {
		return sjjxTabEquipmentdetailDAO.saveEquipDetail(equipDetail);
	}



	/**�����ݿ���ɾ��һ���豸������¼
	 * @param equipDetail
	 * @return
	 */
	public boolean deleteEquipDetail(SjjxTabEquipmentdetail equipDetail) {
		return sjjxTabEquipmentdetailDAO.deleteEquipDetail(equipDetail);
	}
	

	/**�����ݿ��ж�ȡ���е��豸������¼
	 * @return �������в��ҵ���¼
	 */
	public List<SjjxTabEquipmentdetail> getEquipDetailList() {
		return sjjxTabEquipmentdetailDAO.getEquipDetailList();
	}


	/**ͨ���豸��Ų��ҵ��豸������¼
	 * @param equipId
	 * @return ���ز��ҵ���¼
	 */
	public List<SjjxTabEquipmentdetail> getEquipDetailByEquipId(Integer equipId) {
		return sjjxTabEquipmentdetailDAO.getEquipDetailByEquipId(equipId);
	}


	/**�����豸������¼
	 * @param equipDetail
	 */
	public void updateEquipDetail(SjjxTabEquipmentdetail equipDetail) {
		sjjxTabEquipmentdetailDAO.updateEquipDetail(equipDetail);
		
	}
	
}
