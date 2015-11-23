package com.xdsc.dao.xsgl_system;

import java.util.List;

import com.xdsc.model.XsglTabJiangzhu;
import com.xdsc.model.XsglTabParty;

public interface XsglTabPartyDAO {

	public abstract boolean savePartyMember(XsglTabParty partyMember);

	public abstract boolean deletePartyMember(XsglTabParty partyMember);
	
	public abstract boolean updatePartyMember(XsglTabParty partyMember);

	public abstract List<XsglTabParty> getPartyMemberList();

	public abstract List<XsglTabParty> getPartyMemberByFName(String FName);
	
	public abstract XsglTabParty getPartyMemberByFId(int FId);
	
	public abstract List<XsglTabParty> getPartyMemberByStuNum(String StuNum);
	
	public abstract List<XsglTabParty> getPartyMemberListByGrade(int gradeId);
	
	public abstract List<XsglTabParty> getPartyMemberByClassAndFName(String classid,String fName);

	public abstract List<XsglTabParty> getPartyMemberByClass(String classid);
	
	public abstract List<XsglTabParty> getPartyMemberByNameYearAndClass(String year,String classid,String name);

}