package com.xdsc.service.wzmh_system.impl;

import java.util.Iterator;
import java.util.List;

import com.xdsc.dao.htgl_system.impl.MhqxTabFunctionDAOImpl;

import com.xdsc.dao.wzmh_system.MhqxTabMenuDAO;

import com.xdsc.dao.wzmh_system.impl.TabInformationDAOImpl;
import com.xdsc.model.MhqxTabFunction;
import com.xdsc.model.MhqxTabMenu;
import com.xdsc.model.MhqxTabModule;
import com.xdsc.model.TabInformation;
import com.xdsc.service.wzmh_system.MhqxTabMenuManager;

public class MhqxTabMenuManagerImpl implements MhqxTabMenuManager {

	private MhqxTabMenuDAO mhqxTabMenuDAO;
	private TabInformationDAOImpl tabInformationDAOImpl;
	private MhqxTabFunctionDAOImpl mhqxTabFunctionDAOImpl;

	
	public void delete(MhqxTabMenu menuToBeDelete) {
		// TODO Auto-generated method stub
		//删除功能
		//System.out.println("删除的功能："+menuToBeDelete.getFMenuName());
		MhqxTabFunction fun = mhqxTabFunctionDAOImpl
		.findMhqxTabfunctionByNameandRoleid(menuToBeDelete.getFMenuName(), "网站门户管理员");
		mhqxTabFunctionDAOImpl.removeMhqxTabfunction(fun);
		
		//删除信息
//		List<TabInformation> tl=tabInformationDAOImpl.findTabInformationsByType(menuToBeDelete.getFMenuName());
//		if(tl!=null&&tl.size()!=0){
//		for(TabInformation t:tl)
//			tabInformationDAOImpl.delete(t);
//		}
		
		//删除菜单
		mhqxTabMenuDAO.delete(menuToBeDelete);
	}

