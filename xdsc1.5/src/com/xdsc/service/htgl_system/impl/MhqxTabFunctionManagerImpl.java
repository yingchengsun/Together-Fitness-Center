package com.xdsc.service.htgl_system.impl;

import java.util.List;

import com.xdsc.dao.htgl_system.MhqxTabFunctionDAO;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.service.htgl_system.MhqxTabFunctionManager;
/**
 * <p>操作功能表的Service实现<br>
 * @author WenboTse
 * @version 1.1
 */
public class MhqxTabFunctionManagerImpl implements MhqxTabFunctionManager {
	/**功能DAO*/
	private MhqxTabFunctionDAO functiondao;
	
	public MhqxTabFunctionDAO getFunctiondao() {
		return functiondao;
	}

	public void setFunctiondao(MhqxTabFunctionDAO functiondao) {
		this.functiondao = functiondao;
	}
	/**
	 * <p>删除功能<br>
	 * @param 要删除的功能对象
	 */
	public void delete(MhqxTabFunction function) {
		// TODO Auto-generated method stub
		this.functiondao.removeMhqxTabfunction(function);
	}
	/**
	 * <p>查找所有功能<br>
	 * @return 返回功能列表
	 */
	public List<MhqxTabFunction> findAll() {
		// TODO Auto-generated method stub
		return this.functiondao.findAllMhqxTabfunction();
	}
	/**
	 * <p>按照ID查找功能<br>
	 * @param id
	 * @return 返回查找结果
	 */
	public MhqxTabFunction findById(Integer id) {
		// TODO Auto-generated method stub
		return this.functiondao.findMhqxTabfunctionById(id);
	}
	/**
	 * <p>按照功能名称查找<br>
	 * @param name 功能名称
	 * @return 返回查找到的功能
	 */
	public List<MhqxTabFunction> findByName(String name) {
		// TODO Auto-generated method stub
		return this.functiondao.findMhqxTabfunctionByName(name);
	}
	/**
	 * <p>添加功能对象<br>
	 * @param function 要添加的功能对象
	 */
	public void save(MhqxTabFunction function) {
		// TODO Auto-generated method stub
		this.functiondao.saveMhqxTabfunction(function);
	}
	/**
	 * <p>更新功能<br>
	 * @param function
	 */
	public void update(MhqxTabFunction function) {
		// TODO Auto-generated method stub
		this.functiondao.updateMhqxTabfunction(function);
	}
	/**
	 * <p>按照模块和角色查找功能<br>
	 * @param moduleid 模块ID
	 * @param rolename 角色ID
	 * @return 返回查找结果
	 */
	public List<MhqxTabFunction> findByModuleidandRolename(int moduleid,
			String rolename) {
		// TODO Auto-generated method stub
		return this.functiondao.findMhqxTabfunctionByModuleidandRoleid(moduleid, rolename);
	}
	/**
	 * <p>按照父ID查找功能<br>
	 * @param id
	 * @return 返回查找结果
	 */
	public List<MhqxTabFunction> findBySuperId(int id) {
		// TODO Auto-generated method stub
		return this.functiondao.findMhqxTabfunctionBySuperId(id);
	}
	/**
	 * 按角色名查找功能
	 * @param rolename 角色名
	 * @return 角色 rolename 所拥有的功能
	 */
	public List<MhqxTabFunction> findByRoleName(String rolename) {
		// TODO Auto-generated method stub
		return this.functiondao.findMhqxTabfunctionByRoleName(rolename);
	}
	
}
