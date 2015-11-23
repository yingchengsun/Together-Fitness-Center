package com.xdsc.dao.wzmh_system;

import com.xdsc.model.TabAdministrator;
/**
 * ����Ա��Ϣά��
 * @author �·�
 *
 */
public interface AdminInfoDAO {

	/**
	 * ���¹���Ա��Ϣ
	 * @param 
	 */
	public void updateAdminInfo(TabAdministrator Admin);
	
	
	/**
	 * ����һ������Ա
	 * @param Admin
	 */
	public void insertAdminInfo(TabAdministrator Admin);
	
	/**
	 * ���ݹ���Ա�ʺŲ��ҹ���Ա
	 * @param �ʺ�
	 * @return ����Աʵ��
	 */
	public TabAdministrator findAdminByNum(String num);
}
