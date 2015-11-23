package com.xdsc.service.yjssx_system.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.xdsc.dao.yjssx_system.CompanyZhaoPinInfoDao;
import com.xdsc.model.TabInformation;
import com.xdsc.service.yjssx_system.CompanyZhaoPinInfoService;

/**
 * 接口功能：对公司招聘信息的操作
 * @author 许鑫
 * @version 1.1
 */
public class CompanyZhaoPinInfoServiceImpl implements CompanyZhaoPinInfoService {

	private CompanyZhaoPinInfoDao companyZhaoPinInfoDao;
	
	/**
	 * 根据公司的ID查找到公司发布的所有的招聘信息
	 * @param num 公司的ID
	 * @return 返回公司发布的所有招聘信息
	 * @see com.xdsc.service.yjssx_system.CompanyZhaoPinInfoService#findAllZhaoPinInfo()
	 */
	public List<TabInformation> findAllZhaoPinInfo() {
		// TODO Auto-generated method stub
		return companyZhaoPinInfoDao.findAllZhaoPinInfo();
	}
	
	/**
	 * 公司添加招聘信息
	 * @param info 招聘信息详情
	 * @see com.xdsc.service.yjssx_system.CompanyZhaoPinInfoService#addZhaoPinInfo(com.xdsc.model.TabInformation)
	 */
	public void addZhaoPinInfo(TabInformation info) {
		// TODO Auto-generated method stub
		companyZhaoPinInfoDao.addZhaoPinInfo(info);
	}

	/**
	 * 公司删除招聘信息
	 * @param info 要删除的招聘信息
	 * @see com.xdsc.service.yjssx_system.CompanyZhaoPinInfoService#deleteZhaoPinInfo(com.xdsc.model.TabInformation)
	 */
	public void deleteZhaoPinInfo(TabInformation info) {
		// TODO Auto-generated method stub
		companyZhaoPinInfoDao.deleteZhaoPinInfo(info);
	}

	/**
	 * 根据公司的ID查找到公司发布的所有的招聘信息
	 * @param num 公司的ID
	 * @return 返回公司发布的所有招聘信息
	 * @see com.xdsc.service.yjssx_system.CompanyZhaoPinInfoService#findAllZhaoPinByComNum(java.lang.String)
	 */
	public List<TabInformation> findAllZhaoPinByComNum(String num) {
		// TODO Auto-generated method stub
		return companyZhaoPinInfoDao.findAllZhaoPinByComNum(num);
	}

	/**
	 * 根据招聘信息的ID查找到招聘信息的详情
	 * @param id 招聘信息的ID
	 * @return 赶回招聘信息详情
	 * @see com.xdsc.service.yjssx_system.CompanyZhaoPinInfoService#findZhaoPinById(int)
	 */
	public TabInformation findZhaoPinById(int id) {
		// TODO Auto-generated method stub
		return companyZhaoPinInfoDao.findZhaoPinById(id);
	}

	/**
	 * 公司更新招聘信息
	 * @param info
	 * @see com.xdsc.service.yjssx_system.CompanyZhaoPinInfoService#updateZhaoPinInfo(com.xdsc.model.TabInformation)
	 */
	public void updateZhaoPinInfo(TabInformation info) {
		// TODO Auto-generated method stub
		companyZhaoPinInfoDao.updateZhaoPinInfo(info);
	}

	public CompanyZhaoPinInfoDao getCompanyZhaoPinInfoDao() {
		return companyZhaoPinInfoDao;
	}

	public void setCompanyZhaoPinInfoDao(CompanyZhaoPinInfoDao companyZhaoPinInfoDao) {
		this.companyZhaoPinInfoDao = companyZhaoPinInfoDao;
	}

	/** 
	 * 保村文件
	 * @param file 要保存的文件
	 * @param savePath 文件的保存路径
	 * @param fileName 文件名
	 * @see com.xdsc.service.yjssx_system.CompanyZhaoPinInfoService#savefile(java.io.File, java.lang.String, java.lang.String)
	 */
	public void savefile(File file, String savePath, String fileName) {
		// TODO Auto-generated method stub
			FileOutputStream fos=null;
			String imagePath=ServletActionContext.getServletContext().getRealPath(savePath)+"\\"+fileName;
			byte[] buffer=new byte[1024];
			try {
				fos=new FileOutputStream(imagePath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			FileInputStream fis=null;
			try {
				fis=new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int len=0;
			try {
				while((len=fis.read(buffer))>0){
					fos.write(buffer, 0, len);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}

	public List<TabInformation> findAllReleaseZhaoPinInfoByAdmin() {
		// TODO Auto-generated method stub
		return companyZhaoPinInfoDao.findAllReleaseZhaoPinInfoByAdmin();
	}

}
