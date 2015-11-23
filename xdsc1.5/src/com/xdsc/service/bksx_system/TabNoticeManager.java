package com.xdsc.service.bksx_system;

import java.util.List;

import com.xdsc.model.TabNotice;

/**
 * @author 孙建波
 * @version 1.1
 * 
 * 此类封装了对答辩通知的相关操作
 */
public interface TabNoticeManager {
	/**
	 * 保存一个TabNotice对象
	 * 
	 * @param notice
	 *            TabNotice对象
	 * @return boolean
	 */
	public abstract boolean saveNotice(TabNotice notice);

	/**
	 * 删除一个TabNotice对象
	 * 
	 * @param notice
	 *            TabNotice对象
	 * @return boolean
	 */
	public abstract boolean deleteNotice(TabNotice notice);

	/**
	 * 更新一个TabNotice对象
	 * 
	 * @param notice
	 *            TabNotice对象
	 * @return boolean
	 */
	public abstract boolean updateNotice(TabNotice notice);

	/**
	 * 根据答辩通知唯一ID得到该信息的对象
	 * 
	 * @param noticeID
	 *            答辩通知唯一ＩＤ
	 * @return TabNotice
	 */
	public abstract TabNotice getNoticebyID(int noticeID);

	/**
	 * 得到所有的答辩通知对象列表
	 * 
	 * @return List
	 */
	public abstract List getCheckNoticeList();

}