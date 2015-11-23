package com.xdsc.service.sjjx_system;

import java.io.InputStream;
import java.util.List;

import com.xdsc.model.SjjxTabEquipment;

/**对设备基本信息记录进行操作
 * @author 陈雪
 * @version1.1
 */
public interface SjjxTabEquipmentManager {


	/**增添一条设备基本信息到数据库中
	 * @param equip
	 */
	public abstract boolean saveEquip(SjjxTabEquipment equip);


	/**从数据库中删除一条设备基本信息记录
	 * @param equip
	 */
	public abstract boolean deleteEquip(SjjxTabEquipment equip);


	/***从数据库中读取所有的设备基本信息记录
	 * @return 返回所有查找到记录
	 */
	public abstract List<SjjxTabEquipment> getEquipList();


	/**通过设备编号查找到设备记录
	 * @param equipId
	 * @return 返回查找到记录
	 */
	public abstract SjjxTabEquipment getEquipByEquipId(Integer equipId);

//	public abstract SjjxTabEquipment getEquipByEquipTypeId(Integer equipTypeId);

	/**通过设备类型名称查找该类型所有设备记录
	 * @param equipTypeName
	 * @return 返回所有查找到记录
	 */
	public abstract List<SjjxTabEquipment> getEquipByEquipTypeName(String equipTypeName);
	
	/**通过实验室名称找到该实验室所有设备记录
	 * @param labName
	 * @return 返回所有查找到记录
	 */
	public abstract List<SjjxTabEquipment> getEquipByLabName(String labName);
	
	/**更新一条设备记录
	 * @param equip
	 */
	public abstract void updateEquip(SjjxTabEquipment equip);
	
	/**
	 * 构造设备信息表EXCEL文件
	 * 
	 */
	public abstract InputStream getInputStream();

}