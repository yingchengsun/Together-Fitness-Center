package com.xdsc.dao.yjssx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.SystemInfomationDao;
import com.xdsc.model.TabInformation;

/**
 * 类功能：系统信息数据库操作
 * @author 许鑫
 * @version 1.1
 */
public class SystemInfomationDaoImpl extends HibernateDaoSupport implements SystemInfomationDao {

	/**
	 * 添加信息
	 * @param info
	 * @see com.xdsc.dao.yjssx_system.SystemInfomationDao#addInfo(com.xdsc.model.TabInformation)
	 */
	public void addInfo(TabInformation info) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(info);
	}

	/**
	 * 删除信息
	 * @param info
	 * @see com.xdsc.dao.yjssx_system.SystemInfomationDao#deleteInfo(com.xdsc.model.TabInformation)
	 */
	public void deleteInfo(TabInformation info) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(info);
	}

	/**
	 * 查找出所有information信息
	 * @return 返回information信息
	 * @see com.xdsc.dao.yjssx_system.SystemInfomationDao#findAllInfo()
	 */
	public List<TabInformation> findAllInfo() {
		// TODO Auto-generated method stub
		String Hql="from TabInformation info where info.FModuleId='7' order by info.FInfoStartTime desc";
		List<TabInformation> list=this.getHibernateTemplate().find(Hql);
		System.out.println("----------------------------------"+list.size());
		return list;
	}

	/**
	 * 根据信息的ID查找信息详情
	 * @param id
	 * @return 返回信息的详情
	 * @see com.xdsc.dao.yjssx_system.SystemInfomationDao#findInfoById(int)
	 */
	public TabInformation findInfoById(int id) {
		// TODO Auto-generated method stub
		TabInformation info=(TabInformation)this.getHibernateTemplate().get(TabInformation.class, id);
		return info;
	}

	/**
	 * 更新信息
	 * @param info
	 * @see com.xdsc.dao.yjssx_system.SystemInfomationDao#updateInfo(com.xdsc.model.TabInformation)
	 */
	public void updateInfo(TabInformation info) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(info);
	}

}
