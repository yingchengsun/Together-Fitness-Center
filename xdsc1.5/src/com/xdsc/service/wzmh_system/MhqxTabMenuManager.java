package com.xdsc.service.wzmh_system;

import java.util.List;

import com.xdsc.model.MhqxTabMenu;

public interface MhqxTabMenuManager {
	

	/**���һ���˵�
	 * @param menu
	 */
	public void add(MhqxTabMenu menu,String surperMenuName,String IsLeaf);
	
	/**����IDɾ��һ���˵�
	 * @param FMenuId
	 */
	public void delete(int FMenuId);
	
	/**����һ���˵�
	 * @param menu
	 */
	public void update(MhqxTabMenu menu, int newFMenuId);
	
	
	/**
	 * �������в˵�
	 * @return list
	 */
	public List<MhqxTabMenu> findAllMhqxTabMenus();
	/**
	 * ���Ҹ�IDΪid�����в˵�
	 * @return subList
	 */
	public List<MhqxTabMenu> findMhqxTabMenuBySuperId(int id);
	/**
	 * �������ֲ��Ҳ˵�
	 * @return menu.iterator().next()
	 */
	public MhqxTabMenu findMhqxTabMenuByName(String FMenuName);
	/**
	 * ����ID���Ҳ˵�
	 * @return menu.iterator().next()
	 */
	public MhqxTabMenu findMhqxTabMenuByID(int FMenuId);
	/**
	 * ����ID���Ҳ˵�
	 * @return menu.iterator().next()
	 */
	public MhqxTabMenu findMhqxTabMenuByPriority(int superid,int Priority);
	public void updateWithOldName(MhqxTabMenu currentMenu, String oldname);
	
	/**
	 * ����
	 */
	public void update(MhqxTabMenu menu);

	public boolean findIsLeaf(MhqxTabMenu currentMenu);

	public void delete(MhqxTabMenu menuToBeDelete);

	public void deleteAll(List<MhqxTabMenu> ml);

}
