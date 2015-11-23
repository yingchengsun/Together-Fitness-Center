package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.TabTeacherstotypeDAO;
import com.xdsc.model.TabTeacherstotype;

public class TabTeacherstotypeDAOImpl extends HibernateDaoSupport implements TabTeacherstotypeDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.TabTeacherstotypeDAO#getTeacherByNum(java.lang.String)
	 */
	public List<TabTeacherstotype> getTeacherByNum(String TeaNum){
		String hql="from TabTeacherstotype tts where tts.tabTeachers.FTeacherNumber='"+TeaNum+"'";
		return this.getHibernateTemplate().find(hql);
	}

}
