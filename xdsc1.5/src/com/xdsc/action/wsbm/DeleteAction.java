package com.xdsc.action.wsbm;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabNotice;
import com.xdsc.model.WsbmTabRegapplicant;
import com.xdsc.service.wsbm.AdAllCheckManager;
import com.xdsc.service.wsbm.DeleteManager;
import com.xdsc.service.wsbm.MsgCheckManager;

/**ɾ��ϵͳ��Ϣ
 * @author ��С��
 * @version 1.2
 *
 */
public class DeleteAction extends ActionSupport implements SessionAware{
	/**
	 * service���������
	 */
	private AdAllCheckManager aacm;
	/**
	 * session�������
	 */
	private Map session;
	/**
	 * ƽ̨�û�����
	 */
	private MhqxTabUser mhqxTabUser;
	/**
	 * ϵͳ֪ͨ���Զ���
	 */
	private TabNotice tabNotice;
	/**
	 * ƽ̨�û���ض���
	 */
	private String FUserNumber;
	/**
	 * ϵͳ֪ͨ�����������
	 */
	private int FInfoId;
	/**
	 * service��DeleteManager�������
	 */
	private DeleteManager deleteManager;
	/**
	 * service��AdAllCheckManager�������
	 */
	private AdAllCheckManager adAllCheckManager;
	/**
	 * service��MsgCheckManager�������
	 */
	private MsgCheckManager msgCheckManager;
	/**
	 * ��������
	 */
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	/**
	 * ���������б�
	 */
	private List<WsbmTabRegapplicant> listRegapplicantinfo;
	/**
	 * ֪ͨ�����б�
	 */
	private List<TabNotice> listTabNotice;
	/**
	 * �����б�
	 */
	private List<TabNotice> listMsgInfo2;
	private List<TabNotice> listMsgInfo;
	private int p = 1;

	private int lastPage;
	/**
	 * ���д�С
	 */
	private int size;
	public TabNotice getTabNotice() {
		return tabNotice;
	}

	public void setTabNotice(TabNotice tabNotice) {
		this.tabNotice = tabNotice;
	}

	public int getFInfoId() {
		return FInfoId;
	}

	public void setFInfoId(int infoId) {
		FInfoId = infoId;
	}

	/**���֪ͨ��Ϣ�б�
	 * @return listTabNotice �ɹ����
	 */
	public List<TabNotice> getListTabNotice() {
		return listTabNotice;
	}

	public void setListTabNotice(List<TabNotice> listTabNotice) {
		this.listTabNotice = listTabNotice;
	}

	/**ɾ�����������˻�
	 * @return AccDeleted �ɹ�ɾ��
	 */
	public String deleteAcc(){
		mhqxTabUser = deleteManager.findAccByNum(FUserNumber);
		deleteManager.deleteAcc(mhqxTabUser);
		listRegapplicantinfo=deleteManager.findRegapplicantInfo();
		if(listRegapplicantinfo.size()>10){
			int pages = 10;
			int listlength = this.listRegapplicantinfo.size();
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
			this.listRegapplicantinfo = this.listRegapplicantinfo.subList(startIndex, endIndex);
		}
		return "AccDeleted";
	}
	
	/**ɾ�����п����˻������wsbm_tab_regapplicant��
	 * @return AllDeleted ɾ���ɹ�
	 */
	public String deleteAll(){
		System.out.println("In Function@");
		listRegapplicantinfo=aacm.findRegapplicantInfo();
		listRegapplicantinfo.toArray();
		size=listRegapplicantinfo.size();
		System.out.println("size="+size+"Ready to Delete.......");
		for(int i=0;i<size;i++){
			wsbmTabRegapplicant = aacm.sepFindByNum(listRegapplicantinfo.get(i).getFAppRegNum());
			deleteManager.deleteAcc(wsbmTabRegapplicant);
			System.out.println("one Deleted!");
		}
		listRegapplicantinfo=deleteManager.findRegapplicantInfo();
		return "AllDeleted";
	}
	
	/**ɾ��ϵͳ֪ͨ
	 * @return NoticeDeleted ɾ���ɹ�
	 */
	public String deleteNotice(){
		tabNotice= adAllCheckManager.sepFindByNoticeNum(FInfoId);
		deleteManager.deleteNotice(tabNotice);
		listTabNotice=adAllCheckManager.findNotice();
		return "NoticeDeleted";
	}
	
	/**����Աɾ������
	 * @return MessageDeleted ɾ���ɹ�
	 */
	public String deleteMessage(){
		tabNotice= adAllCheckManager.sepFindByNoticeNum(FInfoId);
		deleteManager.deleteNotice(tabNotice);
		listMsgInfo=msgCheckManager.findAdMsg();
		return "MessageDeleted";
	}
	
	/**����ɾ�����͸��Լ�������
	 * @return MessageDeletedApp ɾ���ɹ�
	 */
	public String deleteMessageApp(){
		tabNotice= adAllCheckManager.sepFindByNoticeNum(FInfoId);
		deleteManager.deleteNotice(tabNotice);
		listMsgInfo2=msgCheckManager.findMsg((String)session.get("userNumber"));
		return "MessageDeletedApp";
	}
	
	public MhqxTabUser getMhqxTabUser() {
		return mhqxTabUser;
	}
	public void setMhqxTabUser(MhqxTabUser mhqxTabUser) {
		this.mhqxTabUser = mhqxTabUser;
	}
	public String getFUserNumber() {
		return FUserNumber;
	}
	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}

	public DeleteManager getDeleteManager() {
		return deleteManager;
	}

	public void setDeleteManager(DeleteManager deleteManager) {
		this.deleteManager = deleteManager;
	}

	public List<WsbmTabRegapplicant> getList() {
		return listRegapplicantinfo;
	}

	public void setList(List<WsbmTabRegapplicant> list) {
		this.listRegapplicantinfo = list;
	}

	public WsbmTabRegapplicant getWsbmTabRegapplicant() {
		return wsbmTabRegapplicant;
	}

	public void setWsbmTabRegapplicant(WsbmTabRegapplicant wsbmTabRegapplicant) {
		this.wsbmTabRegapplicant = wsbmTabRegapplicant;
	}

	public List<WsbmTabRegapplicant> getListRegapplicantinfo() {
		return listRegapplicantinfo;
	}

	public void setListRegapplicantinfo(
			List<WsbmTabRegapplicant> listRegapplicantinfo) {
		this.listRegapplicantinfo = listRegapplicantinfo;
	}

	public AdAllCheckManager getAdAllCheckManager() {
		return adAllCheckManager;
	}

	public void setAdAllCheckManager(AdAllCheckManager adAllCheckManager) {
		this.adAllCheckManager = adAllCheckManager;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public MsgCheckManager getMsgCheckManager() {
		return msgCheckManager;
	}

	public void setMsgCheckManager(MsgCheckManager msgCheckManager) {
		this.msgCheckManager = msgCheckManager;
	}

	public List<TabNotice> getListMsgInfo2() {
		return listMsgInfo2;
	}

	public void setListMsgInfo2(List<TabNotice> listMsgInfo2) {
		this.listMsgInfo2 = listMsgInfo2;
	}

	public List<TabNotice> getListMsgInfo() {
		return listMsgInfo;
	}

	public void setListMsgInfo(List<TabNotice> listMsgInfo) {
		this.listMsgInfo = listMsgInfo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

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
}
