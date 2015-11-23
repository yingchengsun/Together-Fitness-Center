package com.xdsc.action.yjssx_system;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabNotice;
import com.xdsc.service.yjssx_system.SystomNoticeService;
import com.xdsc.util.CommonConstVariable;


/**类功能：管理员给子系统个个人员发送信息
 * @author 许鑫
 * @version 1.1
 */
public class AdminNoticeOperationAction extends ActionSupport {
	
	private SystomNoticeService systomNoticeService;
	
	/**
	 * 查找出来的notice列
	 */
	private List<TabNotice> noticeList;
	
	/**
	 * 根据Id查找notice的详情
	 */
	private int noticeId;
	/**
	 * 通知的详情
	 */
	private TabNotice detailNotice;
	
	/**
	 * 删除信息Id
	 */
	private List<String> delId;            

	private int p = 1;

	private int lastPage;

	/**显示所有通知的详情，并分页显示
	 * @return showAllNotice 查找通知成功
	 */
	public String showAllNotice(){
		List<TabNotice> list=systomNoticeService.findAllNoticeByModule();
		noticeList = new ArrayList<TabNotice>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getFInfoType().equals(CommonConstVariable.NOTICE_TYPE_ADMINTOSTUDENT)||list.get(i).getFInfoType().equals(CommonConstVariable.NOTICE_TYPE_ADMINTOTUTOR)||list.get(i).getFInfoType().equals(CommonConstVariable.NOTICE_TYPE_ADMINTOCOMPANY)){
				noticeList.add(list.get(i));
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
		return "showAllNotice";
	}
	
	/**显示通知的详情
	 * @return showNoticeDetail
	 */
	public String showNoticeDetail(){
		detailNotice=systomNoticeService.findNoticeById(noticeId);
		return "showNoticeDetail";
	}
	
	/**根据Id删除通知信息
	 * @return deleteNotice 删除信息成功
	 */
	public String deleteNotice(){
		for(int i=0;i<delId.size();i++){
			TabNotice temp = systomNoticeService.findNoticeById(Integer.parseInt(delId.get(i))) ;
			systomNoticeService.deleteNotice(temp);
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

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public TabNotice getDetailNotice() {
		return detailNotice;
	}

	public void setDetailNotice(TabNotice detailNotice) {
		this.detailNotice = detailNotice;
	}
		
	public List<String> getDelId() {
		return delId;
	}

	public void setDelId(List<String> delId) {
		this.delId = delId;
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
