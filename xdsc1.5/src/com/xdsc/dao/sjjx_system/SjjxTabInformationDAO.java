package com.xdsc.dao.sjjx_system;

import java.util.List;

import com.xdsc.model.TabInformation;

/**��֪ͨ������Ϣ������ز���
 * @author ��ѩ
 * @version1.1
 */
public interface SjjxTabInformationDAO {

	/**���һ����Ϣ��¼�����ݿ���
	 * @param info
	 */
	public abstract boolean saveSjjxTabInformation(TabInformation info);

	/**�����ݿ���ɾ��һ����Ϣ��¼
	 * @param info
	 */
	public abstract boolean deleteSjjxTabInformation(TabInformation info);

	/**����һ����Ϣ��¼
	 * @param info
	 */
	public abstract void updateSjjxTabInformation(TabInformation info);

	/**�����ݿ��ж�ȡ������ʵ����ѧϵͳ������֪ͨ������Ϣ
	 * @return ����������Ϣ��¼
	 */
	public abstract List<TabInformation> getSjjxTZGGTabInformations();

	/**ͨ����Ϣ��Ų��ҵ���Ӧ��Ϣ��¼
	 * @param id
	 * @return ������Ӧ��Ϣ��¼
	 */
	public abstract TabInformation getSjjxTabInformationByInfoId(int id);

}