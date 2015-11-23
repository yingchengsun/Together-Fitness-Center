package com.xdsc.action.wzmh_system;

import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabMenu;
import com.xdsc.service.wzmh_system.MhqxTabMenuManager;

/**
 * @author ����
 * 
 */
public class MhqxTabMenuAction extends ActionSupport {

	private Integer FMenuId;
	private String FMenuName;
	private Integer FSuperMenuId;
	private Integer FMenuPriority;

	private List<MhqxTabMenu> menuList;// ���в˵�
	private List<MhqxTabMenu> subList[]=new List[15];// �����Ӳ˵�
	private MhqxTabMenuManager menuManager;
	private List<MhqxTabMenu> firstList;
	
	private List<MhqxTabMenu> thirdList[][] = new List[15][10];// �����˵�
	private String location;
	
	private MhqxTabMenu menu;
	private MhqxTabMenu menu_pre;

	/** ��ҳ�������ı��� */
	private int p = 1;
	private int lastPage;
	
	public MhqxTabMenuAction() {
	}


	/**�˵�����<br>
	 * ���ݸ��˵�ID�������Ӧ�Ĳ˵��б�
	 * @return findMenuBySuperIdSuccess
	 */
	@SuppressWarnings("unchecked")
	public String showMenuBySuperId() {
		firstList = menuManager.findMhqxTabMenuBySuperId(0);
		//System.out.println(firstList.size());
		int j = 0,pid;
		Iterator<MhqxTabMenu> iterator = firstList.iterator();
		while (iterator.hasNext()) {
			pid = iterator.next().getFMenuId();
			subList[j] = menuManager.findMhqxTabMenuBySuperId(pid);
			//System.out.println(subList[j].size());
			j++;
		}
		return "findMenuBySuperIdSuccess";
	}

	/**�˵�����<br>
	 * ���ݲ�ͬ���ܽ��˵���ʾ�ڲ�ͬλ�ã�����ң�
	 * @return menuListLeft,menuListRight
	 */
	public String menuManagement() {
		firstList = menuManager.findMhqxTabMenuBySuperId(0);
		int j = 0, i, pid, subpid;
		if(firstList!=null){
		Iterator<MhqxTabMenu> iterator = firstList.iterator();
		while (iterator.hasNext()) {
			pid = iterator.next().getFMenuId();
			subList[j] = menuManager.findMhqxTabMenuBySuperId(pid);
			if(subList[j]!=null){
			Iterator<MhqxTabMenu> iterator2 = subList[j].iterator();
			i = 0;
			while (iterator2.hasNext()) {
				subpid = iterator2.next().getFMenuId();
				thirdList[j][i] = menuManager.findMhqxTabMenuBySuperId(subpid);
				i++;
			}
			}
			j++;
		}
		}
		if (location.equals("left"))
			return "menuListLeft";
		else
			return "menuListRight";
	}
	
	
	/**�˵�����<br>
	 * ��Ӳ˵�ҳ��ҳ�����ݵĶ�ȡ
	 * @return menuAddRedirectSuccess
	 */
	public String menuAddRedirect(){
		firstList = menuManager.findMhqxTabMenuBySuperId(0);
		int j = 0, i, pid, subpid;
		Iterator<MhqxTabMenu> iterator = firstList.iterator();
		while (iterator.hasNext()) {
			pid = iterator.next().getFMenuId();
			subList[j] = menuManager.findMhqxTabMenuBySuperId(pid);
			Iterator<MhqxTabMenu> iterator2 = subList[j].iterator();
			i = 0;
			while (iterator2.hasNext()) {
				subpid = iterator2.next().getFMenuId();
				thirdList[j][i] = menuManager.findMhqxTabMenuBySuperId(subpid);
				i++;
			}
			j++;
		}
		return "menuAddRedirectSuccess";
	}
	
	
	
	/**�˵�����<br>
	 * ���һ���˵�
	 * @return menuAddSuccess
	 */
	public String menuAdd(){
		menuManager.add(menu,menu.getFMenuName(),"1");
		return "menuAddSuccess";
	}
	
	/**�˵�����<br> 
	 * ɾ��һ���˵�
	 * @return menuDeleteSuccess
	 */
	public String menuDelete(){
		menuManager.delete(FMenuId);
		return "menuDeleteSuccess";
	}
	
	
	/**�˵�����<br> 
	 * ���²˵�����ת
	 * @return menuUpdateRedirectSuccess
	 */
	public String menuUpdateRedirect(){
		menu_pre = menuManager.findMhqxTabMenuByID(FMenuId);
		return "menuUpdateRedirectSuccess";
	}
	
	
	/**�˵�����<br>
	 * ����һ���˵�
	 * @return menuUpdateSuccess
	 */
	public String menuUpdate(){
		MhqxTabMenu menu = menuManager.findMhqxTabMenuByID(FMenuId);
		menu.setFMenuId(FMenuId);
		menu.setFMenuName(FMenuName);;
		menu.setFMenuPriority(FMenuPriority);
		menu.setFSuperMenuId(FSuperMenuId);
		menuManager.update(menu,FMenuId);
		return "menuUpdateSuccess";
	}
	
	
	public List<MhqxTabMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<MhqxTabMenu> menuList) {
		this.menuList = menuList;
	}

	public Integer getFMenuId() {
		return FMenuId;
	}

	public void setFMenuId(Integer menuId) {
		FMenuId = menuId;
	}

	public String getFMenuName() {
		return FMenuName;
	}

	public void setFMenuName(String menuName) {
		FMenuName = menuName;
	}

	public Integer getFSuperMenuId() {
		return FSuperMenuId;
	}

	public void setFSuperMenuId(Integer superMenuId) {
		FSuperMenuId = superMenuId;
	}

	public Integer getFMenuPriority() {
		return FMenuPriority;
	}

	public void setFMenuPriority(Integer menuPriority) {
		FMenuPriority = menuPriority;
	}

	public MhqxTabMenuManager getMenuManager() {
		return menuManager;
	}

	public void setMenuManager(MhqxTabMenuManager menuManager) {
		this.menuManager = menuManager;
	}

	public List<MhqxTabMenu> getFirstList() {
		return firstList;
	}

	public void setFirstList(List<MhqxTabMenu> firstList) {
		this.firstList = firstList;
	}

	public List<MhqxTabMenu>[] getSubList() {
		return subList;
	}

	public void setSubList(List<MhqxTabMenu>[] subList) {
		this.subList = subList;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<MhqxTabMenu>[][] getThirdList() {
		return thirdList;
	}

	public void setThirdList(List<MhqxTabMenu>[][] thirdList) {
		this.thirdList = thirdList;
	}
	

	public MhqxTabMenu getMenu_pre() {
		return menu_pre;
	}


	public void setMenu_pre(MhqxTabMenu menu_pre) {
		this.menu_pre = menu_pre;
	}
	public MhqxTabMenu getMenu() {
		return menu;
	}


	public synchronized int getP() {
		return p;
	}


	public synchronized void setP(int p) {
		this.p = p;
	}


	public synchronized int getLastPage() {
		return lastPage;
	}


	public synchronized void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}


	public void setMenu(MhqxTabMenu menu) {
		this.menu = menu;
	}
}
