package com.xdsc.dao.mail_system;

import java.util.List;

import com.xdsc.model.Contact;

/** �ӿڣ���ͨѶ¼�йص����̨���ݿ⽻���ķ���
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public interface ContactDaoInterface {
	
	/**���������������е�ͨѶ¼��Ŀ
	 * @return ͨѶ¼�б�
	 */
	public abstract List findContact();
	
	/**��������ͨ����������ͨѶ¼��Ŀ
	 * @param cid ����ֵ
	 * @return �ض�ͨѶ¼��Ŀ
	 */
	public abstract Contact findById(int cid);
	
	/**��������ͨ���û�������ͨѶ¼��Ŀ
	 * @param username �û���
	 * @return �ض�ͨѶ¼��Ŀ
	 */
	public abstract Contact findContactByUsername(String username);
	
	//
	//
	/** ��������ͨ��roleId��ѯmhqx_tab_roleuser���õ�
	 * ���и�roleId������username ��userNumber
	 * @param roleId ��ɫID
	 * @return ����������ͨѶ¼��Ŀ
	 */
	public abstract List findByClass();
	
	public abstract List findByClassNumber(String classNumber);

	//ɾ��
	/** ɾ������
	 * @param contact ͨѶ¼��Ŀ
	 */
	public abstract void deleteContact(Contact contact);
	
	//����
	/** ���²���
	 * @param contact ͨѶ¼��Ŀ
	 */
	public abstract void updateContact(Contact contact);
	
	//���
	/**�������
	 * @param contact ͨѶ¼��Ŀ
	 */
	public abstract void addContact(Contact contact);
}
