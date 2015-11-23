package com.xdsc.action.wsbm;


import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.KsCheckManager;
import com.xdsc.service.wsbm.RegAppliManager;


/**������ѯ��վ������Ϣ������¼ȡ���������Ϣ
 * @author ��С��
 * @version 1.2
 */
public class KsCheckAction extends ActionSupport implements SessionAware{	
	/**
	 * session�����Ϣ
	 */
	private Map session;
	/**
	 * service�� KsCheckManager ����
	 */
	private KsCheckManager ram;
	/**
	 * ��������
	 */
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	/**
	 * ���Կ�Ŀ�����б�
	 */
	private List<WsbmTabExamsubject> listWsbmTabExamsubject;
	/**
	 * ���Կ�Ŀ����
	 */
	private WsbmTabExamsubject wsbmTabExamsubject;

	/**
	 * ������ǩ�������
	 */
	private String InfoAuth;
	private String InfoPre;
	private String InfoFin;
	public String getInfoPre() {
		return InfoPre;
	}

	public void setInfoPre(String infoPre) {
		InfoPre = infoPre;
	}

	public String getInfoFin() {
		return InfoFin;
	}

	public void setInfoFin(String infoFin) {
		InfoFin = infoFin;
	}

	/**�ɿ���������ϵͳע��ţ���ÿ�������
	 * @return success ��ȡ�ɹ�
	 */
	public String execute(){
		wsbmTabRegapplicant = ram.findKaoShengInfoByNum((String)session.get("userNumber"));
		return "success";
		}
	
	/**��ÿ�����ǰ¼ȡ������Ϣ
	 * @return state ��ȡ��Ϣ�ɹ�
	 */
	public String state(){
		System.out.println("Entry");
		wsbmTabRegapplicant = ram.findKaoShengInfoByNum((String)session.get("userNumber"));
		System.out.println(wsbmTabRegapplicant.getFAppRegPassAuth());
		System.out.println("TabGotNum==1");
		
		if(wsbmTabRegapplicant.getFAppRegPassAuth().equalsIgnoreCase("Y")){
			System.out.println("Y");
			InfoAuth="���������Ѿ�ͨ����ʵ";
		}
		else if(wsbmTabRegapplicant.getFAppRegPassAuth().equalsIgnoreCase("N")){
			System.out.println("N");
			InfoAuth="����������δ����֤�������ĵȺ�";
		}
		else if(wsbmTabRegapplicant.getFAppRegPassAuth().equalsIgnoreCase("F")){
			System.out.println("F");
			InfoAuth="��������δͨ����֤����������ȷ����Ϣ";
		}
		//
		//
		if(wsbmTabRegapplicant.getFAppRegPassPreAd().equalsIgnoreCase("Y")){
			System.out.println("Y");
			InfoPre="��ϲ���Ѿ�ͨ��Ԥ¼ȡ";
		}
		else if(wsbmTabRegapplicant.getFAppRegPassPreAd().equalsIgnoreCase("N")){
			System.out.println("N");
			InfoPre="����Ԥ¼ȡ��δ��ȷ���������ĵȺ�";
		}
		else if(wsbmTabRegapplicant.getFAppRegPassPreAd().equalsIgnoreCase("F")){
			System.out.println("F");
			InfoPre="���ź�����δͨ��Ԥ¼ȡ";
		}
		//
		//
		if(wsbmTabRegapplicant.getFAppRegPassFinAd().equalsIgnoreCase("Y")){
			System.out.println("Y");
			InfoFin="��ϲ���Ѿ�����ʽ¼ȡ";
		}
		else if(wsbmTabRegapplicant.getFAppRegPassFinAd().equalsIgnoreCase("N")){
			System.out.println("N");
			InfoFin="����¼ȡ��δ��ȷ���������ĵȺ�";
		}
		else if(wsbmTabRegapplicant.getFAppRegPassFinAd().equalsIgnoreCase("F")){
			System.out.println("F");
			InfoFin="���ź�����δ��¼ȡ";
		}
		
		return "state";
	}
	
	/**��������ѧԺ��ظ�����Ϣ
	 * @return findMyExams ���ҳɹ�
	 */
	public String findMyExams()
	{
		listWsbmTabExamsubject=ram.findExamsubject();
		System.out.println("Got list");
		System.out.println(listWsbmTabExamsubject);
		return "findMyExams";
	}


	public KsCheckManager getRam() {
		return ram;
	}


	public void setRam(KsCheckManager ram) {
		this.ram = ram;
	}

	public WsbmTabRegapplicant getWsbmTabRegapplicant() {
		return wsbmTabRegapplicant;
	}


	public void setWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
	}

	public String getInfoAuth() {
		return InfoAuth;
	}

	public void setInfoAuth(String infoAuth) {
		InfoAuth = infoAuth;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public WsbmTabExamsubject getWsbmTabExamsubject() {
		return wsbmTabExamsubject;
	}

	public void setWsbmTabExamsubject(WsbmTabExamsubject wsbmTabExamsubject) {
		this.wsbmTabExamsubject = wsbmTabExamsubject;
	}

	public List<WsbmTabExamsubject> getListWsbmTabExamsubject() {
		return listWsbmTabExamsubject;
	}

	public void setListWsbmTabExamsubject(
			List<WsbmTabExamsubject> listWsbmTabExamsubject) {
		this.listWsbmTabExamsubject = listWsbmTabExamsubject;
	}
}
