package com.xdsc.dao.sjjx_system;

import com.xdsc.model.TabAdministrator;

/**���ڹ���Ա��Ϣ���в���
 * @author ��ѩ
 * @version1.1
 */
public interface SjjxTabAdministratorDAO {

	/**ͨ������Ա��½Id���ҵ�����Ա��¼
	 * @param adminNumber
	 * @return ���ز��ҵ��Ĺ���Ա��¼
	 */
	public abstract TabAdministrator getAdminByFAdminNumber(String adminNumber);

}