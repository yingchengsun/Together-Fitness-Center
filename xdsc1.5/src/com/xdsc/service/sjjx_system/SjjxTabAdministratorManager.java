package com.xdsc.service.sjjx_system;

import com.xdsc.model.TabAdministrator;

/**���ڹ���Ա��Ϣ���в���
 * @author ��ѩ
 * @version1.1
 */
public interface SjjxTabAdministratorManager {

	/**ͨ������Ա��½Id���ҵ�����Ա��¼
	 * @param adminNumber
	 * @return ���ز��ҵ��Ĺ���Ա��¼
	 */
	public abstract TabAdministrator getAdminByFAdminNumber(String adminNumber);

}