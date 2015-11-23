package com.xdsc.service.wzmh_system;


import java.io.File;
import java.util.List;
import com.xdsc.model.MhqxTabPicture;
/**
 * @author 高雅
 *
 */
public interface MhqxTabPictureManager {

	/**
	 * 调用DAO层方法增加一条图片新闻记录
	 * @param pict
	 */
	public abstract  boolean add(MhqxTabPicture  pict);

	/**
	 * 调用DAO层方法更新一条图片新闻记录
	 * @param pict
	 */
	public abstract  boolean update(MhqxTabPicture  pict);
	/**
	 * 调用DAO层方法通过id得到一条图片新闻记录
	 * @param FId
	 * @return MhqxTabPicture
	 */
	public abstract MhqxTabPicture getMhqxTabPictureByID(int FId);

	/**
	 * 调用DAO层方法，通过外键FInfoId查找出与其绑定的图片新闻纪录
	 * @param  FInfoId
	 */
	public abstract List<MhqxTabPicture> findByInfoId(int FInfoId);

   /** 存储上传的图片
     * @return nav
     */
    public abstract MhqxTabPicture savefile(File file,MhqxTabPicture pic, String savePath,
		String fileName) throws Exception ;
}