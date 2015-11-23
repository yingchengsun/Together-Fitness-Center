package com.xdsc.service.sjjx_system.impl;

import java.util.List;

import com.xdsc.dao.sjjx_system.SjjxTabDirectionDAO;
import com.xdsc.model.TabClasses;
import com.xdsc.model.TabDirection;
import com.xdsc.service.sjjx_system.SjjxTabDirectionManager;

/**对专业方向信息进行操作
 * @author 陈雪
 * @version 1.1
 */
public class SjjxTabDirectionManagerImpl implements SjjxTabDirectionManager {

	/**
	 * SjjxTabDirectionDAOImpl 的接口
	 */
	private SjjxTabDirectionDAO sjjxTabDirectionDAO;

	

	/**
	 * 数据访问方法
	 */
	public SjjxTabDirectionDAO getSjjxTabDirectionDAO() {
		return sjjxTabDirectionDAO;
	}

	public void setSjjxTabDirectionDAO(SjjxTabDirectionDAO sjjxTabDirectionDAO) {
		this.sjjxTabDirectionDAO = sjjxTabDirectionDAO;
	}

	
	/**根据专业方向名称查找到对应的记录
	 * @param directionName
	 * @return 返回对应记录
	 */
	public TabDirection getDirectionByDirectionName(String directionName) {
		return sjjxTabDirectionDAO.getDirectionByDirectionName(directionName);
	}

	/**根据专业方向编号查找到对应的记录
	 * @param directionId
	 * @return 返回对应记录
	 */
	public TabDirection getDirectionByDirectionId(String directionId){
		return sjjxTabDirectionDAO.getDirectionByDirectionId(directionId);
	}
	
}