	public void deleteAll(List<MhqxTabMenu> ml) {
		for(MhqxTabMenu m:ml)
			delete(m);
	}

	
	
	
	public boolean findIsLeaf(MhqxTabMenu currentMenu) {
		MhqxTabFunction fun = mhqxTabFunctionDAOImpl
				.findMhqxTabfunctionByNameandRoleid(currentMenu.getFMenuName(),
						"网站门户管理员");
		if (fun.getFIsLeaf().equals("1"))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see com.xdsc.service.wzmh_system.MhqxTabMenuManager#findMhqxTabMenuByPriority(int)
	 */
	public MhqxTabMenu findMhqxTabMenuByPriority(int superid, int Priority) {
		return mhqxTabMenuDAO.findMhqxTabMenuByPriority(superid, Priority);
	}

	public void update(MhqxTabMenu menu) {
		MhqxTabFunction fun = mhqxTabFunctionDAOImpl
		.findMhqxTabfunctionByNameandRoleid(menu.getFMenuName(),
				"网站门户管理员");
		fun.setFFunctionName(menu.getFMenuName());
		fun.setFPriority(menu.getFMenuPriority());
		//fun.setFFilePath("information!showMenuToNews.action?FMenuId="+menu.getFMenuId());
		
		mhqxTabMenuDAO.update(menu);

	}

	/* (non-Javadoc)
	 * @see com.xdsc.service.wzmh_system.MhqxTabMenuManager#updateWithOldName(com.xdsc.model.MhqxTabMenu, java.lang.String)
	 */
	public void updateWithOldName(MhqxTabMenu menu, String oldname) {
		if (menu == null)
			return;
		//更新菜单对应信息表
		List<TabInformation> infolt = tabInformationDAOImpl
				.findTabInformationsByType(oldname);
	
		if (infolt != null && infolt.size() != 0) {
			for (TabInformation info : infolt) {
				info.setFInfoType(menu.getFMenuName());
			}
			for (TabInformation info : infolt) {
				tabInformationDAOImpl.update(info);
			}
		}

		//更新菜单对应功能表信息
		List<MhqxTabFunction> fl = mhqxTabFunctionDAOImpl
				.findMhqxTabfunctionByName(oldname);
		
		if (fl != null && fl.size() != 0) {
			for (MhqxTabFunction f : fl) {
				f.setFFunctionName(menu.getFMenuName());
			}
			for (MhqxTabFunction f : fl) {
				mhqxTabFunctionDAOImpl.updateMhqxTabfunction(f);
			}
		}
		System.out.println("menuid  " + menu.getFMenuId());
		mhqxTabMenuDAO.update(menu);

		//更新菜单
	}

	/**
	 * 添加一个菜单
	 * 
	 * @param menu
	 */
	public void add(MhqxTabMenu menu, String surperMenuName, String IsLeaf) {

		System.out.println(menu.getFMenuName() + " " + surperMenuName + " "
				+ IsLeaf);

		mhqxTabMenuDAO.save(menu);
		MhqxTabFunction fun = mhqxTabFunctionDAOImpl
				.findMhqxTabfunctionByNameandRoleid(surperMenuName, "网站门户管理员");

		MhqxTabFunction function = new MhqxTabFunction();

		function.setFFunctionName(menu.getFMenuName());
		function.setFFunctionMark("网站门户管理员");
		function.setFIsLeaf(IsLeaf);
		MhqxTabModule m = new MhqxTabModule();
		m.setFModuleId(1);
		function.setMhqxTabModule(m);
		function.setFPriority(menu.getFMenuPriority());
		function.setFSuperFunctionId(fun.getFFunctionId());
		function.setFFilePath("information!showMenuToNews.action?FMenuId="
				+ menu.getFMenuId());

		mhqxTabFunctionDAOImpl.saveMhqxTabfunction(function);
	}

	/**
	 * 根据FMenuId删除一个菜单,删除该菜单后遍历所有菜单，删除父ID为FMenuId的所有菜单
	 * 
	 * @param FMenuId
	 */
	public void delete(int FMenuId) {
		mhqxTabMenuDAO.delete(mhqxTabMenuDAO.findMhqxTabMenuByID(FMenuId));
		List<MhqxTabMenu> menuList = mhqxTabMenuDAO.findAllMhqxTabMenu();
		MhqxTabMenu menu;
		Iterator<MhqxTabMenu> iterator = menuList.iterator();
		while (iterator.hasNext()) {
			menu = iterator.next();
			if (menu.getFSuperMenuId() == FMenuId) {
				mhqxTabMenuDAO.delete(menu);
			}
		}
	}

	/**
	 * 更新一个菜单,如果该菜单的ID被修改，则更新该菜单后遍历所有菜单，
	 * 更新所有父ID为该菜单ID的菜单的父ID字段
	 * @param menu
	 */
	public void update(MhqxTabMenu menu, int newFMenuId) {
		mhqxTabMenuDAO.update(menu);
		if (newFMenuId != menu.getFMenuId()) {
			List<MhqxTabMenu> menuList = mhqxTabMenuDAO.findAllMhqxTabMenu();
			MhqxTabMenu submenu;
			Iterator<MhqxTabMenu> iterator = menuList.iterator();
			while (iterator.hasNext()) {
				submenu = iterator.next();
				if (submenu.getFSuperMenuId() == menu.getFMenuId()) {
					submenu.setFSuperMenuId(menu.getFMenuId());
					mhqxTabMenuDAO.save(submenu);
				}
			}
		}
	}

	/**
	 * 查找所有菜单
	 * 
	 * @return list
	 */
	public List<MhqxTabMenu> findAllMhqxTabMenus() {
		List<MhqxTabMenu> list = mhqxTabMenuDAO.findAllMhqxTabMenu();
		return list;
	}

	/**
	 * 查找父ID为id的所有菜单
	 * 
	 * @return subList
	 */
	public List<MhqxTabMenu> findMhqxTabMenuBySuperId(int id) {
		List<MhqxTabMenu> subList = mhqxTabMenuDAO.findMhqxTabMenuBySuperId(id);
		return subList;
	}

	/**
	 * 根据名字查找菜单
	 * 
	 * @return menu.iterator().next()
	 */
	public MhqxTabMenu findMhqxTabMenuByName(String FMenuName) {
		MhqxTabMenu menu = mhqxTabMenuDAO.findMhqxTabMenuByName(FMenuName);
		return menu;
	}

	/**
	 * 根据ID查找菜单
	 * 
	 * @return menu.iterator().next()
	 */
	public MhqxTabMenu findMhqxTabMenuByID(int FMenuId) {
		MhqxTabMenu menu = mhqxTabMenuDAO.findMhqxTabMenuByID(FMenuId);
		return menu;
	}

	public MhqxTabMenuDAO getMhqxTabMenuDAO() {
		return mhqxTabMenuDAO;
	}

	public void setMhqxTabMenuDAO(MhqxTabMenuDAO mhqxTabMenuDAO) {
		this.mhqxTabMenuDAO = mhqxTabMenuDAO;
	}

	public synchronized TabInformationDAOImpl getTabInformationDAOImpl() {
		return tabInformationDAOImpl;
	}

	public synchronized void setTabInformationDAOImpl(
			TabInformationDAOImpl tabInformationDAOImpl) {
		this.tabInformationDAOImpl = tabInformationDAOImpl;
	}

	public synchronized MhqxTabFunctionDAOImpl getMhqxTabFunctionDAOImpl() {
		return mhqxTabFunctionDAOImpl;
	}

	public synchronized void setMhqxTabFunctionDAOImpl(
			MhqxTabFunctionDAOImpl mhqxTabFunctionDAOImpl) {
		this.mhqxTabFunctionDAOImpl = mhqxTabFunctionDAOImpl;
	}

	

}
