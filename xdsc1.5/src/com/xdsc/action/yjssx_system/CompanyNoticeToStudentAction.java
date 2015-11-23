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
 * 类功能：公司给研究生发送应聘通知
 * @author 许鑫
 * @version 1.1
 */
public class CompanyNoticeToStudentAction extends ActionSupport {
	//发送应聘信息的action 发送实习通知的action再CompanySelectedStudentAction中	
	private PostgraduateInfoService postgraduateInfoService;
	
	private SystomNoticeService systomNoticeService;

	/**
	 * 通知研究生的Id列表
	 */
	private List<String> NoticeStuId;                    //研究生的Id
	
	/**
	 * 通知研究生的信息列表
	 */
	private List<TabPostgraduate> noticeStuList;           //给那些研究生发送应聘通知
	
	/**
	 * 需要通知的研究生
	 */
	private List<String> infoToStuId;                   //给那些研究生保存通知
	
	/**
	 * 发送的通知
	 */
	private TabNotice notice;                            //发送的通知详情
	
	private File uploadFile;          //form中如果有同名的相同类型(text ,textarea...)的信息则放在一个list中

	private String uploadFileContentType;

	private String uploadFileFileName;
	
	private String savePath;

	/**
	 * 发送通知前，给用户显示要发送的研究生的信息
	 * @return 返回通知的研究生信息
	 */
	public String NoticeToStudent(){                   //给研究生发送应聘通知
		noticeStuList=new ArrayList<TabPostgraduate>();
		for(int i=0;i<NoticeStuId.size();i++){
			TabPostgraduate stu=postgraduateInfoService.findPostgraduateByStuNumber(NoticeStuId.get(i));
			noticeStuList.add(stu);
		}
		return "NoticeToStudent";
	}
	
	/**
	 * 保存通知，先保存通知，在将其与user关联起来
	 * @return 发送通知成功
	 */
	public String saveNotice(){
		if(uploadFile!=null){
			String saveName=System.currentTimeMillis()+uploadFileFileName;
			systomNoticeService.savefile(uploadFile, savePath, saveName);
			notice.setFInfoPath(saveName);
		}
		notice.setFModuleId(CommonConstVariable.MODULE_ID);      //研究生实习系统的模块号为7
		notice.setFInfoType(CommonConstVariable.NOTICE_YINGPIN);     //给研究生的应聘通知类型为yingpin
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
