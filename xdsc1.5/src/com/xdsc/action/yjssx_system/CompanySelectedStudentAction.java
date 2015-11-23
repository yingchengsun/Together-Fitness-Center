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
 * �๦��:��˾��ѡ����о����Ĳ���
 * @author ����
 * @version 1.1
 */
public class CompanySelectedStudentAction extends ActionSupport implements SessionAware{
	
	private Map session;
	
	private String FUserNumber;
	
	private PostgraduateInfoService postgraduateInfoService;
	
	private SystomNoticeService systomNoticeService;
	
	/**
	 * �ù�˾�����Ѿ��յ��о�����Ϣ
	 */
	private List<TabPostgraduate> acceptedStuList;   
	
	/**
	 * ����Щ�о���������Ϣ
	 */
	private List<TabPostgraduate> noticeStuList;     
	
	/**
	 *  ����Щ�о�������֪ͨ��ʾ�о�������
	 */
	private List<String> noticeStuId;             
	
	/**
	 * ����Щ�о�������֪ͨ
	 */
	private List<String> infoToStuId;
	
	private TabNotice notice;    
	
	private File uploadFile;          //form�������ͬ������ͬ����(text ,textarea...)����Ϣ�����һ��list��

	private String uploadFileContentType;

	private String uploadFileFileName;
	
	private String savePath;
	
	private int p = 1;

	private int lastPage;
	
	/**
	 * ��ʾ�Ѿ����յ��о�������Ϣ
	 * @return showSelectedStu �����Ѿ����յ��о����б�
	 */
	public String showSelectedStu(){
		FUserNumber =(String) session.get("FUserNumber");                //��session��ȡ������
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
	 * ����ʵϰ֪ͨ��ʾ�о�����Ϣ
	 * @return ת��֪ͨҳ�棬ͬʱ�����о�����Ϣ
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
	 * ����֪ͨ�������м��noticeTo����Ϣ
	 * @return ����֪ͨ�ɹ�
	 */
	public String saveNotice(){
		if(uploadFile!=null){
			String saveName=System.currentTimeMillis()+uploadFileFileName;
			systomNoticeService.savefile(uploadFile, savePath, saveName);
			notice.setFInfoPath(saveName);
		}
		notice.setFModuleId(CommonConstVariable.MODULE_ID);      //�о���ʵϰϵͳ��ģ���Ϊ7
		notice.setFInfoType(CommonConstVariable.NOTICE_TYPE_COMPANYTOSTUDENT);     //���о�������֪ͨ
		systomNoticeService.addNotice(notice);    //�Ƚ�notice�������ݿ�
		List<TabPostgraduate> stuList=new ArrayList<TabPostgraduate>();
		for(int i=0;i<infoToStuId.size();i++){
			TabPostgraduate stu=postgraduateInfoService.findPostgraduateByStuNumber(infoToStuId.get(i));
			stuList.add(stu);
			System.out.println(stuList.size());
		}
		TabNotice lastSave = systomNoticeService.findLastSaveNotice(notice);      //�ҵ��ող������ݿ��֪ͨ
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
