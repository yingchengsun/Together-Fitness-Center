package com.xdsc.service.wzmh_system.impl;

import java.util.List;

import com.xdsc.dao.wzmh_system.MhqxTabLinkDAO;
import com.xdsc.model.MhqxTabLink;
import com.xdsc.service.wzmh_system.MhqxTabLinkManager;
/**
 * @author ����
 *
 */
public class MhqxTabLinkManagerImpl implements MhqxTabLinkManager {
	
	private MhqxTabLinkDAO mhqxTabLinkDAO;
	
	/**
	 * ����DAO�㷽������һ��link��¼
	 * @param l
	 * @return true
	 */
	public boolean add(MhqxTabLink l) 
	{
		mhqxTabLinkDAO.save(l);
		return true;
	}
	/**
	 * ����DAO�㷽��ɾ��һ��link��¼
	 * @param l
	 * @return true
	 */
	public boolean delete(MhqxTabLink l)
	{
		mhqxTabLinkDAO.delete(l);
		return true;
	}
   /**
    * ����DAO�㷽������һ��link��¼
    * @param l
    * @return true
    */
	public boolean update(MhqxTabLink l)
	{
		mhqxTabLinkDAO.update(l);
		return true;
    }
	/**
	 * ����DAO�㷽��ͨ��id�õ�һ��link��¼
	 * @param FLinkId
	 * @return MhqxTabLink
	 */
	public  MhqxTabLink getMhqxTabLinkByID(int FLinkId) {
		return mhqxTabLinkDAO.getMhqxTabLinkByID(FLinkId);
	}

	/**
	 *����DAO�㷽���������ݿ������е�link��¼
	 * @return List<MhqxTabLink>
	 */
	public List<MhqxTabLink> findAllMhqxTabLink() {
		List<MhqxTabLink> list = mhqxTabLinkDAO.findAllMhqxTabLink();
		return list;
	}
	
	/**
	 * ����DAO�㷽��ͨ��Titleֵ���ҵ�����ƥ���link��¼
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
