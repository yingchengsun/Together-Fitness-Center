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
 * �о�������֪ͨ
 * @author Administrator
 *
 */
public class PostgraduateReceiveNoticeAction extends ActionSupport implements SessionAware{

	private Map session;
	
	private String FUserNumber;
	
	private SystomNoticeService systomNoticeService;
	
	/**
	 *  ��Ϣ����ͨ��URL�������������ж���Ϣ������
	 */
	private String type;                            
	
	/**
	 * �о�������֪ͨ��֪ͨ�б�
	 */
	private List<TabNotice> noticeList;                 //��Ϣ�б�
	
	/**
	 * ��ʾ��ϸ��Ϣ��֪ͨ��ID
	 */
	private int detailId;
	
	private TabNotice detailInfo;
	
	private List<String> noticeId;

	private int p = 1;

	private int lastPage;

	/**
	 * ����URL�����Ĳ鿴֪ͨ�����ͣ����ҳ���ͬ���͵�֪ͨ
	 * @return ��ͬ���͵�֪ͨ�б�
	 */
	public String findAllNotice(){
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		List<TabNoticetosb> nlist= systomNoticeService.findNoticeToByUserNum(FUserNumber);
		System.out.println(nlist.size());
		noticeList = new ArrayList<TabNotice>();
		if(type.equals("1")){
			for(int i=0;i<nlist.size();i++){
				if(nlist.get(i).getTabNotice().getFInfoType().equals(CommonConstVariable.NOTICE_TYPE_ADMINTOSTUDENT)){
					noticeList.add(nlist.get(i).getTabNotice());
				}
		  }
		}
		else if(type.equals("2")){
			for(int i=0;i<nlist.size();i++){
				if(nlist.get(i).getTabNotice().getFInfoType().equals(CommonConstVariable.NOTICE_TYPE_TUTORTOSTUDENT)){
					noticeList.add(nlist.get(i).getTabNotice());
				}
			}
		}
		else{
				for(int i=0;i<nlist.size();i++){
					if(nlist.get(i).getTabNotice().getFInfoType().equals(CommonConstVariable.NOTICE_TYPE_COMPANYTOSTUDENT)){
						noticeList.add(nlist.get(i).getTabNotice());
					}
			}		
		}
		if(noticeList.size()==0){
			return "noNoticeRightNow";
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
		return "findAllNotice";
	}
	
	/**
	 * ��ʾ֪ͨ������
	 * @return ֪ͨ����
	 */
	public String showNoticeDetail(){
		detailInfo = systomNoticeService.findNoticeById(detailId);
		return "showNoticeDetail";
	}
	
	/**
	 * ɾ��֪ͨ��������ֻ��ɾ���м����Ϣ
	 * @return deleteNotice ɾ���ɹ�
	 */
	public String deleteNotice(){                      //ɾ��֪ͨ��Ϣ
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
		for(int i=0;i<noticeId.size();i++){               //���ҵ����и���Ϣ����˭����
			List<TabNoticetosb> nlist=systomNoticeService.findNoticeToByNoticeId(noticeId.get(i));
			for(int j=0;j<nlist.size();j++){                  //ɾ������˾��Ϣ���м����
				if(nlist.get(j).getMhqxTabUser().getFUserNumber().equals(FUserNumber)){
					systomNoticeService.deleteNoticeTo(nlist.get(j));
				}
			}
		}
		
		return "deleteNotice";
	}

	
	public void setDetailInfo(TabNotice detailInfo) {
		this.detailInfo = detailInfo;
	}


	public SystomNoticeService getSystomNoticeService() {
		return systomNoticeService;
	}

	public void setSystomNoticeService(SystomNoticeService systomNoticeService) {
		this.systomNoticeService = systomNoticeService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<TabNotice> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<TabNotice> noticeList) {
		this.noticeList = noticeList;
	}
		
	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public TabNotice getDetailInfo() {
		return detailInfo;
	}

	public List<String> getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(List<String> noticeId) {
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
