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
	 * 调用DAO层方法增加一条图片新闻记录
	 * @param pict
	 */
	public boolean add(MhqxTabPicture  pict) {
		mhqxTabPictureDAO.save(pict);
		return true;
	}
	/**
	 * 调用DAO层方法更新一条图片新闻记录
	 * @param pict
	 */
	public boolean update(MhqxTabPicture  pict) {
		mhqxTabPictureDAO.update(pict);
		return true;
	}
	/**
	 * 调用DAO层方法通过id得到一条图片新闻记录
	 * @param FId
	 * @return MhqxTabPicture
	 */
	public MhqxTabPicture getMhqxTabPictureByID(int FId){
		return mhqxTabPictureDAO.getMhqxTabPictureByID(FId);
	}

	/**
	 * 调用DAO层方法，通过外键FInfoId查找出与其绑定的图片新闻纪录
	 * @param  FInfoId
	 */
	public List<MhqxTabPicture> findByInfoId(int FInfoId){ 
		List<MhqxTabPicture> list = mhqxTabPictureDAO.findByInfoId(FInfoId);
		return list;
	}
	/** 存储上传的附件
	 * @return MhqxTabPicture pic
	 */
	public MhqxTabPicture savefile(File file, MhqxTabPicture pic, String path,
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
