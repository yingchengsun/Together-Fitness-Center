package com.xdsc.service.wzmh_system;


import java.io.File;
import java.util.List;
import com.xdsc.model.MhqxTabPicture;
/**
 * @author ����
 *
 */
public interface MhqxTabPictureManager {

	/**
	 * ����DAO�㷽������һ��ͼƬ���ż�¼
	 * @param pict
	 */
	public abstract  boolean add(MhqxTabPicture  pict);

	/**
	 * ����DAO�㷽������һ��ͼƬ���ż�¼
	 * @param pict
	 */
	public abstract  boolean update(MhqxTabPicture  pict);
	/**
	 * ����DAO�㷽��ͨ��id�õ�һ��ͼƬ���ż�¼
	 * @param FId
	 * @return MhqxTabPicture
	 */
	public abstract MhqxTabPicture getMhqxTabPictureByID(int FId);

	/**
	 * ����DAO�㷽����ͨ�����FInfoId���ҳ�����󶨵�ͼƬ���ż�¼
	 * @param  FInfoId
	 */
	public abstract List<MhqxTabPicture> findByInfoId(int FInfoId);

   /** �洢�ϴ���ͼƬ
     * @return nav
     */
    public abstract MhqxTabPicture savefile(File file,MhqxTabPicture pic, String savePath,
		String fileName) throws Exception ;
}