package com.xdsc.service.wsbm.impl;

import com.xdsc.dao.wsbm.RegAppliDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.RegAppliManager;

/**考生注册
 * @author 苟小龙
 * @version 1.2
 */
public class RegAppliManagerImpl implements RegAppliManager {
	/**
	 * DAO层对象属性
	 */
	RegAppliDAO regAppliDAO;
	public RegAppliDAO getRegAppliDAO() {
		return regAppliDAO;
	}
	public void setRegAppliDAO(RegAppliDAO regAppliDAO) {
		this.regAppliDAO = regAppliDAO;
	}
	/** 插入考生
	 * @param regAppli 考生对象
	 */
	public void addRegAppli(WsbmTabRegapplicant regAppli) {
		regAppliDAO.addRegAppli(regAppli);
		
	}
	/**插入系统用户
	 * @param fun 系统用户对象
	 */
	public void addRegAppli(MhqxTabUser fun) {
		regAppliDAO.addRegAppli(fun);
	}

}
