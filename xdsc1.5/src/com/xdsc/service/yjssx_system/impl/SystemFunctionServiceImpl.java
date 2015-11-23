package com.xdsc.service.yjssx_system.impl;

import java.util.List;

import com.xdsc.dao.yjssx_system.SystemFunctionDao;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.service.yjssx_system.SystemFunctionService;

/**
 * 接口功能：系统功能配置
 * @author 许鑫
 * @version 1.1
 */
public class SystemFunctionServiceImpl implements SystemFunctionService {

	private SystemFunctionDao systemFunctionDao;
	
	/**
	 * 给用户提交某项功能
	 * @param userFunction
	 * @see com.xdsc.service.yjssx_system.SystemFunctionService#addFunctionToUser(com.xdsc.model.MhqxTabUserfunction)
	 */
	public void addFunctionToUser(MhqxTabUserfunction userFunction) {
		// TODO Auto-generated method stub
		systemFunctionDao.addFunctionToUser(userFunction);
	}

	/**
	 * 删除用户的某个功能
	 * @param userFunction
	 * @see com.xdsc.service.yjssx_system.SystemFunctionService#deleteUserFunction(com.xdsc.model.MhqxTabUserfunction)
	 */
	public void deleteUserFunction(MhqxTabUserfunction userFunction) {
		// TODO Auto-generated method stub
		systemFunctionDao.deleteUserFunction(userFunction);
	}

	/**
	 * 根据用户Id查找用户所具有的功能
	 * @param num
	 * @return 返回该用户所具有的功能
	 * @see com.xdsc.service.yjssx_system.SystemFunctionService#findUserFunctionByUserNum(java.lang.String)
	 */
	public List<MhqxTabUserfunction> findUserFunctionByUserNum(String num) {
		// TODO Auto-generated method stub
		return systemFunctionDao.findUserFunctionByUserNum(num);
	}

	public SystemFunctionDao getSystemFunctionDao() {
		return systemFunctionDao;
	}

	public void setSystemFunctionDao(SystemFunctionDao systemFunctionDao) {
		this.systemFunctionDao = systemFunctionDao;
	}

	/**
	 * 根据功能ID查找功能信息
	 * @param id
	 * @return 功能详情
	 * @see com.xdsc.service.yjssx_system.SystemFunctionService#findFunctionById(int)
	 */
	public MhqxTabFunction findFunctionById(int id) {
		// TODO Auto-generated method stub
		return systemFunctionDao.findFunctionById(id);
	}

	/**
	 * 根据功能Id查找功能人员列表
	 * @param id
	 * @return 用户功能列表
	 * @see com.xdsc.service.yjssx_system.SystemFunctionService#findUserFunctionByFunctionId(int)
	 */
	public List<MhqxTabUserfunction> findUserFunctionByFunctionId(int id) {
		// TODO Auto-generated method stub
		return systemFunctionDao.findUserFunctionByFunctionId(id);
	}

	/**
	 * 根据用户ID和功能ID查找用户功能列表
	 * @param num
	 * @param id
	 * @return 返回用户功能列表
	 * @see com.xdsc.service.yjssx_system.SystemFunctionService#findUserFunctionByUserNumAndFunctionId(java.lang.String, int)
	 */
	public List<MhqxTabUserfunction> findUserFunctionByUserNumAndFunctionId(
			String num, int id) {
		// TODO Auto-generated method stub
		return systemFunctionDao.findUserFunctionByUserNumAndFunctionId(num, id);
	}

}
