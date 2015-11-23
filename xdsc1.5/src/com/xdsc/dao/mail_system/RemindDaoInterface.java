package com.xdsc.dao.mail_system;

import java.util.List;

import com.xdsc.model.Remind;

/**接口：与数据库交互的与私人提醒有关的抽象函数
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public interface RemindDaoInterface {
	
	/**抽象函数：添加新提醒
	 * @param remind 提醒实体
	 */
	public abstract void addRemind(Remind remind);
	
	/**抽象函数：删除提醒
	 * @param remind 提醒实体
	 */
	public abstract void deleteRemind(Remind remind);
	
	
	/**抽象函数：通过ID找到提醒条目
	 * @param id ID
	 * @return 提醒条目
	 */
	public abstract Remind findById(int id);
	
	/**抽象函数：找到符合条件的提醒条目
	 * @param username 用户名
	 * @return 提醒列表
	 */
	public abstract List<Remind> findRemind(String username);

}
