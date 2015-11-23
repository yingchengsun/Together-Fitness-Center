package com.xdsc.dao.sjjx_system;

import java.util.List;

import com.xdsc.model.TabDirection;

/**对专业方向信息进行操作
 * @author 陈雪
 * @version 1.1
 */
public interface SjjxTabDirectionDAO {

	

	/**根据专业方向名称查找到对应的记录
	 * @param directionName
	 * @return 返回对应记录
	 */
	public abstract TabDirection getDirectionByDirectionName(
			String directionName);

	/**根据专业方向编号查找到对应的记录
	 * @param directionId
	 * @return 返回对应记录
	 */
	public abstract TabDirection getDirectionByDirectionId(String directionId) ;

}