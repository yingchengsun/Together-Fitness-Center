package com.xdsc.service.wsbm;

import java.util.List;

import com.xdsc.model.TabNotice;

/**��Ϣ��ѯ
 * @author ��С��
 * @version 1.2
 */
public interface MsgCheckManager {
	public List<TabNotice> findMsg(String FAppRegNum);
	public List<TabNotice> findAdMsg();
	public TabNotice findMsgByNum(int FInfoId);
}
