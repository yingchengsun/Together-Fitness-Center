package com.xdsc.service.wzmh_system;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.xdsc.model.TabInformation;
import com.xdsc.model.TabInformationimage;


public interface TabInformationManager {
	
	/**
	 * 存储一条新闻
	 */
	public abstract void add(TabInformation info) throws Exception;
	/**
	 * 存储新闻里相关的图片
	 */
	public void saveTabInformationimage(TabInformationimage infoImage) ;
	
	/** 存储上传的附件
	 * @return info
	 */
	public TabInformation savefile(File file,TabInformation info, String savePath,
			String fileName) throws Exception ;
	
	/**
	 * 调用DAO层方法删除一条user记录
	 */
	public abstract void delete(int id);
	/**
	 * 调用DAO层方法更新一条user记录
	 */
	public abstract void update(TabInformation info) throws Exception;
	/** 
	 * 查找所有新闻
	 * @return list
	 */
	public List<TabInformation> findAllTabInformations();
	/** 
	 * 查找学院新闻栏目信息
	 * @return xyxwList
	 */
	public List<TabInformation> findXYXWTabInformations();
	/** 
	 * 查找招生就业栏目信息
	 * @return zsjyList
	 */
	public List<TabInformation> findZSJYTabInformations();
	/** 
	 * 查找合作交流栏目信息
	 * @return hzjlList
	 */
	public List<TabInformation> findHZJLTabInformations();
	/** 
	 * 查找通知公告栏目信息
	 * @return tzggList
	 */
	public List<TabInformation> findTZGGTabInformations();
	/** 
	 * 查找招贤纳士栏目信息
	 * @return zxnsList
	 */
	public List<TabInformation> findZXNSTabInformations();
	/** 
	 *  查找图片新闻栏目信息
	 * @return tpxwList
	 */
	public List<TabInformation> findTPXWTabInformations();
	/** 
	 * 查找最后一条信息
	 * @return infos.iterator().next()
	 */
	public TabInformation findLastTabInformation() ;
	/** 
	 * 根据ID查找信息
	 * @return list.iterator().next()
	 */
	public TabInformation findTabInformationsByID(int id) ;
	/** 
	 * 根据信息查找相关图片
	 * @return list
	 */
	public List<TabInformation> findTabInformationsByType(String FMenuName);

	/** 
	 * 根据标题查找通知公告信息
	 * @return list
	 */
	public List<TabInformation> findTZGGTabInformationsByTitle(String FInfoTitle);
	/** 
	 * 根据标题查找新闻
	 * @return list
	 */
	public List<TabInformation> findTabInformationsByTitle(String FInfoTitle);
	
	/** 
	 * 高级查找新闻
	 * @param FInfoTitle
	 * @param FInfoContet
	 * @param FInfoStartTime
	 * @param FModuleId
	 * @param FInfoType
	 * @param FInfoZhiDing
	 * @return list
	 */
	public List<TabInformation> NewsAdvanceSearch(String FInfoTitle,String FInfoContet,Date FInfoStartTime,
												String FModuleId,String FInfoType, String FInfoZhiDing);
}
