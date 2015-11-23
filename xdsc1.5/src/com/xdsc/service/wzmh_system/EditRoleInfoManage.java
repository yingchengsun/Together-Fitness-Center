package com.xdsc.service.wzmh_system;
/**
 * 编辑角色信息
 * @author 陈丰
 *
 */
public interface EditRoleInfoManage {
	/**
	 * 编辑角色信息
	 * @param 角色类型编号 管理员 0，教师、导师、辅导员 1，助教4，家长 5，企业6，本科生7，研究生8
	 * @param 用户账号
	 * @param 是否为管理员
	 * @return jsp代码
	 */
	public String editRole(int roletype,String id,boolean isAdimin); 
}
