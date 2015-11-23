package com.xdsc.dao.mail_system;

import java.util.List;

import com.xdsc.model.Contact;

/** 接口：与通讯录有关的与后台数据库交互的方法
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public interface ContactDaoInterface {
	
	/**抽象函数：查找所有的通讯录条目
	 * @return 通讯录列表
	 */
	public abstract List findContact();
	
	/**抽象函数：通过主键查找通讯录条目
	 * @param cid 主键值
	 * @return 特定通讯录条目
	 */
	public abstract Contact findById(int cid);
	
	/**抽象函数：通过用户名查找通讯录条目
	 * @param username 用户名
	 * @return 特定通讯录条目
	 */
	public abstract Contact findContactByUsername(String username);
	
	//
	//
	/** 抽象函数：通过roleId查询mhqx_tab_roleuser表，得到
	 * 具有该roleId的所有username 即userNumber
	 * @param roleId 角色ID
	 * @return 符合条件的通讯录条目
	 */
	public abstract List findByClass();
	
	public abstract List findByClassNumber(String classNumber);

	//删除
	/** 删除操作
	 * @param contact 通讯录条目
	 */
	public abstract void deleteContact(Contact contact);
	
	//更新
	/** 更新操作
	 * @param contact 通讯录条目
	 */
	public abstract void updateContact(Contact contact);
	
	//添加
	/**插入操作
	 * @param contact 通讯录条目
	 */
	public abstract void addContact(Contact contact);
}
