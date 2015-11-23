package com.xdsc.dao.wsbm;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;
/**处理留言发送更新
 * @author 苟小龙
 * @version 1.2
 */
public interface MegDAO {
	public void addMeg(TabNotice tn);
	public void addMeg(TabNoticetosb tnts);
	public void updateMeg(TabNotice tn);
}
