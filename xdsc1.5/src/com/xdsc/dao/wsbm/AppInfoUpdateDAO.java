package com.xdsc.dao.wsbm;

import com.xdsc.model.WsbmTabRegapplicant;
/**考生信息更新
 * @author 苟小龙
 * @version 1.2
 */
public interface AppInfoUpdateDAO {
	public void updateAppInfo(WsbmTabRegapplicant wsbmTabRegapplicant);
	
	public WsbmTabRegapplicant sepFindByNum(String appRegNum);

}
