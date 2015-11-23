package com.xdsc.dao.wzmh_system;


import java.util.List;

import com.xdsc.model.MhqxTabLink;

/**
 * @author ����
 *
 */
public interface MhqxTabLinkDAO {
	
	
	/**
	 * ����һ��link��¼
	 * @param l
	 */
	public abstract boolean save(MhqxTabLink l) ;
	/**
	 * ɾ��һ��link��¼
	 * @param l
	 */
	public abstract boolean delete(MhqxTabLink l) ;
   /**
    * ����һ��link��¼
    * @param l
    */
	public abstract boolean update(MhqxTabLink l) ;
	/**
	 * ͨ��id�õ�һ��link��¼
	 * @param FLinkId
	 * @return MhqxTabLink
	 */
	public abstract MhqxTabLink getMhqxTabLinkByID(int FLinkId);
	/**
	 * �������ݿ������е�link��¼
	 * @return List<MhqxTabLink>
	 */
	public abstract List<MhqxTabLink> findAllMhqxTabLink();
	/**
	 * ͨ�������Titleֵ���ҵ���ƥ�������link��¼
	 * @param FLinkTitle
	 * @return List<MhqxTabLink>
	 */
	public  abstract List<MhqxTabLink> findMhqxTabLinkByTitle( String FLinkTitle);
}
