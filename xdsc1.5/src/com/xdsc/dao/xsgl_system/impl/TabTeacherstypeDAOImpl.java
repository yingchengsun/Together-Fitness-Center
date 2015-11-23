package com.xdsc.dao.xsgl_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.xsgl_system.TabTeacherstypeDAO;
import com.xdsc.model.TabTeacherstype;

public class TabTeacherstypeDAOImpl extends HibernateDaoSupport implements TabTeacherstypeDAO {
	/* (non-Javadoc)
	 * @see com.xdsc.dao.xsgl_system.impl.TabTeacherstypeDAO#getTeacherByTypeNum(java.lang.String)
	 */
	public List<TabTeacherstype> getTeacherByTypeNum(String TypeNum){
		String hql="from TabTeacherstype tts where tts.FTypeNumber='"+TypeNum+"'";
		return this.getHibernateTemplate().find(hql);
	}

}
