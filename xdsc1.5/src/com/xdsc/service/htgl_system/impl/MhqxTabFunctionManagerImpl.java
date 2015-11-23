package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabFunctionDAO;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.service.htgl_system.MhqxTabFunctionManager;
/**
 * <p>�������ܱ��Serviceʵ��<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabFunctionManagerImpl implements MhqxTabFunctionManager {
	/**����DAO*/
	private MhqxTabFunctionDAO functiondao;
	
	public MhqxTabFunctionDAO getFunctiondao() {
		return functiondao;
	}

	public void setFunctiondao(MhqxTabFunctionDAO functiondao) {
		this.functiondao = functiondao;
	}
	/**
	 * <p>ɾ������<br>
	 * @param Ҫɾ���Ĺ��ܶ���
	 */
	public void delete(MhqxTabFunction function) {
		// TODO Auto-generated method stub
		this.functiondao.removeMhqxTabfunction(function);
	}
	/**
	 * <p>�������й���<br>
	 * @return ���ع����б�
	 */
	public List<MhqxTabFunction> findAll() {
		// TODO Auto-generated method stub
		return this.functiondao.findAllMhqxTabfunction();
	}
	/**
	 * <p>����ID���ҹ���<br>
	 * @param id
	 * @return ���ز��ҽ��
	 */
	public MhqxTabFunction findById(Integer id) {
		// TODO Auto-generated method stub
		return this.functiondao.findMhqxTabfunctionById(id);
	}
	/**
	 * <p>���չ������Ʋ���<br>
	 * @param name ��������
	 * @return ���ز��ҵ��Ĺ���
	 */
	public List<MhqxTabFunction> findByName(String name) {
		// TODO Auto-generated method stub
		return this.functiondao.findMhqxTabfunctionByName(name);
	}
	/**
	 * <p>��ӹ��ܶ���<br>
	 * @param function Ҫ��ӵĹ��ܶ���
	 */
	public void save(MhqxTabFunction function) {
		// TODO Auto-generated method stub
		this.functiondao.saveMhqxTabfunction(function);
	}
	/**
	 * <p>���¹���<br>
	 * @param function
	 */
	public void update(MhqxTabFunction function) {
		// TODO Auto-generated method stub
		this.functiondao.updateMhqxTabfunction(function);
	}
	/**
	 * <p>����ģ��ͽ�ɫ���ҹ���<br>
	 * @param moduleid ģ��ID
	 * @param rolename ��ɫID
	 * @return ���ز��ҽ��
	 */
	public List<MhqxTabFunction> findByModuleidandRolename(int moduleid,
			String rolename) {
		// TODO Auto-generated method stub
		return this.functiondao.findMhqxTabfunctionByModuleidandRoleid(moduleid, rolename);
	}
	/**
	 * <p>���ո�ID���ҹ���<br>
	 * @param id
	 * @return ���ز��ҽ��
	 */
	public List<MhqxTabFunction> findBySuperId(int id) {
		// TODO Auto-generated method stub
		return this.functiondao.findMhqxTabfunctionBySuperId(id);
	}
	/**
	 * ����ɫ�����ҹ���
	 * @param rolename ��ɫ��
	 * @return ��ɫ rolename ��ӵ�еĹ���
	 */
	public List<MhqxTabFunction> findByRoleName(String rolename) {
		// TODO Auto-generated method stub
		return this.functiondao.findMhqxTabfunctionByRoleName(rolename);
	}
	
}
