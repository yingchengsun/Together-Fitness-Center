package com.xdsc.service.bksx_system;

import java.util.List;

import com.xdsc.model.TabNotice;

/**
 * @author �ｨ��
 * @version 1.1
 * 
 * �����װ�˶Դ��֪ͨ����ز���
 */
public interface TabNoticeManager {
	/**
	 * ����һ��TabNotice����
	 * 
	 * @param notice
	 *            TabNotice����
	 * @return boolean
	 */
	public abstract boolean saveNotice(TabNotice notice);

	/**
	 * ɾ��һ��TabNotice����
	 * 
	 * @param notice
	 *            TabNotice����
	 * @return boolean
	 */
	public abstract boolean deleteNotice(TabNotice notice);

	/**
	 * ����һ��TabNotice����
	 * 
	 * @param notice
	 *            TabNotice����
	 * @return boolean
	 */
	public abstract boolean updateNotice(TabNotice notice);

	/**
	 * ���ݴ��֪ͨΨһID�õ�����Ϣ�Ķ���
	 * 
	 * @param noticeID
	 *            ���֪ͨΨһ�ɣ�
	 * @return TabNotice
	 */
	public abstract TabNotice getNoticebyID(int noticeID);

	/**
	 * �õ����еĴ��֪ͨ�����б�
	 * 
	 * @return List
	 */
	public abstract List getCheckNoticeList();

}