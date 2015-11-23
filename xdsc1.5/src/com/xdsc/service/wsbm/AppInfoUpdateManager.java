package com.xdsc.service.wsbm;

import com.xdsc.model.WsbmTabRegapplicant;

/**考生更新个人信息
 * @author 苟小龙
 * @version 1.2
 */
public interface AppInfoUpdateManager {
	public void updateAppInfo(WsbmTabRegapplicant wsbmTabRegapplicant);
	
	public WsbmTabRegapplicant findAppByID(String FAppRegNum);
}
