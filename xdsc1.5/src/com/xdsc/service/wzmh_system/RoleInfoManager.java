package com.xdsc.service.wzmh_system;

import java.util.List;

import com.xdsc.model.MhqxTabRole;

/**
 * ��ɫ��Ϣչʾ
 * @author �·�
 *
 */
public interface RoleInfoManager {
	/**
	 * ��ɫ��Ϣչʾ
	 * @param �û��˺�
	 * @param ��ɫ�б�
	 * @return jsp����
	 */
	public String getRoleInfo(String id,List<MhqxTabRole> rolelist);
}
