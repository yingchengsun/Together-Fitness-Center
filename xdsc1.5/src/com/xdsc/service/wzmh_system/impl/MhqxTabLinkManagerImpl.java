package com.xdsc.service.wzmh_system.impl;

import java.util.List;

import com.xdsc.dao.wzmh_system.MhqxTabLinkDAO;
import com.xdsc.model.MhqxTabLink;
import com.xdsc.service.wzmh_system.MhqxTabLinkManager;
/**
 * @author 高雅
 *
 */
public class MhqxTabLinkManagerImpl implements MhqxTabLinkManager {
	
	private MhqxTabLinkDAO mhqxTabLinkDAO;
	
	/**
	 * 调用DAO层方法增加一条link记录
	 * @param l
	 * @return true
	 */
	public boolean add(MhqxTabLink l) 
	{
		mhqxTabLinkDAO.save(l);
		return true;
	}
	/**
	 * 调用DAO层方法删除一条link记录
	 * @param l
	 * @return true
	 */
	public boolean delete(MhqxTabLink l)
	{
		mhqxTabLinkDAO.delete(l);
		return true;
	}
   /**
    * 调用DAO层方法更新一条link记录
    * @param l
    * @return true
    */
	public boolean update(MhqxTabLink l)
	{
		mhqxTabLinkDAO.update(l);
		return true;
    }
	/**
	 * 调用DAO层方法通过id得到一条link记录
	 * @param FLinkId
	 * @return MhqxTabLink
	 */
	public  MhqxTabLink getMhqxTabLinkByID(int FLinkId) {
		return mhqxTabLinkDAO.getMhqxTabLinkByID(FLinkId);
	}

	/**
	 *调用DAO层方法查找数据库中所有的link记录
	 * @return List<MhqxTabLink>
	 */
	public List<MhqxTabLink> findAllMhqxTabLink() {
		List<MhqxTabLink> list = mhqxTabLinkDAO.findAllMhqxTabLink();
		return list;
	}
	
	/**
	 * 调用DAO层方法通过Title值查找到所有匹配的link记录
	 * @param FLinkTitle
	 * @return List<MhqxTabLink>
	 */
	public List<MhqxTabLink> findMhqxTabLinkByTitle(String FLinkTitle){
		List<MhqxTabLink> link = mhqxTabLinkDAO.findMhqxTabLinkByTitle(FLinkTitle);
		return link;
	}


	public MhqxTabLinkDAO getMhqxTabLinkDAO() {
		return mhqxTabLinkDAO;
	}


	public void setMhqxTabLinkDAO(MhqxTabLinkDAO mhqxTabLinkDAO) {
		this.mhqxTabLinkDAO = mhqxTabLinkDAO;
	}
	
	
	

}
