package com.xdsc.service.bksx_system.impl;

import com.xdsc.dao.bksx_system.TabAdministratorDAO;
import com.xdsc.model.TabAdministrator;
import com.xdsc.service.bksx_system.TabAdministratorManager;

public class TabAdministratorManagerImpl implements TabAdministratorManager {
	/**
	 * TabAdministratorDAOImpl�ӿ�
	 */
	private TabAdministratorDAO tabAdministratorDAO;

	/**
	 * tabAdministratorDAO���Ե�Get��Set����
	 */
	public TabAdministratorDAO getTabAdministratorDAO() {
		return tabAdministratorDAO;
	}

	public void setTabAdministratorDAO(TabAdministratorDAO tabAdministratorDAO) {
		this.tabAdministratorDAO = tabAdministratorDAO;
	}

	/* (non-Javadoc)
	 * @see com.xdsc.service.bksx_system.impl.TabAdministratorManager#getAdminById(java.lang.String)
	 */
	public TabAdministrator getAdminById(String adminID) {
		return tabAdministratorDAO.getAdminById(adminID);
	}
}
