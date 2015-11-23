package com.xdsc.dao.wzmh_system.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.xdsc.dao.wzmh_system.MhqxTabMenuDAO;
import com.xdsc.model.MhqxTabMenu;
import com.xdsc.model.TabInformation;

/**
 * 菜单的所有对数据库操作方法
 * @author 孙颖成
 */
public class MhqxTabMenuDAOImpl implements MhqxTabMenuDAO {

	private HibernateTemplate hibernateTemplate;
	
	
	
	/**添加一个菜单
	 * 
	 * @param menu
	 */
	public void save(MhqxTabMenu menu){	
		if(menu==null)
			return;
		hibernateTemplate.save(menu);
	}
	/**删除一个菜单
	 * @param menu
	 */
	public void delete(MhqxTabMenu menu){
		if(menu==null)
			return ;
		hibernateTemplate.delete(menu);
	}
	
	/**更新一个菜单
	 * @param menu
	 */
	public void update(MhqxTabMenu menu) {
		if(menu==null)
			return;
		hibernateTemplate.update(menu);
	}
	
	/**
	 * 查找所有菜单
	 * @return list
	 */
	public List<MhqxTabMenu> findAllMhqxTabMenu() {
		String hql = "from MhqxTabMenu menu order by  menu.FMenuPriority ";
		List<MhqxTabMenu> list = this.getHibernateTemplate().find(hql);
		return list.isEmpty()?null:list;
	}
	/**
	 * 查找父ID为id的所有菜单
	 * @return subList
	 */
	public List<MhqxTabMenu> findMhqxTabMenuBySuperId(int id) {
		String hql = "from MhqxTabMenu menu where menu.FSuperMenuId=? order by menu.FMenuPriority ";
		List<MhqxTabMenu> subList = getHibernateTemplate().find(hql,id);
		return subList.isEmpty()?null:subList;
	}
	/**
	 * 根据名字查找菜单
	 * @return menu.iterator().next()
	 */
	public MhqxTabMenu findMhqxTabMenuByName(String FMenuName) {
		String hql = "from MhqxTabMenu menu where menu.FMenuName=? order by menu.FMenuPriority ";
		List<MhqxTabMenu> menu = this.getHibernateTemplate().find(hql,FMenuName);
		return menu.isEmpty()?null:menu.get(0);
	}
	/**
	 * 根据ID查找菜单
	 * @return menu.iterator().next()
	 */
	public MhqxTabMenu findMhqxTabMenuByID (int id) {
		String hql = "from MhqxTabMenu menu where menu.FMenuId=? order by menu.FMenuPriority ";
		List<MhqxTabMenu> menu = this.getHibernateTemplate().find(hql,id);
		return menu.isEmpty()?null:menu.get(0);
	}
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public MhqxTabMenu findMhqxTabMenuByPriority(int sid,int Priority) {
		String hql = "from MhqxTabMenu  where FMenuPriority=? and FSuperMenuId="+sid;
		return (MhqxTabMenu)hibernateTemplate.find(hql,Priority).get(0);
	}
}
