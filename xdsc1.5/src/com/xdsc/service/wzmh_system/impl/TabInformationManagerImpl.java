package com.xdsc.service.wzmh_system.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xdsc.dao.wzmh_system.TabInformationDAO;
import com.xdsc.model.TabInformation;
import com.xdsc.model.TabInformationimage;
import com.xdsc.service.wzmh_system.TabInformationManager;

public class TabInformationManagerImpl implements TabInformationManager {
	private TabInformationDAO tabInformationDAO;

	/**
	 * �洢һ������
	 */
	public void add(TabInformation info) throws Exception {
		tabInformationDAO.save(info);
	}

	/**
	 * �洢��������ص�ͼƬ
	 */
	public void saveTabInformationimage(TabInformationimage infoImage) {
		tabInformationDAO.saveTabInformationimage(infoImage);

	}

	/** �洢�ϴ��ĸ���
	 * @return info
	 */
	public TabInformation savefile(File file, TabInformation info, String path,
			String fileName) throws Exception {
		String name = System.currentTimeMillis() + fileName;
		HttpServletRequest request = ServletActionContext.getRequest();
		String savePath = request.getRealPath(path);

		// ���ϴ��ļ����·����ԭ�ļ�������һ�������
		FileOutputStream fos = new FileOutputStream(savePath + "\\" + name);
		// ���ϴ��ļ�����һ��������
		FileInputStream fis = new FileInputStream(file);
		// ���ϴ��ļ�д�뵽���������Ӧ���ļ���
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		info.setFInfoPath(name);
		return info;
	}

	/**
	 * ɾ��һ�����ż�������ص�ͼƬ
	 */
	public void delete(int id) {
		TabInformation info = tabInformationDAO.findTabInformationById(id);
		tabInformationDAO.delete(info);
		List<TabInformationimage> images = tabInformationDAO
				.findImageByInformationId(id);
		
		if(images!=null){
		for (int i = 0; i < images.size(); i++) {
			tabInformationDAO.deleteInformationImage(images.get(i));
			String Path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\houtai\\userfiles\\image\\"
					+ images.get(i).getFImgPath();
			File file = new File(Path);
			file.delete();
		}

		String Path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\houtai\\newsFile\\uploadFile\\"
				+ info.getFInfoPath();
		File file = new File(Path);
		file.delete();
		}
	}

	/**
	 * ����һ������
	 */
	public void update(TabInformation info) throws Exception {
		tabInformationDAO.update(info);

	}


	/**
	 * ������������
	 */
	public List<TabInformation> findAllTabInformations() {
		List<TabInformation> list = tabInformationDAO.findAllTabInformations();
		return list;
	}
	/** 
	 * ����ѧԺ������Ŀ��Ϣ
	 * @return xyxwList
	 */
	public List<TabInformation> findXYXWTabInformations() {
		List<TabInformation> xyxwList = tabInformationDAO
				.findXYXWTabInformations();
		return xyxwList;
	}
	/** 
	 * ����������ҵ��Ŀ��Ϣ
	 * @return zsjyList
	 */
	public List<TabInformation> findZSJYTabInformations() {
		List<TabInformation> zsjyList = tabInformationDAO
				.findZSJYTabInformations();
		return zsjyList;
	}
	/** 
	 * ���Һ���������Ŀ��Ϣ
	 * @return hzjlList
	 */
	public List<TabInformation> findHZJLTabInformations() {
		List<TabInformation> hzjlList = tabInformationDAO
				.findHZJLTabInformations();
		return hzjlList;
	}

	/** 
	 *  ����ͼƬ������Ŀ��Ϣ
	 * @return tpxwList
	 */
	public List<TabInformation> findTPXWTabInformations() {
		List<TabInformation> tpxwList = tabInformationDAO
				.findTPXWTabInformations();
		return tpxwList;
	}
	/** 
	 * ����������ʿ��Ŀ��Ϣ
	 * @return zxnsList
	 */
	public List<TabInformation> findZXNSTabInformations() {
		List<TabInformation> zxnsList = tabInformationDAO.findZXNSTabInformations();
		return zxnsList;
	}
	/** 
	 * ����֪ͨ������Ŀ��Ϣ
	 * @return tzggList
	 */
	public List<TabInformation> findTZGGTabInformations() {
		List<TabInformation> tzggList = tabInformationDAO
				.findTZGGTabInformations();
		return tzggList;
	}
	/** 
	 * ����ID������Ϣ
	 * @return list.iterator().next()
	 */
	public TabInformation findTabInformationsByID(int id) {
		TabInformation info = tabInformationDAO.findTabInformationById(id);
		return info;
	}
	/** 
	 * �������һ����Ϣ
	 * @return infos.iterator().next()
	 */
	public TabInformation findLastTabInformation() {
		TabInformation info = tabInformationDAO.findLastTabInformation();
		return info;
	}
	/** 
	 * �������Ͳ�����Ϣ
	 * @return list
	 */
	public List<TabInformation> findTabInformationsByType(String FMenuName) {
		List<TabInformation> menuNewsList = tabInformationDAO.findTabInformationsByType(FMenuName);
		return menuNewsList;
	}

	/** 
	 * ���ݱ������֪ͨ������Ϣ
	 * @return list
	 */
	public List<TabInformation> findTZGGTabInformationsByTitle(String FInfoTitle){
		List<TabInformation> list = tabInformationDAO.findTZGGTabInformationsByTitle(FInfoTitle);
		return list;
	}
	/** 
	 * ���ݱ����������
	 * @return list
	 */
	public List<TabInformation> findTabInformationsByTitle(String FInfoTitle){
		List<TabInformation> list = tabInformationDAO.findTabInformationsByTitle(FInfoTitle);
		return list;
	}
	
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
												String FModuleId,String FInfoType, String FInfoZhiDing){
		List<TabInformation> list = tabInformationDAO.NewsAdvanceSearch(FInfoTitle, FInfoContet, FInfoStartTime, FModuleId, FInfoType, FInfoZhiDing);
		return list;
	}
	
	
	public TabInformationDAO getTabInformationDAO() {
		return tabInformationDAO;
	}

	public void setTabInformationDAO(TabInformationDAO tabInformationDAO) {
		this.tabInformationDAO = tabInformationDAO;
	}
}
