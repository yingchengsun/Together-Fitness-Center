package com.xdsc.dao.sjjx_system;

import java.util.List;

import com.xdsc.model.TabDirection;

/**��רҵ������Ϣ���в���
 * @author ��ѩ
 * @version 1.1
 */
public interface SjjxTabDirectionDAO {

	

	/**����רҵ�������Ʋ��ҵ���Ӧ�ļ�¼
	 * @param directionName
	 * @return ���ض�Ӧ��¼
	 */
	public abstract TabDirection getDirectionByDirectionName(
			String directionName);

	/**����רҵ�����Ų��ҵ���Ӧ�ļ�¼
	 * @param directionId
	 * @return ���ض�Ӧ��¼
	 */
	public abstract TabDirection getDirectionByDirectionId(String directionId) ;

}