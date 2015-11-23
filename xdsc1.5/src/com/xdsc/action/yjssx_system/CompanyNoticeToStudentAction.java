package com.xdsc.action.yjssx_system;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.TabNotice;
import com.xdsc.model.TabNoticetosb;
import com.xdsc.model.TabPostgraduate;
import com.xdsc.service.yjssx_system.PostgraduateInfoService;
import com.xdsc.service.yjssx_system.SystomNoticeService;
import com.xdsc.util.CommonConstVariable;

/**
 * �๦�ܣ���˾���о�������ӦƸ֪ͨ
 * @author ����
 * @version 1.1
 */
public class CompanyNoticeToStudentAction extends ActionSupport {
	//����ӦƸ��Ϣ��action ����ʵϰ֪ͨ��action��CompanySelectedStudentAction��	
	private PostgraduateInfoService postgraduateInfoService;
	
	private SystomNoticeService systomNoticeService;

	/**
	 * ֪ͨ�о�����Id�б�
	 */
	private List<String> NoticeStuId;                    //�о�����Id
	
	/**
	 * ֪ͨ�о�������Ϣ�б�
	 */
	private List<TabPostgraduate> noticeStuList;           //����Щ�о�������ӦƸ֪ͨ
	
	/**
	 * ��Ҫ֪ͨ���о���
	 */
	private List<String> infoToStuId;                   //����Щ�о�������֪ͨ
	
	/**
	 * ���͵�֪ͨ
	 */
	private TabNotice notice;                            //���͵�֪ͨ����
	
	private File uploadFile;          //form�������ͬ������ͬ����(text ,textarea...)����Ϣ�����һ��list��

	private String uploadFileContentType;

	private String uploadFileFileName;
	
	private String savePath;

	/**
	 * ����֪ͨǰ�����û���ʾҪ���͵��о�������Ϣ
	 * @return ����֪ͨ���о�����Ϣ
	 */
	public String NoticeToStudent(){                   //���о�������ӦƸ֪ͨ
		noticeStuList=new ArrayList<TabPostgraduate>();
		for(int i=0;i<NoticeStuId.size();i++){
			TabPostgraduate stu=postgraduateInfoService.findPostgraduateByStuNumber(NoticeStuId.get(i));
			noticeStuList.add(stu);
		}
		return "NoticeToStudent";
	}
	
	/**
	 * ����֪ͨ���ȱ���֪ͨ���ڽ�����user��������
	 * @return ����֪ͨ�ɹ�
	 */
	public String saveNotice(){
		if(uploadFile!=null){
			String saveName=System.currentTimeMillis()+uploadFileFileName;
			systomNoticeService.savefile(uploadFile, savePath, saveName);
			notice.setFInfoPath(saveName);
		}
		notice.setFModuleId(CommonConstVariable.MODULE_ID);      //�о���ʵϰϵͳ��ģ���Ϊ7
		notice.setFInfoType(CommonConstVariable.NOTICE_YINGPIN);     //���о�����ӦƸ֪ͨ����Ϊyingpin
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
		return NoticeStuId;
	}

	public void setNoticeStuId(List<String> noticeStuId) {
		NoticeStuId = noticeStuId;
	}

	public PostgraduateInfoService getPostgraduateInfoService() {
		return postgraduateInfoService;
	}

	public void setPostgraduateInfoService(
			PostgraduateInfoService postgraduateInfoService) {
		this.postgraduateInfoService = postgraduateInfoService;
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

	public SystomNoticeService getSystomNoticeService() {
		return systomNoticeService;
	}

	public void setSystomNoticeService(SystomNoticeService systomNoticeService) {
		this.systomNoticeService = systomNoticeService;
	}
}
