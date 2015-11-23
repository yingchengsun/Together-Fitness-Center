package com.xdsc.action.jiaofu;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.xdsc.model.JfptTabCourseaskquestion;
import com.xdsc.model.JfptTabCoursenotice;
import com.xdsc.model.JfptTabCoursereplyquestion;
import com.xdsc.model.JfptTabNoticetoreceive;
import com.xdsc.model.MhqxTabUser;
import com.xdsc.model.TabCourse;
import com.xdsc.model.TabDirection;
import com.xdsc.model.TabStudents;
import com.xdsc.service.jiaofu.AssistCourseManageManager;

/**
 * <p>功能：助教课程管理模块，主要功能为：查看课程、发布通知、课程答疑。<br>
 * @author qianxun
 * @version 1.1
 */
public class AssistCourseManageAction extends ActionSupport implements SessionAware {
	/**service层对象，便于调用service层的方法*/
	private AssistCourseManageManager assistCourseManageManager;
	/**课程信息*/
	private List<TabCourse> listCourseInfo;
	/**课程疑问*/
	private List<JfptTabCourseaskquestion> listCourseaskquestionInfo;
	/**课程编号*/
	private String FCourseNumber;
	/**问题Id号*/
	private int FQuestionId;
	/**课程疑问对象*/
	private JfptTabCourseaskquestion jfptTabCourseaskquestion;
	/**问题回复信息*/
	private List<JfptTabCoursereplyquestion> listCoursereplyquestionInfo;
	/**内容*/
	private String FContents;
	/**时间*/
	private Date FDateTime;
	/**课程通知信息*/
	private List<JfptTabCoursenotice> listCoursenoticeInfo;
	/**通知ID号*/
	private int FNoticeId;
	/**通知类型对象*/
	private JfptTabCoursenotice jfptTabCoursenotice;
	/**下载页面类型设置*/
	private String contentType; // 下载
	/**文件路径*/
	private String filePath;
	/**文件名称*/
	private String fileName;
	/**下载Id号*/
	private int downId;
	/**课程类型对象*/
	private TabCourse tabCourse;
	/**学生信息*/
	private List<TabStudents> listStudentsInfo;
	/**学生学号信息*/
	private List<String> listStudentNumber;
	/**上传文件*/
	private File uploadFile; // 上传
	/**页面设置*/
	private String uploadFileContentType;
	/**文件名称*/
	private String uploadFileFileName;
	/**保存路径*/
	private String savePath;
	/**内容*/
	private String FContent;
	/**时间*/
	private Date FDate;
	/**标题*/
	private String FTitle;
	/**文件地址*/
	private String FUrl;
	/**通知接收对应信息*/
	private JfptTabNoticetoreceive jfptTabNoticetoreceive;
	/**Map 类型变量*/
	private Map<String, Object> session;
	//发送对象分类
	/**班级号信息*/
    private List<String> listClassNumberInfo = new ArrayList<String>();
    /**方向信息*/
    private List<TabDirection> listDirectionInfo = new ArrayList<TabDirection>();
    /**班级编号*/
    private String ClassNumber;
    /**方向编号*/
    private int DirectionNumber;
    /**分页处理中记录当前页面编号*/
    private int p = 1;
    /**分页处理中记录查询结果集的总页面数*/
	private int lastPage;

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

	public List<String> getListClassNumberInfo() {
		return listClassNumberInfo;
	}

	public void setListClassNumberInfo(List<String> listClassNumberInfo) {
		this.listClassNumberInfo = listClassNumberInfo;
	}

	public List<TabDirection> getListDirectionInfo() {
		return listDirectionInfo;
	}

	public void setListDirectionInfo(List<TabDirection> listDirectionInfo) {
		this.listDirectionInfo = listDirectionInfo;
	}

	public String getClassNumber() {
		return ClassNumber;
	}

	public void setClassNumber(String classNumber) {
		ClassNumber = classNumber;
	}

	public int getDirectionNumber() {
		return DirectionNumber;
	}

	public void setDirectionNumber(int directionNumber) {
		DirectionNumber = directionNumber;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public AssistCourseManageManager getAssistCourseManageManager() {
		return assistCourseManageManager;
	}

	public void setAssistCourseManageManager(
			AssistCourseManageManager assistCourseManageManager) {
		this.assistCourseManageManager = assistCourseManageManager;
	}

	public String getFCourseNumber() {
		return FCourseNumber;
	}

	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}

