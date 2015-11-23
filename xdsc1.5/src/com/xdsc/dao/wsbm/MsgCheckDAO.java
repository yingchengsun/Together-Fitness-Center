package com.xdsc.dao.wsbm;

import java.util.List;

import com.xdsc.model.TabNotice;
/**²é¿´ÁôÑÔ
 * @author ¹¶Ð¡Áú
 * @version 1.2
 */
public interface MsgCheckDAO {
	public List<TabNotice> findMsg(String FAppRegNum);
	public List<TabNotice> findAdMsg();
	public TabNotice findMsgByNum(int fInfoId);

}
