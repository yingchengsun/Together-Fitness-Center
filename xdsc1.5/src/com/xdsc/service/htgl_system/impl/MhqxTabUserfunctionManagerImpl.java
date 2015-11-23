package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabUserfunctionDAO;
import com.xdsc.model.MhqxTabUserfunction;
import com.xdsc.service.htgl_system.MhqxTabUserfunctionManager;
/**
 * ��ɫ���ܱ����Serviceʵ��
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabUserfunctionManagerImpl implements
		MhqxTabUserfunctionManager {
	private MhqxTabUserfunctionDAO userfunctiondao;
		
	public MhqxTabUserfunctionDAO getUserfunctiondao() {
		return userfunctiondao;
	}

	public void setUserfunctiondao(MhqxTabUserfunctionDAO userfunctiondao) {
		this.userfunctiondao = userfunctiondao;
	}
	/**
	 * ɾ����ɫ����
	 * @param userfunction �û����ܶ���
	 */
	public void delete(MhqxTabUserfunction userfunction) {
		// TODO Auto-generated method stub
		this.userfunctiondao.removeMhqxTabUserfunction(userfunction);
	}
	/**
	 * �������е��û�����
	 * @return �û������б�
	 */
	public List<MhqxTabUserfunction> findAll() {
		// TODO Auto-generated method stub
		return this.userfunctiondao.findAllMhqxTabUserfunction();
	}
	/**
	 * ��ID���ҽ�ɫ������Ŀ
	 * @param id ��ɫ����ID
	 * @return �û����ܶ���
	 */
	public MhqxTabUserfunction findById(Integer id) {
		// TODO Auto-generated method stub
		return this.userfunctiondao.findMhqxTabUserfunctionById(id);
	}
	/**
	 * �����û��˺Ų���
	 * @param usernumber �û��˺�
	 * @return �û��˺��б�
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionByUserNumber(String usernumber) {
		// TODO Auto-generated method stub
		
		return this.userfunctiondao.findMhqxTabUserfunctionByUserNumber(usernumber);
	}
	/**
	 * ��ӽ�ɫ����
	 * @param userfunction �û����ܶ���
	 */
	public void save(MhqxTabUserfunction userfunction) {
		// TODO Auto-generated method stub
		this.userfunctiondao.saveMhqxTabUserfunction(userfunction);
	}
	/**
	 * �����û�����
	 * @param userfunction �û����ܶ���
	 */
	public void update(MhqxTabUserfunction userfunction) {
		// TODO Auto-generated method stub
		this.userfunctiondao.updateMhqxTabUserfunction(userfunction);
	}
	/**
	 * ���ո���ID�ܲ����û�����
	 * @param id ������ID
	 * @return �û�����List
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionBySuperFunctionId(
			int id) {
		// TODO Auto-generated method stub
		return this.userfunctiondao.findMhqxTabUserfunctionBySuperFunctionId(id);
	}
	
	/**
	 * ����û��Ƿ��иù���
	 * @return ���򷵻�true,���򷵻�false.
	 */
	public boolean CheckUserFunction(MhqxTabUserfunction userfunction)
	{
		return this.userfunctiondao.CheckUserFunction(userfunction);
	}

}