	public List<JfptTabCourseaskquestion> getListCourseaskquestionInfo() {
		return listCourseaskquestionInfo;
	}

	public void setListCourseaskquestionInfo(
			List<JfptTabCourseaskquestion> listCourseaskquestionInfo) {
		this.listCourseaskquestionInfo = listCourseaskquestionInfo;
	}

	public int getFQuestionId() {
		return FQuestionId;
	}

	public void setFQuestionId(int questionId) {
		FQuestionId = questionId;
	}

	public List<JfptTabCoursenotice> getListCoursenoticeInfo() {
		return listCoursenoticeInfo;
	}

	public void setListCoursenoticeInfo(
			List<JfptTabCoursenotice> listCoursenoticeInfo) {
		this.listCoursenoticeInfo = listCoursenoticeInfo;
	}

	public int getFNoticeId() {
		return FNoticeId;
	}

	public void setFNoticeId(int noticeId) {
		FNoticeId = noticeId;
	}

	public JfptTabCoursenotice getJfptTabCoursenotice() {
		return jfptTabCoursenotice;
	}

	public void setJfptTabCoursenotice(JfptTabCoursenotice jfptTabCoursenotice) {
		this.jfptTabCoursenotice = jfptTabCoursenotice;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getDownId() {
		return downId;
	}

	public void setDownId(int downId) {
		this.downId = downId;
	}

	public TabCourse getTabCourse() {
		return tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public List<TabStudents> getListStudentsInfo() {
		return listStudentsInfo;
	}

	public void setListStudentsInfo(List<TabStudents> listStudentsInfo) {
		this.listStudentsInfo = listStudentsInfo;
	}

	public List<String> getListStudentNumber() {
		return listStudentNumber;
	}

	public void setListStudentNumber(List<String> listStudentNumber) {
		this.listStudentNumber = listStudentNumber;
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

	public String getFContent() {
		return FContent;
	}

	public void setFContent(String content) {
		FContent = content;
	}

	public Date getFDate() {
		return FDate;
	}

	public void setFDate(Date date) {
		FDate = date;
	}

	public String getFTitle() {
		return FTitle;
	}

	public void setFTitle(String title) {
		FTitle = title;
	}

	public String getFUrl() {
		return FUrl;
	}

	public void setFUrl(String url) {
		FUrl = url;
	}

	public JfptTabNoticetoreceive getJfptTabNoticetoreceive() {
		return jfptTabNoticetoreceive;
	}

	public void setJfptTabNoticetoreceive(
			JfptTabNoticetoreceive jfptTabNoticetoreceive) {
		this.jfptTabNoticetoreceive = jfptTabNoticetoreceive;
	}

	public JfptTabCourseaskquestion getJfptTabCourseaskquestion() {
		return jfptTabCourseaskquestion;
	}

	public void setJfptTabCourseaskquestion(
			JfptTabCourseaskquestion jfptTabCourseaskquestion) {
		this.jfptTabCourseaskquestion = jfptTabCourseaskquestion;
	}

	public List<JfptTabCoursereplyquestion> getListCoursereplyquestionInfo() {
		return listCoursereplyquestionInfo;
	}

	public void setListCoursereplyquestionInfo(
			List<JfptTabCoursereplyquestion> listCoursereplyquestionInfo) {
		this.listCoursereplyquestionInfo = listCoursereplyquestionInfo;
	}

	public String getFContents() {
		return FContents;
	}

	public void setFContents(String contents) {
		FContents = contents;
	}

	public Date getFDateTime() {
		return FDateTime;
	}

	public void setFDateTime(Date dateTime) {
		FDateTime = dateTime;
	}

	public List<TabCourse> getListCourseInfo() {
		return listCourseInfo;
	}

	public void setListCourseInfo(List<TabCourse> listCourseInfo) {
		this.listCourseInfo = listCourseInfo;
	}

	/**
	 * <p>功能：根据助教编号查询出与其相关的课程信息,并进行分页处理<br>
	 * @return action findCourseInfo
	 */
	public String findCourseInfo() {
		String id = (String)session.get("FUserNumber");
		listCourseInfo = assistCourseManageManager.findCourseInfoByAid(id);
		
		int pages = 5;
		int listlength = listCourseInfo.size();
		if(listlength==0)
			return "findCourseInfo";
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
		listCourseInfo = listCourseInfo.subList(startIndex, endIndex);
		
		return "findCourseInfo";
	}

	/**
	 * <p>功能：通过助教Id号查找与其相关的课程疑问<br>
	 * @return action questionReplyInfo
	 */
	public String questionReplyInfo() {
		String id = (String)session.get("FUserNumber");
		listCourseaskquestionInfo = assistCourseManageManager.findQuestionReplyInfoByAid(id);
		listCourseInfo = assistCourseManageManager.findCourseInfoByAid(id);
		return "questionReplyInfo";
	}

	/**
	 * <p>功能：根据课程号和助教编号查找相关的课程疑问，并进行分页处理<br>
	 * @return action selectQuestionReplyInfo
	 */
	public String selectQuestionReplyInfo() {
		String id = (String)session.get("FUserNumber");
		listCourseaskquestionInfo = assistCourseManageManager.findQuestionReplayInfoByTwo(id, FCourseNumber);
		
		int pages = 5;
		int listlength = listCourseaskquestionInfo.size();
		if(listlength==0)
			return "selectQuestionReplyInfo";
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
		listCourseaskquestionInfo = listCourseaskquestionInfo.subList(startIndex, endIndex);
		
		return "selectQuestionReplyInfo";
	}

	/**
	 * <p>功能：根据课程疑问Id号查找相关的疑问详情，并根据其id号查找相关的回复内容<br>
	 * @return action findProblemDetailByID
	 */
	public String findProblemDetailByID() {
		jfptTabCourseaskquestion = assistCourseManageManager
				.findCourseaskquestionInfoByID(FQuestionId);
		listCoursereplyquestionInfo = assistCourseManageManager
				.findCourseReplyInfoByID(FQuestionId);
		return "findProblemDetailByID";
	}

	/**
	 * <p>功能：添加回复内容<br>
	 * @return action addReplyInfoByID
	 */
	public String addReplyInfoByID() {
		String id = (String)session.get("FUserNumber");
		JfptTabCoursereplyquestion jfptTabCoursereplyquestion1 = new JfptTabCoursereplyquestion();
		jfptTabCoursereplyquestion1.setFContents(FContents);
		jfptTabCoursereplyquestion1.setFDateTime(new Date());
		jfptTabCoursereplyquestion1.setFReplyUserId(id);
		JfptTabCourseaskquestion jfptTabCourseaskquestion1 = new JfptTabCourseaskquestion();
		jfptTabCourseaskquestion1 = assistCourseManageManager
				.findCourseaskquestionInfoByID(FQuestionId);
		jfptTabCoursereplyquestion1
				.setJfptTabCourseaskquestion(jfptTabCourseaskquestion1);
		assistCourseManageManager
				.addCoursereplyInfo(jfptTabCoursereplyquestion1);

		listCourseaskquestionInfo = assistCourseManageManager
				.findQuestionReplyInfoByAid(id);
		return "addReplyInfoByID";
	}

	/**
	 * <p>功能：删除课程疑问，级联删除相关的回复信息<br>
	 * @return action deleteAskQuestionByID
	 */
	public String deleteAskQuestionByID() {
		String id = (String)session.get("FUserNumber");
		assistCourseManageManager.deleteAskQuestionByID(FQuestionId);

		listCourseaskquestionInfo = assistCourseManageManager.findQuestionReplyInfoByAid(id);
		listCourseInfo = assistCourseManageManager.findCourseInfoByAid(id);
		return "deleteAskQuestionByID";
	}

	// 查看课程通知
	/**
	 * <p>功能：查找课程通知信息，并对结果进行分页处理<br>
	 * @return action findCourseNoticeInfo
	 */
	public String findCourseNoticeInfo() {
		String id = (String)session.get("FUserNumber");
		listCoursenoticeInfo = assistCourseManageManager.findCourseNoticeInfo(id);
		listCourseInfo = assistCourseManageManager.findCourseInfoByAid(id);
		
		int pages = 5;
		int listlength = listCoursenoticeInfo.size();
		if(listlength==0)
			return "findCourseNoticeInfo";
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
		listCoursenoticeInfo = listCoursenoticeInfo.subList(startIndex, endIndex);
		
		return "findCourseNoticeInfo";
	}

	// 删除通知
	/**
	 * <p>功能：删除课程通知信息<br>
	 * @return action deleteNoticeByID
	 */
	public String deleteNoticeByID() {
		String id = (String)session.get("FUserNumber");
		jfptTabCoursenotice = assistCourseManageManager
				.findCourseNoticeInfoByID(FNoticeId);
		assistCourseManageManager.deleteCourseNoticeInfo(jfptTabCoursenotice);

		listCoursenoticeInfo = assistCourseManageManager
				.findCourseNoticeInfo(id);
		return "deleteNoticeByID";
	}

	// 查看详情
	/**
	 * <p>功能：查看课程通知的详细内容<br>
	 * @return action findNoticeDetailByID
	 */
	public String findNoticeDetailByID() {
		jfptTabCoursenotice = assistCourseManageManager
				.findCourseNoticeInfoByID(FNoticeId);
		return "findNoticeDetailByID";
	}

	/**
	 * <p>功能：用于文件下载的方法<br>
	 * @return action downFile
	 */
	public String downFile() { // 下载 jfpt/Resource/CourseNotice/课程通知.txt
		JfptTabCoursenotice info = assistCourseManageManager
				.findCourseNoticeInfoByID(FNoticeId);
		this.setContentType("application/" + this.getExt(info.getFUrl()));
		String nametofile = info.getFUrl().substring(
				info.getFUrl().lastIndexOf("/") + 1);
		this.setFilePath("\\files\\jfpt_system\\Resource\\CourseNotice\\"
				+ nametofile);
		this.setFileName(nametofile);
		return "downFileSuccess";
	}

	/**
	 * <p>功能：创建文件下载输出流<br>
	 * @return InputStream
	 * @throws Exception
	 */
	public InputStream getDownFile() throws Exception { // 文件下载输出流
		return ServletActionContext.getServletContext().getResourceAsStream(
				this.getFilePath());
	}

	/**
	 * <p>功能：获得文件后缀名称<br>
	 * @param str 文件名称
	 * @return subStr 文件后缀名
	 */
	public String getExt(String str) { // 获得文件的后缀名
		String subStr = str.substring(str.lastIndexOf("."));
		return subStr;
	}

	/**
	 * <p>功能：添加课程通知前的准备工作，查找与助教相关的课程信息，学生信息，班级信息及方向信息<br>
	 * @return action AddNewNoticeBefore
	 */
	public String AddNewNoticeBefore() {
		String id = (String)session.get("FUserNumber");
		tabCourse = assistCourseManageManager.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = assistCourseManageManager.findStudentsInfoByTwo(id, FCourseNumber);
		
		listClassNumberInfo = assistCourseManageManager.findClassNumberInfo(id,FCourseNumber);
		listDirectionInfo = assistCourseManageManager.findDirectionInfo(listStudentsInfo,FCourseNumber);
		return "AddNewNoticeBefore";
	}
	
	/**
	 * <p>功能：根据相关的课程信息查找课程信息并查找与之相关的学生信息，在此基础上通过方、班级来查找最后的学生对象信息<br>
	 * @return action AddNewNoticeBefore2
	 */
	public String AddNewNoticeBefore2() {
		String id = (String)session.get("FUserNumber");
		tabCourse = assistCourseManageManager.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = assistCourseManageManager.findStudentsInfoByTwo(id, FCourseNumber);
		
		listStudentsInfo = assistCourseManageManager.findStudentsInfo(ClassNumber,DirectionNumber,listStudentsInfo);
		return "AddNewNoticeBefore2";
	}

	/**
	 * <p>功能：添加通知<br>
	 * @return action addNotice
	 */
	public String addNotice() { // 添加通知
		String id = (String)session.get("FUserNumber");
		for (String i : listStudentNumber) {
			System.out.println(i);
		}
		if (uploadFile != null) {
			assistCourseManageManager.savefile(uploadFile, savePath,
					uploadFileFileName);
			JfptTabCoursenotice jfptTabCoursenotice1 = new JfptTabCoursenotice();
			jfptTabCoursenotice1.setFContent(FContent);
			MhqxTabUser mhqxTabUser1 = new MhqxTabUser();
			mhqxTabUser1 = assistCourseManageManager.findUserByID(id);
			jfptTabCoursenotice1.setMhqxTabUser(mhqxTabUser1);
			jfptTabCoursenotice1.setFDate(new Date());
			jfptTabCoursenotice1.setFTitle(FTitle);
			FUrl = savePath + "/" + uploadFileFileName;
			jfptTabCoursenotice1.setFUrl(FUrl);
			tabCourse = assistCourseManageManager
					.findCourseInfoByID(FCourseNumber);
			jfptTabCoursenotice1.setTabCourse(tabCourse);
			assistCourseManageManager.addCoursenotice(jfptTabCoursenotice1);
			// 添加相关对应信息到--->对应表
			for (String i : listStudentNumber) {
				JfptTabNoticetoreceive jfptTabNoticetoreceive1 = new JfptTabNoticetoreceive();
				jfptTabNoticetoreceive1.setFMarkable("N");
				jfptTabNoticetoreceive1
						.setJfptTabCoursenotice(jfptTabCoursenotice1);
				MhqxTabUser mhqxTabUser = new MhqxTabUser();
				mhqxTabUser = assistCourseManageManager.findUserByID(i);
				jfptTabNoticetoreceive1.setMhqxTabUser(mhqxTabUser);
				assistCourseManageManager
						.addCoursenoticetoto(jfptTabNoticetoreceive1);
			}

			listCoursenoticeInfo = assistCourseManageManager
					.findCourseNoticeInfo(id);
			listCourseInfo = assistCourseManageManager
					.findCourseInfoByAid(id);
			return "addNotice";
		}
		JfptTabCoursenotice jfptTabCoursenotice1 = new JfptTabCoursenotice();
		jfptTabCoursenotice1.setFContent(FContent);
		jfptTabCoursenotice1.setFDate(new Date());
		jfptTabCoursenotice1.setFTitle(FTitle);
		MhqxTabUser mhqxTabUser1 = new MhqxTabUser();
		mhqxTabUser1 = assistCourseManageManager.findUserByID(id);
		jfptTabCoursenotice1.setMhqxTabUser(mhqxTabUser1);
		tabCourse = assistCourseManageManager.findCourseInfoByID(FCourseNumber);
		jfptTabCoursenotice1.setTabCourse(tabCourse);
		assistCourseManageManager.addCoursenotice(jfptTabCoursenotice1);
		// 添加相关对应信息到--->对应表
		for (String i : listStudentNumber) {
			JfptTabNoticetoreceive jfptTabNoticetoreceive1 = new JfptTabNoticetoreceive();
			jfptTabNoticetoreceive1.setFMarkable("N");
			jfptTabNoticetoreceive1
					.setJfptTabCoursenotice(jfptTabCoursenotice1);
			MhqxTabUser mhqxTabUser = new MhqxTabUser();
			mhqxTabUser = assistCourseManageManager.findUserByID(i);
			jfptTabNoticetoreceive1.setMhqxTabUser(mhqxTabUser);
			assistCourseManageManager
					.addCoursenoticetoto(jfptTabNoticetoreceive1);
		}

		listCoursenoticeInfo = assistCourseManageManager
				.findCourseNoticeInfo(id);
		listCourseInfo = assistCourseManageManager.findCourseInfoByAid(id);
		return "addNotice";
	}
	
	/**
	 * <p>功能：查找对应课程的班级和方向信息<br>
	 * @return action seeCourseDetail
	 */
	public String seeCourseDetail(){
		String id = (String)session.get("FUserNumber");
		System.out.println("seeCourseDetail-------------begin---------------Assist");
		listClassNumberInfo = assistCourseManageManager.findClassNumberInfo(id, FCourseNumber); //List<String>
		listStudentsInfo = assistCourseManageManager.findStudentsInfoByTwo(id, FCourseNumber);
		listDirectionInfo = assistCourseManageManager.findDirectionInfo(listStudentsInfo, FCourseNumber);  //List<TabDirection>
		System.out.println("seeCourseDetail---------------end-------------Assist");
		return "seeCourseDetail";
	}
}
