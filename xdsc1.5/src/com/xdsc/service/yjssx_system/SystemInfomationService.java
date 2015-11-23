package com.xdsc.service.yjssx_system;

import java.util.List;

import com.xdsc.model.TabInformation;

/**
 * 接口功能：系统信息数据库操作
 * @author 许鑫
 * @version 1.1
 */
public interface SystemInfomationService {

	/**
	 * 查找出所有information信息
	 * @return 返回information信息
	 */
	public List<TabInformation> findAllInfo();
	
	/**
	 * 根据信息的ID查找信息详情
	 * @param id
	 * @return 返回信息的详情
	 */
	public TabInformation findInfoById(int id);
	
	/**
	 * 添加信息
	 * @param info
	 */
	public void addInfo(TabInformation info);
	
	/**
	 * 删除信息
	 * @param info
	 */
	public void deleteInfo(TabInformation info);
	
	/**
	 * 更新信息
	 * @param info
	 */
	public void updateInfo(TabInformation info);
}
