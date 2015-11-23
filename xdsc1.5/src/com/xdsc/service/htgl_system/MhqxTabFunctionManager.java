package com.xdsc.service.htgl_system;

import java.util.List;

import com.xdsc.model.MhqxTabFunction;
/**
 * <p>�������ܱ��Service<br>
 * @author WenboTse
 * @version 1.1
 */
public interface MhqxTabFunctionManager {	
	/**
	 * <p>�������й���<br>
	 * @return ���ع����б�
	 */
	public List<MhqxTabFunction> findAll();
	/**
	 * <p>��ӹ��ܶ���<br>
	 * @param function Ҫ��ӵĹ��ܶ���
	 */
	public void save(MhqxTabFunction function);
	/**
	 * <p>ɾ������<br>
	 * @param Ҫɾ���Ĺ��ܶ���
	 */
	public void delete(MhqxTabFunction function);
	/**
	 * <p>����ID���ҹ���<br>
	 * @param id
	 * @return ���ز��ҽ��
	 */
	public MhqxTabFunction findById(Integer id);
	/**
	 * <p>���¹���<br>
	 * @param function
	 */
	public void update(MhqxTabFunction function);
	/**
	 * <p>���չ������Ʋ���<br>
	 * @param name ��������
	 * @return ���ز��ҵ��Ĺ���
	 */
	public List<MhqxTabFunction> findByName(String name);
	/**
	 * <p>����ģ��ͽ�ɫ���ҹ���<br>
	 * @param moduleid ģ��ID
	 * @param rolename ��ɫID
	 * @return ���ز��ҽ��
	 */
	public List<MhqxTabFunction> findByModuleidandRolename(int moduleid,String rolename);
	/**
	 * <p>���ո�ID���ҹ���<br>
	 * @param id
	 * @return ���ز��ҽ��
	 */
	public List<MhqxTabFunction> findBySuperId(int id);
	/**
	 * ����ɫ�����ҹ���
	 * @param rolename ��ɫ��
	 * @return ��ɫ rolename ��ӵ�еĹ���
	 */
	public List<MhqxTabFunction> findByRoleName(String rolename);
}
