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
 * @author ����
 *
 */
public class  MhqxTabNavigationManagerImpl implements MhqxTabNavigationManager{
	private MhqxTabNavigationDAO mhqxTabNavigationDAO;
	
	
	
	/**
	 * ����һ��navigation��¼
	 * @param n
	 * @return true
	 */
	public  boolean add(MhqxTabNavigation n) {
		mhqxTabNavigationDAO.save(n);
		return true;
	}
	/**
	 * ɾ��һ��navigation��¼
	 * @param n
	 * @return true
	 */
	public  boolean delete(MhqxTabNavigation n) {
		mhqxTabNavigationDAO.delete(n);
		return true;
	}
   /**
    * ����һ��navigation��¼
    * @param n
    * @return true
    */
	public  boolean update(MhqxTabNavigation n) {
		mhqxTabNavigationDAO.update(n);
		return true;
	}
	/**
	 * ͨ��id�õ�һ��navigation��¼
	 * @param FNavigationId
	 * @return MhqxTabNavigation
	 */
	public  MhqxTabNavigation  getMhqxTabNavigationByID(int FNavigationId){
		return mhqxTabNavigationDAO.getMhqxTabNavigationByID(FNavigationId);
	}
	/**
	 *�������ݿ������е�navigation��¼
	 * @return List<MhqxTabNavigation>
	 */
	public  List<MhqxTabNavigation> findAllMhqxTabNavigation(){
		List<MhqxTabNavigation> navigation = mhqxTabNavigationDAO.findAllMhqxTabNavigation();
		return navigation;
	}
	/**
	 * ͨ�������nameֵ���ҵ���ƥ�������navigation��¼
	 * @param FNavigationName
	 * @return List<MhqxTabNavigation> 
	 */
	public   List<MhqxTabNavigation> findMhqxTabNavigationByName( String FNavigationName){
		List<MhqxTabNavigation> navigation = mhqxTabNavigationDAO.findMhqxTabNavigationByName(FNavigationName);
		return navigation;
	}
	/** �洢�ϴ��ĸ���
	 * @return info
	 */
	public MhqxTabNavigation savefile(File file, MhqxTabNavigation nav, String path,
			String fileName) throws Exception {
		String name = System.currentTimeMillis() + fileName;
		HttpServletRequest request = ServletActionContext.getRequest();
		String savePath = request.getRealPath(path);
		System.out.println("savapath:"+savePath+"  path:"+path+" name:"+name);

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


