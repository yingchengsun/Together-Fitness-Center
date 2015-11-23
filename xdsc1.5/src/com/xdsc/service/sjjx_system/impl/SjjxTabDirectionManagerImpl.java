package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabDirectionDAO;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabDirection;
import com.xdsc.service.sjjx_system.SjjxTabDirectionManager;

/**��רҵ������Ϣ���в���
 * @author ��ѩ
 * @version 1.1
 */
public class SjjxTabDirectionManagerImpl implements SjjxTabDirectionManager {

	/**
	 * SjjxTabDirectionDAOImpl �Ľӿ�
	 */
	private SjjxTabDirectionDAO sjjxTabDirectionDAO;

	

	/**
	 * ���ݷ��ʷ���
	 */
	public SjjxTabDirectionDAO getSjjxTabDirectionDAO() {
		return sjjxTabDirectionDAO;
	}

	public void setSjjxTabDirectionDAO(SjjxTabDirectionDAO sjjxTabDirectionDAO) {
		this.sjjxTabDirectionDAO = sjjxTabDirectionDAO;
	}

	
	/**����רҵ�������Ʋ��ҵ���Ӧ�ļ�¼
	 * @param directionName
	 * @return ���ض�Ӧ��¼
	 */
	public TabDirection getDirectionByDirectionName(String directionName) {
		return sjjxTabDirectionDAO.getDirectionByDirectionName(directionName);
	}

	/**����רҵ�����Ų��ҵ���Ӧ�ļ�¼
	 * @param directionId
	 * @return ���ض�Ӧ��¼
	 */
	public TabDirection getDirectionByDirectionId(String directionId){
		return sjjxTabDirectionDAO.getDirectionByDirectionId(directionId);
	}
	
}
