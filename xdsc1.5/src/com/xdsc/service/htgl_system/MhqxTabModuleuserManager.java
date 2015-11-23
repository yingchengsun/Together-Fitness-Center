package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabModuleuser;
/**
 * <p>�����û�ģ����Service<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabModuleuserManager {
	/**
	 * ���������û�ģ����Ŀ
	 * @return �û�ģ����Ŀ�б�
	 */
	public List<MhqxTabModuleuser> findAll();
	/**
	 * ����û�ģ���Ӧ��ϵ
	 * @param moduleuser �û�ģ�����
	 */
	public void save(MhqxTabModuleuser moduleuser);
	/**
	 * ɾ���û�ģ���Ӧ��Ŀ
	 * @param moduleuser �û�ģ�����
	 */
	public void delete(MhqxTabModuleuser moduleuser);
	/**
	 * ��ID�����û�ģ���Ӧ��ϵ
	 * @param id Ҫ��ѯ��ID
	 * @return ���ز�ѯ����û�ģ�����
	 */
	public MhqxTabModuleuser findById(Integer id);
	/**
	 * �����û�ģ����Ŀ
	 * @param moduleuser �û�ģ�����
	 */
	public void update(MhqxTabModuleuser moduleuser);
	/**
	 * �����û��˺Ų����û�ģ����Ϣ
	 * @param usernumber �û��˺�
	 * @return �����û��˺Ų��ҵĽ��
	 */
	public List<MhqxTabModuleuser> findMhqxTabModuleuserByUserNumber(String usernumber);
	/**
	 * ����û��Ƿ���ڸ���ϵͳ
	 * @param moduleuser �û�ģ�����
	 */
	public boolean CheckModuleUser(MhqxTabModuleuser moduleuser);
}
