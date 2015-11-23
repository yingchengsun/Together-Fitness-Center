package com.xdsc.dao.yjssx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.CompanyZhaoPinInfoDao;
import com.xdsc.model.TabInformation;
import com.xdsc.util.CommonConstVariable;

/**
 * 类功能：对公司招聘信息的数据库操作
 * @author 许鑫
 * @version 1.1
 */
public class CompanyZhaoPinInfoDaoImpl extends HibernateDaoSupport implements CompanyZhaoPinInfoDao {

	/**
	 * 公司添加招聘信息
	 * @param info 招聘信息详情
	 * @see com.xdsc.dao.yjssx_system.CompanyZhaoPinInfoDao#addZhaoPinInfo(com.xdsc.model.TabInformation)
	 */
	public void addZhaoPinInfo(TabInformation info) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(info);
	}

	/**
	 * 公司删除招聘信息
	 * @param info 要删除的招聘信息
	 * @see com.xdsc.dao.yjssx_system.CompanyZhaoPinInfoDao#deleteZhaoPinInfo(com.xdsc.model.TabInformation)
	 */
	public void deleteZhaoPinInfo(TabInformation info) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(info);
	}

	/**
	 * 根据公司的ID查找到公司发布的所有的招聘信息
	 * @param num 公司的ID
	 * @return 返回公司发布的所有招聘信息
	 * @see com.xdsc.dao.yjssx_system.CompanyZhaoPinInfoDao#findAllZhaoPinByComNum(java.lang.String)
	 */
	public List<TabInformation> findAllZhaoPinByComNum(String num) {
		// TODO Auto-generated method stub
		String Hql="from TabInformation info where info.mhqxTabUser.FUserNumber='"+num+"'";
		List<TabInformation> list=this.getHibernateTemplate().find(Hql);
		return list;
	}

	/**
	 * 根据招聘信息的ID查找到招聘信息的详情
	 * @param id 招聘信息的ID
	 * @return 赶回招聘信息详情
	 * @see com.xdsc.dao.yjssx_system.CompanyZhaoPinInfoDao#findZhaoPinById(int)
	 */
	public TabInformation findZhaoPinById(int id) {
		// TODO Auto-generated method stub
		TabInformation info=(TabInformation)this.getHibernateTemplate().get(TabInformation.class, id);
		return info;
	}

	/**
	 * 公司更新招聘信息
	 * @param info
	 * @see com.xdsc.dao.yjssx_system.CompanyZhaoPinInfoDao#updateZhaoPinInfo(com.xdsc.model.TabInformation)
	 */
	public void updateZhaoPinInfo(TabInformation info) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(info);

	}

	/**
	 * 查找到所有招聘信息
	 * @return 返回所有招聘信息
	 * @see com.xdsc.dao.yjssx_system.CompanyZhaoPinInfoDao#findAllZhaoPinInfo()
	 */
	public List<TabInformation> findAllZhaoPinInfo() {
		// TODO Auto-generated method stub
		String Hql="from TabInformation info where info.FInfoType='"+CommonConstVariable.FIRST_PAGE_ZHOPIN+"'";
		List<TabInformation> list=this.getHibernateTemplate().find(Hql);
		return list;
	}
	
	/**
	 * 查找到所有经过管理员同意发布的招聘信息
	 * @return 返回所有招聘信息
	 * @see com.xdsc.dao.yjssx_system.CompanyZhaoPinInfoDao#findAllZhaoPinInfo()
	 */
	public List<TabInformation> findAllReleaseZhaoPinInfoByAdmin() {
		// TODO Auto-generated method stub
		String Hql="from TabInformation info where info.FInfoType='"+CommonConstVariable.FIRST_PAGE_ZHOPIN+"'"+
		"and info.FBiaoZhi='Y'";
		List<TabInformation> list=this.getHibernateTemplate().find(Hql);
		return list;
	}

}
