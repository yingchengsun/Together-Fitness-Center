package com.xdsc.dao.wzmh_system;

import java.util.List;

import com.xdsc.model.MhqxTabMenu;

public interface MhqxTabMenuDAO  {
	
	/**添加一个菜单
	 * @param menu
	 */
	public void save(MhqxTabMenu menu);
	
	/**删除一个菜单
	 * @param menu
	 */
	public void delete(MhqxTabMenu menu);
	
	/**更新一个菜单
	 * @param menu
	 */
	public void update(MhqxTabMenu menu);
	
	/**
	 * 查找所有菜单
	 * @return list
	 */
	public List<MhqxTabMenu> findAllMhqxTabMenu();
	/**
	 * 查找父ID为id的所有菜单
	 * @return subList
	 */
	public List<MhqxTabMenu> findMhqxTabMenuBySuperId(int id);
	/**
	 * 根据名字查找菜单
	 * @return menu.iterator().next()
	 */
	public MhqxTabMenu findMhqxTabMenuByName(String FMenuName);
	/**
	 * 根据ID查找菜单
	 * @return menu.iterator().next()
	 */
	public MhqxTabMenu findMhqxTabMenuByID (int id);
	
	
	/**
	 * 根据优先级查找
	 * @param Priority
	 * @return
	 */
	public MhqxTabMenu findMhqxTabMenuByPriority(int sid,int Priority);
	
}
