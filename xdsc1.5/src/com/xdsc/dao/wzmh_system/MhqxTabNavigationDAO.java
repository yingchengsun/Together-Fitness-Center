package com.xdsc.dao.wzmh_system;


import java.util.List;

import com.xdsc.model.MhqxTabNavigation;

/**
 * @author 高雅
 *
 */
public interface MhqxTabNavigationDAO {
	/**
	 * 增加一条navigation记录
	 * @param n
	 */
	public abstract boolean save(MhqxTabNavigation n) ;
	/**
	 * 删除一条navigation记录
	 * @param n
	 */
	public abstract boolean delete(MhqxTabNavigation n) ;
   /**
    * 更新一条navigation记录
    * @param n
    */
	public abstract boolean update(MhqxTabNavigation n) ;
	/**
	 * 通过id得到一条navigation记录
	 * @param FNavigationId
	 * @return MhqxTabNavigation
	 */
	public abstract MhqxTabNavigation  getMhqxTabNavigationByID(int FNavigationId);
	/**
	 *查找数据库中所有的navigation记录
	 * @return List<MhqxTabNavigation>
	 */
	public abstract List<MhqxTabNavigation > findAllMhqxTabNavigation();
	/**
	 * 通过传入的name值查找到相匹配的所有navigation记录
	 * @param FNavigationName
	 * @return List<MhqxTabNavigation> 
	 */
	public  abstract List<MhqxTabNavigation> findMhqxTabNavigationByName( String FNavigationName);
}

