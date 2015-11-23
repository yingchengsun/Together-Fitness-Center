package com.xdsc.dao.sjjx_system;

import java.util.List;

import com.xdsc.model.SjjxTabLab;

/**对实验室信息进行操作
 * @author 陈雪
 * @version1.1
 */
public interface SjjxTabLabDAO {

	/**增添一条实验室记录到数据库中
	 * @param lab
	 */
	public abstract boolean saveLab(SjjxTabLab lab);

	/**从数据库中删除一条实验室记录
	 * @param lab
	 */
	public abstract boolean deleteLab(SjjxTabLab lab);

	/**从数据库中读取所有的实验室记录
	 * @return 返回所有查找到记录
	 */
	public abstract List<SjjxTabLab> getLabList();

	/**通过实验室编号查找到实验室记录
	 * @param labId
	 * @return 返回查找到的记录
	 */
	public abstract SjjxTabLab getLabByLabId(Integer labId);
	
	/**通过实验室名称查找到实验室记录
	 * @param labName
	 * @return 返回查找到的一条记录
	 */
	public abstract SjjxTabLab getLabByLabName1(String labName);
	
	/**通过实验室名称查找到实验室记录
	 * @param labName
	 * @return 返回查找到的记录
	 */
	public abstract List<SjjxTabLab> getLabByLabName(String labName);
	
	/**通过实验室所在房间编号查找到实验室记录
	 * @param roomNumber
	 * @return 返回查找到的记录
	 */
	public abstract List<SjjxTabLab> getLabByRoomNumber(String roomNumber);

	/**更新实验室信息
	 * @param lab
	 */
	public abstract void updateLab(SjjxTabLab lab);

}