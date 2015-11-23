package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabPartygatherDAO;

import com.xdsc.model.XsglTabJiangzhu;
import com.xdsc.model.XsglTabPartygather;
import com.xdsc.service.xsgl_system.XsglTabPartygatherManager;

public class XsglTabPartygatherManagerImpl implements XsglTabPartygatherManager {
	private XsglTabPartygatherDAO xsglTabPartygatherDAO;

	public XsglTabPartygatherDAO getXsglTabPartygatherDAO() {
		return xsglTabPartygatherDAO;
	}

	public void setXsglTabPartygatherDAO(XsglTabPartygatherDAO xsglTabPartygatherDAO) {
		this.xsglTabPartygatherDAO = xsglTabPartygatherDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabPartygatherManager#saveParty(com.xdsc.model.xsgl_system.XsglTabPartygather)
	 */
	public boolean saveParty(XsglTabPartygather party){
		return xsglTabPartygatherDAO.saveParty(party);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabPartygatherManager#deleteParty(com.xdsc.model.xsgl_system.XsglTabPartygather)
	 */
	public boolean deleteParty(XsglTabPartygather party){
		return xsglTabPartygatherDAO.deleteParty(party);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabPartygatherManager#getPartyList()
	 */
	public List<XsglTabPartygather> getPartyList(){
		return xsglTabPartygatherDAO.getPartyList();
		
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabPartygatherManager#getPartyByFCNum(java.lang.String)
	 */
	public XsglTabPartygather getPartyByFCNum(String FCNum) {
		return xsglTabPartygatherDAO.getPartyByFCNum(FCNum);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabPartygatherManager#getPartyByFName(java.lang.String)
	 */
	public XsglTabPartygather getPartyByFName(String FName) {
		return xsglTabPartygatherDAO.getPartyByFName(FName);
	}

	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabPartygatherManager#updateParty(com.xdsc.model.xsgl_system.XsglTabPartygather)
	 */
	public boolean updateParty(XsglTabPartygather party) {
		return xsglTabPartygatherDAO.updateParty(party);
		
	}

	public XsglTabPartygather getPartyByFId(int FId) {
		// TODO Auto-generated method stub
		return xsglTabPartygatherDAO.getPartyByFId(FId);
	}

	

	public List<XsglTabPartygather> getPartyByNameYearAndClass(String year,
			String classid, String name) {
		// TODO Auto-generated method stub
		return xsglTabPartygatherDAO.getPartyByNameYearAndClass(year, classid, name);
	}

	

}
