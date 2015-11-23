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
import com.xdsc.service.jiaofu.TeacherCourseManageManager;
/**
 * <p>功能：教师课程管理模块，主要功能为：查看课程、发布通知、课程答疑。<br>
 * @author qianxun
 * @version 1.1
 */
public class TeacherCourseManageAction extends ActionSupport implements SessionAware{
	/**service层对象，便于调用service层的方法*/
	private TeacherCourseManageManager teacherCourseManageManager;
	/**课程信息*/
	private List<TabCourse> listCourseInfo;
	/**课程疑问*/
	private List<JfptTabCourseaskquestion> listCourseaskquestionInfo;
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
	/**课程编号*/
	private String FCourseNumber;
	/**课程通知信息*/
	private List<JfptTabCoursenotice> listCoursenoticeInfo;
	/**通知ID号*/
	private int FNoticeId;
	/**通知类型对象*/
    private JfptTabCoursenotice jfptTabCoursenotice;
    /**下载页面类型设置*/
    private String contentType;                  //下载
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
	private File uploadFile;  //上传
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
    //从Session中拿用户ID
    /**教师编号*/
    private String FTeacherNumber;
    /**Map 类型变量*/
    private Map<String,Object> session;
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

	public List<TabDirection> getListDirectionInfo() {
		return listDirectionInfo;
	}

	public void setListDirectionInfo(List<TabDirection> listDirectionInfo) {
		this.listDirectionInfo = listDirectionInfo;
	}

	public List<String> getListClassNumberInfo() {
		return listClassNumberInfo;
	}

	public void setListClassNumberInfo(List<String> listClassNumberInfo) {
		this.listClassNumberInfo = listClassNumberInfo;
	}

	public JfptTabNoticetoreceive getJfptTabNoticetoreceive() {
		return jfptTabNoticetoreceive;
	}

