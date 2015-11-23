package com.xdsc.dao.mail_system;

import java.util.HashMap;
import java.util.List;

import javax.mail.Folder;

import com.xdsc.model.Mail;

/**�ӿڣ���װ���ʼ�����ط����ĳ�����
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public interface EmailDaoInterface {
	
	/**���������õ�POP3�ʼ��������ϵ��ʼ��ж���
	 * @param host ������
	 * @param username �û���
	 * @param password ����
	 * @return �ʼ���
	 */
	public abstract Folder getFolder(String host,String username,String password);
	
	
	/**�������������ʼ�
	 * @param mail �ʼ�ʵ��
	 * @return �ʼ��ķ���״̬
	 */
	public abstract HashMap sendMail(Mail mail);
	
	//�ʼ������ķ���
//	public abstract List searchMail(String search_condition,String search_value);
}
