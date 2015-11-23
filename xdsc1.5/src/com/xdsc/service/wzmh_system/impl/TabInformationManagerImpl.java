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
	 * 存储一条新闻
	 */
	public void add(TabInformation info) throws Exception {
		tabInformationDAO.save(info);
	}

	/**
	 * 存储新闻里相关的图片
	 */
	public void saveTabInformationimage(TabInformationimage infoImage) {
		tabInformationDAO.saveTabInformationimage(infoImage);

	}

	/** 存储上传的附件
	 * @return info
	 */
	public TabInformation savefile(File file, TabInformation info, String path,
			String fileName) throws Exception {
		String name = System.currentTimeMillis() + fileName;
		HttpServletRequest request = ServletActionContext.getRequest();
		String savePath = request.getRealPath(path);

		// 以上传文件存放路径和原文件名建立一个输出流
		FileOutputStream fos = new FileOutputStream(savePath + "\\" + name);
		// 以上传文件建立一个输入流
		FileInputStream fis = new FileInputStream(file);
		// 将上传文件写入到输出流所对应的文件中
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		info.setFInfoPath(name);
		return info;
	}

	/**
	 * 删除一条新闻及新闻相关的图片
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
	 * 更新一条新闻
	 */
	public void update(TabInformation info) throws Exception {
		tabInformationDAO.update(info);

	}


	/**
	 * 查找所有新闻
	 */
	public List<TabInformation> findAllTabInformations() {
		List<TabInformation> list = tabInformationDAO.findAllTabInformations();
		return list;
	}
	/** 
	 * 查找学院新闻栏目信息
	 * @return xyxwList
	 */
	public List<TabInformation> findXYXWTabInformations() {
		List<TabInformation> xyxwList = tabInformationDAO
				.findXYXWTabInformations();
		return xyxwList;
	}
	/** 
	 * 查找招生就业栏目信息
	 * @return zsjyList
	 */
	public List<TabInformation> findZSJYTabInformations() {
		List<TabInformation> zsjyList = tabInformationDAO
				.findZSJYTabInformations();
		return zsjyList;
	}
	/** 
	 * 查找合作交流栏目信息
	 * @return hzjlList
	 */
	public List<TabInformation> findHZJLTabInformations() {
		List<TabInformation> hzjlList = tabInformationDAO
				.findHZJLTabInformations();
		return hzjlList;
	}

	/** 
	 *  查找图片新闻栏目信息
	 * @return tpxwList
	 */
	public List<TabInformation> findTPXWTabInformations() {
		List<TabInformation> tpxwList = tabInformationDAO
				.findTPXWTabInformations();
		return tpxwList;
	}
	/** 
	 * 查找招贤纳士栏目信息
	 * @return zxnsList
	 */
	public List<TabInformation> findZXNSTabInformations() {
		List<TabInformation> zxnsList = tabInformationDAO.findZXNSTabInformations();
		return zxnsList;
	}
	/** 
	 * 查找通知公告栏目信息
	 * @return tzggList
	 */
	public List<TabInformation> findTZGGTabInformations() {
		List<TabInformation> tzggList = tabInformationDAO
				.findTZGGTabInformations();
		return tzggList;
	}
	/** 
	 * 根据ID查找信息
	 * @return list.iterator().next()
	 */
	public TabInformation findTabInformationsByID(int id) {
		TabInformation info = tabInformationDAO.findTabInformationById(id);
		return info;
	}
	/** 
	 * 查找最后一条信息
	 * @return infos.iterator().next()
	 */
	public TabInformation findLastTabInformation() {
		TabInformation info = tabInformationDAO.findLastTabInformation();
		return info;
	}
	/** 
	 * 根据类型查找信息
	 * @return list
	 */
	public List<TabInformation> findTabInformationsByType(String FMenuName) {
		List<TabInformation> menuNewsList = tabInformationDAO.findTabInformationsByType(FMenuName);
		return menuNewsList;
	}

	/** 
	 * 根据标题查找通知公告信息
	 * @return list
	 */
	public List<TabInformation> findTZGGTabInformationsByTitle(String FInfoTitle){
		List<TabInformation> list = tabInformationDAO.findTZGGTabInformationsByTitle(FInfoTitle);
		return list;
	}
	/** 
	 * 根据标题查找新闻
	 * @return list
	 */
	public List<TabInformation> findTabInformationsByTitle(String FInfoTitle){
		List<TabInformation> list = tabInformationDAO.findTabInformationsByTitle(FInfoTitle);
		return list;
	}
	
	/** 
	 * 高级查找新闻
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