	public void setJfptTabNoticetoreceive(
			JfptTabNoticetoreceive jfptTabNoticetoreceive) {
		this.jfptTabNoticetoreceive = jfptTabNoticetoreceive;
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

	public List<String> getListStudentNumber() {
		return listStudentNumber;
	}

	public void setListStudentNumber(List<String> listStudentNumber) {
		this.listStudentNumber = listStudentNumber;
	}

	public TabCourse getTabCourse() {
		return tabCourse;
	}

	public void setTabCourse(TabCourse tabCourse) {
		this.tabCourse = tabCourse;
	}

	public TeacherCourseManageManager getTeacherCourseManageManager() {
		return teacherCourseManageManager;
	}

	public void setTeacherCourseManageManager(
			TeacherCourseManageManager teacherCourseManageManager) {
		this.teacherCourseManageManager = teacherCourseManageManager;
	}
	
	public int getFQuestionId() {
		return FQuestionId;
	}

	public void setFQuestionId(int questionId) {
		FQuestionId = questionId;
	}

	public List<TabCourse> getListCourseInfo() {
		return listCourseInfo;
	}

	public void setListCourseInfo(List<TabCourse> listCourseInfo) {
		this.listCourseInfo = listCourseInfo;
	}

	public List<JfptTabCourseaskquestion> getListCourseaskquestionInfo() {
		return listCourseaskquestionInfo;
	}

	public void setListCourseaskquestionInfo(
			List<JfptTabCourseaskquestion> listCourseaskquestionInfo) {
		this.listCourseaskquestionInfo = listCourseaskquestionInfo;
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

	public String getFTeacherNumber() {
		return FTeacherNumber;
	}

	public void setFTeacherNumber(String teacherNumber) {
		FTeacherNumber = teacherNumber;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getFContents() {
		return FContents;
	}

	public void setFContents(String contents) {
		FContents = contents;
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

	public Date getFDateTime() {
		return FDateTime;
	}

	public void setFDateTime(Date dateTime) {
		FDateTime = dateTime;
	}

	public List<JfptTabCoursenotice> getListCoursenoticeInfo() {
		return listCoursenoticeInfo;
	}

	public void setListCoursenoticeInfo(
			List<JfptTabCoursenotice> listCoursenoticeInfo) {
		this.listCoursenoticeInfo = listCoursenoticeInfo;
	}

	/**
	 * <p>功能：根据教师编号查询出与其相关的课程信息,并进行分页处理<br>
	 * @return action findCourseInfo
	 */
	public String findCourseInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
		
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
	 * <p>功能：通过教师Id号查找与其相关的课程疑问<br>
	 * @return action questionReplyInfo
	 */
	public String questionReplyInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
	    listCourseaskquestionInfo = teacherCourseManageManager.findQuestionReplyInfoByTid(FTeacherNumber);
	    listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
	    
	    int pages = 5;
		int listlength = listCourseaskquestionInfo.size();
		if(listlength==0)
			return "questionReplyInfo";
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
	    
		return "questionReplyInfo";
	}
	
	/**
	 * <p>功能：根据课程号和助教编号查找相关的课程疑问，并进行分页处理<br>
	 * @return action selectQuestionReplyInfo
	 */
	public String selectQuestionReplyInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listCourseaskquestionInfo = teacherCourseManageManager.findQuestionReplayInfoByTwo(FTeacherNumber,FCourseNumber);
		listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
		
		if(listCourseaskquestionInfo.size() <= 0)
			return "selectQuestionReplyInfo";
		
		int pages = 5;
		int listlength = listCourseaskquestionInfo.size();
		if(listlength==0)
			return "questionReplyInfo";
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
	
	public String getFCourseNumber() {
		return FCourseNumber;
	}

	public void setFCourseNumber(String courseNumber) {
		FCourseNumber = courseNumber;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public List<TabStudents> getListStudentsInfo() {
		return listStudentsInfo;
	}

	public void setListStudentsInfo(List<TabStudents> listStudentsInfo) {
		this.listStudentsInfo = listStudentsInfo;
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

	public JfptTabCoursenotice getJfptTabCoursenotice() {
		return jfptTabCoursenotice;
	}

	public void setJfptTabCoursenotice(JfptTabCoursenotice jfptTabCoursenotice) {
		this.jfptTabCoursenotice = jfptTabCoursenotice;
	}

	public int getFNoticeId() {
		return FNoticeId;
	}

	public void setFNoticeId(int noticeId) {
		FNoticeId = noticeId;
	}

	/**
	 * <p>功能：根据课程疑问Id号查找相关的疑问详情，并根据其id号查找相关的回复内容<br>
	 * @return action findProblemDetailByID
	 */
	public String findProblemDetailByID(){		
		jfptTabCourseaskquestion = teacherCourseManageManager.findCourseaskquestionInfoByID(FQuestionId);
		listCoursereplyquestionInfo = teacherCourseManageManager.findCourseReplyInfoByID(FQuestionId);
		return "findProblemDetailByID";
	}
	
	/**
	 * <p>功能：添加回复内容<br>
	 * @return action addReplyInfoByID
	 */
	public String addReplyInfoByID(){
		FTeacherNumber = (String)session.get("FUserNumber");
		JfptTabCoursereplyquestion jfptTabCoursereplyquestion1 = new JfptTabCoursereplyquestion();
		jfptTabCoursereplyquestion1.setFContents(FContents);
		jfptTabCoursereplyquestion1.setFDateTime(new Date());
		jfptTabCoursereplyquestion1.setFReplyUserId(FTeacherNumber);
		JfptTabCourseaskquestion jfptTabCourseaskquestion1 = new JfptTabCourseaskquestion();
		jfptTabCourseaskquestion1 = teacherCourseManageManager.findCourseaskquestionInfoByID(FQuestionId);
		jfptTabCoursereplyquestion1.setJfptTabCourseaskquestion(jfptTabCourseaskquestion1);
		teacherCourseManageManager.addCoursereplyInfo(jfptTabCoursereplyquestion1);
		
		listCourseaskquestionInfo = teacherCourseManageManager.findQuestionReplyInfoByTid(FTeacherNumber);
		return "addReplyInfoByID";
	}
	
	/**
	 * <p>功能：删除课程疑问，级联删除相关的回复信息<br>
	 * @return action deleteAskQuestionByID
	 */
	public String deleteAskQuestionByID(){
		FTeacherNumber = (String)session.get("FUserNumber");
		teacherCourseManageManager.deleteAskQuestionByID(FQuestionId);
		
		listCourseaskquestionInfo = teacherCourseManageManager.findQuestionReplyInfoByTid(FTeacherNumber);
	    listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
		return "deleteAskQuestionByID";
	}
	
	/**
	 * <p>功能：查找课程通知信息，并对结果进行分页处理<br>
	 * @return action findCourseNoticeInfo
	 */
	public String findCourseNoticeInfo(){
		FTeacherNumber = (String)session.get("FUserNumber");
		listCoursenoticeInfo = teacherCourseManageManager.findCourseNoticeInfo(FTeacherNumber);
		listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
		
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
	
	/**
	 * <p>功能：删除课程通知信息<br>
	 * @return action deleteNoticeByID
	 */
	public String deleteNoticeByID(){
		FTeacherNumber = (String)session.get("FUserNumber");
		jfptTabCoursenotice = teacherCourseManageManager.findCourseNoticeInfoByID(FNoticeId);
		teacherCourseManageManager.deleteCourseNoticeInfo(jfptTabCoursenotice);
		
		listCoursenoticeInfo = teacherCourseManageManager.findCourseNoticeInfo(FTeacherNumber);
		return "deleteNoticeByID";
	}
	
	/**
	 * <p>功能：查看课程通知的详细内容<br>
	 * @return action findNoticeDetailByID
	 */
	public String findNoticeDetailByID(){
		jfptTabCoursenotice = teacherCourseManageManager.findCourseNoticeInfoByID(FNoticeId);
		return "findNoticeDetailByID";
	}
	
	/**
	 * <p>功能：用于文件下载的方法<br>
	 * @return action downFile
	 */
	public String downFile(){      //下载      jfpt/Resource/CourseNotice/课程通知.txt
		JfptTabCoursenotice info=teacherCourseManageManager.findCourseNoticeInfoByID(FNoticeId);
		this.setContentType("application/"+this.getExt(info.getFUrl()));
		String nametofile = info.getFUrl().substring(info.getFUrl().lastIndexOf("/")+1);
		this.setFilePath("\\files\\jfpt_system\\Resource\\CourseNotice\\"+nametofile);
		this.setFileName(nametofile);
		return "downFileSuccess";
	}
	
	/**
	 * <p>功能：创建文件下载输出流<br>
	 * @return InputStream
	 * @throws Exception
	 */
	public InputStream getDownFile() throws Exception{        //文件下载输出流
		return ServletActionContext.getServletContext().getResourceAsStream(this.getFilePath());
	}
	
	/**
	 * <p>功能：获得文件后缀名称<br>
	 * @param str 文件名称
	 * @return subStr 文件后缀名
	 */
	public String getExt(String str){               //获得文件的后缀名
		String subStr=str.substring(str.lastIndexOf("."));
		return subStr;
	}

	/**
	 * <p>功能：添加课程通知前的准备工作，查找与助教相关的课程信息，学生信息，班级信息及方向信息<br>
	 * @return action AddNewNoticeBefore
	 */
	public String AddNewNoticeBefore(){
		FTeacherNumber = (String)session.get("FUserNumber");
		tabCourse = teacherCourseManageManager.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = teacherCourseManageManager.findStudentsInfoByTwo(FTeacherNumber,FCourseNumber);
		
		listClassNumberInfo = teacherCourseManageManager.findClassNumberInfo(FTeacherNumber,FCourseNumber);
		listDirectionInfo = teacherCourseManageManager.findDirectionInfo(listStudentsInfo,FCourseNumber);
		
		return "AddNewNoticeBefore";
	}
	
	/**
	 * <p>功能：根据相关的课程信息查找课程信息并查找与之相关的学生信息，在此基础上通过方、班级来查找最后的学生对象信息<br>
	 * @return action AddNewNoticeBefore2
	 */
	public String AddNewNoticeBefore2(){
		FTeacherNumber = (String)session.get("FUserNumber");
		tabCourse = teacherCourseManageManager.findCourseInfoByID(FCourseNumber);
		listStudentsInfo = teacherCourseManageManager.findStudentsInfoByTwo(FTeacherNumber,FCourseNumber);
		listStudentsInfo = teacherCourseManageManager.findStudentsInfo(ClassNumber,DirectionNumber,listStudentsInfo);
		return "AddNewNoticeBefore2";
	}
	
	/**
	 * <p>功能：添加通知<br>
	 * @return action addNotice
	 */
	public String addNotice(){                         //添加通知
		FTeacherNumber = (String)session.get("FUserNumber");
		for(String i:listStudentNumber){
			System.out.println(i);
		}
		if(uploadFile != null){
			teacherCourseManageManager.savefile(uploadFile, savePath, uploadFileFileName);
			JfptTabCoursenotice jfptTabCoursenotice1 = new JfptTabCoursenotice();
			jfptTabCoursenotice1.setFContent(FContent);
			MhqxTabUser mhqxTabUser1 = new MhqxTabUser();
			mhqxTabUser1 = teacherCourseManageManager.findUserByID(FTeacherNumber);
			jfptTabCoursenotice1.setMhqxTabUser(mhqxTabUser1);
			jfptTabCoursenotice1.setFDate(new Date());
			jfptTabCoursenotice1.setFTitle(FTitle);
			FUrl = savePath +"/"+ uploadFileFileName;
			jfptTabCoursenotice1.setFUrl(FUrl);
			tabCourse = teacherCourseManageManager.findCourseInfoByID(FCourseNumber);
			jfptTabCoursenotice1.setTabCourse(tabCourse);
			teacherCourseManageManager.addCoursenotice(jfptTabCoursenotice1);
			//添加相关对应信息到--->对应表
			for(String i: listStudentNumber){
				JfptTabNoticetoreceive jfptTabNoticetoreceive1 = new JfptTabNoticetoreceive();
				jfptTabNoticetoreceive1.setFMarkable("N");
				jfptTabNoticetoreceive1.setJfptTabCoursenotice(jfptTabCoursenotice1);
				MhqxTabUser mhqxTabUser = new MhqxTabUser();
				mhqxTabUser = teacherCourseManageManager.findUserByID(i);
				jfptTabNoticetoreceive1.setMhqxTabUser(mhqxTabUser);
				teacherCourseManageManager.addCoursenoticetoto(jfptTabNoticetoreceive1);
			}
			
			listCoursenoticeInfo = teacherCourseManageManager.findCourseNoticeInfo(FTeacherNumber);
			listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
			return "addNotice";
		}
		JfptTabCoursenotice jfptTabCoursenotice1 = new JfptTabCoursenotice();
		jfptTabCoursenotice1.setFContent(FContent);
		jfptTabCoursenotice1.setFDate(new Date());
		jfptTabCoursenotice1.setFTitle(FTitle);
		MhqxTabUser mhqxTabUser1 = new MhqxTabUser();
		mhqxTabUser1 = teacherCourseManageManager.findUserByID(FTeacherNumber);
		jfptTabCoursenotice1.setMhqxTabUser(mhqxTabUser1);
		tabCourse = teacherCourseManageManager.findCourseInfoByID(FCourseNumber);
		jfptTabCoursenotice1.setTabCourse(tabCourse);
		teacherCourseManageManager.addCoursenotice(jfptTabCoursenotice1);
		//添加相关对应信息到--->对应表
		for(String i: listStudentNumber){
			JfptTabNoticetoreceive jfptTabNoticetoreceive1 = new JfptTabNoticetoreceive();
			jfptTabNoticetoreceive1.setFMarkable("N");
			jfptTabNoticetoreceive1.setJfptTabCoursenotice(jfptTabCoursenotice1);
			MhqxTabUser mhqxTabUser = new MhqxTabUser();
			mhqxTabUser = teacherCourseManageManager.findUserByID(i);
			jfptTabNoticetoreceive1.setMhqxTabUser(mhqxTabUser);
			teacherCourseManageManager.addCoursenoticetoto(jfptTabNoticetoreceive1);
		}
		
		listCoursenoticeInfo = teacherCourseManageManager.findCourseNoticeInfo(FTeacherNumber);
		listCourseInfo = teacherCourseManageManager.findCourseInfoByTid(FTeacherNumber);
		return "addNotice";
	}
	
	/**
	 * <p>功能：查找对应课程的班级和方向信息<br>
	 * @return action seeCourseDetail
	 */
	public String seeCourseDetail(){
		FTeacherNumber = (String)session.get("FUserNumber");
		System.out.println(FTeacherNumber+"-------------------FTeacherNumber---"+FCourseNumber+"--------FCourseNumber");
		listClassNumberInfo = teacherCourseManageManager.findClassNumberInfo(FTeacherNumber, FCourseNumber); //List<String>
		listStudentsInfo = teacherCourseManageManager.findStudentsInfoByTwo(FTeacherNumber, FCourseNumber);
		listDirectionInfo = teacherCourseManageManager.findDirectionInfo(listStudentsInfo, FCourseNumber);  //List<TabDirection>
		return "seeCourseDetail";
	}
}
