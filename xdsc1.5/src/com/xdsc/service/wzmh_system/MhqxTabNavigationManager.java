package com.xdsc.service.wzmh_system;

import java.io.File;
import java.util.List;

import com.xdsc.model.MhqxTabNavigation;
import com.xdsc.model.TabInformation;
/**
 * @author 高雅
 *
 */

public interface MhqxTabNavigationManager {
	
	/**
	 * 调用DAO层方法增加一条navigation记录
	 * @param n
	 */
	public abstract  boolean add(MhqxTabNavigation n) ;
	/**
	 * 调用DAO层方法删除一条navigation记录
	 * @param n
	 */
	public abstract  boolean delete(MhqxTabNavigation n) ;
   /**
    * 调用DAO层方法更新一条navigation记录
    * @param n
    */
	public abstract  boolean update(MhqxTabNavigation n) ;
	/**
	 * 调用DAO层方法通过id得到一条navigation记录
	 * @param FNavigationId
	 * @return
	 */
	public abstract MhqxTabNavigation getMhqxTabNavigationByID(int FNavigationId);
	/**
	 *调用DAO层方法查找数据库中所有的navigation记录
	 * @return List<MhqxTabNavigation>
	 */
	public abstract  List<MhqxTabNavigation> findAllMhqxTabNavigation();
	/**
	 * 调用DAO层方法通过name值查找到所有匹配的link记录
	 * @param FNavigationName
	 * @return List<MhqxTabNavigation>
	 */
	public abstract  List<MhqxTabNavigation> findMhqxTabNavigationByName( String FNavigationName);
	
	/** 存储上传的图片
	 * @return nav
	 */
	public abstract MhqxTabNavigation savefile(File file,MhqxTabNavigation nav, String savePath,
			String fileName) throws Exception ;
}
