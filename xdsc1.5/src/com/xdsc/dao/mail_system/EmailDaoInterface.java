package com.xdsc.dao.mail_system;

import java.util.HashMap;
import java.util.List;

import javax.mail.Folder;

import com.xdsc.model.Mail;

/**接口：封装了邮件的相关方法的抽象函数
 * @author 郑灿双 2010-04-30
 * @version 1.1
 *
 */
public interface EmailDaoInterface {
	
	/**抽象函数：得到POP3邮件服务器上的邮件夹对象
	 * @param host 主机号
	 * @param username 用户名
	 * @param password 密码
	 * @return 邮件夹
	 */
	public abstract Folder getFolder(String host,String username,String password);
	
	
	/**抽象函数：发送邮件
	 * @param mail 邮件实体
	 * @return 邮件的发送状态
	 */
	public abstract HashMap sendMail(Mail mail);
	
	//邮件搜索的方法
//	public abstract List searchMail(String search_condition,String search_value);
}
