package com.xdsc.dao.sjjx_system;

import java.util.List;

import com.xdsc.model.TabInformation;

/**对通知公告信息进行相关操作
 * @author 陈雪
 * @version1.1
 */
public interface SjjxTabInformationDAO {

	/**添加一条信息记录到数据库中
	 * @param info
	 */
	public abstract boolean saveSjjxTabInformation(TabInformation info);

	/**从数据库中删除一条信息记录
	 * @param info
	 */
	public abstract boolean deleteSjjxTabInformation(TabInformation info);

	/**更新一条信息记录
	 * @param info
	 */
	public abstract void updateSjjxTabInformation(TabInformation info);

	/**从数据库中读取到所有实践教学系统发出的通知公告信息
	 * @return 返回所有信息记录
	 */
	public abstract List<TabInformation> getSjjxTZGGTabInformations();

	/**通过信息编号查找到相应信息记录
	 * @param id
	 * @return 返回相应信息记录
	 */
	public abstract TabInformation getSjjxTabInformationByInfoId(int id);

}