package com.xdsc.action.yjssx_system;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.SystomNoticeService;
import com.xdsc.util.CommonConstVariable;

/**
 * 类功能:公司已选择的研究生的操作
 * @author 许鑫
 * @version 1.1
 */
public class CompanySelectedStudentAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private SystomNoticeService systomNoticeService;
	
	/**
	 * 该公司所有已经收的研究生信息
	 */
	private List<TabPostgraduate> acceptedStuList;   
	
	/**
	 * 给哪些研究生发送信息
	 */
	private List<TabPostgraduate> noticeStuList;     
	
	/**
	 *  给哪些研究生发送通知显示研究生详情
	 */
	private List<String> noticeStuId;             
	
	/**
	 * 给哪些研究生保存通知
	 */
	private List<String> infoToStuId;
	
	private TabNotice notice;    
	
	private File uploadFile;          //form中如果有同名的相同类型(text ,textarea...)的信息则放在一个list中

	private String uploadFileContentType;

	private String uploadFileFileName;
	
	private String savePath;
	
	private int p = 1;

	private int lastPage;
	
	/**
	 * 显示已经接收的研究生的信息
	 * @return showSelectedStu 返回已经接收的研究生列表
	 */
	public String showSelectedStu(){
		FUserNumber =(String) session.get("FUserNumber");                //从session中取到数据
		acceptedStuList = postgraduateInfoService.findPostgraduateByComNumber(FUserNumber);
		if(acceptedStuList.size()>10){
			int pages = 10;
			int listlength = this.acceptedStuList.size();
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
			this.acceptedStuList = this.acceptedStuList.subList(startIndex, endIndex);
		}		
		return "findAllSelectedStu";
	}
	
	/**
	 * 发送实习通知显示研究生信息
	 * @return 转向通知页面，同时返回研究生信息
	 */
	public String sendPracticeNotice(){
		noticeStuList=new ArrayList<TabPostgraduate>();
		for(int i=0;i<noticeStuId.size();i++){
			TabPostgraduate stu=postgraduateInfoService.findPostgraduateByStuNumber(noticeStuId.get(i));
			noticeStuList.add(stu);
		}
		return "sendPracticeNotice";
	}
	
	/**
	 * 保存通知并保存中间表noticeTo的信息
	 * @return 发送通知成功
	 */
	public String saveNotice(){
		if(uploadFile!=null){
			String saveName=System.currentTimeMillis()+uploadFileFileName;
			systomNoticeService.savefile(uploadFile, savePath, saveName);
			notice.setFInfoPath(saveName);
		}
		notice.setFModuleId(CommonConstVariable.MODULE_ID);      //研究生实习系统的模块号为7
		notice.setFInfoType(CommonConstVariable.NOTICE_TYPE_COMPANYTOSTUDENT);     //给研究生发送通知
		systomNoticeService.addNotice(notice);    //先将notice存入数据库
		List<TabPostgraduate> stuList=new ArrayList<TabPostgraduate>();
		for(int i=0;i<infoToStuId.size();i++){
			TabPostgraduate stu=postgraduateInfoService.findPostgraduateByStuNumber(infoToStuId.get(i));
			stuList.add(stu);
			System.out.println(stuList.size());
		}
		TabNotice lastSave = systomNoticeService.findLastSaveNotice(notice);      //找到刚刚插入数据库的通知
		TabNoticetosb noticeTo=new TabNoticetosb();
		for(int i=0;i<infoToStuId.size();i++){
			noticeTo.setMhqxTabUser(stuList.get(i).getTabStudents().getMhqxTabUser());
			noticeTo.setTabNotice(lastSave);
			noticeTo.setFAlreadyRead("0");
			systomNoticeService.addNoticeTo(noticeTo);
		}		
		return "saveNotice";
	}

	public List<String> getNoticeStuId() {
		return noticeStuId;
	}

	public void setNoticeStuId(List<String> noticeStuId) {
		this.noticeStuId = noticeStuId;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
	}

	public List<TabPostgraduate> getAcceptedStuList() {
		return acceptedStuList;
	}

	public void setAcceptedStuList(List<TabPostgraduate> acceptedStuList) {
		this.acceptedStuList = acceptedStuList;
	}

	public SystomNoticeService getSystomNoticeService() {
		return systomNoticeService;
	}

	public void setSystomNoticeService(SystomNoticeService systomNoticeService) {
		this.systomNoticeService = systomNoticeService;
	}

	public List<TabPostgraduate> getNoticeStuList() {
		return noticeStuList;
	}

	public void setNoticeStuList(List<TabPostgraduate> noticeStuList) {
		this.noticeStuList = noticeStuList;
	}

	public List<String> getInfoToStuId() {
		return infoToStuId;
	}

	public void setInfoToStuId(List<String> infoToStuId) {
		this.infoToStuId = infoToStuId;
	}

	public TabNotice getNotice() {
		return notice;
	}

	public void setNotice(TabNotice notice) {
		this.notice = notice;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
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
