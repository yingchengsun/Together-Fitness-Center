package com.xdsc.action.wsbm;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.AdAllCheckManager;
import com.xdsc.service.wsbm.MegManager;
import com.xdsc.service.wsbm.MsgCheckManager;
import com.xdsc.service.wsbm.UserLoginService;

/**发送留言
 * @author 苟小龙
 * @version 1.2
 */
public class MegAction extends ActionSupport implements SessionAware{
	
	/**
	 * session相关属性
	 */
	private Map session;
	/**
	 * 留言对象相关属性
	 */
	private Integer FInfoId;
	private String FInfoTitle;
	private String FInfoContet;
	private String FModuleId;
	private String FInfoPath;
	private String FInfoFrom;
	private String FInfoType;
	private String art;
	/**
	 * 留言对象
	 */
	TabNotice tn=new TabNotice();
	/**
	 * service 层AdAllCheckManager 对象
	 */
	private AdAllCheckManager acm;
	/**
	 * 留言对象列表
	 */
	private List<TabNotice> listTabNotice;
	//private List<WsbmTabRegapplicant> listTsbmTabRegapplicant;
	/**
	 * service层 MsgCheckManager对象
	 */
	private MsgCheckManager mcm;
	/**
	 * 页面显示所用留言对象列表
	 */
	private List<TabNotice> listMsgInfo;

	
	/**
	 * service层 MegManager对象
	 */

	private MegManager mm;
	

	public MsgCheckManager getMcm() {
		return mcm;
	}


	public void setMcm(MsgCheckManager mcm) {
		this.mcm = mcm;
	}


	public List<TabNotice> getListMsgInfo() {
		return listMsgInfo;
	}


	public void setListMsgInfo(List<TabNotice> listMsgInfo) {
		this.listMsgInfo = listMsgInfo;
	}
	private AdAllCheckManager aacm;
	private int p = 1;

	private int lastPage;


	public AdAllCheckManager getAacm() {
		return aacm;
	}


	public void setAacm(AdAllCheckManager aacm) {
		this.aacm = aacm;
	}


	public int getP() {
		return p;
	}


	public void setP(int p) {
		this.p = p;
	}


	public int getLastPage() {
		return lastPage;
	}


	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}


	/**发送留言
	 * @success 发送成功
	 */
	public String execute(){
		
		//TabNotice tn = new TabNotice();
		tn.setFInfoId(FInfoId);
		tn.setFInfoTitle(FInfoTitle);
		tn.setFInfoContet(FInfoContet);
		tn.setFModuleId("4");
		tn.setFInfoFrom("admin");
		tn.setFInfoType("Message");
		tn.setFInfoPath(FInfoPath);//接受者ID
		mm.addMeg(tn);
		listMsgInfo = mcm.findAdMsg();
		return "success";
	}
	
	
	/**发送公告信息
	 * @return pubNoticeSent 发送成功
	 */
	public String pubNotice(){
		TabNotice tn=new TabNotice();
		tn.setFInfoId(FInfoId);
		tn.setFInfoTitle(FInfoTitle);
		tn.setFInfoContet(FInfoContet);
		tn.setFModuleId("4");
		tn.setFInfoFrom("admin");
		tn.setFInfoType("notice");
		tn.setFInfoPath(art);
		mm.addMeg(tn);
		listTabNotice = aacm.findNotice();
		if(listTabNotice.size()>10){
			int pages = 10;
			int listlength = this.listTabNotice.size();
			if(listlength % pages == 0){
				this.lastPage = listlength / pages;
			} else{
				this.lastPage = listlength / pages +1;
			}
			if(this.p < 1)
				this.p = 1;
			if(this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.listTabNotice = this.listTabNotice.subList(startIndex, endIndex);
		}
		return "pubNoticeSent";
	}
	

	
	/**考生发送留言
	 * @return appMsgSent发送成功
	 */
	public String appSend(){
		TabNotice tn2 = new TabNotice();
		tn2.setFInfoId(FInfoId);
		tn2.setFInfoTitle(FInfoTitle);
		tn2.setFInfoContet(FInfoContet);
		tn2.setFModuleId("4");
		tn2.setFInfoType("Message");
		tn2.setFInfoFrom((String)session.get("userNumber"));//
		tn2.setFInfoPath("admin");//接受者ID
		mm.addMeg(tn2);
		return "appMsgSent";
	}
	
	public MegManager getMm() {
		return mm;
	}
	public void setMm(MegManager mm) {
		this.mm = mm;
	}
	public Integer getFInfoId() {
		return FInfoId;
	}
	public void setFInfoId(Integer infoId) {
		FInfoId = infoId;
	}
	public String getFInfoTitle() {
		return FInfoTitle;
	}
	public void setFInfoTitle(String infoTitle) {
		FInfoTitle = infoTitle;
	}
	public String getFInfoContet() {
		return FInfoContet;
	}
	public void setFInfoContet(String infoContet) {
		FInfoContet = infoContet;
	}
	
	public String getFModuleId() {
		return FModuleId;
	}
	public void setFModuleId(String moduleId) {
		FModuleId = moduleId;
	}
	
	public String getFInfoPath() {
		return FInfoPath;
	}
	public void setFInfoPath(String infoPath) {
		FInfoPath = infoPath;
	}

	public void setFInfoFrom(String infoFrom) {
		FInfoFrom = infoFrom;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public String getFInfoFrom() {
		return FInfoFrom;
	}

	public String getFInfoType() {
		return FInfoType;
	}

	public void setFInfoType(String infoType) {
		FInfoType = "notice";
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public List<TabNotice> getListTabNotice() {
		return listTabNotice;
	}

	public void setListTabNotice(List<TabNotice> listTabNotice) {
		this.listTabNotice = listTabNotice;
	}

	public AdAllCheckManager getAcm() {
		return acm;
	}

	public void setAcm(AdAllCheckManager acm) {
		this.acm = acm;
	}

	public TabNotice getTn() {
		return tn;
	}

	public void setTn(TabNotice tn) {
		this.tn = tn;
	}

//	public List<WsbmTabRegapplicant> getListTsbmTabRegapplicant() {
//		return listTsbmTabRegapplicant;
//	}
//
//	public void setListTsbmTabRegapplicant(
//			List<WsbmTabRegapplicant> listTsbmTabRegapplicant) {
//		this.listTsbmTabRegapplicant = listTsbmTabRegapplicant;
//	}

}
