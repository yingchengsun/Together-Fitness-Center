package com.xdsc.dao.htgl_system;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUserfunction;
/**
 * ��ɫ���ܱ����DAO
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabUserfunctionDAO  {
	/**
	 * ��ӽ�ɫ����
	 * @param userfunction �û����ܶ���
	 */
	public void saveMhqxTabUserfunction(MhqxTabUserfunction userfunction);
	/**
	 * ɾ����ɫ����
	 * @param userfunction �û����ܶ���
	 */
	public void removeMhqxTabUserfunction(MhqxTabUserfunction userfunction);
	/**
	 * ��ID���ҽ�ɫ������Ŀ
	 * @param id ��ɫ����ID
	 * @return �û����ܶ���
	 */
	public MhqxTabUserfunction findMhqxTabUserfunctionById(Integer id);
	/**
	 * �����û��˺Ų���
	 * @param usernumber �û��˺�
	 * @return �û��˺��б�
	 */
	public List<MhqxTabUserfunction> findMhqxTabUserfunctionByUserNumber (String usernumber);
	/**
	 * �������е��û�����
	 * @return �û������б�
	 */
	public List<MhqxTabUserfunction> findAllMhqxTabUserfunction();
	/**
	 * �����û�����
	 * @param userfunction �û����ܶ���
	 */
	public void updateMhqxTabUserfunction(MhqxTabUserfunction userfunction);
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
