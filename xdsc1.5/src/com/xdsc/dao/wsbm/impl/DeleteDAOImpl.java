package com.xdsc.dao.wsbm.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.DeleteDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;

/**删除网站信息
 * @author 苟小龙
 * @version 1.2
 */
public class DeleteDAOImpl extends HibernateDaoSupport implements DeleteDAO{

	/**删除考生帐号
	 * @param mhqxTabUser 系统用户对象
	 */
	public void deleteAcc(MhqxTabUser mhqxTabUser) {
		this.getHibernateTemplate().delete(mhqxTabUser);
	}

	/**查找系统用户
	 * @param FUserNumber 系统用户id
	 * @return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, FUserNumber) 系统用户对象
	 */
	public MhqxTabUser findAccByNum(String FUserNumber) {
		// TODO Auto-generated method stub
		return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, FUserNumber);
	}

	/**查找所有考生
	 * @return listRegapplicantinfo 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant";
		List<WsbmTabRegapplicant> listRegapplicantinfo = this.getHibernateTemplate().find(sql);
		return listRegapplicantinfo;
	}
	
	/**删除系统公告信息
	 * @param tabNotice 公告信息对象
	 */
	public void deleteNotice(TabNotice tabNotice) {
		this.getHibernateTemplate().delete(tabNotice);
	}

	/**删除考生帐号
	 * @param wsbmTabRegapplicant 考生对象
	 */
	public void deleteAcc(WsbmTabRegapplicant wsbmTabRegapplicant) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(wsbmTabRegapplicant);
	}

	public List<WsbmTabExamsubject> findSubject() {
		String sql = "from WsbmTabExamsubject";
		List<WsbmTabExamsubject> listWsbmTabExamsubject = this.getHibernateTemplate().find(sql);
		return listWsbmTabExamsubject;
	}

	public void deleteSubject(WsbmTabExamsubject wsbmTabExamsubject) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(wsbmTabExamsubject);
	}
}
