package com.xdsc.dao.sjjx_system;

import java.util.List;

import com.xdsc.model.SjjxTabLab;

/**��ʵ������Ϣ���в���
 * @author ��ѩ
 * @version1.1
 */
public interface SjjxTabLabDAO {

	/**����һ��ʵ���Ҽ�¼�����ݿ���
	 * @param lab
	 */
	public abstract boolean saveLab(SjjxTabLab lab);

	/**�����ݿ���ɾ��һ��ʵ���Ҽ�¼
	 * @param lab
	 */
	public abstract boolean deleteLab(SjjxTabLab lab);

	/**�����ݿ��ж�ȡ���е�ʵ���Ҽ�¼
	 * @return �������в��ҵ���¼
	 */
	public abstract List<SjjxTabLab> getLabList();

	/**ͨ��ʵ���ұ�Ų��ҵ�ʵ���Ҽ�¼
	 * @param labId
	 * @return ���ز��ҵ��ļ�¼
	 */
	public abstract SjjxTabLab getLabByLabId(Integer labId);
	
	/**ͨ��ʵ�������Ʋ��ҵ�ʵ���Ҽ�¼
	 * @param labName
	 * @return ���ز��ҵ���һ����¼
	 */
	public abstract SjjxTabLab getLabByLabName1(String labName);
	
	/**ͨ��ʵ�������Ʋ��ҵ�ʵ���Ҽ�¼
	 * @param labName
	 * @return ���ز��ҵ��ļ�¼
	 */
	public abstract List<SjjxTabLab> getLabByLabName(String labName);
	
	/**ͨ��ʵ�������ڷ����Ų��ҵ�ʵ���Ҽ�¼
	 * @param roomNumber
	 * @return ���ز��ҵ��ļ�¼
	 */
	public abstract List<SjjxTabLab> getLabByRoomNumber(String roomNumber);

	/**����ʵ������Ϣ
	 * @param lab
	 */
	public abstract void updateLab(SjjxTabLab lab);

}