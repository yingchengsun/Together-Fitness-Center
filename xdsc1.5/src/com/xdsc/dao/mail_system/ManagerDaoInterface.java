package com.xdsc.dao.mail_system;

import com.xdsc.model.User;

/**�ӿڣ����û���¼�йصķ���
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public interface ManagerDaoInterface {

	/**��������ͨ���û�����������֤��½
	 * @param name �û���
	 * @param pwd ����
	 * @return ͨ������true ����false
	 */
	public abstract boolean findManager(String name, String pwd);
	
	/**��������ͨ���û����ҵ�User����
	 * @param userName �û���
	 * @return �û�����
	 */
	public abstract User findUserByName(String userName);

}