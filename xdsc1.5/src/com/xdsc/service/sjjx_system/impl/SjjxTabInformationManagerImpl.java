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


/**��֪ͨ������Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public class SjjxTabInformationManagerImpl implements SjjxTabInformationManager{

	
	/**
	 * SjjxTabInformationDAOImpl �Ľӿ�
	 */
	private SjjxTabInformationDAO sjjxTabInformationDAO;

	/**
	 * ���ݷ��ʷ���
	 */
	public SjjxTabInformationDAO getSjjxTabInformationDAO() {
		return sjjxTabInformationDAO;
	}

	public void setSjjxTabInformationDAO(SjjxTabInformationDAO sjjxTabInformationDAO) {
		this.sjjxTabInformationDAO = sjjxTabInformationDAO;
	}
	

	/**���һ����Ϣ��¼�����ݿ���
	 * @param info
	 */
	public boolean saveSjjxTabInformation(TabInformation info) {
		 return sjjxTabInformationDAO.saveSjjxTabInformation(info);
	}


	/**�ϴ�����
	 * @param file
	 * @param info
	 * @param path
	 * @param fileName
	 * @return ������Ϣ��¼
	 * @throws Exception
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



	/**�����ݿ���ɾ��һ����Ϣ��¼
	 * @param info
	 */
	public boolean deleteSjjxTabInformation(TabInformation info) {
		return sjjxTabInformationDAO.deleteSjjxTabInformation(info);
		
	}
	

	/**����һ����Ϣ��¼
	 * @param info
	 */
	public void updateSjjxTabInformation(TabInformation info){
		sjjxTabInformationDAO.updateSjjxTabInformation(info);

	}


	/**�����ݿ��ж�ȡ������ʵ����ѧϵͳ������֪ͨ������Ϣ
	 * @return ����������Ϣ��¼
	 */
	public List<TabInformation> getSjjxTZGGTabInformations() {
		return sjjxTabInformationDAO.getSjjxTZGGTabInformations();
	}


	/**ͨ����Ϣ��Ų��ҵ���Ӧ��Ϣ��¼
	 * @param id
	 * @return ������Ӧ��Ϣ��¼
	 */
	public TabInformation getSjjxTabInformationByInfoId(int id) {
		
		return sjjxTabInformationDAO.getSjjxTabInformationByInfoId(id);
	}



	
}
