package com.xdsc.service.jiaofu.impl;

import java.util.List;

import com.xdsc.dao.jiaofu.AdminResourceManageDAO;
import com.xdsc.model.JfptTabUploadfile;
import com.xdsc.service.jiaofu.AdminResourceManageManager;
/**
 * <p>���ܣ�����Ա�Խ̸�ϵͳ�е��ϴ��μ���Դ���й������а�������ѯ��Դ��ɾ����Դ��<br>
 * @author qianxun
 * @version 1.1
 */
public class AdminResourceManageManagerImpl implements AdminResourceManageManager{

	/**DAO�����*/
	private AdminResourceManageDAO adminResourceManageDAO;

	public AdminResourceManageDAO getAdminResourceManageDAO() {
		return adminResourceManageDAO;
	}

	public void setAdminResourceManageDAO(
			AdminResourceManageDAO adminResourceManageDAO) {
		this.adminResourceManageDAO = adminResourceManageDAO;
	}

	/**
	 * <p>���ܣ�������Դ��Ž�����Դɾ��<br>
	 * @param FNumber ��Դ���
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public void deleteUpfileInfoByID(int FNumber) {
		// TODO Auto-generated method stub
		adminResourceManageDAO.deleteUpfileInfoByID(FNumber);
	}

	/**
	 * <p>���ܣ�������Դ��Ž�����Դ����<br>
	 * @param FNumber ��Դ���
	 * @return JfptTabUploadfile ��Դ����
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public JfptTabUploadfile findUploadfileByID(int FNumber) {
		// TODO Auto-generated method stub
		return adminResourceManageDAO.findUploadfileByID(FNumber);
	}

	/**
	 * <p>���ܣ����ҳ��̸�ϵͳ�����еĿμ���Դ<br>
	 * @return list ���ҳ�������Ϣ�б�
	 * @see org.springframework.orm.hibernate3.support.HibernateDaoSupport
	 */
	public List<JfptTabUploadfile> findUploadfileInfo() {
		// TODO Auto-generated method stub
		return adminResourceManageDAO.findUploadfileInfo();
	}
}
