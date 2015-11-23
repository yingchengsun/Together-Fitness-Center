package com.xdsc.service.sjjx_system.impl;

import java.util.List;




import com.xdsc.dao.sjjx_system.SjjxTabLabDAO;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.SjjxTabLab;
import com.xdsc.service.sjjx_system.SjjxTabLabManager;

/**��ʵ������Ϣ���в���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabLabManagerImpl implements SjjxTabLabManager {

	
	/**
	 * SjjxTabLabDAOImpl �Ľӿ�
	 */
	private SjjxTabLabDAO sjjxTabLabDAO;

	/**
	 * ���ݷ��ʷ���
	 */
	public SjjxTabLabDAO getSjjxTabLabDAO() {
		return sjjxTabLabDAO;
	}

	public void setSjjxTabLabDAO(SjjxTabLabDAO sjjxTabLabDAO) {
		this.sjjxTabLabDAO = sjjxTabLabDAO;
	}
	

	/**����һ��ʵ���Ҽ�¼�����ݿ���
	 * @param lab
	 */
	public boolean saveLab(SjjxTabLab lab) {
		return sjjxTabLabDAO.saveLab(lab);
	}
	

	/**�����ݿ���ɾ��һ��ʵ���Ҽ�¼
	 * @param lab
	 */
	public boolean deleteLab(SjjxTabLab lab){
		return sjjxTabLabDAO.deleteLab(lab);
	}
	
	
	/**�����ݿ��ж�ȡ���е�ʵ���Ҽ�¼
	 * @return �������в��ҵ���¼
	 */
	public List<SjjxTabLab> getLabList(){
		return sjjxTabLabDAO.getLabList();
	}
	

	/**ͨ��ʵ���ұ�Ų��ҵ�ʵ���Ҽ�¼
	 * @param labId
	 * @return ���ز��ҵ��ļ�¼
	 */
	public SjjxTabLab getLabByLabId(Integer labId){
		return sjjxTabLabDAO.getLabByLabId(labId);
	}
	
	
	/**ͨ��ʵ�������Ʋ��ҵ�ʵ���Ҽ�¼
	 * @param labName
	 * @return ���ز��ҵ���һ����¼
	 */
	public SjjxTabLab getLabByLabName1(String labName){
		return sjjxTabLabDAO.getLabByLabName1(labName);
	}
	
	/**ͨ��ʵ�������Ʋ��ҵ�ʵ���Ҽ�¼
	 * @param labName
	 * @return ���ز��ҵ��ļ�¼
	 */
	public List<SjjxTabLab> getLabByLabName(String labName){
		return sjjxTabLabDAO.getLabByLabName(labName);
	}
	
	/**ͨ��ʵ�������ڷ����Ų��ҵ�ʵ���Ҽ�¼
	 * @param roomNumber
	 * @return ���ز��ҵ��ļ�¼
	 */
	public List<SjjxTabLab> getLabByRoomNumber(String roomNumber){
		return sjjxTabLabDAO.getLabByRoomNumber(roomNumber);
	}

	/**����ʵ������Ϣ
	 * @param lab
	 */
	public void updateLab(SjjxTabLab lab){
		 sjjxTabLabDAO.updateLab(lab);
	}
	
	
}
