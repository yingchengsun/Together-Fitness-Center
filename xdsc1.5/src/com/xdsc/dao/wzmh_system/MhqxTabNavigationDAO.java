package com.xdsc.dao.wzmh_system;


import java.util.List;

import com.xdsc.model.MhqxTabNavigation;

/**
 * @author ����
 *
 */
public interface MhqxTabNavigationDAO {
	/**
	 * ����һ��navigation��¼
	 * @param n
	 */
	public abstract boolean save(MhqxTabNavigation n) ;
	/**
	 * ɾ��һ��navigation��¼
	 * @param n
	 */
	public abstract boolean delete(MhqxTabNavigation n) ;
   /**
    * ����һ��navigation��¼
    * @param n
    */
	public abstract boolean update(MhqxTabNavigation n) ;
	/**
	 * ͨ��id�õ�һ��navigation��¼
	 * @param FNavigationId
	 * @return MhqxTabNavigation
	 */
	public abstract MhqxTabNavigation  getMhqxTabNavigationByID(int FNavigationId);
	/**
	 *�������ݿ������е�navigation��¼
	 * @return List<MhqxTabNavigation>
	 */
	public abstract List<MhqxTabNavigation > findAllMhqxTabNavigation();
	/**
	 * ͨ�������nameֵ���ҵ���ƥ�������navigation��¼
	 * @param FNavigationName
	 * @return List<MhqxTabNavigation> 
	 */
	public  abstract List<MhqxTabNavigation> findMhqxTabNavigationByName( String FNavigationName);
}

