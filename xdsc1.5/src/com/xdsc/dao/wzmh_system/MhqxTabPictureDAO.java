package com.xdsc.dao.wzmh_system;

import java.util.List;

import com.xdsc.model.MhqxTabLink;
import com.xdsc.model.MhqxTabPicture;

  /**
   * @author ����
   *
   */
  public interface MhqxTabPictureDAO  {
	/**
	 * ����һ��ͼƬ����
	 * @param pict
	 * @return
	 */
	public abstract boolean save(MhqxTabPicture  pict) ;
	/**
	 * ����һ��ͼƬ����
	 * @param pict
	 * @return
	 */
	public abstract boolean update(MhqxTabPicture  pict);
	/**
	 * ͨ��id�õ�һ��ͼƬ���ż�¼
	 * @param FId
	 * @return MhqxTabPicture
	 */
	public abstract MhqxTabPicture getMhqxTabPictureByID(int FId);
	/**
	 * ͨ�����FInfoId���ҳ�����󶨵�ͼƬ���ż�¼
	 * @param FInfoId
	 * @return
	 */
	public abstract List<MhqxTabPicture> findByInfoId(int FInfoId);
}
