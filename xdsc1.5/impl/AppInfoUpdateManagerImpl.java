package com.xdsc.service.wsbm.impl;

import com.xdsc.dao.wsbm.AppInfoUpdateDAO;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.AppInfoUpdateManager;

/**������Ϣ����
 * @author ��С��
 * @version 1.2
 */
public class AppInfoUpdateManagerImpl implements AppInfoUpdateManager{
	/**
	 * DAO���������
	 */
	private AppInfoUpdateDAO appInfoUpdateDAO;
	/**���¿�����Ϣ
	 * @param wsbmTabRegapplicant ��������
	 * @return
	 */
	public void updateAppInfo(WsbmTabRegapplicant wsbmTabRegapplicant) {
		// TODO Auto-generated method stub
		appInfoUpdateDAO.updateAppInfo(wsbmTabRegapplicant);
	}

	public AppInfoUpdateDAO getAppInfoUpdateDAO() {
		return appInfoUpdateDAO;
	}

	public void setAppInfoUpdateDAO(AppInfoUpdateDAO appInfoUpdateDAO) {
		this.appInfoUpdateDAO = appInfoUpdateDAO;
	}
	/** ���ݿ���ע��Ų��ҿ���
	 * @param FAppRegNum ����id
	 * @return ��������
	 */
	public WsbmTabRegapplicant findAppByID(String FAppRegNum) {
		// TODO Auto-generated method stub
		return appInfoUpdateDAO.sepFindByNum(FAppRegNum);
	}

}
