package com.xdsc.service.wzmh_system;

import java.util.List;

import com.xdsc.model.MhqxTabRole;

/**
 * 角色信息展示
 * @author 陈丰
 *
 */
public interface RoleInfoManager {
	/**
	 * 角色信息展示
	 * @param 用户账号
	 * @param 角色列表
	 * @return jsp代码
	 */
	public String getRoleInfo(String id,List<MhqxTabRole> rolelist);
}
