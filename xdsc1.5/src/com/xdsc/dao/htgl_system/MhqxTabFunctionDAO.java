package com.xdsc.dao.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabFunction;
/**
 * <p>�������ܱ��DAO<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabFunctionDAO {
	/**
	 * <p>��ӹ��ܶ���<br>
	 * @param function Ҫ��ӵĹ��ܶ���
	 */
	public void saveMhqxTabfunction(MhqxTabFunction function);
	/**
	 * <p>ɾ������<br>
	 * @param Ҫɾ���Ĺ��ܶ���
	 */
	public void removeMhqxTabfunction(MhqxTabFunction function);
	/**
	 * <p>����ID���ҹ���<br>
	 * @param id
	 * @return ���ز��ҽ��
	 */
	public MhqxTabFunction findMhqxTabfunctionById(Integer id);
	/**
	 * <p>���չ������Ʋ���<br>
	 * @param name ��������
	 * @return ���ز��ҵ��Ĺ���
	 */
	public List<MhqxTabFunction> findMhqxTabfunctionByName(String name);
	/**
	 * <p>�������й���<br>
	 * @return ���ع����б�
	 */
	public List<MhqxTabFunction> findAllMhqxTabfunction();
	/**
	 * <p>���¹���<br>
	 * @param function
	 */
	public void updateMhqxTabfunction(MhqxTabFunction function);
	/**
	 * <p>����ģ��ͽ�ɫ���ҹ���<br>
	 * @param moduleid ģ��ID
	 * @param rolename ��ɫID
	 * @return ���ز��ҽ��
	 */
	public List<MhqxTabFunction> findMhqxTabfunctionByModuleidandRoleid(int moduleid,String rolename);
	/**
	 * <p>���ո�ID���ҹ���<br>
	 * @param id
	 * @return ���ز��ҽ��
	 */
	public List<MhqxTabFunction> findMhqxTabfunctionBySuperId(int id);
	/**
	 * ����ɫ�����ҹ���
	 * @param rolename ��ɫ��
	 * @return ��ɫ rolename ��ӵ�еĹ���
	 */
	public List<MhqxTabFunction> findMhqxTabfunctionByRoleName(String rolename);
	/**
	 * <p>�������ƺͽ�ɫ���ҹ���<br>
	 * @param Name ��������
	 * @param rolename ��ɫID
	 * @return ���ز��ҽ��
	 */
	public MhqxTabFunction findMhqxTabfunctionByNameandRoleid(
			String name, String rolename);
}
