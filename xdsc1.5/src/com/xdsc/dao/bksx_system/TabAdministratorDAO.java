package com.xdsc.dao.bksx_system;

import com.xdsc.model.TabAdministrator;
/**
 * @author �ｨ��
 * @version 1.1
 * 
 * ��װ��TabAdministrator�Ĳ���
 */
public interface TabAdministratorDAO {

	/**
	 * ����ID���һ������Ա����
	 * 
	 * @param adminID
	 *            ����ԱID
	 * @return TabAdministrator
	 */
	public abstract TabAdministrator getAdminById(String adminID);

}