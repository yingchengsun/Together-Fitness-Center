package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabUserfunction;

/**
 * ��ɫ���ܱ����Service
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabUserfunctionManager {
	/**
	 * �������е��û�����
	 * @return �û������б�
	 */
	public List<MhqxTabUserfunction> findAll();
	/**
	 * ��ӽ�ɫ����
	 * @param userfunction �û����ܶ���
	 */
	public void save(MhqxTabUserfunction userfunction);
	/**
	 * ɾ����ɫ����
	 * @param userfunction �û����ܶ���
	 */
	public void delete(MhqxTabUserfunction userfunction);
	/**
	 * ��ID���ҽ�ɫ������Ŀ
	 * @param id ��ɫ����ID
	 * @return �û����ܶ���
	 */
	public MhqxTabUserfunction findById(Integer id);
	/**
	 * �����û�����
	 * @param userfunction �û����ܶ���
	 */
	public void update(MhqxTabUserfunction userfunction);
	/**
	 * �����û��˺Ų���
	 * @param usernumber �û��˺�
	 * @return �û��˺��б�
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionByUserNumber(String usernumber);
	/**
	 * ���ո���ID�ܲ����û�����
	 * @param id ������ID
	 * @return �û�����List
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionBySuperFunctionId(int id);
	/**
	 * ����û��Ƿ��иù���
	 * @return ���򷵻�true,���򷵻�false.
	 */
	public boolean CheckUserFunction(MhqxTabUserfunction userfunction);
}
