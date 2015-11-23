package com.xdsc.service.sjjx_system;

import java.io.InputStream;
import java.util.List;

import com.xdsc.model.SjjxTabEquipmenttype;

/**对设备类型信息记录进行操作
 * @author 陈雪
 * @version1.1
 */
public interface SjjxTabEquipmenttypeManager {

	/**增添一条设备类型信息到数据库中
	 * @param equipType
	 */
	public abstract boolean saveEquipType(SjjxTabEquipmenttype equipType);

	/**从数据库中删除一条设备类型信息记录
	 * @param equipType
	 */
	public abstract boolean deleteEquipType(SjjxTabEquipmenttype equipType);

	/**从数据库中读取所有的设备类型记录
	 * @return 返回所有查找到记录
	 */
	public abstract List<SjjxTabEquipmenttype> getEquipTypeList();

	/**通过设备类型编号查找到设备类型记录
	 * @param equipTypeId
	 * @return 返回查找到记录
	 */
	public abstract SjjxTabEquipmenttype getEquipTypeByEquipTypeId(
			Integer equipTypeId);

	/**通过设备类型名称查找到设备类型记录
	 * @param equipTypeName
	 * @return 返回查找到记录
	 */
	public abstract SjjxTabEquipmenttype getEquipTypeByEquipTypeName(
			String equipTypeName);
	
	public abstract List<SjjxTabEquipmenttype> getEquipTypeByEquipTypeName1(String equipTypeName);

	/**更新一条设备类型记录
	 * @param equipType
	 */
	public abstract void updateEquipType(SjjxTabEquipmenttype equipType);
	


}