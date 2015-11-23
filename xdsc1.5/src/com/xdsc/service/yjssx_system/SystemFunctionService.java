package com.xdsc.service.yjssx_system;

import java.util.List;

import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabUserfunction;

/**
 * 接口功能：系统功能配置
 * @author 许鑫
 * @version 1.1
 */
public interface SystemFunctionService {

	/**
	 * 根据用户Id查找用户所具有的功能
	 * @param num
	 * @return 返回该用户所具有的功能
	 */
	public List<MhqxTabUserfunction> findUserFunctionByUserNum(String num);
	
	/**
	 * 根据功能Id查找功能人员列表
	 * @param id
	 * @return 用户功能列表
	 */
	public List<MhqxTabUserfunction> findUserFunctionByFunctionId(int id);
	
	/**
	 * 根据用户ID和功能ID查找用户功能列表
	 * @param num
	 * @param id
	 * @return 返回用户功能列表
	 */
	public List<MhqxTabUserfunction> findUserFunctionByUserNumAndFunctionId(String num,int id);
	
	/**
	 * 根据功能ID查找功能信息
	 * @param id
	 * @return 功能详情
	 */
	public MhqxTabFunction findFunctionById(int id);
	
	/**
	 * 给用户提交某项功能
	 * @param userFunction
	 */
	public void addFunctionToUser(MhqxTabUserfunction userFunction);
	
	/**
	 * 删除用户的某个功能
	 * @param userFunction
	 */
	public void deleteUserFunction(MhqxTabUserfunction userFunction);
	
	
}
