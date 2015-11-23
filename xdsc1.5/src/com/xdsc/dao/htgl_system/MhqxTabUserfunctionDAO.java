package com.xdsc.dao.htgl_system;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUserfunction;
/**
 * 角色功能表操作DAO
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabUserfunctionDAO  {
	/**
	 * 添加角色功能
	 * @param userfunction 用户功能对象
	 */
	public void saveMhqxTabUserfunction(MhqxTabUserfunction userfunction);
	/**
	 * 删除角色功能
	 * @param userfunction 用户功能对象
	 */
	public void removeMhqxTabUserfunction(MhqxTabUserfunction userfunction);
	/**
	 * 按ID查找角色功能条目
	 * @param id 角色功能ID
	 * @return 用户功能对象
	 */
	public MhqxTabUserfunction findMhqxTabUserfunctionById(Integer id);
	/**
	 * 按照用户账号查找
	 * @param usernumber 用户账号
	 * @return 用户账号列表
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionByUserNumber (String usernumber);
	/**
	 * 返回所有的用户功能
	 * @return 用户功能列表
	 */
	public List<MhqxTabUserfunction> findAllMhqxTabUserfunction();
	/**
	 * 更新用户功能
	 * @param userfunction 用户功能对象
	 */
	public void updateMhqxTabUserfunction(MhqxTabUserfunction userfunction);
	/**
	 * 按照父功ID能查找用户功能
	 * @param id 父功能ID
	 * @return 用户功能List
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionBySuperFunctionId(int id);
	/**
	 * 检查用户是否有该功能
	 * @return 有则返回true,无则返回false.
	 */
	public boolean CheckUserFunction(MhqxTabUserfunction userfunction);
}
