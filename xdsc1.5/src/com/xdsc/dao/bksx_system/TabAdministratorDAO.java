package com.xdsc.dao.bksx_system;

import com.xdsc.model.TabAdministrator;
/**
 * @author 孙建波
 * @version 1.1
 * 
 * 封装对TabAdministrator的操作
 */
public interface TabAdministratorDAO {

	/**
	 * 根据ID获得一个管理员对象
	 * 
	 * @param adminID
	 *            管理员ID
	 * @return TabAdministrator
	 */
	public abstract TabAdministrator getAdminById(String adminID);

}