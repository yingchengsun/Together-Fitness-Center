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
 * 类功能：导师接收管理员的通知
 * @author 许鑫
 * @version 1.1
 */
public class TutorReceiveNoticeAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private SystomNoticeService systomNoticeService;
	
	/**
	 * 导师接收到的所有同志
	 */
	private List<TabNotice> noticeList;                 //信息列表
	
	/**
	 * 通知详情的ID
	 */
	private int detailId;
	
	private TabNotice detailInfo;
	
	private List<String> noticeId;
	
	private int p = 1;

	private int lastPage;
	
	/**
	 * 查找所有通知
	 * @return 返回通知列表
	 */
	public String findAllNotice(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		List<TabNoticetosb> nlist= systomNoticeService.findNoticeToByUserNum(FUserNumber);
		System.out.println(nlist.size());
		noticeList = new ArrayList<TabNotice>();
		for(int i=0;i<nlist.size();i++){
			if(nlist.get(i).getTabNotice().getFInfoType().equals(CommonConstVariable.NOTICE_TYPE_ADMINTOTUTOR)){
				noticeList.add(nlist.get(i).getTabNotice());
			}
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
	 * 显示通知的详情
	 * @return 返回通知的详情
	 */
	public String showNoticeDetail(){
		detailInfo = systomNoticeService.findNoticeById(detailId);
		return "showNoticeDetail";
	}
	
	/**
	 * 根据通知Id删除通知
	 * @return 删除通知成功
	 */
	public String deleteNotice(){                      //删除通知信息
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		for(int i=0;i<noticeId.size();i++){               //先找到所有该信息都给谁发了
			List<TabNoticetosb> nlist=systomNoticeService.findNoticeToByNoticeId(noticeId.get(i));
			for(int j=0;j<nlist.size();j++){                  //删除本公司信息的中间表项
				if(nlist.get(j).getMhqxTabUser().getFUserNumber().equals(FUserNumber)){
					systomNoticeService.deleteNoticeTo(nlist.get(j));
				}
			}
		}
		
		return "deleteNotice";
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

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public TabNotice getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(TabNotice detailInfo) {
		this.detailInfo = detailInfo;
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
