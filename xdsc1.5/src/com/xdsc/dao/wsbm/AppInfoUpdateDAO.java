package com.xdsc.dao.wsbm;

import com.xdsc.model.WsbmTabRegapplicant;
/**������Ϣ����
 * @author ��С��
 * @version 1.2
 */
public interface AppInfoUpdateDAO {
	public void updateAppInfo(WsbmTabRegapplicant wsbmTabRegapplicant);
	
	public WsbmTabRegapplicant sepFindByNum(String appRegNum);

}
