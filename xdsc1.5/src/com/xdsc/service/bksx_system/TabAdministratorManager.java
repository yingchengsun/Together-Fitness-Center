package com.xdsc.service.bksx_system;

import com.xdsc.model.TabAdministrator;

public interface TabAdministratorManager {

	/**
	 * 根据ID获得一个管理员对象
	 * 
	 * @param adminID
	 *            管理员ID
	 * @return TabAdministrator
	 */
	public abstract TabAdministrator getAdminById(String adminID);

}