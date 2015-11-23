package com.xdsc.dao.wzmh_system;

import com.xdsc.model.JfptTabOtherassist;

/**
 * 助教信息维护
 * @author 陈丰
 *
 */

public interface AssitInfoDAO {

	/**
	 * 更新助教信息
	 * @param 助教实例
	 */
	public void updateAssitInfo(JfptTabOtherassist Assit);
	
	
	/**
	 * 插入助教
	 * @param Assit
	 */
	public void insertAssitInfo(JfptTabOtherassist Assit);
	
	/**
	 * 根据帐号查询助教
	 * @param 帐号
	 * @return 助教实例
	 */
	public JfptTabOtherassist findAssitByNum(String num);
}
