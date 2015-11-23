package com.xdsc.service.wzmh_system.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.xdsc.dao.wzmh_system.MhqxTabPictureDAO;
import com.xdsc.model.MhqxTabPicture;
import com.xdsc.model.TabInformation;
import com.xdsc.service.wzmh_system.MhqxTabPictureManager;

public class MhqxTabPictureManagerImpl implements MhqxTabPictureManager {
	
	private MhqxTabPictureDAO mhqxTabPictureDAO;
	/**
	 * ����DAO�㷽������һ��ͼƬ���ż�¼
	 * @param pict
	 */
	public boolean add(MhqxTabPicture  pict) {
		mhqxTabPictureDAO.save(pict);
		return true;
	}
	/**
	 * ����DAO�㷽������һ��ͼƬ���ż�¼
	 * @param pict
	 */
	public boolean update(MhqxTabPicture  pict) {
		mhqxTabPictureDAO.update(pict);
		return true;
	}
	/**
	 * ����DAO�㷽��ͨ��id�õ�һ��ͼƬ���ż�¼
	 * @param FId
	 * @return MhqxTabPicture
	 */
	public MhqxTabPicture getMhqxTabPictureByID(int FId){
		return mhqxTabPictureDAO.getMhqxTabPictureByID(FId);
	}

	/**
	 * ����DAO�㷽����ͨ�����FInfoId���ҳ�����󶨵�ͼƬ���ż�¼
	 * @param  FInfoId
	 */
	public List<MhqxTabPicture> findByInfoId(int FInfoId){ 
		List<MhqxTabPicture> list = mhqxTabPictureDAO.findByInfoId(FInfoId);
		return list;
	}
	/** �洢�ϴ��ĸ���
	 * @return MhqxTabPicture pic
	 */
	public MhqxTabPicture savefile(File file, MhqxTabPicture pic, String path,
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
		pic.setFPicContent(name);
		return pic;
	}
	public MhqxTabPictureDAO getMhqxTabPictureDAO() {
		return mhqxTabPictureDAO;
	}
	public void setMhqxTabPictureDAO(MhqxTabPictureDAO mhqxTabPictureDAO) {
		this.mhqxTabPictureDAO = mhqxTabPictureDAO;
	}

	

}
