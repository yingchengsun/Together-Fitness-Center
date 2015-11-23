package com.xdsc.action.wzmh_system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.xdsc.check.AppException;
import com.xdsc.model.MhqxTabMenu;
import com.xdsc.service.wzmh_system.MhqxTabMenuManager;
import com.xdsc.service.wzmh_system.impl.MhqxTabMenuManagerImpl;

public class MenuAction extends ActionSupport {

	/** menu的属性 */
	private Integer FMenuId;
	private String FMenuName;
	private Integer FSuperMenuId;
	private Integer FMenuPriority;

	/** 页面传参数时的FMenuId */
	private Integer mid;

	/** 当前要进行操作的菜单 */
	private MhqxTabMenu CurrentMenu;

	/** 当前要进行删除的菜单 */
	private List<MhqxTabMenu> MenuToBeDeletelist;// 同一菜单目录下的菜单列表
	private MhqxTabMenu MenuToBeDelete;
	/** 删除页面传参数时的FMenuId */
	private Integer dmid;

	/** 当前要进行操作的父菜单 */
	private MhqxTabMenu CurrentfatherMenu;

	/** 查找结果个数 */
	private Integer searchCount;

	private MhqxTabMenuManager mhqxTabMenuManagerImpl;

	/** menu优先级处理 */
	private List<MhqxTabMenu> sameLevelmenulist;// 同一菜单目录下的菜单列表
	private Integer isfirst = 0;// 是否为第一个 用来识别是否需呀上移菜单
	private Integer islast = 0;// 是否为最后一个 用来识别是否需呀下移菜单
	private Integer swichtype;//

	/** menu修改名字处理 */
	private String name;

	/** menu查找处理 */
	private boolean Leaf;
	
	/** menu增加处理 */
	private String IsLeaf;

	/** 错误提示 */
	private String errmsg;

	/** 当前菜单为首页（虚拟） */
	private int IsShouYe;

	
	
	private List<MhqxTabMenu>   submenulist;
	/**
	 * 删除一个子菜单
	 * 
	 * @return
	 */
	public String deleteSubMenu() {

		MenuToBeDelete = mhqxTabMenuManagerImpl.findMhqxTabMenuByID(dmid);
		Boolean flag = mhqxTabMenuManagerImpl.findIsLeaf(MenuToBeDelete);
		int priority =MenuToBeDelete.getFMenuPriority();
		//先将菜单调到最后一个再删除
		while(priority!=mhqxTabMenuManagerImpl.findMhqxTabMenuBySuperId(MenuToBeDelete.getFSuperMenuId()).size()){
		MhqxTabMenu m = mhqxTabMenuManagerImpl.findMhqxTabMenuByPriority(
				MenuToBeDelete.getFSuperMenuId(), priority + 1);
		m.setFMenuPriority(priority);
		MenuToBeDelete.setFMenuPriority(priority + 1);
		mhqxTabMenuManagerImpl.update(MenuToBeDelete);
		mhqxTabMenuManagerImpl.update(m);
		priority++;
		}
		
		
		if (flag)// 如果是叶子就直接删除
		{
			mhqxTabMenuManagerImpl.delete(MenuToBeDelete);
		}
		if (!flag)// 如果不是叶子 则级联删除
		{
			List<MhqxTabMenu> ml = mhqxTabMenuManagerImpl
					.findMhqxTabMenuBySuperId(MenuToBeDelete.getFMenuId());
			if (ml != null) {
				ml.add(MenuToBeDelete);
			} else {
				ml = new ArrayList<MhqxTabMenu>();
				ml.add(MenuToBeDelete);
			}
			mhqxTabMenuManagerImpl.deleteAll(ml);
		}
		return "deleteSubMenu";
	}

	public String predelete() {
		if (IsShouYe != 1) {
			MenuToBeDeletelist = mhqxTabMenuManagerImpl
					.findMhqxTabMenuBySuperId(CurrentMenu.getFMenuId());
		} else {
			MenuToBeDeletelist = mhqxTabMenuManagerImpl
					.findMhqxTabMenuBySuperId(0);
		}
		return "predelete";
	}

	/**
	 * 检测菜单是否为叶子节点 是叶子节点则不能再增加子菜单
	 * 
	 * @return
	 */
	public String preaddMenu() {
		// undo 检测菜单是否为叶子节点
		if (IsShouYe != 1 && mhqxTabMenuManagerImpl.findIsLeaf(CurrentMenu)) {
			errmsg = "当前菜单是叶子菜单，不能再增加子菜单";
			new AppException(errmsg);

			return "preaddError";
		}

		return "preaddMenu";
	}

