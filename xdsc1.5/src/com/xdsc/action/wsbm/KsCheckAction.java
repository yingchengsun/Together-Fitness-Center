package com.xdsc.action.wsbm;


import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.WsbmTabExamsubject;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.KsCheckManager;
import com.xdsc.service.wsbm.RegAppliManager;


/**考生查询网站公告信息和自身录取事物相关信息
 * @author 苟小龙
 * @version 1.2
 */
public class KsCheckAction extends ActionSupport implements SessionAware{	
	/**
	 * session相关信息
	 */
	private Map session;
	/**
	 * service层 KsCheckManager 对象
	 */
	private KsCheckManager ram;
	/**
	 * 考生对象
	 */
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	/**
	 * 考试科目对象列表
	 */
	private List<WsbmTabExamsubject> listWsbmTabExamsubject;
	/**
	 * 考试科目对象
	 */
	private WsbmTabExamsubject wsbmTabExamsubject;

	/**
	 * 考生标签相关属性
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

	/**由考生主键（系统注册号）获得考生对象
	 * @return success 获取成功
	 */
	public String execute(){
		wsbmTabRegapplicant = ram.findKaoShengInfoByNum((String)session.get("userNumber"));
		return "success";
		}
	
	/**获得考生当前录取进度信息
	 * @return state 获取信息成功
	 */
	public String state(){
		System.out.println("Entry");
		wsbmTabRegapplicant = ram.findKaoShengInfoByNum((String)session.get("userNumber"));
		System.out.println(wsbmTabRegapplicant.getFAppRegPassAuth());
		System.out.println("TabGotNum==1");
		
		if(wsbmTabRegapplicant.getFAppRegPassAuth().equalsIgnoreCase("Y")){
			System.out.println("Y");
			InfoAuth="您的资料已经通过核实";
		}
		else if(wsbmTabRegapplicant.getFAppRegPassAuth().equalsIgnoreCase("N")){
			System.out.println("N");
			InfoAuth="您的资料尚未被验证，请耐心等候";
		}
		else if(wsbmTabRegapplicant.getFAppRegPassAuth().equalsIgnoreCase("F")){
			System.out.println("F");
			InfoAuth="您的资料未通过验证，请输入正确的信息";
		}
		//
		//
		if(wsbmTabRegapplicant.getFAppRegPassPreAd().equalsIgnoreCase("Y")){
			System.out.println("Y");
			InfoPre="恭喜您已经通过预录取";
		}
		else if(wsbmTabRegapplicant.getFAppRegPassPreAd().equalsIgnoreCase("N")){
			System.out.println("N");
			InfoPre="您的预录取尚未被确定，请耐心等候";
		}
		else if(wsbmTabRegapplicant.getFAppRegPassPreAd().equalsIgnoreCase("F")){
			System.out.println("F");
			InfoPre="很遗憾，您未通过预录取";
		}
		//
		//
		if(wsbmTabRegapplicant.getFAppRegPassFinAd().equalsIgnoreCase("Y")){
			System.out.println("Y");
			InfoFin="恭喜您已经被正式录取";
		}
		else if(wsbmTabRegapplicant.getFAppRegPassFinAd().equalsIgnoreCase("N")){
			System.out.println("N");
			InfoFin="您的录取尚未被确定，请耐心等候";
		}
		else if(wsbmTabRegapplicant.getFAppRegPassFinAd().equalsIgnoreCase("F")){
			System.out.println("F");
			InfoFin="很遗憾，您未被录取";
		}
		
		return "state";
	}
	
	/**考生查找学院相关复试信息
	 * @return findMyExams 查找成功
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
