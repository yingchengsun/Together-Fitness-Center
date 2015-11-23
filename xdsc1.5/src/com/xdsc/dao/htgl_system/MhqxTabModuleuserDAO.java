package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabModuleuser;
/**
 * <p>�����û�ģ����DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabModuleuserDAO {
	/**
	 * ����û�ģ���Ӧ��ϵ
	 * @param moduleuser �û�ģ�����
	 */
	public void saveMhqxTabModuleuser(MhqxTabModuleuser moduleuser);
	/**
	 * ɾ���û�ģ���Ӧ��Ŀ
	 * @param moduleuser �û�ģ�����
	 */
	public void removeMhqxTabModuleuser(MhqxTabModuleuser moduleuser);
	/**
	 * ��ID�����û�ģ���Ӧ��ϵ
	 * @param id Ҫ��ѯ��ID
	 * @return ���ز�ѯ����û�ģ�����
	 */
	public MhqxTabModuleuser findMhqxTabModuleuserById(Integer id);
	/**
	 * �����û��˺Ų����û�ģ����Ϣ
	 * @param usernumber �û��˺�
	 * @return �����û��˺Ų��ҵĽ��
	 */
	public List<MhqxTabModuleuser> findMhqxTabModuleuserByUserNumber(String usernumber);
	/**
	 * ���������û�ģ����Ŀ
	 * @return �û�ģ����Ŀ�б�
	 */
	public List<MhqxTabModuleuser> findAllMhqxTabModuleuser();
	/**
	 * �����û�ģ����Ŀ
	 * @param moduleuser �û�ģ�����
	 */
	public void updateMhqxTabModuleuser(MhqxTabModuleuser moduleuser);
	/**
	 * ����û��Ƿ���ڸ���ϵͳ
	 * @param moduleuser �û�ģ�����
	 */
	public boolean CheckModuleUser(MhqxTabModuleuser moduleuser);
}
