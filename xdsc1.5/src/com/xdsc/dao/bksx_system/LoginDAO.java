package com.xdsc.dao.bksx_system;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶Ե�¼����ز���
 */
public interface LoginDAO {

	/**
	 * �ж��û��Ƿ�Ϸ�
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            �û�����
	 * @return boolean
	 */
	public abstract boolean userLogin(String username, String password);

	/**
	 * ��һ��ȷ�ϸ��û��Ƿ���ѧ��
	 * 
	 * @param userNum
	 *            �û���
	 * @return boolean
	 */
	public abstract boolean studentConfirm(String userNum);

	/**
	 * ��һ��ȷ�ϸ��û��Ƿ��ǽ�ʦ
	 * 
	 * @param userNum
	 *            �û���
	 * @return boolean
	 */
	public abstract boolean teacherConfirm(String userNum);

	/**
	 * ��һ��ȷ�ϸ��û��Ƿ��ǹ���Ա
	 * 
	 * @param userNum
	 *            �û���
	 * @return boolean
	 */
	public abstract boolean adminConfirm(String username);

}