package com.xdsc.dao.sjjx_system;

import com.xdsc.model.TabAdministrator;

/**对于管理员信息进行操作
 * @author 陈雪
 * @version1.1
 */
public interface SjjxTabAdministratorDAO {

	/**通过管理员登陆Id查找到管理员记录
	 * @param adminNumber
	 * @return 返回查找到的管理员记录
	 */
	public abstract TabAdministrator getAdminByFAdminNumber(String adminNumber);

}