package com.xdsc.util;
import java.util.*;
public class UnCheckUrl {
private ArrayList<String> uncheckjspList=new  ArrayList<String>();
private ArrayList<String> uncheckactionList=new  ArrayList<String>();

public UnCheckUrl()
{
	uncheckjspList.add("/index.jsp");
	uncheckjspList.add("/");
	uncheckjspList.add("/login.jsp");

	
	uncheckactionList.add("/information");
	uncheckactionList.add("/CheckLoginAction");
	uncheckactionList.add("/11_BackGroundSystem");
	uncheckactionList.add("/2_xsgl_system");
	uncheckactionList.add("/3_jiaofu_system");
	uncheckactionList.add("/4_wangshangbaoming_system");
	uncheckactionList.add("/5_sjjx_system");
	uncheckactionList.add("/7_yjssx_system");
	uncheckactionList.add("/8_mail_system");
	uncheckactionList.add("/9_genzongfankui_system");
	uncheckactionList.add("/bksx");
	uncheckactionList.add("/UserRoleAction");
	uncheckactionList.add("/register");
	uncheckactionList.add("/adAllCheck");
	uncheckactionList.add("download");
	uncheckactionList.add("yjssxCommon");
	uncheckactionList.add("login");
	
}

public synchronized ArrayList<String> getUncheckjspList() {
	return uncheckjspList;
}

public synchronized void setUncheckjspList(ArrayList<String> uncheckjspList) {
	this.uncheckjspList = uncheckjspList;
}

public synchronized ArrayList<String> getUncheckactionList() {
	return uncheckactionList;
}

public synchronized void setUncheckactionList(
		ArrayList<String> uncheckactionList) {
	this.uncheckactionList = uncheckactionList;
}










}
