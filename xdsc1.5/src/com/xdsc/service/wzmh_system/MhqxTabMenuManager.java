package com.xdsc.service.wzmh_system;

import java.util.List;

import com.xdsc.model.MhqxTabMenu;

public interface MhqxTabMenuManager {
	

	/**添加一个菜单
	 * @param menu
	 */
	public void add(MhqxTabMenu menu,String surperMenuName,String IsLeaf);
	
	/**根据ID删除一个菜单
	 * @param FMenuId
	 */
	public void delete(int FMenuId);
	
	/**更新一个菜单
	 * @param menu
	 */
	public void update(MhqxTabMenu menu, int newFMenuId);
	
	
	/**
	 * 查找所有菜单
	 * @return list
	 */
	public List<MhqxTabMenu> findAllMhqxTabMenus();
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
	public MhqxTabMenu findMhqxTabMenuByID(int FMenuId);
	/**
	 * 根据ID查找菜单
	 * @return menu.iterator().next()
	 */
	public MhqxTabMenu findMhqxTabMenuByPriority(int superid,int Priority);
	public void updateWithOldName(MhqxTabMenu currentMenu, String oldname);
	
	/**
	 * 更新
	 */
	public void update(MhqxTabMenu menu);

	public boolean findIsLeaf(MhqxTabMenu currentMenu);

	public void delete(MhqxTabMenu menuToBeDelete);

	public void deleteAll(List<MhqxTabMenu> ml);

}
