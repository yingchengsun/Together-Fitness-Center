package com.xdsc.dao.wzmh_system;

import com.xdsc.model.TabAdministrator;
/**
 * 管理员信息维护
 * @author 陈丰
 *
 */
public interface AdminInfoDAO {

	/**
	 * 更新管理员信息
	 * @param 
	 */
	public void updateAdminInfo(TabAdministrator Admin);
	
	
	/**
	 * 插入一个管理员
	 * @param Admin
	 */
	public void insertAdminInfo(TabAdministrator Admin);
	
	/**
	 * 根据管理员帐号查找管理员
	 * @param 帐号
	 * @return 管理员实例
	 */
	public TabAdministrator findAdminByNum(String num);
}
