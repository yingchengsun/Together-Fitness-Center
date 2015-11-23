package com.xdsc.dao.yjssx_system;

import java.util.List;

import com.xdsc.model.TabInformation;

/**
 * 接口功能：对公司招聘信息的数据库操作
 * @author 许鑫
 * @version 1.1
 */
public interface CompanyZhaoPinInfoDao {

	/**
	 * 根据公司的ID查找到公司发布的所有的招聘信息
	 * @param num 公司的ID
	 * @return 返回公司发布的所有招聘信息
	 */
	public List<TabInformation> findAllZhaoPinByComNum(String num);
	
	/**
	 * 查找到所有招聘信息
	 * @return 返回所有招聘信息
	 */
	public List<TabInformation> findAllZhaoPinInfo();
	
	/**
	 * 根据招聘信息的ID查找到招聘信息的详情
	 * @param id 招聘信息的ID
	 * @return 赶回招聘信息详情
	 */
	public TabInformation findZhaoPinById(int id);
	
	/**
	 * 公司添加招聘信息
	 * @param info 招聘信息详情
	 */
	public void addZhaoPinInfo(TabInformation info);
	
	/**
	 * 公司删除招聘信息
	 * @param info 要删除的招聘信息
	 */
	public void deleteZhaoPinInfo(TabInformation info);
	
	/**
	 * 公司更新招聘信息
	 * @param info
	 */
	public void updateZhaoPinInfo(TabInformation info);
	
	public List<TabInformation> findAllReleaseZhaoPinInfoByAdmin();
	
	
}
