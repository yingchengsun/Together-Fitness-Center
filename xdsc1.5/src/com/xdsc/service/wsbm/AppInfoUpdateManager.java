package com.xdsc.service.wsbm;

import com.xdsc.model.WsbmTabRegapplicant;

/**�������¸�����Ϣ
 * @author ��С��
 * @version 1.2
 */
public interface AppInfoUpdateManager {
	public void updateAppInfo(WsbmTabRegapplicant wsbmTabRegapplicant);
	
	public WsbmTabRegapplicant findAppByID(String FAppRegNum);
}
