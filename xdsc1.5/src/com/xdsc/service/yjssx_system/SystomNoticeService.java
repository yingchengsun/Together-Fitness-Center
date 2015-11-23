package com.xdsc.service.yjssx_system;

import java.io.File;
import java.util.List;

import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;

/**
 * 接口功能：系统通知数据库操作
 * @author 许鑫
 * @version 1.1
 */
public interface SystomNoticeService {
	
	/**
	 * 添加通知
	 * @param notice
	 */
	public void addNotice(TabNotice notice);
	
	/**
	 * 删除系统通知
	 * @param notice
	 */
	public void deleteNotice(TabNotice notice);
	
	/**
	 * 根据通知的ID查找通知的详情
	 * @param id
	 * @return 返回通知的详情
	 */
	public TabNotice findNoticeById(int id);
	
	/**
	 * 根据系统模块查找通知
	 * @return 返回通知列表
	 */
	public List<TabNotice> findAllNoticeByModule();
	
	/**
	 * 查找刚刚插入到数据库的数据
	 * @param notice
	 * @return 返回刚刚插入数据的数据
	 */
	public TabNotice findLastSaveNotice(TabNotice notice);
	
	/**
	 * 将一个通知和一个用户相关联
	 * @param noticeTo
	 */
	public void addNoticeTo(TabNoticetosb noticeTo);
	
	/**
	 * 用户删除给自己发的通知
	 * @param noticeTo
	 */
	public void deleteNoticeTo(TabNoticetosb noticeTo);
	
	/**
	 * 查找给某个人发送的通知
	 * @param num
	 * @return 返回信息列表
	 */
	public List<TabNoticetosb> findNoticeToByUserNum(String num);
	
	/**
	 * 根据通知查找这条通知都给谁发了
	 * @param id
	 * @return 通知信息列表
	 */
	public List<TabNoticetosb> findNoticeToByNoticeId(String id);
	
	/**
	 * 保存通知相关文件
	 * @param file
	 * @param savePath
	 * @param fileName
	 */
	public void savefile(File file, String savePath, String fileName) ;
	
}
