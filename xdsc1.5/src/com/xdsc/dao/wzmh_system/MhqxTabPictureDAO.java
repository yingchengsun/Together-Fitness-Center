package com.xdsc.dao.wzmh_system;

import java.util.List;

import com.xdsc.model.MhqxTabLink;
import com.xdsc.model.MhqxTabPicture;

  /**
   * @author 高雅
   *
   */
  public interface MhqxTabPictureDAO  {
	/**
	 * 增加一条图片新闻
	 * @param pict
	 * @return
	 */
	public abstract boolean save(MhqxTabPicture  pict) ;
	/**
	 * 更新一条图片新闻
	 * @param pict
	 * @return
	 */
	public abstract boolean update(MhqxTabPicture  pict);
	/**
	 * 通过id得到一条图片新闻记录
	 * @param FId
	 * @return MhqxTabPicture
	 */
	public abstract MhqxTabPicture getMhqxTabPictureByID(int FId);
	/**
	 * 通过外键FInfoId查找出与其绑定的图片新闻纪录
	 * @param FInfoId
	 * @return
	 */
	public abstract List<MhqxTabPicture> findByInfoId(int FInfoId);
}
