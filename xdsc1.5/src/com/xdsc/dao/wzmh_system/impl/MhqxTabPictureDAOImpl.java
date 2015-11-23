package com.xdsc.dao.wzmh_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.xdsc.dao.wzmh_system.MhqxTabPictureDAO;
import com.xdsc.model.MhqxTabLink;
import com.xdsc.model.MhqxTabPicture;


/**
 * @author 高雅
 *
 */
public class MhqxTabPictureDAOImpl implements MhqxTabPictureDAO {
	private HibernateTemplate hibernateTemplate;
	/**
	 * 增加一条图片新闻
	 * @param pict
	 * @return true
	 */
	public boolean save(MhqxTabPicture pict) {
		if(pict==null)
			return false;
		hibernateTemplate.save(pict);
		return true;
	}
	/**
	 * 更新一条图片新闻
	 * @param pict
	 * @return true
	 */
	public boolean update(MhqxTabPicture pict) {
		if(pict==null)
			return false;
		hibernateTemplate.saveOrUpdate(pict);
		return true;

	}
	/**
	 * 通过id得到一条图片新闻记录
	 * @param FId
	 * @return MhqxTabPicture
	 */
	public  MhqxTabPicture getMhqxTabPictureByID(int FId){
		String hql = "from MhqxTabPicture pict where pict.FId="
			+FId;
		List<MhqxTabPicture> MhqxTabPicturelist=getHibernateTemplate().find(hql);
	     return MhqxTabPicturelist.isEmpty()?null:MhqxTabPicturelist.get(0);
	}
	
	/**
	 * 通过外键FInfoId查找出与其绑定的图片新闻纪录
	 * @param FInfoId
	 * @return List<MhqxTabPicture>
	 */
	public List<MhqxTabPicture> findByInfoId(int FInfoId) {
		String hql = "from MhqxTabPicture pict where pict.tabInformation.FInfoId="+FInfoId;
		List<MhqxTabPicture> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	

}
