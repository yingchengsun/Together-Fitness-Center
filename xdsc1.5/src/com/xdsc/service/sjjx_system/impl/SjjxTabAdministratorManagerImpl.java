package com.xdsc.service.sjjx_system.impl;

import com.xdsc.dao.sjjx_system.SjjxTabAdministratorDAO;
import com.xdsc.model.TabAdministrator;
import com.xdsc.service.sjjx_system.SjjxTabAdministratorManager;

/**对于管理员信息进行操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabAdministratorManagerImpl implements SjjxTabAdministratorManager {

	
	/**
	 * SjjxTabAdministratorDAOImpl 的接口
	 */
	private SjjxTabAdministratorDAO sjjxTabAdministratorDAO;

	/**
	 * 数据访问方法
	 */
	public SjjxTabAdministratorDAO getSjjxTabAdministratorDAO() {
		return sjjxTabAdministratorDAO;
	}

	public void setSjjxTabAdministratorDAO(
			SjjxTabAdministratorDAO sjjxTabAdministratorDAO) {
		this.sjjxTabAdministratorDAO = sjjxTabAdministratorDAO;
	}
	
	
	/**通过管理员登陆Id查找到管理员记录
	 * @param adminNumber
	 * @return 返回查找到的管理员记录
	 */
	public TabAdministrator getAdminByFAdminNumber(String adminNumber) {
		return sjjxTabAdministratorDAO.getAdminByFAdminNumber(adminNumber);
	}
	
}
