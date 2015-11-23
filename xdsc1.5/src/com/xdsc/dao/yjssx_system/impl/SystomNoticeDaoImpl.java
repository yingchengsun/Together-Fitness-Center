package com.xdsc.dao.yjssx_system.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xdsc.dao.yjssx_system.SystomNoticeDao;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;

/**
 * 类功能：系统通知数据库操作
 * @author 许鑫
 * @version 1.1
 */
public class SystomNoticeDaoImpl extends HibernateDaoSupport implements SystomNoticeDao {

	/**
	 * 添加通知
	 * @param notice
	 * @see com.xdsc.dao.yjssx_system.SystomNoticeDao#addNotice(com.xdsc.model.TabNotice)
	 */
	public void addNotice(TabNotice notice) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(notice);
	}

	/**
	 * 将一个通知和一个用户相关联
	 * @param noticeTo
	 * @see com.xdsc.dao.yjssx_system.SystomNoticeDao#addNoticeTo(com.xdsc.model.TabNoticetosb)
	 */
	public void addNoticeTo(TabNoticetosb noticeTo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(noticeTo);
	}

	/**
	 * 删除系统通知
	 * @param notice
	 * @see com.xdsc.dao.yjssx_system.SystomNoticeDao#deleteNotice(com.xdsc.model.TabNotice)
	 */
	public void deleteNotice(TabNotice notice) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(notice);
	}

	/**
	 * 用户删除给自己发的通知
	 * @param noticeTo
	 * @see com.xdsc.dao.yjssx_system.SystomNoticeDao#deleteNoticeTo(com.xdsc.model.TabNoticetosb)
	 */
	public void deleteNoticeTo(TabNoticetosb noticeTo) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(noticeTo);
	}

	/**
	 * 根据通知的ID查找通知的详情
	 * @param id
	 * @return 返回通知的详情
	 * @see com.xdsc.dao.yjssx_system.SystomNoticeDao#findNoticeById(int)
	 */
	public TabNotice findNoticeById(int id) {
		// TODO Auto-generated method stub
		TabNotice notice=(TabNotice)this.getHibernateTemplate().get(TabNotice.class, id);
		return notice;
	}

	/**
	 * 查找给某个人发送的通知
	 * @param num
	 * @return 返回信息列表
	 * @see com.xdsc.dao.yjssx_system.SystomNoticeDao#findNoticeToByUserNum(java.lang.String)
	 */
	public List<TabNoticetosb> findNoticeToByUserNum(String num) {
		// TODO Auto-generated method stub
		String hql="from TabNoticetosb n where n.mhqxTabUser.FUserNumber='"+num+"' and n.FAlreadyRead=0";
		List<TabNoticetosb> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 查找刚刚插入到数据库的数据
	 * @param notice
	 * @return 返回刚刚插入数据的数据
	 * @see com.xdsc.dao.yjssx_system.SystomNoticeDao#findLastSaveNotice(com.xdsc.model.TabNotice)
	 */
	public TabNotice findLastSaveNotice(TabNotice notice) {
		// TODO Auto-generated method stub
		TabNotice n=(TabNotice)this.getHibernateTemplate().findByExample(notice).iterator().next();
		return n;
	}

	/**
	 * 根据系统模块查找通知
	 * @return 返回通知列表
	 * @see com.xdsc.dao.yjssx_system.SystomNoticeDao#findAllNoticeByModule()
	 */
	public List<TabNotice> findAllNoticeByModule() {
		// TODO Auto-generated method stub
		String hql="from TabNotice n where n.FModuleId='7'";
		List<TabNotice> list=this.getHibernateTemplate().find(hql);
		return list;
	}

	/**
	 * 根据通知查找这条通知都给谁发了
	 * @param id
	 * @return 通知信息列表
	 * @see com.xdsc.dao.yjssx_system.SystomNoticeDao#findNoticeToByNoticeId(java.lang.String)
	 */
	public List<TabNoticetosb> findNoticeToByNoticeId(String id) {
		// TODO Auto-generated method stub
		String hql="from TabNoticetosb n where n.tabNotice.FInfoId='"+id+"'";
		List<TabNoticetosb> list=this.getHibernateTemplate().find(hql);
		return list;
	}

}
