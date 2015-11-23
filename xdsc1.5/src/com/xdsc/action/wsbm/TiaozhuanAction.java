package com.xdsc.action.wsbm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.AdAllCheckManager;

/**����ҳ����ת
 * @author ��С��
 * @version 1.2
 */
public class TiaozhuanAction extends ActionSupport implements SessionAware{
	/**
	 * ��½�������
	 */
	private Map session;
	/**
	 * �������ݿ������
	 */
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	/**
	 * ���ظ�ҳ�������˵�ѡ����ַ����б�
	 */
	private List<String> list = new ArrayList<String>();
	/**
	 * ���ظ�ҳ�������˵�ѡ����ַ����б�
	 */
	private List<String> listFTypeInfo = new ArrayList<String>();
	/**
	 * ���������б�
	 */
	private List<WsbmTabRegapplicant> listRegapplicantinfo;
	/**
	 * service��AdAllCheckManager����
	 */
	private AdAllCheckManager aacm;
	
	/**�ж��û��Ƿ����������ϢȨ��
	 * 
	 * @return okToUpdate ����Ȩ�ޣ�������ת
	 * @return unableToUpdate ������Ȩ�ޣ���ת����ʾҳ��
	 */
	public String wanshan(){
		wsbmTabRegapplicant=aacm.sepFindByNum((String)session.get("userNumber"));
		System.out.println(wsbmTabRegapplicant.getFAppRegBackUpChar().toString());
		if (wsbmTabRegapplicant.getFAppRegBackUpChar().equals("0"))
			return "okToUpdate";
		else
			return "unableToUpdate";
	}

	/**����Ա��������ʱ��ת��������ѡ������ߵ�ҳ��
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
		listFTypeInfo.add("������֤");
		listFTypeInfo.add("Ԥ¼ȡ���");
		listFTypeInfo.add("����¼ȡ���");		
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
