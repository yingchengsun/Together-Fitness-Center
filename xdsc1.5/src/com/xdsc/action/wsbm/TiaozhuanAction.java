package com.xdsc.action.wsbm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.AdAllCheckManager;

/**处理页面跳转
 * @author 苟小龙
 * @version 1.2
 */
public class TiaozhuanAction extends ActionSupport implements SessionAware{
	/**
	 * 登陆相关属性
	 */
	private Map session;
	/**
	 * 考生数据库类对象
	 */
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	/**
	 * 返回给页面下拉菜单选项的字符串列表
	 */
	private List<String> list = new ArrayList<String>();
	/**
	 * 返回给页面下拉菜单选项的字符串列表
	 */
	private List<String> listFTypeInfo = new ArrayList<String>();
	/**
	 * 考生对象列表
	 */
	private List<WsbmTabRegapplicant> listRegapplicantinfo;
	/**
	 * service层AdAllCheckManager对象
	 */
	private AdAllCheckManager aacm;
	
	/**判断用户是否具有完善信息权限
	 * 
	 * @return okToUpdate 具有权限，可以跳转
	 * @return unableToUpdate 不具有权限，跳转至提示页面
	 */
	public String wanshan(){
		wsbmTabRegapplicant=aacm.sepFindByNum((String)session.get("userNumber"));
		System.out.println(wsbmTabRegapplicant.getFAppRegBackUpChar().toString());
		if (wsbmTabRegapplicant.getFAppRegBackUpChar().equals("0"))
			return "okToUpdate";
		else
			return "unableToUpdate";
	}

	/**管理员发送留言时跳转至可下拉选择接受者的页面
	 * @return
	 */
	public String tiaozhuanForMessage(){
		list.clear();
		listRegapplicantinfo=aacm.findRegapplicantInfo();
		int a=0;
		listRegapplicantinfo.toArray();
		int size=0;
		size=listRegapplicantinfo.size();
		while(a<size){
			list.add(listRegapplicantinfo.get(a).getFAppRegNum());
			a++;
		}
		return "tiaozhuanForMessage";
	}
	
	public String tiaozhuanForAdUpdate(){
		list.clear();
		listRegapplicantinfo=aacm.findRegapplicantInfo();
		int a=0;
		listRegapplicantinfo.toArray();
		int size=0;
		size=listRegapplicantinfo.size();
		while(a<size){
			list.add(listRegapplicantinfo.get(a).getFAppRegNum());
			a++;
		}
		listFTypeInfo.clear();
		listFTypeInfo.add("资料验证");
		listFTypeInfo.add("预录取结果");
		listFTypeInfo.add("最终录取结果");		
		return "tiaozhuanForAdUpdate";
	}

	public List<WsbmTabRegapplicant> getListRegapplicantinfo() {
		return listRegapplicantinfo;
	}

	public void setListRegapplicantinfo(
			List<WsbmTabRegapplicant> listRegapplicantinfo) {
		this.listRegapplicantinfo = listRegapplicantinfo;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	

	public AdAllCheckManager getAacm() {
		return aacm;
	}

	public void setAacm(AdAllCheckManager aacm) {
		this.aacm = aacm;
	}
	


	public List<String> getListFTypeInfo() {
		return listFTypeInfo;
	}

	public void setListFTypeInfo(List<String> listFTypeInfo) {
		this.listFTypeInfo = listFTypeInfo;
	}

	public WsbmTabRegapplicant getWsbmTabRegapplicant() {
		return wsbmTabRegapplicant;
	}

	public void setWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}


}
