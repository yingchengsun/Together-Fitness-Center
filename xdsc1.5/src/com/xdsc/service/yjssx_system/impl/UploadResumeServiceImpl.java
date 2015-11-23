package com.xdsc.service.yjssx_system.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.xdsc.dao.yjssx_system.UploadResumeDao;
import com.xdsc.model.YjssxTabResume;
import com.xdsc.service.yjssx_system.UploadResumeService;

/**
 * 类功能：研究生简历的逻辑操作
 * @author 许鑫
 * @version 1.1
 */
public class UploadResumeServiceImpl implements UploadResumeService {
	
	private UploadResumeDao uploadResumeDao;

	/**
	 * 增加一个简历信息
	 * @param resume
	 * @see com.xdsc.service.yjssx_system.UploadResumeService#addResume(com.xdsc.model.YjssxTabResume)
	 */
	public void addResume(YjssxTabResume resume) {
		// TODO Auto-generated method stub
		uploadResumeDao.addResume(resume);
	}

	/**
	 * 删除一个简历信息
	 * @param resume
	 * @see com.xdsc.service.yjssx_system.UploadResumeService#deleteResume(com.xdsc.model.YjssxTabResume)
	 */
	public void deleteResume(YjssxTabResume resume) {
		// TODO Auto-generated method stub
		uploadResumeDao.deleteResume(resume);
	}

	/**
	 * 根据公司的ID查找所有提交的简历
	 * @param num
	 * @return 返回所有已经提交的简历
	 * @see com.xdsc.service.yjssx_system.UploadResumeService#findAllResumeByComNum(java.lang.String)
	 */
	public List<YjssxTabResume> findAllResumeByComNum(String num) {
		// TODO Auto-generated method stub
		return uploadResumeDao.findAllResumeByComNum(num);
	}
	
	/**
	 * 根据简历的ID查找简历的详情
	 * @param id
	 * @return 返回简历的详情
	 * @see com.xdsc.service.yjssx_system.UploadResumeService#findResumeById(int)
	 */
	public YjssxTabResume findResumeById(int id) {
		// TODO Auto-generated method stub
		return uploadResumeDao.findResumeById(id);
	}


	public UploadResumeDao getUploadResumeDao() {
		return uploadResumeDao;
	}

	public void setUploadResumeDao(UploadResumeDao uploadResumeDao) {
		this.uploadResumeDao = uploadResumeDao;
	}

	/**
	 * 保存简历信息
	 * @param file 简历的文件
	 * @param savePath 简历存储路径
	 * @param fileName 简历名称
	 * @see com.xdsc.service.yjssx_system.UploadResumeService#savefile(java.io.File, java.lang.String, java.lang.String)
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
}
