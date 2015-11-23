package com.xdsc.dao.mail_system;

import java.util.List;

import com.xdsc.model.Mailmanager;

/**接口：封装了与数据库交互的有关邮件管理的抽象函数
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public interface MailManagerDaoInterface {

	/**抽象函数：通过邮件编号和用户名查找管理对象
	 * @param msgnum 邮件号 
	 * @param username 用户名
	 * @return 找到返回true 否则返回false
	 */
	public abstract boolean findByMsgnum(int msgnum,String username);

	/**抽象函数：通过邮件编号和用户名查找管理对象
	 * @param msgnum 邮件号
	 * @param username 用户名
	 * @return 管理对象
	 */
	public abstract Mailmanager findByMsgnumandUsername(int msgnum,String username);

	
	/**抽象函数：如果没有对应的msgnum就是未读邮件，那么在读取内容的时候插入一条记录，并且置标志位为已读
	 * @param mailmanager 管理对象
	 */
	public abstract void addSeen(Mailmanager mailmanager);

	/** 抽象函数：找到所有的已读邮件
	 * @param username 用户名
	 * @return 邮件集合
	 */
	public abstract List<Mailmanager> findSeen(String username);
	
	
	/**抽象函数：查找出所有已读邮件的数量
	 * @param username 用户名
	 * @return 已读邮件数量
	 */
	public abstract int findCountOfSeen(String username);
	
	
	/**抽象函数：将邮件删除标志位设置为1
	 * @param mailmanager 管理对象
	 */
	public abstract void updateDeleted(Mailmanager mailmanager);
	
	/**抽象函数：找到设置为删除的邮件
	 * @param username 用户名
	 * @return 已删除邮件列表
	 */
	public abstract List<Mailmanager> findDeleted(String username); 
	
	
	/** 抽象函数：标记为未读
	 * @param mailmanager 管理对象
	 */
	public abstract void updateNew(Mailmanager mailmanager);
	
	
	/** 抽象函数：标记为垃圾邮件
	 * @param mailmanager 管理对象
	 */
	public abstract void updateRubbish(Mailmanager mailmanager);
	
	/**抽象函数：查找所有的垃圾邮件
	 * @param username 用户名
	 * @return 垃圾邮件列表
	 */
	public abstract List<Mailmanager> findRubbish(String username);
	
}