package com.xdsc.service.wzmh_system.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;




import com.xdsc.dao.wzmh_system.MhqxTabNavigationDAO;
import com.xdsc.model.MhqxTabNavigation;
import com.xdsc.service.wzmh_system.MhqxTabNavigationManager;
import com.xdsc.util.HibernateUtil;
/**
 * @author 高雅
 *
 */
public class  MhqxTabNavigationManagerImpl implements MhqxTabNavigationManager{
	private MhqxTabNavigationDAO mhqxTabNavigationDAO;
	
	
	
	/**
	 * 增加一条navigation记录
	 * @param n
	 * @return true
	 */
	public  boolean add(MhqxTabNavigation n) {
		mhqxTabNavigationDAO.save(n);
		return true;
	}
	/**
	 * 删除一条navigation记录
	 * @param n
	 * @return true
	 */
	public  boolean delete(MhqxTabNavigation n) {
		mhqxTabNavigationDAO.delete(n);
		return true;
	}
   /**
    * 更新一条navigation记录
    * @param n
    * @return true
    */
	public  boolean update(MhqxTabNavigation n) {
		mhqxTabNavigationDAO.update(n);
		return true;
	}
	/**
	 * 通过id得到一条navigation记录
	 * @param FNavigationId
	 * @return MhqxTabNavigation
	 */
	public  MhqxTabNavigation  getMhqxTabNavigationByID(int FNavigationId){
		return mhqxTabNavigationDAO.getMhqxTabNavigationByID(FNavigationId);
	}
	/**
	 *查找数据库中所有的navigation记录
	 * @return List<MhqxTabNavigation>
	 */
	public  List<MhqxTabNavigation> findAllMhqxTabNavigation(){
		List<MhqxTabNavigation> navigation = mhqxTabNavigationDAO.findAllMhqxTabNavigation();
		return navigation;
	}
	/**
	 * 通过传入的name值查找到相匹配的所有navigation记录
	 * @param FNavigationName
	 * @return List<MhqxTabNavigation> 
	 */
	public   List<MhqxTabNavigation> findMhqxTabNavigationByName( String FNavigationName){
		List<MhqxTabNavigation> navigation = mhqxTabNavigationDAO.findMhqxTabNavigationByName(FNavigationName);
		return navigation;
	}
	/** 存储上传的附件
	 * @return info
	 */
	public MhqxTabNavigation savefile(File file, MhqxTabNavigation nav, String path,
			String fileName) throws Exception {
		String name = System.currentTimeMillis() + fileName;
		HttpServletRequest request = ServletActionContext.getRequest();
		String savePath = request.getRealPath(path);
		System.out.println("savapath:"+savePath+"  path:"+path+" name:"+name);

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
		nav.setFNavigationPicUrl(name);
		return nav;
	}
	
	public MhqxTabNavigationDAO getMhqxTabNavigationDAO() {
		return mhqxTabNavigationDAO;
	}
	public void setMhqxTabNavigationDAO(MhqxTabNavigationDAO mhqxTabNavigationDAO) {
		this.mhqxTabNavigationDAO = mhqxTabNavigationDAO;
	}
}


