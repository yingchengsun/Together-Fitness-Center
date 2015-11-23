package com.xdsc.dao.wzmh_system;


import java.util.List;

import com.xdsc.model.MhqxTabLink;

/**
 * @author 高雅
 *
 */
public interface MhqxTabLinkDAO {
	
	
	/**
	 * 增加一条link记录
	 * @param l
	 */
	public abstract boolean save(MhqxTabLink l) ;
	/**
	 * 删除一条link记录
	 * @param l
	 */
	public abstract boolean delete(MhqxTabLink l) ;
   /**
    * 更新一条link记录
    * @param l
    */
	public abstract boolean update(MhqxTabLink l) ;
	/**
	 * 通过id得到一条link记录
	 * @param FLinkId
	 * @return MhqxTabLink
	 */
	public abstract MhqxTabLink getMhqxTabLinkByID(int FLinkId);
	/**
	 * 查找数据库中所有的link记录
	 * @return List<MhqxTabLink>
	 */
	public abstract List<MhqxTabLink> findAllMhqxTabLink();
	/**
	 * 通过传入的Title值查找到相匹配的所有link记录
	 * @param FLinkTitle
	 * @return List<MhqxTabLink>
	 */
	public  abstract List<MhqxTabLink> findMhqxTabLinkByTitle( String FLinkTitle);
}
