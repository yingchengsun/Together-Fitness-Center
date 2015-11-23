package com.xdsc.service.wzmh_system;

import java.io.File;
import java.util.List;

import com.xdsc.model.MhqxTabNavigation;
import com.xdsc.model.TabInformation;
/**
 * @author ����
 *
 */

public interface MhqxTabNavigationManager {
	
	/**
	 * ����DAO�㷽������һ��navigation��¼
	 * @param n
	 */
	public abstract  boolean add(MhqxTabNavigation n) ;
	/**
	 * ����DAO�㷽��ɾ��һ��navigation��¼
	 * @param n
	 */
	public abstract  boolean delete(MhqxTabNavigation n) ;
   /**
    * ����DAO�㷽������һ��navigation��¼
    * @param n
    */
	public abstract  boolean update(MhqxTabNavigation n) ;
	/**
	 * ����DAO�㷽��ͨ��id�õ�һ��navigation��¼
	 * @param FNavigationId
	 * @return
	 */
	public abstract MhqxTabNavigation getMhqxTabNavigationByID(int FNavigationId);
	/**
	 *����DAO�㷽���������ݿ������е�navigation��¼
	 * @return List<MhqxTabNavigation>
	 */
	public abstract  List<MhqxTabNavigation> findAllMhqxTabNavigation();
	/**
	 * ����DAO�㷽��ͨ��nameֵ���ҵ�����ƥ���link��¼
	 * @param FNavigationName
	 * @return List<MhqxTabNavigation>
	 */
	public abstract  List<MhqxTabNavigation> findMhqxTabNavigationByName( String FNavigationName);
	
	/** �洢�ϴ���ͼƬ
	 * @return nav
	 */
	public abstract MhqxTabNavigation savefile(File file,MhqxTabNavigation nav, String savePath,
			String fileName) throws Exception ;
}
