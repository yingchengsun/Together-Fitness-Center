package com.xdsc.service.bksx_system;

import com.xdsc.model.TabAdministrator;

public interface TabAdministratorManager {

	/**
	 * ����ID���һ������Ա����
	 * 
	 * @param adminID
	 *            ����ԱID
	 * @return TabAdministrator
	 */
	public abstract TabAdministrator getAdminById(String adminID);

}