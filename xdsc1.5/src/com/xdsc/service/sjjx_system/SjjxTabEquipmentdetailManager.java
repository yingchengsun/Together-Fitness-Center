package com.xdsc.service.sjjx_system;

import java.util.List;

import com.xdsc.model.SjjxTabEquipmentdetail;

/**对设备调拨等详细信息进行操作
 * @author 陈雪
 * @version1.1
 */
public interface SjjxTabEquipmentdetailManager {

	/**增添一条设备调拨记录到数据库中
	 * @param equipDetail
	 */
	public abstract boolean saveEquipDetail(SjjxTabEquipmentdetail equipDetail);

	/**从数据库中删除一条设备调拨记录
	 * @param equipDetail
	 * @return
	 */
	public abstract boolean deleteEquipDetail(SjjxTabEquipmentdetail equipDetail);

	/**从数据库中读取所有的设备调拨记录
	 * @return 返回所有查找到记录
	 */
	public abstract List<SjjxTabEquipmentdetail> getEquipDetailList();

	/**通过设备编号查找到设备调拨记录
	 * @param equipId
	 * @return 返回查找到记录
	 */
	public abstract List<SjjxTabEquipmentdetail> getEquipDetailByEquipId(Integer equipId);

	/**更新设备调拨记录
	 * @param equipDetail
	 */
	public abstract void updateEquipDetail(SjjxTabEquipmentdetail equipDetail);

}