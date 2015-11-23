package com.xdsc.service.sjjx_system.impl;

import com.xdsc.dao.sjjx_system.SjjxTabAdministratorDAO;
import com.xdsc.model.TabAdministrator;
import com.xdsc.service.sjjx_system.SjjxTabAdministratorManager;

/**���ڹ���Ա��Ϣ���в���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabAdministratorManagerImpl implements SjjxTabAdministratorManager {

	
	/**
	 * SjjxTabAdministratorDAOImpl �Ľӿ�
	 */
	private SjjxTabAdministratorDAO sjjxTabAdministratorDAO;

	/**
	 * ���ݷ��ʷ���
	 */
	public SjjxTabAdministratorDAO getSjjxTabAdministratorDAO() {
		return sjjxTabAdministratorDAO;
	}

	public void setSjjxTabAdministratorDAO(
			SjjxTabAdministratorDAO sjjxTabAdministratorDAO) {
		this.sjjxTabAdministratorDAO = sjjxTabAdministratorDAO;
	}
	
	
	/**ͨ������Ա��½Id���ҵ�����Ա��¼
	 * @param adminNumber
	 * @return ���ز��ҵ��Ĺ���Ա��¼
	 */
	public TabAdministrator getAdminByFAdminNumber(String adminNumber) {
		return sjjxTabAdministratorDAO.getAdminByFAdminNumber(adminNumber);
	}
	
}
