package com.xdsc.action.yjssx_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;
import com.xdsc.service.yjssx_system.SystomNoticeService;
import com.xdsc.util.CommonConstVariable;

/**
 * �๦�ܣ��о�������ӦƸ��Ϣ
 * @author ����
 * @version 1.1
 */
public class PostgraduateYingPinInfoAction extends ActionSupport implements SessionAware{

	private Map session;
	
	private String FUserNumber;
	
	private SystomNoticeService systomNoticeService;
	
	/**
	 * �ѽ��յ��ļ����б�
	 */
	private List<TabNotice> noticeList;             //����ϵͳģ�����ҵ������û���֪ͨ������Щ��֪ͨ���ҵ�����ΪӦƸ��Ϣ�ļ�FInfoType=="YingPin"
	
	/**
	 * ����������
	 */
	private TabNotice NoticeDetail;
	
	private int noticeId; 
	
	private int p = 1;

	private int lastPage;

	/**
	 * ��ʾ���н��յ���ӦƸ��Ϣ
	 * @return ���ؽ��յ���ӦƸ��Ϣ
	 */
	public String ShowNotice(){
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<TabNoticetosb> noticeToList=systomNoticeService.findNoticeToByUserNum(FUserNumber);
		noticeList=new ArrayList<TabNotice>();
		for(int i=0;i<noticeToList.size();i++){
			if(noticeToList.get(i).getTabNotice().getFInfoType().equals(CommonConstVariable.NOTICE_YINGPIN)){
				noticeList.add(noticeToList.get(i).getTabNotice());
			}
		}
		if(noticeList.size()==0){
			return "noYingPinNotice";
		}
		if(noticeList.size()>10){
			int pages = 10;
			int listlength = this.noticeList.size();
			if (listlength % pages == 0) {
				this.lastPage = listlength / pages;
			} else {
				this.lastPage = listlength / pages + 1;
			}
			if (this.p < 1)
				this.p = 1;
			if (this.p > this.lastPage)
				this.p = this.lastPage;
			int startIndex = (this.p - 1) * pages;
			int endIndex = startIndex + pages;
			if (endIndex >= listlength)
				endIndex = listlength;
			this.noticeList = this.noticeList.subList(startIndex, endIndex);
		}
		
		return "ShowNotice";
	}
	
	/**
	 * ��ʾӦƸ��Ϣ������
	 * @return ����ӦƸ��Ϣ������
	 */
	public String showDetail(){
		NoticeDetail = systomNoticeService.findNoticeById(noticeId);
		return "showDetail";
	}

	public SystomNoticeService getSystomNoticeService() {
		return systomNoticeService;
	}

	public void setSystomNoticeService(SystomNoticeService systomNoticeService) {
		this.systomNoticeService = systomNoticeService;
	}

	public List<TabNotice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<TabNotice> noticeList) {
		this.noticeList = noticeList;
	}
	
	
	public TabNotice getNoticeDetail() {
		return NoticeDetail;
	}

	public void setNoticeDetail(TabNotice noticeDetail) {
		NoticeDetail = noticeDetail;
	}	

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
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

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getFUserNumber() {
		return FUserNumber;
	}

	public void setFUserNumber(String userNumber) {
		FUserNumber = userNumber;
	}
}
