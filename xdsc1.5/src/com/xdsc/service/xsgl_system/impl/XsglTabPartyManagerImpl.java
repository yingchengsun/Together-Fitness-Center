package com.xdsc.service.xsgl_system.impl;

import java.util.List;

import com.xdsc.dao.xsgl_system.XsglTabPartyDAO;
import com.xdsc.model.XsglTabParty;
import com.xdsc.service.xsgl_system.XsglTabPartyManager;

public class XsglTabPartyManagerImpl implements XsglTabPartyManager {
	private XsglTabPartyDAO xsglTabPartyDAO;

	public XsglTabPartyDAO getXsglTabPartyDAO() {
		return xsglTabPartyDAO;
	}

	public void setXsglTabPartyDAO(XsglTabPartyDAO xsglTabPartyDAO) {
		this.xsglTabPartyDAO = xsglTabPartyDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabPartyManager#savePartyMember(com.xdsc.model.XsglTabParty)
	 */
	public boolean savePartyMember(XsglTabParty partyMember){
		return xsglTabPartyDAO.savePartyMember(partyMember);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabPartyManager#deletePartyMember(com.xdsc.model.XsglTabParty)
	 */
	public boolean deletePartyMember(XsglTabParty partyMember){
		return xsglTabPartyDAO.deletePartyMember(partyMember);
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabPartyManager#getPartyMemberList()
	 */
	public List<XsglTabParty> getPartyMemberList(){
		return xsglTabPartyDAO.getPartyMemberList();
	}
	
	/* (non-Javadoc)
	 * @see com.xdsc.service.xsgl_system.impl.XsglTabPartyManager#getPartyMemberByFName(java.lang.String)
	 */
	public List<XsglTabParty> getPartyMemberByFName(String FName){
		return xsglTabPartyDAO.getPartyMemberByFName(FName);
	}

	public XsglTabParty getPartyMemberByFId(int FId) {
		// TODO Auto-generated method stub
		return xsglTabPartyDAO.getPartyMemberByFId(FId);
	}

	public List<XsglTabParty> getPartyMemberByStuNum(String StuNum) {
		// TODO Auto-generated method stub
		return xsglTabPartyDAO.getPartyMemberByStuNum(StuNum);
	}

	public List<XsglTabParty> getPartyMemberListByGrade(int gradeId) {
		// TODO Auto-generated method stub
		return xsglTabPartyDAO.getPartyMemberListByGrade(gradeId);
	}

	public List<XsglTabParty> getPartyMemberByClassAndFName(String classid,
			String fName) {
		// TODO Auto-generated method stub
		return xsglTabPartyDAO.getPartyMemberByClassAndFName(classid, fName);
	}

	public boolean updatePartyMember(XsglTabParty partyMember) {
		// TODO Auto-generated method stub
		return xsglTabPartyDAO.updatePartyMember(partyMember);
	}

	public List<XsglTabParty> getPartyMemberByClass(String classid) {
		// TODO Auto-generated method stub
		return xsglTabPartyDAO.getPartyMemberByClass(classid);
	}

	public List<XsglTabParty> getPartyMemberByNameYearAndClass(String year,
			String classid, String name) {
		// TODO Auto-generated method stub
		return xsglTabPartyDAO.getPartyMemberByNameYearAndClass(year, classid, name);
	}

}