	/**
	 * 增加一个菜单 向菜单表里增加一个菜单 向功能表里增加一个菜单链接
	 * 
	 * @return
	 */
	public String addMenu() {
		MhqxTabMenu menu = new MhqxTabMenu();
		menu.setFMenuName(name);

		if (IsShouYe != 1) {
			int co = 0;
			if (mhqxTabMenuManagerImpl.findMhqxTabMenuBySuperId(CurrentMenu
					.getFMenuId()) != null)
				co = mhqxTabMenuManagerImpl.findMhqxTabMenuBySuperId(
						CurrentMenu.getFMenuId()).size();
			menu.setFMenuPriority(co + 1);
			menu.setFSuperMenuId(CurrentMenu.getFMenuId());
			mhqxTabMenuManagerImpl
					.add(menu, CurrentMenu.getFMenuName(), IsLeaf);
		} else {
			menu.setFMenuPriority(mhqxTabMenuManagerImpl
					.findMhqxTabMenuBySuperId(0).size() + 1);
			menu.setFSuperMenuId(0);
			mhqxTabMenuManagerImpl.add(menu, "新闻管理", IsLeaf);
		}

		return "addMenu";
	}

	/**
	 * 查询菜单
	 * 
	 * @return
	 */
	public String searchMenu() {
		CurrentMenu = mhqxTabMenuManagerImpl.findMhqxTabMenuByName(FMenuName);
		if (CurrentMenu == null) {
			searchCount = 0;
			return "searchMenu";
		}
		searchCount = 1;
		if (CurrentMenu.getFSuperMenuId() == 0) {
			CurrentfatherMenu = new MhqxTabMenu();
			CurrentfatherMenu.setFMenuId(0);
			CurrentfatherMenu.setFMenuName("根菜单");
			CurrentfatherMenu.setFMenuPriority(1);

		} else {
			CurrentfatherMenu = mhqxTabMenuManagerImpl
					.findMhqxTabMenuByID(CurrentMenu.getFSuperMenuId());
		}

		return "searchMenu";
	}

	/**
	 * 根据所选择的菜单进行操作 修改菜单名称 调整优先级 插入和删除子菜单
	 * 
	 * @return
	 */
	public String menuManager() {
		if (mid == 0) {
			IsShouYe = 1;
			CurrentMenu = new MhqxTabMenu();
			CurrentMenu.setFMenuId(0); 
			CurrentMenu.setFMenuName("根菜单");
			CurrentMenu.setFMenuPriority(1);
			CurrentfatherMenu = null;
			sameLevelmenulist=null;
		} 
		else {
			IsShouYe = 0;   
			CurrentMenu = mhqxTabMenuManagerImpl.findMhqxTabMenuByID(mid);
			
			Leaf= mhqxTabMenuManagerImpl.findIsLeaf(CurrentMenu);
			
			
			if (CurrentMenu.getFSuperMenuId() != 0)
				CurrentfatherMenu = mhqxTabMenuManagerImpl
						.findMhqxTabMenuByID(CurrentMenu.getFSuperMenuId());
			else
				CurrentfatherMenu = null;

			sameLevelmenulist = mhqxTabMenuManagerImpl
					.findMhqxTabMenuBySuperId(CurrentMenu.getFSuperMenuId());

		   

			if (CurrentMenu.getFMenuPriority() >= sameLevelmenulist.size()) {
				islast = 1;
			} else {
				islast = 0;
			}
			if (CurrentMenu.getFMenuPriority() == 1) {
				isfirst = 1;
			} else {
				isfirst = 0;
			}
		}
		if(IsShouYe==1)
			return "tosublist";
		return "menuManager";
	}

	public String subMenuList()
	{
		System.out.println("========="+CurrentMenu.getFMenuName());
		submenulist =mhqxTabMenuManagerImpl.findMhqxTabMenuBySuperId(CurrentMenu.getFMenuId());
		return "subMenuList";
	}
	
	
	/**
	 * 
	 * 改变优先级
	 * 
	 * @return
	 */
	public String swichMenu() {
		int priority = CurrentMenu.getFMenuPriority();

		if (swichtype == 1) // 上移
		{
			MhqxTabMenu m = mhqxTabMenuManagerImpl.findMhqxTabMenuByPriority(
					CurrentMenu.getFSuperMenuId(), priority - 1);
			System.out.println(m.getFMenuName());
			m.setFMenuPriority(priority);
			CurrentMenu.setFMenuPriority(priority - 1);
			mhqxTabMenuManagerImpl.update(CurrentMenu);
			mhqxTabMenuManagerImpl.update(m);
		} else if (swichtype == 0)// 下移
		{
			MhqxTabMenu m = mhqxTabMenuManagerImpl.findMhqxTabMenuByPriority(
					CurrentMenu.getFSuperMenuId(), priority + 1);
			m.setFMenuPriority(priority);
			CurrentMenu.setFMenuPriority(priority + 1);
			mhqxTabMenuManagerImpl.update(CurrentMenu);
			mhqxTabMenuManagerImpl.update(m);
		}

		return "swichMenu";
	}

