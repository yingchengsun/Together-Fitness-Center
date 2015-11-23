package com.xdsc.dao.mail_system;

import com.xdsc.model.UserInfo;

/**接口：有用户信息有关的抽象函数
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public interface UserInfoDaoInterface {
	
	/**抽象函数：通过用户名查找用户信息条目
	 * @param username 用户名
	 * @return 用户信息条目
	 */
	public abstract UserInfo selectByUsername(String username);
	
	/**抽象函数：通过ID查找用户信息条目
	 * @param info_id ID
	 * @return 用户信息条目
	 */
	public abstract UserInfo selectById(int info_id);
	
	/**抽象函数：修改用户信息
	 * @param userInfo 用户信息条目
	 */
	public abstract void updateInfo(UserInfo userInfo);
}
