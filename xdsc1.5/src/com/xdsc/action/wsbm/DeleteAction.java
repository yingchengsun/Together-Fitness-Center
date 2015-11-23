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

/**删除系统信息
 * @author 苟小龙
 * @version 1.2
 *
 */
public class DeleteAction extends ActionSupport implements SessionAware{
	/**
	 * service层相关属性
	 */
	private AdAllCheckManager aacm;
	/**
	 * session相关属性
	 */
	private Map session;
	/**
	 * 平台用户对象
	 */
	private MhqxTabUser mhqxTabUser;
	/**
	 * 系统通知留言对象
	 */
	private TabNotice tabNotice;
	/**
	 * 平台用户相关对象
	 */
	private String FUserNumber;
	/**
	 * 系统通知留言相关属性
	 */
	private int FInfoId;
	/**
	 * service层DeleteManager相关属性
	 */
	private DeleteManager deleteManager;
	/**
	 * service层AdAllCheckManager相关属性
	 */
	private AdAllCheckManager adAllCheckManager;
	/**
	 * service层MsgCheckManager相关属性
	 */
	private MsgCheckManager msgCheckManager;
	/**
	 * 考生对象
	 */
	private WsbmTabRegapplicant wsbmTabRegapplicant;
	/**
	 * 考生对象列表
	 */
	private List<WsbmTabRegapplicant> listRegapplicantinfo;
	/**
	 * 通知留言列表
	 */
	private List<TabNotice> listTabNotice;
	/**
	 * 留言列表
	 */
	private List<TabNotice> listMsgInfo2;
	private List<TabNotice> listMsgInfo;
	private int p = 1;

	private int lastPage;
	/**
	 * 队列大小
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

	/**获得通知信息列表
	 * @return listTabNotice 成功获得
	 */
	public List<TabNotice> getListTabNotice() {
		return listTabNotice;
	}

	public void setListTabNotice(List<TabNotice> listTabNotice) {
		this.listTabNotice = listTabNotice;
	}

	/**删除考生单个账户
	 * @return AccDeleted 成功删除
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
	
	/**删除所有考生账户，清空wsbm_tab_regapplicant表
	 * @return AllDeleted 删除成功
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
	
	/**删除系统通知
	 * @return NoticeDeleted 删除成功
	 */
	public String deleteNotice(){
		tabNotice= adAllCheckManager.sepFindByNoticeNum(FInfoId);
		deleteManager.deleteNotice(tabNotice);
		listTabNotice=adAllCheckManager.findNotice();
		return "NoticeDeleted";
	}
	
	/**管理员删除留言
	 * @return MessageDeleted 删除成功
	 */
	public String deleteMessage(){
		tabNotice= adAllCheckManager.sepFindByNoticeNum(FInfoId);
		deleteManager.deleteNotice(tabNotice);
		listMsgInfo=msgCheckManager.findAdMsg();
		return "MessageDeleted";
	}
	
	/**考生删除发送给自己的留言
	 * @return MessageDeletedApp 删除成功
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
