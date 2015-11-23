package com.xdsc.service.sjjx_system.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.xdsc.dao.sjjx_system.SjjxTabInformationDAO;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.TabInformation;
import com.xdsc.model.TabInformationimage;
import com.xdsc.service.sjjx_system.SjjxTabInformationManager;


/**对通知公告信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabInformationManagerImpl implements SjjxTabInformationManager{

	
	/**
	 * SjjxTabInformationDAOImpl 的接口
	 */
	private SjjxTabInformationDAO sjjxTabInformationDAO;

	/**
	 * 数据访问方法
	 */
	public SjjxTabInformationDAO getSjjxTabInformationDAO() {
		return sjjxTabInformationDAO;
	}

	public void setSjjxTabInformationDAO(SjjxTabInformationDAO sjjxTabInformationDAO) {
		this.sjjxTabInformationDAO = sjjxTabInformationDAO;
	}
	

	/**添加一条信息记录到数据库中
	 * @param info
	 */
	public boolean saveSjjxTabInformation(TabInformation info) {
		 return sjjxTabInformationDAO.saveSjjxTabInformation(info);
	}


	/**上传附件
	 * @param file
	 * @param info
	 * @param path
	 * @param fileName
	 * @return 返回信息记录
	 * @throws Exception
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



	/**从数据库中删除一条信息记录
	 * @param info
	 */
	public boolean deleteSjjxTabInformation(TabInformation info) {
		return sjjxTabInformationDAO.deleteSjjxTabInformation(info);
		
	}
	

	/**更新一条信息记录
	 * @param info
	 */
	public void updateSjjxTabInformation(TabInformation info){
		sjjxTabInformationDAO.updateSjjxTabInformation(info);

	}


	/**从数据库中读取到所有实践教学系统发出的通知公告信息
	 * @return 返回所有信息记录
	 */
	public List<TabInformation> getSjjxTZGGTabInformations() {
		return sjjxTabInformationDAO.getSjjxTZGGTabInformations();
	}


	/**通过信息编号查找到相应信息记录
	 * @param id
	 * @return 返回相应信息记录
	 */
	public TabInformation getSjjxTabInformationByInfoId(int id) {
		
		return sjjxTabInformationDAO.getSjjxTabInformationByInfoId(id);
	}



	
}