	/**
	 * 修改菜单名称
	 * 
	 * @return
	 */
	public String changeName() {
		String oldname = CurrentMenu.getFMenuName();
		CurrentMenu.setFMenuName(name);
		mhqxTabMenuManagerImpl.updateWithOldName(CurrentMenu, oldname);
		return "changeName";
	}

	/** set get 方法 */
	public synchronized Integer getFMenuId() {
		return FMenuId;
	}

	public synchronized void setFMenuId(Integer menuId) {
		FMenuId = menuId;
	}

	public synchronized String getFMenuName() {
		return FMenuName;
	}

	public synchronized void setFMenuName(String menuName) {
		FMenuName = menuName;
	}

	public synchronized Integer getFSuperMenuId() {
		return FSuperMenuId;
	}

	public synchronized void setFSuperMenuId(Integer superMenuId) {
		FSuperMenuId = superMenuId;
	}

	public synchronized Integer getFMenuPriority() {
		return FMenuPriority;
	}

	public synchronized void setFMenuPriority(Integer menuPriority) {
		FMenuPriority = menuPriority;
	}

	public synchronized Integer getSearchCount() {
		return searchCount;
	}

	public synchronized void setSearchCount(Integer searchCount) {
		this.searchCount = searchCount;
	}

	public synchronized Integer getMid() {
		return mid;
	}

	public synchronized void setMid(Integer mid) {
		this.mid = mid;
	}

	public synchronized MhqxTabMenu getCurrentMenu() {
		return CurrentMenu;
	}

	public synchronized void setCurrentMenu(MhqxTabMenu currentMenu) {
		CurrentMenu = currentMenu;
	}

	public synchronized List<MhqxTabMenu> getSameLevelmenulist() {
		return sameLevelmenulist;
	}

	public synchronized void setSameLevelmenulist(
			List<MhqxTabMenu> sameLevelmenulist) {
		this.sameLevelmenulist = sameLevelmenulist;
	}

	public synchronized Integer getIslast() {
		return islast;
	}

	public synchronized void setIslast(Integer islast) {
		this.islast = islast;
	}

	public synchronized Integer getIsfirst() {
		return isfirst;
	}

	public synchronized void setIsfirst(Integer isfirst) {
		this.isfirst = isfirst;
	}

	public synchronized Integer getSwichtype() {
		return swichtype;
	}

	public synchronized void setSwichtype(Integer swichtype) {
		this.swichtype = swichtype;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized MhqxTabMenu getCurrentfatherMenu() {
		return CurrentfatherMenu;
	}

	public synchronized void setCurrentfatherMenu(MhqxTabMenu currentfatherMenu) {
		CurrentfatherMenu = currentfatherMenu;
	}

	public synchronized MhqxTabMenuManager getMhqxTabMenuManagerImpl() {
		return mhqxTabMenuManagerImpl;
	}

	public synchronized void setMhqxTabMenuManagerImpl(
			MhqxTabMenuManagerImpl mhqxTabMenuManagerImpl) {
		this.mhqxTabMenuManagerImpl = mhqxTabMenuManagerImpl;
	}

	public synchronized void setMhqxTabMenuManagerImpl(
			MhqxTabMenuManager mhqxTabMenuManagerImpl) {
		this.mhqxTabMenuManagerImpl = mhqxTabMenuManagerImpl;
	}

	public synchronized String getIsLeaf() {
		return IsLeaf;
	}

	public synchronized void setIsLeaf(String isLeaf) {
		IsLeaf = isLeaf;
	}

	public synchronized String getErrmsg() {
		return errmsg;
	}

	public synchronized void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public synchronized MhqxTabMenu getMenuToBeDelete() {
		return MenuToBeDelete;
	}

	public synchronized void setMenuToBeDelete(MhqxTabMenu menuToBeDelete) {
		MenuToBeDelete = menuToBeDelete;
	}

	public synchronized Integer getDmid() {
		return dmid;
	}

	public synchronized void setDmid(Integer dmid) {
		this.dmid = dmid;
	}

	public synchronized List<MhqxTabMenu> getMenuToBeDeletelist() {
		return MenuToBeDeletelist;
	}

	public synchronized void setMenuToBeDeletelist(
			List<MhqxTabMenu> menuToBeDeletelist) {
		MenuToBeDeletelist = menuToBeDeletelist;
	}

	public synchronized int getIsShouYe() {
		return IsShouYe;
	}

	public synchronized void setIsShouYe(int isShouYe) {
		IsShouYe = isShouYe;
	}

	public synchronized boolean isLeaf() {
		return Leaf;
	}

	public synchronized void setLeaf(boolean leaf) {
		Leaf = leaf;
	}

	public synchronized List<MhqxTabMenu> getSubmenulist() {
		return submenulist;
	}

	public synchronized void setSubmenulist(List<MhqxTabMenu> submenulist) {
		this.submenulist = submenulist;
	}


}
