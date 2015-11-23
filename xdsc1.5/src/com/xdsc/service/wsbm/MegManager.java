package com.xdsc.service.wsbm;

import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;

/**网站消息管理
 * @author 苟小龙
 * @version 1.2
 */
public interface MegManager {
	public void addMeg(TabNotice tn);
	public void addMeg(TabNoticetosb tnts);
	public void updateMeg(TabNotice tn);

}
