package com.xdsc.dao.mail_system;

import com.xdsc.model.User;

/**接口：与用户登录有关的方法
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public interface ManagerDaoInterface {

	/**抽象函数：通过用户名和密码验证登陆
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 通过返回true 否则false
	 */
	public abstract boolean findManager(String name, String pwd);
	
	/**抽象函数：通过用户名找到User对象
	 * @param userName 用户名
	 * @return 用户对象
	 */
	public abstract User findUserByName(String userName);

}