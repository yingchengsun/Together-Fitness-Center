package com.xdsc.dao.gzfk_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.gzfk_system.UniInfoDAO;
import com.xdsc.model.GzfkTabStudyuniversity;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabCompany;

public class UniInfoDAOImpl extends HibernateDaoSupport implements UniInfoDAO{

	public void addUniInfo(GzfkTabStudyuniversity uni) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(uni);
	}

	public void delUniInfo(GzfkTabStudyuniversity uni) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(uni);
	}

	public List<GzfkTabStudyuniversity> findAllUniInfo() {
		// TODO Auto-generated method stub
		List<GzfkTabStudyuniversity> list=this.getHibernateTemplate().loadAll(GzfkTabStudyuniversity.class);
		return list;
	}

	public List<GzfkTabStudyuniversity> findUniByName(String name) {
		// TODO Auto-generated method stub
		String LikeName="%"+name+"%";
		String hql="from GzfkTabStudyuniversity c where c.FUniName like'"+LikeName+"'";
		List<GzfkTabStudyuniversity> list=this.getHibernateTemplate().find(hql);
		
		return list;
	}

	public GzfkTabStudyuniversity findUniByNum(int num) {
		// TODO Auto-generated method stub
		GzfkTabStudyuniversity info=(GzfkTabStudyuniversity)this.getHibernateTemplate().get(GzfkTabStudyuniversity.class, num);
		return info;
	}

	public void updateUniInfo(GzfkTabStudyuniversity uni) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(uni);
	}

	public List<GzfkTabStudyuniversity> findUniByExample(GzfkTabStudyuniversity uni) {
		// TODO Auto-generated method stub
		System.out.println("uni exist daoimpl*******************************");
		List<GzfkTabStudyuniversity> list = this.getHibernateTemplate().findByExample(uni);
		System.out.println(" finish uni exist daoimpl*******************************");
		
		return list;
	}

	public List<GzfkTabStudyuniversity> searchUniByName(String name) {
		// TODO Auto-generated method stub
		String LikeName="%"+name+"%";
		String hql="from GzfkTabStudyuniversity c where c.FUniName like'"+LikeName+"'";
		List<GzfkTabStudyuniversity> list=this.getHibernateTemplate().find(hql);
		return list;
		
	}
	

}
