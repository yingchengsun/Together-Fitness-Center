package com.xdsc.dao.wsbm.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.wsbm.AdAllCheckDAO;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabRegapplicant;
/**管理员查看网站信息
 * @author 苟小龙
 * @version 1.2
 */
public class AdAllCheckDAOImpl extends HibernateDaoSupport implements AdAllCheckDAO{
	/**查找所有考生信息
	 * @return list 考生信息列表
	 */
	public List<WsbmTabRegapplicant> findRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/**查找单个考生
	 * @param FAppRegNum 考生id
	 * @return (WsbmTabRegapplicant)this.getHibernateTemplate().get(WsbmTabRegapplicant.class, FAppRegNum) 考生对象
	 */
	public WsbmTabRegapplicant sepFindByNum(String FAppRegNum){
		return (WsbmTabRegapplicant)this.getHibernateTemplate().get(WsbmTabRegapplicant.class, FAppRegNum);
	}
	public MhqxTabUser sepFindByNumInUser(String FAppRegNum) {
		return (MhqxTabUser)this.getHibernateTemplate().get(MhqxTabUser.class, FAppRegNum);
	}
	/**查找所有网站公告信息
	 * @return list 网站公告信息列表
	 */
	public List<TabNotice> findNotice() {
		String sql = "from TabNotice where (FModuleId='4' and FInfoType='notice')";
		List<TabNotice> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/**查找单个网站信息
	 * @param FInfoId 公告信息id
	 * @return (TabNotice)this.getHibernateTemplate().get(TabNotice.class, FInfoId) 网站通知信息对象
	 */
	public TabNotice sepFindByNoticeNum(int FInfoId) {
		// TODO Auto-generated method stub
		return (TabNotice)this.getHibernateTemplate().get(TabNotice.class, FInfoId);
	}

	/**更新考生信息
	 * @param wsbmTabRegapplicant 考生对象
	 */
	public void updateApp(WsbmTabRegapplicant wsbmTabRegapplicant) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(wsbmTabRegapplicant);
	}

	/** 查找所有通过信息验证的考生
	 * @return list 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findAuthPassRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassAuth='Y'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** 查找所有不通过信息验证的考生
	 * @return list 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findAuthPassNotRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassAuth='F'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** 查找所有正在信息验证的考生
	 * @return list 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findAuthingNotRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassAuth='N'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** 查找所有通过预录取的考生
	 * @return list 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findPrePassRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassPreAd='Y'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** 查找所有不通过预录取的考生
	 * @return list 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findPrePassNotRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassPreAd='F'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** 查找所有正在预录取的考生
	 * @return list 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findPreingRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassPreAd='N'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** 查找所有通过最终录取的考生
	 * @return list 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findFinPassRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassFinAd='Y'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** 查找所有不通过最终录取的考生
	 * @return list 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findFinPassNotRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassFinAd='F'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** 查找所有正在最终录取的考生
	 * @return list 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findFiningRegapplicantInfo() {
		String sql = "from WsbmTabRegapplicant where FAppRegPassFinAd='N'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** 查找所有交过报名费的考生
	 * @return list 考生对象列表
	 */
	public List<WsbmTabRegapplicant> findfeed() {
		String sql = "from WsbmTabRegapplicant where FAppRegBaoMingFei='Y'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}
	/** 查找所有未交报名费的考生
	 * @return list 考生对象列表
	 */
	public List<WsbmTabRegapplicant> unfindfeed() {
		String sql = "from WsbmTabRegapplicant where FAppRegBaoMingFei='N'";
		List<WsbmTabRegapplicant> list = this.getHibernateTemplate().find(sql);
		return list;
	}



}
