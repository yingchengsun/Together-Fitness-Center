package com.xdsc.service.wsbm.impl;

import com.xdsc.dao.wsbm.RegAppliDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.RegAppliManager;

/**����ע��
 * @author ��С��
 * @version 1.2
 */
public class RegAppliManagerImpl implements RegAppliManager {
	/**
	 * DAO���������
	 */
	RegAppliDAO regAppliDAO;
	public RegAppliDAO getRegAppliDAO() {
		return regAppliDAO;
	}
	public void setRegAppliDAO(RegAppliDAO regAppliDAO) {
		this.regAppliDAO = regAppliDAO;
	}
	/** ���뿼��
	 * @param regAppli ��������
	 */
	public void addRegAppli(WsbmTabRegapplicant regAppli) {
		regAppliDAO.addRegAppli(regAppli);
		
	}
	/**����ϵͳ�û�
	 * @param fun ϵͳ�û�����
	 */
	public void addRegAppli(MhqxTabUser fun) {
		regAppliDAO.addRegAppli(fun);
	}

}
