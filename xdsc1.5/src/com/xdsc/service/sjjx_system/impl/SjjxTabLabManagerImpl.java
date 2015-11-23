package com.xdsc.service.sjjx_system.impl;

import java.util.List;




import com.xdsc.dao.sjjx_system.SjjxTabLabDAO;
import com.xdsc.model.SjjxTabEquipment;
import com.xdsc.model.SjjxTabLab;
import com.xdsc.service.sjjx_system.SjjxTabLabManager;

/**对实验室信息进行操作
 * @author 陈雪
 * @version1.1
 */
public class SjjxTabLabManagerImpl implements SjjxTabLabManager {

	
	/**
	 * SjjxTabLabDAOImpl 的接口
	 */
	private SjjxTabLabDAO sjjxTabLabDAO;

	/**
	 * 数据访问方法
	 */
	public SjjxTabLabDAO getSjjxTabLabDAO() {
		return sjjxTabLabDAO;
	}

	public void setSjjxTabLabDAO(SjjxTabLabDAO sjjxTabLabDAO) {
		this.sjjxTabLabDAO = sjjxTabLabDAO;
	}
	

	/**增添一条实验室记录到数据库中
	 * @param lab
	 */
	public boolean saveLab(SjjxTabLab lab) {
		return sjjxTabLabDAO.saveLab(lab);
	}
	

	/**从数据库中删除一条实验室记录
	 * @param lab
	 */
	public boolean deleteLab(SjjxTabLab lab){
		return sjjxTabLabDAO.deleteLab(lab);
	}
	
	
	/**从数据库中读取所有的实验室记录
	 * @return 返回所有查找到记录
	 */
	public List<SjjxTabLab> getLabList(){
		return sjjxTabLabDAO.getLabList();
	}
	

	/**通过实验室编号查找到实验室记录
	 * @param labId
	 * @return 返回查找到的记录
	 */
	public SjjxTabLab getLabByLabId(Integer labId){
		return sjjxTabLabDAO.getLabByLabId(labId);
	}
	
	
	/**通过实验室名称查找到实验室记录
	 * @param labName
	 * @return 返回查找到的一条记录
	 */
	public SjjxTabLab getLabByLabName1(String labName){
		return sjjxTabLabDAO.getLabByLabName1(labName);
	}
	
	/**通过实验室名称查找到实验室记录
	 * @param labName
	 * @return 返回查找到的记录
	 */
	public List<SjjxTabLab> getLabByLabName(String labName){
		return sjjxTabLabDAO.getLabByLabName(labName);
	}
	
	/**通过实验室所在房间编号查找到实验室记录
	 * @param roomNumber
	 * @return 返回查找到的记录
	 */
	public List<SjjxTabLab> getLabByRoomNumber(String roomNumber){
		return sjjxTabLabDAO.getLabByRoomNumber(roomNumber);
	}

	/**更新实验室信息
	 * @param lab
	 */
	public void updateLab(SjjxTabLab lab){
		 sjjxTabLabDAO.updateLab(lab);
	}
	
	
}
