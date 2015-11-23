package com.xdsc.service.yjssx_system.impl;

import java.util.List;

import com.xdsc.dao.yjssx_system.SystemInfomationDao;
import com.xdsc.model.TabInformation;
import com.xdsc.service.yjssx_system.SystemInfomationService;

/**
 * 接口功能：系统信息操作
 * @author 许鑫
 * @version 1.1
 */
public class SystemInfomationServiceImpl implements SystemInfomationService {

	private SystemInfomationDao systemInfomationDao;
	
	/**
	 * 添加信息
	 * @param info
	 * @see com.xdsc.service.yjssx_system.SystemInfomationService#addInfo(com.xdsc.model.TabInformation)
	 */
	public void addInfo(TabInformation info) {
		// TODO Auto-generated method stub
		systemInfomationDao.addInfo(info);
	}

	/**
	 * 删除信息
	 * @param info
	 * @see com.xdsc.service.yjssx_system.SystemInfomationService#deleteInfo(com.xdsc.model.TabInformation)
	 */
	public void deleteInfo(TabInformation info) {
		// TODO Auto-generated method stub
		systemInfomationDao.deleteInfo(info);
	}

	/**
	 * 查找出所有information信息
	 * @return 返回information信息
	 * @see com.xdsc.service.yjssx_system.SystemInfomationService#findAllInfo()
	 */
	public List<TabInformation> findAllInfo() {
		// TODO Auto-generated method stub
		return systemInfomationDao.findAllInfo();
	}

	/**
	 * 根据信息的ID查找信息详情
	 * @param id
	 * @return 返回信息的详情
	 * @see com.xdsc.service.yjssx_system.SystemInfomationService#findInfoById(int)
	 */
	public TabInformation findInfoById(int id) {
		// TODO Auto-generated method stub
		return systemInfomationDao.findInfoById(id);
	}

	/**
	 * 更新信息
	 * @param info
	 * @see com.xdsc.service.yjssx_system.SystemInfomationService#updateInfo(com.xdsc.model.TabInformation)
	 */
	public void updateInfo(TabInformation info) {
		// TODO Auto-generated method stub
		systemInfomationDao.updateInfo(info);
	}

	public SystemInfomationDao getSystemInfomationDao() {
		return systemInfomationDao;
	}

	public void setSystemInfomationDao(SystemInfomationDao systemInfomationDao) {
		this.systemInfomationDao = systemInfomationDao;
	}

}
