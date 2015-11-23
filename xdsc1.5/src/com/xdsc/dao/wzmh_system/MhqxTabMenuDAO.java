package com.xdsc.dao.wzmh_system;

import java.util.List;

import com.xdsc.model.MhqxTabMenu;

public interface MhqxTabMenuDAO  {
	
	/**���һ���˵�
	 * @param menu
	 */
	public void save(MhqxTabMenu menu);
	
	/**ɾ��һ���˵�
	 * @param menu
	 */
	public void delete(MhqxTabMenu menu);
	
	/**����һ���˵�
	 * @param menu
	 */
	public void update(MhqxTabMenu menu);
	
	/**
	 * �������в˵�
	 * @return list
	 */
	public List<MhqxTabMenu> findAllMhqxTabMenu();
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
	public MhqxTabMenu findMhqxTabMenuByID (int id);
	
	
	/**
	 * �������ȼ�����
	 * @param Priority
	 * @return
	 */
	public MhqxTabMenu findMhqxTabMenuByPriority(int sid,int Priority);
	
}
