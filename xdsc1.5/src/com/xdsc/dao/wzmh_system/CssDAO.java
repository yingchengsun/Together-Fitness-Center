package com.xdsc.dao.wzmh_system;

import com.xdsc.model.MhqxTabRemind;

public interface CssDAO {

	/**
	 * ��ǰ��cssʱ ����
	 * @param css
	 */
	public void insert(MhqxTabRemind css);
	
	
	
	/**
	 * �� ����
	 * @param css
	 */
	public void update(MhqxTabRemind css);
	
	
	/**
	 * �����û�����
	 * @param UserNumber
	 * @return
	 */
	public MhqxTabRemind findbyusernumber(String UserNumber);
	
	/**����id����
	 * @param id
	 * @return
	 */
	public MhqxTabRemind findbyid(int id);
}
