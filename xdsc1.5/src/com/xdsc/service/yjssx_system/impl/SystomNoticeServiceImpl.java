package com.xdsc.service.yjssx_system.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.xdsc.dao.yjssx_system.SystomNoticeDao;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;
import com.xdsc.service.yjssx_system.SystomNoticeService;

public class SystomNoticeServiceImpl implements SystomNoticeService {
	
	private SystomNoticeDao systomNoticeDao;

	/**
	 * 添加通知
	 * @param notice
	 * @see com.xdsc.service.yjssx_system.SystomNoticeService#addNotice(com.xdsc.model.TabNotice)
	 */
	public void addNotice(TabNotice notice) {
		// TODO Auto-generated method stub
		systomNoticeDao.addNotice(notice);
	}

	/**
	 * 将一个通知和一个用户相关联
	 * @param noticeTo
	 * @see com.xdsc.service.yjssx_system.SystomNoticeService#addNoticeTo(com.xdsc.model.TabNoticetosb)
	 */
	public void addNoticeTo(TabNoticetosb noticeTo) {
		// TODO Auto-generated method stub
		systomNoticeDao.addNoticeTo(noticeTo);
	}

	/**
	 * 删除系统通知
	 * @param notice
	 * @see com.xdsc.service.yjssx_system.SystomNoticeService#deleteNotice(com.xdsc.model.TabNotice)
	 */
	public void deleteNotice(TabNotice notice) {
		// TODO Auto-generated method stub
		systomNoticeDao.deleteNotice(notice);
	}

	/**
	 * 用户删除给自己发的通知
	 * @param noticeTo
	 * @see com.xdsc.service.yjssx_system.SystomNoticeService#deleteNoticeTo(com.xdsc.model.TabNoticetosb)
	 */
	public void deleteNoticeTo(TabNoticetosb noticeTo) {
		// TODO Auto-generated method stub
		systomNoticeDao.deleteNoticeTo(noticeTo);
	}

	/**
	 * 根据通知的ID查找通知的详情
	 * @param id
	 * @return 返回通知的详情
	 * @see com.xdsc.service.yjssx_system.SystomNoticeService#findNoticeById(int)
	 */
	public TabNotice findNoticeById(int id) {
		// TODO Auto-generated method stub
		return systomNoticeDao.findNoticeById(id);
	}

	/**
	 * 查找给某个人发送的通知
	 * @param num
	 * @return 返回信息列表
	 * @see com.xdsc.service.yjssx_system.SystomNoticeService#findNoticeToByUserNum(java.lang.String)
	 */
	public List<TabNoticetosb> findNoticeToByUserNum(String num) {
		// TODO Auto-generated method stub
		return systomNoticeDao.findNoticeToByUserNum(num);
	}
	

	/**
	 * 根据通知查找这条通知都给谁发了
	 * @param id
	 * @return 通知信息列表
	 * @see com.xdsc.service.yjssx_system.SystomNoticeService#findNoticeToByNoticeId(java.lang.String)
	 */
	public List<TabNoticetosb> findNoticeToByNoticeId(String id) {
		// TODO Auto-generated method stub
		return systomNoticeDao.findNoticeToByNoticeId(id);
	}

	public SystomNoticeDao getSystomNoticeDao() {
		return systomNoticeDao;
	}

	public void setSystomNoticeDao(SystomNoticeDao systomNoticeDao) {
		this.systomNoticeDao = systomNoticeDao;
	}

	/**
	 * 保存通知相关文件
	 * @param file
	 * @param savePath
	 * @param fileName
	 * @see com.xdsc.service.yjssx_system.SystomNoticeService#savefile(java.io.File, java.lang.String, java.lang.String)
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

	/**
	 * 查找刚刚插入到数据库的数据
	 * @param notice
	 * @return 返回刚刚插入数据的数据
	 * @see com.xdsc.service.yjssx_system.SystomNoticeService#findLastSaveNotice(com.xdsc.model.TabNotice)
	 */
	public TabNotice findLastSaveNotice(TabNotice notice) {
		// TODO Auto-generated method stub
		return systomNoticeDao.findLastSaveNotice(notice);
	}

	/**
	 * 根据系统模块查找通知
	 * @return 返回通知列表
	 * @see com.xdsc.service.yjssx_system.SystomNoticeService#findAllNoticeByModule()
	 */
	public List<TabNotice> findAllNoticeByModule() {
		// TODO Auto-generated method stub
		return systomNoticeDao.findAllNoticeByModule();
	}

}
