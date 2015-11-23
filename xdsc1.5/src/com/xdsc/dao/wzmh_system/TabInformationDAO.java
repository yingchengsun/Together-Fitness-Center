package com.xdsc.dao.wzmh_system;
import java.util.Date;
import java.util.List;

import com.xdsc.model.MhqxTabMenu;
import com.xdsc.model.TabInformation;
import com.xdsc.model.TabInformationimage;
public interface TabInformationDAO {
	/**
	 * �洢һ������
	 */
	public  void save(TabInformation info);
	/**
	 * �洢��������ص�ͼƬ
	 */
	public void saveTabInformationimage(TabInformationimage infoimage);
	/** 
	 * ɾ��һ������
	 */
	public void delete(TabInformation info);
	/** 
	 * ɾ����Ϣ���ͼƬ
	 */
	public void deleteInformationImage(TabInformationimage infoimage);
	/** 
	 * ����һ������
	 */
	public void update(TabInformation info);
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
	 *  ����ͼƬ������Ŀ��Ϣ
	 * @return tpxwList
	 */
	public List<TabInformation> findTPXWTabInformations();

	/** 
	 * ����������ʿ��Ŀ��Ϣ
	 * @return zxnsList
	 */
	public List<TabInformation> findZXNSTabInformations();
	/** 
	 * �������һ����Ϣ
	 * @return infos.iterator().next()
	 */
	public TabInformation findLastTabInformation();
	/** 
	 * ����ID������Ϣ
	 * @return list.iterator().next()
	 */
	public TabInformation findTabInformationById(int id);
	/** 
	 * ������Ϣ�������ͼƬ
	 * @return list
	 */
	public List<TabInformationimage> findImageByInformationId(int id);
	/** 
	 * �������Ͳ�����Ϣ
	 * @return list
	 */
	public List<TabInformation> findTabInformationsByType(String FMenuName) ;
	

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
	 */
	public List<TabInformation> NewsAdvanceSearch(String FInfoTitle,String FInfoContet,Date FInfoStartTime,
			String FModuleId,String FInfoType, String FInfoZhiDing);
}
