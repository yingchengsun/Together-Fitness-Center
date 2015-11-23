package com.xdsc.service.bksx_system.impl;

import com.xdsc.dao.bksx_system.TabAdministratorDAO;
import com.xdsc.model.TabAdministrator;
import com.xdsc.service.bksx_system.TabAdministratorManager;

public class TabAdministratorManagerImpl implements TabAdministratorManager {
	/**
	 * TabAdministratorDAOImpl接口
	 */
	private TabAdministratorDAO tabAdministratorDAO;

	/**
	 * tabAdministratorDAO属性的Get与Set方法
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
