package com.xdsc.dao.wzmh_system.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.xdsc.dao.wzmh_system.MhqxTabMenuDAO;
import com.xdsc.model.MhqxTabMenu;
import com.xdsc.model.TabInformation;

/**
 * �˵������ж����ݿ��������
 * @author ��ӱ��
 */
public class MhqxTabMenuDAOImpl implements MhqxTabMenuDAO {

	private HibernateTemplate hibernateTemplate;
	
	
	
	/**���һ���˵�
	 * 
	 * @param menu
	 */
	public void save(MhqxTabMenu menu){	
		if(menu==null)
			return;
		hibernateTemplate.save(menu);
	}
	/**ɾ��һ���˵�
	 * @param menu
	 */
	public void delete(MhqxTabMenu menu){
		if(menu==null)
			return ;
		hibernateTemplate.delete(menu);
	}
	
	/**����һ���˵�
	 * @param menu
	 */
	public void update(MhqxTabMenu menu) {
		if(menu==null)
			return;
		hibernateTemplate.update(menu);
	}
	
	/**
	 * �������в˵�
	 * @return list
	 */
	public List<MhqxTabMenu> findAllMhqxTabMenu() {
		String hql = "from MhqxTabMenu menu order by  menu.FMenuPriority ";
		List<MhqxTabMenu> list = this.getHibernateTemplate().find(hql);
		return list.isEmpty()?null:list;
	}
	/**
	 * ���Ҹ�IDΪid�����в˵�
	 * @return subList
	 */
	public List<MhqxTabMenu> findMhqxTabMenuBySuperId(int id) {
		String hql = "from MhqxTabMenu menu where menu.FSuperMenuId=? order by menu.FMenuPriority ";
		List<MhqxTabMenu> subList = getHibernateTemplate().find(hql,id);
		return subList.isEmpty()?null:subList;
	}
	/**
	 * �������ֲ��Ҳ˵�
	 * @return menu.iterator().next()
	 */
	public MhqxTabMenu findMhqxTabMenuByName(String FMenuName) {
		String hql = "from MhqxTabMenu menu where menu.FMenuName=? order by menu.FMenuPriority ";
		List<MhqxTabMenu> menu = this.getHibernateTemplate().find(hql,FMenuName);
		return menu.isEmpty()?null:menu.get(0);
	}
	/**
	 * ����ID���Ҳ˵�
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
