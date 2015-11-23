package com.xdsc.dao.mail_system;

import com.xdsc.model.UserInfo;

/**�ӿڣ����û���Ϣ�йصĳ�����
 * @author ֣��˫ 2010-04-30
 * @version 1.1
 *
 */
public interface UserInfoDaoInterface {
	
	/**��������ͨ���û��������û���Ϣ��Ŀ
	 * @param username �û���
	 * @return �û���Ϣ��Ŀ
	 */
	public abstract UserInfo selectByUsername(String username);
	
	/**��������ͨ��ID�����û���Ϣ��Ŀ
	 * @param info_id ID
	 * @return �û���Ϣ��Ŀ
	 */
	public abstract UserInfo selectById(int info_id);
	
	/**���������޸��û���Ϣ
	 * @param userInfo �û���Ϣ��Ŀ
	 */
	public abstract void updateInfo(UserInfo userInfo);
}
