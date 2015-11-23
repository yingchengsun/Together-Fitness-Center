package com.xdsc.dao.wsbm;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.WsbmTabRegapplicant;
/**考生报名
 * @author 苟小龙
 * @version 1.2
 */
public interface RegAppliDAO {
	public void addRegAppli(WsbmTabRegapplicant regAppli);
	public void addRegAppli(MhqxTabUser fun);

}
