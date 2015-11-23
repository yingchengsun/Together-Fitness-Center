package com.xdsc.service.wzmh_system;

import java.util.List;

import com.xdsc.model.MhqxTabLink;
/**
 * @author ����
 *
 */
public interface MhqxTabLinkManager {
	
	/**
	 * ����DAO�㷽������һ��link��¼
	 * @param l
	 */
	public abstract  boolean add(MhqxTabLink l) ;
	/**
	 * ����DAO�㷽��ɾ��һ��link��¼
	 * @param l
	 */
	public abstract  boolean delete(MhqxTabLink l) ;
   /**
    * ����DAO�㷽������һ��link��¼
    * @param l
    */
	public abstract  boolean update(MhqxTabLink l) ;
	/**
	 * ����DAO�㷽��ͨ��id�õ�һ��link��¼
	 * @param FLinkId
	 * @return MhqxTabLink
	 */
	public abstract MhqxTabLink getMhqxTabLinkByID(int FLinkId);
	/**
	 *����DAO�㷽���������ݿ������е�link��¼
	 * @return List<MhqxTabLink>
	 */
	public abstract  List<MhqxTabLink> findAllMhqxTabLink();
	/**
	 * ����DAO�㷽��ͨ��Titleֵ���ҵ�����ƥ���link��¼
	 * @param FLinkTitle
	 * @return List<MhqxTabLink>
	 */
	public abstract  List<MhqxTabLink> findMhqxTabLinkByTitle( String FLinkTitle);
}
	

