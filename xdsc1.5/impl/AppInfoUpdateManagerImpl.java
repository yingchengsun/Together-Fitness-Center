package com.xdsc.service.wsbm.impl;

import com.xdsc.dao.wsbm.AppInfoUpdateDAO;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.AppInfoUpdateManager;

/**考生信息更新
 * @author 苟小龙
 * @version 1.2
 */
public class AppInfoUpdateManagerImpl implements AppInfoUpdateManager{
	/**
	 * DAO层对象属性
	 */
	private AppInfoUpdateDAO appInfoUpdateDAO;
	/**更新考生信息
	 * @param wsbmTabRegapplicant 考生对象
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
	/** 根据考生注册号查找考生
	 * @param FAppRegNum 考生id
	 * @return 考生对象
	 */
	public WsbmTabRegapplicant findAppByID(String FAppRegNum) {
		// TODO Auto-generated method stub
		return appInfoUpdateDAO.sepFindByNum(FAppRegNum);
	}

}
