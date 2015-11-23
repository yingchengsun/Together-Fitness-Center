package com.xdsc.service.wzmh_system;

import java.io.File;
import java.util.Date;
import java.util.List;

import com.xdsc.model.TabInformation;
import com.xdsc.model.TabInformationimage;


public interface TabInformationManager {
	
	/**
	 * �洢һ������
	 */
	public abstract void add(TabInformation info) throws Exception;
	/**
	 * �洢��������ص�ͼƬ
	 */
	public void saveTabInformationimage(TabInformationimage infoImage) ;
	
	/** �洢�ϴ��ĸ���
	 * @return info
	 */
	public TabInformation savefile(File file,TabInformation info, String savePath,
			String fileName) throws Exception ;
	
	/**
	 * ����DAO�㷽��ɾ��һ��user��¼
	 */
	public abstract void delete(int id);
	/**
	 * ����DAO�㷽������һ��user��¼
	 */
	public abstract void update(TabInformation info) throws Exception;
	/** 
	 * ������������
	 * @return list
	 */
	public List<TabInformation> findAllTabInformations();
	/** 
	 * ����ѧԺ������Ŀ��Ϣ
	 * @return xyxwList
	 */
	public List<TabInformation> findXYXWTabInformations();
	/** 
	 * ����������ҵ��Ŀ��Ϣ
	 * @return zsjyList
	 */
	public List<TabInformation> findZSJYTabInformations();
	/** 
	 * ���Һ���������Ŀ��Ϣ
	 * @return hzjlList
	 */
	public List<TabInformation> findHZJLTabInformations();
	/** 
	 * ����֪ͨ������Ŀ��Ϣ
	 * @return tzggList
	 */
	public List<TabInformation> findTZGGTabInformations();
	/** 
	 * ����������ʿ��Ŀ��Ϣ
	 * @return zxnsList
	 */
	public List<TabInformation> findZXNSTabInformations();
	/** 
	 *  ����ͼƬ������Ŀ��Ϣ
	 * @return tpxwList
	 */
	public List<TabInformation> findTPXWTabInformations();
	/** 
	 * �������һ����Ϣ
	 * @return infos.iterator().next()
	 */
	public TabInformation findLastTabInformation() ;
	/** 
	 * ����ID������Ϣ
	 * @return list.iterator().next()
	 */
	public TabInformation findTabInformationsByID(int id) ;
	/** 
	 * ������Ϣ�������ͼƬ
	 * @return list
	 */
	public List<TabInformation> findTabInformationsByType(String FMenuName);

	/** 
	 * ���ݱ������֪ͨ������Ϣ
	 * @return list
	 */
	public List<TabInformation> findTZGGTabInformationsByTitle(String FInfoTitle);
	/** 
	 * ���ݱ����������
	 * @return list
	 */
	public List<TabInformation> findTabInformationsByTitle(String FInfoTitle);
	
	/** 
	 * �߼���������
	 * @param FInfoTitle
	 * @param FInfoContet
	 * @param FInfoStartTime
	 * @param FModuleId
	 * @param FInfoType
	 * @param FInfoZhiDing
	 * @return list
	 */
	public List<TabInformation> NewsAdvanceSearch(String FInfoTitle,String FInfoContet,Date FInfoStartTime,
												String FModuleId,String FInfoType, String FInfoZhiDing);
}
