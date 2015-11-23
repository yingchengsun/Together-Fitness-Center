package com.xdsc.dao.mail_system;

import java.util.List;

import com.xdsc.model.Mailmanager;

/**�ӿڣ���װ�������ݿ⽻�����й��ʼ�����ĳ�����
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public interface MailManagerDaoInterface {

	/**��������ͨ���ʼ���ź��û������ҹ������
	 * @param msgnum �ʼ��� 
	 * @param username �û���
	 * @return �ҵ�����true ���򷵻�false
	 */
	public abstract boolean findByMsgnum(int msgnum,String username);

	/**��������ͨ���ʼ���ź��û������ҹ������
	 * @param msgnum �ʼ���
	 * @param username �û���
	 * @return �������
	 */
	public abstract Mailmanager findByMsgnumandUsername(int msgnum,String username);

	
	/**�����������û�ж�Ӧ��msgnum����δ���ʼ�����ô�ڶ�ȡ���ݵ�ʱ�����һ����¼�������ñ�־λΪ�Ѷ�
	 * @param mailmanager �������
	 */
	public abstract void addSeen(Mailmanager mailmanager);

	/** ���������ҵ����е��Ѷ��ʼ�
	 * @param username �û���
	 * @return �ʼ�����
	 */
	public abstract List<Mailmanager> findSeen(String username);
	
	
	/**�����������ҳ������Ѷ��ʼ�������
	 * @param username �û���
	 * @return �Ѷ��ʼ�����
	 */
	public abstract int findCountOfSeen(String username);
	
	
	/**�����������ʼ�ɾ����־λ����Ϊ1
	 * @param mailmanager �������
	 */
	public abstract void updateDeleted(Mailmanager mailmanager);
	
	/**���������ҵ�����Ϊɾ�����ʼ�
	 * @param username �û���
	 * @return ��ɾ���ʼ��б�
	 */
	public abstract List<Mailmanager> findDeleted(String username); 
	
	
	/** �����������Ϊδ��
	 * @param mailmanager �������
	 */
	public abstract void updateNew(Mailmanager mailmanager);
	
	
	/** �����������Ϊ�����ʼ�
	 * @param mailmanager �������
	 */
	public abstract void updateRubbish(Mailmanager mailmanager);
	
	/**���������������е������ʼ�
	 * @param username �û���
	 * @return �����ʼ��б�
	 */
	public abstract List<Mailmanager> findRubbish(String username);
	
}