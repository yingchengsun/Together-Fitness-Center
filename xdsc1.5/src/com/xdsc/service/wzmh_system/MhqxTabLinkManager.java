package com.xdsc.service.wzmh_system;

import java.util.List;

import com.xdsc.model.MhqxTabLink;
/**
 * @author 高雅
 *
 */
public interface MhqxTabLinkManager {
	
	/**
	 * 调用DAO层方法增加一条link记录
	 * @param l
	 */
	public abstract  boolean add(MhqxTabLink l) ;
	/**
	 * 调用DAO层方法删除一条link记录
	 * @param l
	 */
	public abstract  boolean delete(MhqxTabLink l) ;
   /**
    * 调用DAO层方法更新一条link记录
    * @param l
    */
	public abstract  boolean update(MhqxTabLink l) ;
	/**
	 * 调用DAO层方法通过id得到一条link记录
	 * @param FLinkId
	 * @return MhqxTabLink
	 */
	public abstract MhqxTabLink getMhqxTabLinkByID(int FLinkId);
	/**
	 *调用DAO层方法查找数据库中所有的link记录
	 * @return List<MhqxTabLink>
	 */
	public abstract  List<MhqxTabLink> findAllMhqxTabLink();
	/**
	 * 调用DAO层方法通过Title值查找到所有匹配的link记录
	 * @param FLinkTitle
	 * @return List<MhqxTabLink>
	 */
	public abstract  List<MhqxTabLink> findMhqxTabLinkByTitle( String FLinkTitle);
}
	

