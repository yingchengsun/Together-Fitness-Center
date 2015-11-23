package com.xdsc.action.wsbm;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabNotice;
import com.xdsc.service.wsbm.MsgCheckManager;

/**管理员，考生查找留言及其相关信息
 * @author 苟小龙
 * @version 1.2
 */
public class MsgCheckAction extends ActionSupport implements SessionAware{
	
	private int p = 1;

	private int lastPage;	
	/**
	 * session相关属性
	 */
	private Map session;
	/**
	 * service层MsgCheckManager对象
	 */
	private MsgCheckManager mcm;
	
	/**
	 * service层 TabNotice对象
	 */
	private TabNotice tabNotice;
	/**
	 * 留言对象列表
	 */
	private List<TabNotice> listMsgInfo;
	private List<TabNotice> listMsgInfo2;
	/**
	 * 留言相关属性
	 */
	private int FInfoId;
	
	/**返回发送给某个考生的留言
	 *@return success找到留言并返回列表
	 */
	public String execute(){
		System.out.println((String)session.get("userNumber"));
		listMsgInfo2 = mcm.findMsg((String)session.get("userNumber"));
		return "success";
	}
	
	/**管理员查找所有给留言
	 * @return adChecking 查找成功，返回留言列表
	 */
	public String adCheck(){
		listMsgInfo = mcm.findAdMsg();
		if(listMsgInfo.size()>10){
			int pages = 10;
			int listlength = this.listMsgInfo.size();
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
			this.listMsgInfo = this.listMsgInfo.subList(startIndex, endIndex);
		}
		return "adChecking";
	}
	
	/**由留言编号查询留言详细内容
	 * @return FoundByNum 成功找到
	 */
	public String findMsgByNum(){
		tabNotice = mcm.findMsgByNum(getFInfoId());
		return "FoundByNum";
	}
	
	/**考生由留言编号查询留言详细内容
	 * @return AppFoundByNum 成功找到
	 */
	public String appFindMsgByNum(){
		tabNotice = mcm.findMsgByNum(getFInfoId());
		return "AppFoundByNum";
	}

	
	public MsgCheckManager getMcm() {
		return mcm;
	}
	public void setMcm(MsgCheckManager mcm) {
		this.mcm = mcm;
	}
	public TabNotice getTabNotice() {
		return tabNotice;
	}
	public void setTabNotice(TabNotice tabNotice) {
		this.tabNotice = tabNotice;
	}
	public List<TabNotice> getListMsgInfo() {
		return listMsgInfo;
	}
	public void setListMsgInfo(List<TabNotice> listMsgInfo) {
		this.listMsgInfo = listMsgInfo;
	}

	public int getFInfoId() {
		return FInfoId;
	}

	public void setFInfoId(int infoId) {
		FInfoId = infoId;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public List<TabNotice> getListMsgInfo2() {
		return listMsgInfo2;
	}

	public void setListMsgInfo2(List<TabNotice> listMsgInfo2) {
		this.listMsgInfo2 = listMsgInfo2;
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

}
