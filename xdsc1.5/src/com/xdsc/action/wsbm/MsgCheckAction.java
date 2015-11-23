package com.xdsc.action.wsbm;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabNotice;
import com.xdsc.service.wsbm.MsgCheckManager;

/**����Ա�������������Լ��������Ϣ
 * @author ��С��
 * @version 1.2
 */
public class MsgCheckAction extends ActionSupport implements SessionAware{
	
	private int p = 1;

	private int lastPage;	
	/**
	 * session�������
	 */
	private Map session;
	/**
	 * service��MsgCheckManager����
	 */
	private MsgCheckManager mcm;
	
	/**
	 * service�� TabNotice����
	 */
	private TabNotice tabNotice;
	/**
	 * ���Զ����б�
	 */
	private List<TabNotice> listMsgInfo;
	private List<TabNotice> listMsgInfo2;
	/**
	 * �����������
	 */
	private int FInfoId;
	
	/**���ط��͸�ĳ������������
	 *@return success�ҵ����Բ������б�
	 */
	public String execute(){
		System.out.println((String)session.get("userNumber"));
		listMsgInfo2 = mcm.findMsg((String)session.get("userNumber"));
		return "success";
	}
	
	/**����Ա�������и�����
	 * @return adChecking ���ҳɹ������������б�
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
	
	/**�����Ա�Ų�ѯ������ϸ����
	 * @return FoundByNum �ɹ��ҵ�
	 */
	public String findMsgByNum(){
		tabNotice = mcm.findMsgByNum(getFInfoId());
		return "FoundByNum";
	}
	
	/**���������Ա�Ų�ѯ������ϸ����
	 * @return AppFoundByNum �ɹ��ҵ�
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
