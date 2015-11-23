package com.xdsc.dao.wzmh_system;

import com.xdsc.model.MhqxTabRemind;

public interface CssDAO {

	/**
	 * 当前无css时 插入
	 * @param css
	 */
	public void insert(MhqxTabRemind css);
	
	
	
	/**
	 * 有 更新
	 * @param css
	 */
	public void update(MhqxTabRemind css);
	
	
	/**
	 * 根据用户查找
	 * @param UserNumber
	 * @return
	 */
	public MhqxTabRemind findbyusernumber(String UserNumber);
	
	/**根据id查找
	 * @param id
	 * @return
	 */
	public MhqxTabRemind findbyid(int id);
}
